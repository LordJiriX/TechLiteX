package io.github.lordjirix.techlitex.common.block;

import io.github.lordjirix.techlitex.api.block.BaseBlock;
import io.github.lordjirix.techlitex.common.entity.BatteryBoxEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class BatteryBoxBlock extends BaseBlock implements EntityBlock {
  public BatteryBoxBlock(Properties pProperties) {
    super(pProperties);
  }

  @Override
  public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
    return new BatteryBoxEntity(pPos, pState);
  }
}
