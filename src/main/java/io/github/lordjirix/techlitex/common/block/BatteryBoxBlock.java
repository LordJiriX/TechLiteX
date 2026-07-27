package io.github.lordjirix.techlitex.common.block;

import io.github.lordjirix.techlitex.common.entity.BatteryBoxEntity;
import io.github.lordjirix.techlitex.loader.TLXItems;
import java.util.List;
import net.minecraft.client.gui.screens.Screen;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class BatteryBoxBlock extends Block implements EntityBlock {

  private final boolean isCreative;

  public BatteryBoxBlock(Properties pProperties, boolean isCreative) {
    super(pProperties);
    this.isCreative = isCreative;
  }

  @Override
  public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
    return new BatteryBoxEntity(pPos, pState);
  }

  @Override
  public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(
      Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
    return pLevel.isClientSide
        ? null
        : (lvl, pos, st, be) -> {
          if (be instanceof BatteryBoxEntity te) {
            te.tick();
          }
        };
  }

  @Override
  public InteractionResult use(
      BlockState pState,
      Level pLevel,
      BlockPos pPos,
      Player pPlayer,
      InteractionHand pHand,
      BlockHitResult pHit) {
    if (!pLevel.isClientSide) {
      if (isCreative) {
        return InteractionResult.SUCCESS;
      }
      BlockEntity be = pLevel.getBlockEntity(pPos);
      ItemStack itemstack = pPlayer.getItemInHand(pHand);
      if (itemstack.getItem() == TLXItems.WRENCH.get()) {
        return InteractionResult.PASS;
      }
      if (be instanceof MenuProvider provider) {
        NetworkHooks.openScreen((ServerPlayer) pPlayer, provider, pPos);
      }
    }
    return InteractionResult.sidedSuccess(pLevel.isClientSide);
  }

  @Override
  public void appendHoverText(
      ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
    super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    if (Screen.hasShiftDown()) {
      pTooltip.add(Component.literal("Lose all energy when break"));
      pTooltip.add(Component.literal("Output Energy only from output side"));
    }
    pTooltip.add(Component.literal("Energy Box!!!"));
    pTooltip.add(Component.literal("Store Energy"));
  }
}
