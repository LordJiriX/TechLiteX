package io.github.lordjirix.techlitex.api.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.Nullable;

public class BaseBlock extends Block {
  public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

  public BaseBlock(Properties pProperties) {
    super(pProperties);
    this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
  }

  @Override
  public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
    return this.defaultBlockState()
        .setValue(FACING, pContext.getHorizontalDirection().getOpposite());
  }

  @Override
  public BlockState rotate(
      BlockState state, LevelAccessor level, BlockPos pos, Rotation direction) {
    return state.setValue(FACING, direction.rotate(state.getValue(FACING)));
  }

  @Override
  public BlockState mirror(BlockState pState, Mirror pMirror) {
    return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
    super.createBlockStateDefinition(pBuilder);
    pBuilder.add(FACING);
  }
}
