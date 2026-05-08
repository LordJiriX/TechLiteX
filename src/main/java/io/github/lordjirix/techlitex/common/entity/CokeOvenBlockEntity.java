package io.github.lordjirix.techlitex.common.entity;

import io.github.lordjirix.techlitex.Config;
import io.github.lordjirix.techlitex.gui.menu.CokeOvenMenu;
import io.github.lordjirix.techlitex.loader.TLXBlockEntitys;
import io.github.lordjirix.techlitex.loader.TLXBlocks;
import io.github.lordjirix.techlitex.loader.TLXItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

// TODO: Remake structure
public class CokeOvenBlockEntity extends BlockEntity implements MenuProvider {
  public boolean isMultiblockValid = false;
  public int timeToRunRecipe = Config.timePerCokeOvenRecipe;
  public int currentRunTime = 0;
  private final ItemStackHandler inventory =
      new ItemStackHandler(2) {
        @Override
        protected void onContentsChanged(int slot) {
          setChanged();
        }
      };
  private final LazyOptional<IItemHandler> itemHandler = LazyOptional.of(() -> inventory);

  public CokeOvenBlockEntity(BlockPos pPos, BlockState pBlockState) {
    super(TLXBlockEntitys.COKE_OVEN_BLOCK_ENTITY.get(), pPos, pBlockState);
  }

  public void tick() {
    if (level.isClientSide()) return;

    isMultiblockValid = isMultiblockValid(getBlockPos());

    if (!isMultiblockValid) {
      return;
    }

    if (inventory.getStackInSlot(0).isEmpty()) {
      currentRunTime = 0;
      return;
    }
    if (inventory.getStackInSlot(0).getItem() != Items.COAL) {
      currentRunTime = 0;
      return;
    }
    ;

    currentRunTime++;
    if (currentRunTime >= timeToRunRecipe) {
      inventory.extractItem(0, 1, false);
      inventory.insertItem(1, new ItemStack(TLXItems.COAL_COKE.get(), 1), false);
      currentRunTime = 0;
    }
    setChanged();
  }

  @Override
  public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
    if (cap == ForgeCapabilities.ITEM_HANDLER) {
      return itemHandler.cast();
    }
    return super.getCapability(cap);
  }

  @Override
  public void load(CompoundTag pTag) {
    super.load(pTag);
    isMultiblockValid = pTag.getBoolean("isMultiblockValid");
    timeToRunRecipe = pTag.getInt("timeToRunRecipe");
    currentRunTime = pTag.getInt("currentRunTime");
    inventory.deserializeNBT(pTag.getCompound("inventory"));
  }

  @Override
  protected void saveAdditional(CompoundTag pTag) {
    super.saveAdditional(pTag);
    pTag.putBoolean("isMultiblockValid", isMultiblockValid);
    pTag.putInt("timeToRunRecipe", timeToRunRecipe);
    pTag.putInt("currentRunTime", currentRunTime);
    pTag.put("inventory", inventory.serializeNBT());
  }

  @Override
  public void invalidateCaps() {
    super.invalidateCaps();
    itemHandler.invalidate();
  }

  public boolean isMultiblockValid(BlockPos pos) {
    if (level == null) return false;
    Block brick = TLXBlocks.COKE_OVEN_BRICK_BLOCK.get();
    Block firebox = TLXBlocks.COKE_OVEN_FIREBOX.get();
    if (!level.getBlockState(pos.below()).is(firebox)) return false;
    BlockPos[] requiredBricks =
        new BlockPos[] {
          pos.above(),
          pos.offset(0, -1, 1),
          pos.offset(1, -1, 0),
          pos.offset(0, -1, -1),
          pos.offset(-1, -1, 0)
        };
    for (BlockPos p : requiredBricks) {
      if (!level.getBlockState(p).is(brick)) return false;
    }
    return true;
  }

  public boolean isValid() {
    return isMultiblockValid;
  }

  @Override
  public Component getDisplayName() {
    return Component.literal("Coke Oven");
  }

  @Override
  public @Nullable AbstractContainerMenu createMenu(
      int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
    return new CokeOvenMenu(pContainerId, pPlayerInventory, inventory);
  }
}
