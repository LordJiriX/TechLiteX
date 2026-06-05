package io.github.lordjirix.techlitex.api.block;

import io.github.lordjirix.techlitex.api.data.MD;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class BaseMachineBlock extends BaseBlock implements EntityBlock {

  private MD.MachineType machineType;

  public BaseMachineBlock(Properties properties, MD.MachineType machineType) {
    super(properties);
    this.machineType = machineType;
  }

  @Override
  public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
    System.out.println(machineType.getBlockEntityType().getId());
    return machineType.getBlockEntityType().get().create(pos, state);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <E extends BlockEntity> @Nullable BlockEntityTicker<E> getTicker(
      Level level, BlockState state, BlockEntityType<E> blockEntityType) {
    return level.isClientSide
        ? null
        : (lvl, pos, st, be) -> {
          if (be instanceof IBlockEntityMachineBase tbe) {
            tbe.tick();
          }
        };
  }

  @Override
  public InteractionResult use(
      BlockState state,
      Level level,
      BlockPos pos,
      Player player,
      InteractionHand hand,
      BlockHitResult hit) {
    if (!level.isClientSide) {
      BlockEntity be = level.getBlockEntity(pos);
      if (be instanceof MenuProvider provider) {
        NetworkHooks.openScreen((ServerPlayer) player, provider, pos);
      }
    }
    return InteractionResult.sidedSuccess(level.isClientSide);
  }
}
