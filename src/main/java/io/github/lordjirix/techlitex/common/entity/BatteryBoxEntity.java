package io.github.lordjirix.techlitex.common.entity;

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

public class BatteryBoxEntity extends BlockEntity {
  private final int capacity = 100000;
  private final int maxIO = 1000;
  private final EnergyStorage energy =
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

  public void tick() {}

  @Override
  public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {

    if (cap == ForgeCapabilities.ENERGY) {
      return LazyOptional.of(() -> energy).cast();
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
  }

  @Override
  public CompoundTag getUpdateTag() {
    return super.getUpdateTag();
  }

  @Override
  protected void saveAdditional(CompoundTag pTag) {
    pTag.put("energy", energy.serializeNBT());
    super.saveAdditional(pTag);
  }
}
