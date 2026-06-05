package io.github.lordjirix.techlitex.api.block;

import io.github.lordjirix.techlitex.loader.TLXBlockEntitys;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BaseMachineEntity extends BlockEntity {
  public int timeToRunRecipe = 0;
  public int currentRunTime = 0;
  public int energyPerTick = 0;
  public int xTimeToRunRecipe = 1;
  public int xRfUsage = 1;
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

  public BaseMachineEntity(BlockPos pPos, BlockState pBlockState) {
    super(TLXBlockEntitys.GRINDER_BLOCK_ENTITY.get(), pPos, pBlockState);
  }
}
