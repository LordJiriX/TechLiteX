package io.github.lordjirix.techlitex.common.entity;

import io.github.lordjirix.techlitex.TLXData;
import io.github.lordjirix.techlitex.api.block.IBlockEntityMachineBase;
import io.github.lordjirix.techlitex.api.block.IRecipeRunnable;
import io.github.lordjirix.techlitex.api.data.recipe.GrinderRecipe;
import io.github.lordjirix.techlitex.gui.menu.SimpleInOutMenu;
import io.github.lordjirix.techlitex.loader.TLXBlockEntitys;
import io.github.lordjirix.techlitex.loader.TLXBlocks;
import java.util.HashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
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

public class GrinderBlockEntity extends BlockEntity
    implements MenuProvider, IRecipeRunnable, IBlockEntityMachineBase {
  public int timeToRunRecipe = 0;
  public int currentRunTime = 0;
  public int energyPerTick = 0;
  public int xTimeToRunRecipe = 1;
  public int xRfUsage = 1;
  public HashMap<Item, GrinderRecipe> recipes = TLXData.grinderRecipes;
  private final ItemStackHandler inventory =
      new ItemStackHandler(2) {
        @Override
        protected void onContentsChanged(int slot) {
          setChanged();
        }
      };
  private final EnergyStorage energy = new EnergyStorage(100000, 1000, 1000) {};
  private final LazyOptional<IEnergyStorage> energyCap = LazyOptional.of(() -> energy);
  private final LazyOptional<IItemHandler> itemHandler = LazyOptional.of(() -> inventory);

  public GrinderBlockEntity(BlockPos pPos, BlockState pBlockState) {
    super(TLXBlockEntitys.GRINDER_BLOCK_ENTITY.get(), pPos, pBlockState);
    // maybe need rework
    if (pBlockState.getBlock() == TLXBlocks.GRINDER_BLOCK_1.get()) {
      this.xRfUsage = 1;
      this.xTimeToRunRecipe = 1;
    }
    if (pBlockState.getBlock() == TLXBlocks.GRINDER_BLOCK_2.get()) {
      this.xRfUsage = 4;
      this.xTimeToRunRecipe = 2;
    }
  }

  @Override
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
    if (inventory.getStackInSlot(1).getCount() >= inventory.getStackInSlot(1).getMaxStackSize()) {
      currentRunTime = 0;
      timeToRunRecipe = 0;
      return;
    }
    if (!hasRecipe(inventory.getStackInSlot(0))) {
      currentRunTime = 0;
      timeToRunRecipe = 0;
      return;
    }

    GrinderRecipe recipe = recipes.get(inventory.getStackInSlot(0).getItem());
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
        output = recipes.get(inventory.getStackInSlot(0).getItem()).getOutput();
      } catch (Exception e) {
      }
      for (int i = 0; i < output.length; i++) {
        inventory.insertItem(i + 1, output[i].copy(), false);
      }
      inventory.extractItem(0, 1, false);
      currentRunTime = 0;
      timeToRunRecipe = 0;
      return;
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

  @Override
  public Component getDisplayName() {
    return Component.literal("Grinder");
  }

  @Override
  protected void saveAdditional(CompoundTag pTag) {
    super.saveAdditional(pTag);
    pTag.putInt("timeToRunRecipe", timeToRunRecipe);
    pTag.putInt("currentRunTime", currentRunTime);
    pTag.putInt("energyPerTick", energyPerTick);
    pTag.put("inventory", inventory.serializeNBT());
    pTag.put("energy", energy.serializeNBT());
  }

  @Override
  public void load(CompoundTag pTag) {
    super.load(pTag);
    inventory.deserializeNBT(pTag.getCompound("inventory"));
    currentRunTime = pTag.getInt("currentRunTime");
    timeToRunRecipe = pTag.getInt("timeToRunRecipe");
    energyPerTick = pTag.getInt("energyPerTick");
    energy.deserializeNBT(pTag.get("energy"));
  }

  @Override
  public @Nullable AbstractContainerMenu createMenu(
      int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
    return new SimpleInOutMenu(pContainerId, pPlayerInventory, inventory);
  }

  public boolean hasRecipe(ItemStack stack) {
    if (stack == null || stack.isEmpty()) return false;
    return recipes.containsKey(stack.getItem());
  }

  @Override
  public int getTimeToRunRecipe() {
    return timeToRunRecipe;
  }

  @Override
  public int getCurrentRunTime() {
    return currentRunTime;
  }

  @Override
  public int getRFPerTick() {
    return energyPerTick;
  }
}
