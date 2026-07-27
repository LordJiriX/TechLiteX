package io.github.lordjirix.techlitex.common.entity;

import io.github.lordjirix.techlitex.api.wrench.IWrenchableEntity;
import io.github.lordjirix.techlitex.gui.menu.BatteryBoxMenu;
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
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;
import org.jetbrains.annotations.Nullable;

public class BatteryBoxEntity extends BlockEntity implements IWrenchableEntity, MenuProvider {
  /*
   * TODO: Rework energy extraction
   *  */
  public int capacity = 50_000;
  public int maxIO = 250;
  public byte outputSide = 0;
  public boolean isCreative = false;
  public EnergyStorage energy =
      new EnergyStorage(capacity, maxIO, maxIO) {
        @Override
        public boolean canExtract() {
          return true;
        }

        @Override
        public boolean canReceive() {
          return true;
        }
      };
  public ContainerData data =
      new ContainerData() {

        @Override
        public int get(int pIndex) {
          switch (pIndex) {
            case 0:
              return energy.getEnergyStored();
            case 1:
              return energy.getMaxEnergyStored();
            default:
              return 0;
          }
        }

        @Override
        public void set(int pIndex, int pValue) {
          // I don't need this
        }

        @Override
        public int getCount() {
          return 2;
        }
      };
  private final LazyOptional<IEnergyStorage> energyCap = LazyOptional.of(() -> energy);

  public BatteryBoxEntity(BlockPos pPos, BlockState pBlockState) {
    super(TLXBlockEntitys.BATTERYBOX_BLOCK_ENTITY.get(), pPos, pBlockState);
    if (pBlockState.getBlock() == TLXBlocks.BATTERY_BOX_I.get()) {
      this.maxIO = 250;
      this.capacity = 50_000;
    } else if (pBlockState.getBlock() == TLXBlocks.BATTERY_BOX_II.get()) {
      this.maxIO = 750;
      this.capacity = 100_000;
      energy =
          new EnergyStorage(capacity, maxIO, maxIO) {
            @Override
            public boolean canExtract() {
              return true;
            }

            @Override
            public boolean canReceive() {
              return true;
            }
          };
    } else if (pBlockState.getBlock() == TLXBlocks.BATTERY_BOX_CREATIVE.get()) {
      this.maxIO = Integer.MAX_VALUE;
      this.capacity = Integer.MAX_VALUE;
      this.isCreative = true;
      energy =
          new EnergyStorage(capacity, maxIO, maxIO) {
            @Override
            public boolean canExtract() {
              return true;
            }

            @Override
            public boolean canReceive() {
              return true;
            }
          };
    }
    /*
     * ADD a pBlockState types to change capacity & maxIO
     */
  }

  public void tick() {
    if (level == null || level.isClientSide()) {
      return;
    }
    if (isCreative && energy.getEnergyStored() == 0) {
      energy.receiveEnergy(energy.getMaxEnergyStored(), false);
    }
    BatteryBoxEntity entity = (BatteryBoxEntity) level.getBlockEntity(worldPosition);
    BlockEntity targetBlockEntity =
        level.getBlockEntity(worldPosition.relative(Direction.from3DDataValue(outputSide)));
    for (Direction dir : Direction.values()) {
      if (targetBlockEntity == null) {
        return;
      }
      targetBlockEntity
          .getCapability(ForgeCapabilities.ENERGY, dir)
          .ifPresent(
              cap -> {
                int amount = energy.extractEnergy(maxIO, true);

                int accepted = cap.receiveEnergy(amount, false);

                energy.extractEnergy(accepted, false);
              });
    }
    if (isCreative) {
      energy.receiveEnergy(energy.getMaxEnergyStored(), false);
    }
  }

  @Override
  public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
    if (cap == ForgeCapabilities.ENERGY) {
      return energyCap.cast();
    }

    return super.getCapability(cap, side);
  }

  @Override
  public void invalidateCaps() {
    super.invalidateCaps();
    energyCap.invalidate();
  }

  @Override
  public void load(CompoundTag pTag) {
    super.load(pTag);
    if (pTag.contains("energy")) {
      energy.deserializeNBT(pTag.get("energy"));
    }
    isCreative = pTag.getBoolean("isCreative");
    outputSide = pTag.getByte("outputSide");
  }

  @Override
  public CompoundTag getUpdateTag() {
    return super.getUpdateTag();
  }

  @Override
  protected void saveAdditional(CompoundTag pTag) {
    pTag.put("energy", energy.serializeNBT());
    pTag.putByte("outputSide", outputSide);
    pTag.putBoolean("isCreative", isCreative);
    super.saveAdditional(pTag);
  }

  @Override
  public byte getSide() {
    return outputSide;
  }

  @Override
  public void setSide(byte side) {
    outputSide = side;
  }

  @Override
  public Component getDisplayName() {
    return Component.literal("BatteryBox");
  }

  @Override
  public @Nullable AbstractContainerMenu createMenu(
      int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
    return new BatteryBoxMenu(pContainerId, pPlayerInventory, data);
  }
}
