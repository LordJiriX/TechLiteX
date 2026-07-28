package io.github.lordjirix.techlitex.common.entity;

import io.github.lordjirix.techlitex.loader.TLXBlockEntitys;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WaterSourceEntity extends BlockEntity {
  int waterRate = 5;
  int energyPerTick = 5;
  public FluidTank tank = new FluidTank(4000);
  public EnergyStorage energy = new EnergyStorage(2000, 100, 100);
  LazyOptional<FluidTank> tankCap = LazyOptional.of(() -> tank);
  LazyOptional<EnergyStorage> energyCap = LazyOptional.of(() -> energy);

  public WaterSourceEntity(BlockPos pPos, BlockState pBlockState) {
    super(TLXBlockEntitys.WATER_SOURCE_ENTITY.get(), pPos, pBlockState);
  }

  public void tick() {
    if (level.isClientSide || level == null) {
      return;
    }
    if ((tank.getFluidAmount() + waterRate <= tank.getCapacity())
        && energy.getEnergyStored() >= energyPerTick) {
      tank.fill(new FluidStack(Fluids.WATER, waterRate), IFluidHandler.FluidAction.EXECUTE);
      energy.extractEnergy(energyPerTick, false);
    }
  }

  @Override
  public @NotNull <T> LazyOptional<T> getCapability(
      @NotNull Capability<T> cap, @Nullable Direction side) {
    if (cap == ForgeCapabilities.FLUID_HANDLER) {
      return tankCap.cast();
    }
    if (cap == ForgeCapabilities.ENERGY) {
      return energyCap.cast();
    }
    return super.getCapability(cap, side);
  }

  @Override
  public void invalidateCaps() {
    super.invalidateCaps();
    tankCap.invalidate();
    energyCap.invalidate();
  }

  @Override
  public void load(CompoundTag pTag) {
    super.load(pTag);
    waterRate = pTag.getInt("waterRate");
    if (pTag.contains("tank")) {
      tank.readFromNBT(pTag.getCompound("tank"));
    }
    if (pTag.contains("energy")) {
      energy.deserializeNBT(pTag.getCompound("energy"));
    }
  }

  @Override
  protected void saveAdditional(CompoundTag pTag) {
    super.saveAdditional(pTag);
    pTag.putInt("waterRate", waterRate);
    tank.writeToNBT(pTag.getCompound("tank"));
    pTag.put("energy", energy.serializeNBT());
  }
}
