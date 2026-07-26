package io.github.lordjirix.techlitex.common.entity;

import io.github.lordjirix.techlitex.api.wrench.IWrenchableEntity;
import io.github.lordjirix.techlitex.loader.TLXBlockEntitys;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;

public class BatteryBoxEntity extends BlockEntity implements IWrenchableEntity {
  private final int capacity = 50_000;
  private final int maxIO = 250;
  public byte outputSide = 0;
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
  private final LazyOptional<IEnergyStorage> energyCap = LazyOptional.of(() -> energy);

  public BatteryBoxEntity(BlockPos pPos, BlockState pBlockState) {
    super(TLXBlockEntitys.BATTERYBOX_BLOCK_ENTITY.get(), pPos, pBlockState);
    /*
     * ADD a pBlockState types to change capacity & maxIO
     */
  }

  public void tick() {
    if (level == null || level.isClientSide()) {
      return;
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
}
