package io.github.lordjirix.techlitex.api.block;

import io.github.lordjirix.techlitex.api.data.MD;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
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
  private int lvl;

  public BaseMachineBlock(Properties properties, MD.MachineType machineType, int lvl) {
    super(properties);
    this.machineType = machineType;
    this.lvl = lvl;
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

  @Override
  public void appendHoverText(
      ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
    int speed_factor = 1;
    int energy_usage = 1;
    if (lvl == 2) {
      speed_factor = 2;
      energy_usage = 4;
    }
    pTooltip.add(Component.literal("type: " + machineType.getName()));
    pTooltip.add(Component.literal("speed: base/" + speed_factor));
    pTooltip.add(Component.literal("energy: base*" + energy_usage));
    super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
  }
}
