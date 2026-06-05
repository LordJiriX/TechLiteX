package io.github.lordjirix.techlitex.common.entity;

import io.github.lordjirix.techlitex.TLXData;
import io.github.lordjirix.techlitex.api.block.IBlockEntityMachineBase;
import io.github.lordjirix.techlitex.api.block.IRecipeRunnable;
import io.github.lordjirix.techlitex.api.data.recipe.GreenHouseRecipe;
import io.github.lordjirix.techlitex.gui.menu.MultipleOutSlotMenu;
import io.github.lordjirix.techlitex.loader.TLXBlockEntitys;
import io.github.lordjirix.techlitex.loader.TLXBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GreenHouseBlockEntity extends BlockEntity
    implements IRecipeRunnable, MenuProvider, IBlockEntityMachineBase {
  public int timeToRunRecipe = 0;
  public int currentRunTime = 0;
  public int energyPerTick = 0;
  public int xTimeToRunRecipe = 1;
  public int xRfUsage = 1;
  private final ItemStackHandler inventory =
      new ItemStackHandler(10) {
        @Override
        protected void onContentsChanged(int slot) {
          setChanged();
        }
      };
  private final EnergyStorage energy = new EnergyStorage(100000, 1000, 1000) {};
  private final ContainerData data =
      new ContainerData() {
        @Override
        public int get(int index) {
          return switch (index) {
            case 0 -> currentRunTime;
            case 1 -> timeToRunRecipe;
            default -> 0;
          };
        }

        @Override
        public void set(int index, int value) {
          switch (index) {
            case 0 -> currentRunTime = value;
            case 1 -> timeToRunRecipe = value;
          }
        }

        @Override
        public int getCount() {
          return 2;
        }
      };

  public ContainerData getData() {
    return data;
  }

  private final LazyOptional<IEnergyStorage> energyCap = LazyOptional.of(() -> energy);
  private final LazyOptional<IItemHandler> itemHandler = LazyOptional.of(() -> inventory);

  public GreenHouseBlockEntity(BlockPos pos, BlockState pBlockState) {
    super(TLXBlockEntitys.GREENHOUSE_BLOCK_ENTITY.get(), pos, pBlockState);
    // maybe need rework
    if (pBlockState.getBlock() == TLXBlocks.GREENHOUSE_BLOCK_1.get()) {
      this.xRfUsage = 1;
      this.xTimeToRunRecipe = 1;
    }
    if (pBlockState.getBlock() == TLXBlocks.GREENHOUSE_BLOCK_2.get()) {
      this.xRfUsage = 4;
      this.xTimeToRunRecipe = 2;
    }
  }

  @Override
  public @NotNull <T> LazyOptional<T> getCapability(
      @NotNull Capability<T> cap, @Nullable Direction side) {
    if (cap == ForgeCapabilities.ITEM_HANDLER) {
      return itemHandler.cast();
    }
    if (cap == ForgeCapabilities.ENERGY) {
      return energyCap.cast();
    }
    return super.getCapability(cap, side);
  }

  @Override
  public void invalidateCaps() {
    super.invalidateCaps();
    itemHandler.invalidate();
    energyCap.invalidate();
  }

  public void tick() {
    if (level == null || level.isClientSide()) return;
    if (energy.getEnergyStored() <= energyPerTick) {
      return;
    }
    if (inventory.getStackInSlot(0).isEmpty()) {
      currentRunTime = 0;
      timeToRunRecipe = 0;
      return;
    }
    if (!hasRecipe(inventory.getStackInSlot(0))) {
      currentRunTime = 0;
      timeToRunRecipe = 0;
      return;
    }

    GreenHouseRecipe recipe = TLXData.greenHouseRecipes.get(inventory.getStackInSlot(0).getItem());
    if (recipe == null) {
      return;
    }
    energyPerTick = recipe.getRFPerTick() * xRfUsage;
    timeToRunRecipe = recipe.getTimePerRecipe() / xTimeToRunRecipe;
    energy.extractEnergy(energyPerTick, false);
    currentRunTime++;
    if (currentRunTime >= timeToRunRecipe) {
      ItemStack[] output = null;
      try {
        output = TLXData.greenHouseRecipes.get(inventory.getStackInSlot(0).getItem()).getOutput();
      } catch (Exception e) {
      }
      for (int i = 0; i < output.length; i++) {
        inventory.insertItem(i + 1, output[i].copy(), false);
      }
      currentRunTime = 0;
      timeToRunRecipe = 0;
      return;
    }
  }

  @Override
  public void load(CompoundTag pTag) {
    timeToRunRecipe = pTag.getInt("timeToRunRecipe");
    currentRunTime = pTag.getInt("currentRunTime");
    inventory.deserializeNBT(pTag.getCompound("inventory"));
    energy.deserializeNBT(pTag.get("energy"));
    super.load(pTag);
  }

  @Override
  public CompoundTag getUpdateTag() {
    return saveWithoutMetadata();
  }

  @Override
  protected void saveAdditional(CompoundTag pTag) {
    pTag.putInt("timeToRunRecipe", timeToRunRecipe);
    pTag.putInt("currentRunTime", currentRunTime);
    pTag.put("inventory", inventory.serializeNBT());
    pTag.put("energy", energy.serializeNBT());
    super.saveAdditional(pTag);
  }

  @Override
  public int getCurrentRunTime() {
    return currentRunTime;
  }

  @Override
  public int getTimeToRunRecipe() {
    return timeToRunRecipe;
  }

  @Override
  public int getRFPerTick() {
    return energyPerTick;
  }

  @Override
  public Component getDisplayName() {
    return Component.literal("Green House");
  }

  @Nullable
  @Override
  public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
    return new MultipleOutSlotMenu(id, inv, inventory, data);
  }

  public boolean hasRecipe(ItemStack stack) {
    if (stack == null || stack.isEmpty()) return false;
    return TLXData.greenHouseRecipes.containsKey(stack.getItem());
  }
}
