package io.github.lordjirix.techlitex.common.block;

import io.github.lordjirix.techlitex.common.entity.WaterSourceEntity;
import java.util.List;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.Nullable;

public class WaterSourceBlock extends Block implements EntityBlock {

  public WaterSourceBlock(Properties pProperties) {
    super(pProperties);
  }

  @Override
  public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
    return new WaterSourceEntity(pPos, pState);
  }

  @Override
  public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(
      Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
    return pLevel.isClientSide
        ? null
        : (lvl, pos, st, be) -> {
          if (be instanceof WaterSourceEntity te) {
            te.tick();
          }
        };
  }

  /*
   * TODO: Add support for others items (like GT/Cell)
   * TODO: Check if fluid is water
   *  */
  @Override
  public InteractionResult use(
      BlockState pState,
      Level pLevel,
      BlockPos pPos,
      Player pPlayer,
      InteractionHand pHand,
      BlockHitResult pHit) {
    if (pLevel.isClientSide) {
      return InteractionResult.PASS;
    }
    ItemStack itemStack = pPlayer.getItemInHand(pHand);
    if (itemStack.getItem() != Items.BUCKET || itemStack.getItem() == Items.WATER_BUCKET) {
      return InteractionResult.PASS;
    }
    BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
    if (blockEntity instanceof WaterSourceEntity be) {
      if (be.tank.getFluidAmount() > 1000) {
        itemStack.shrink(1);
        be.tank.setFluid(new FluidStack(Fluids.WATER, be.tank.getFluidAmount() - 1000));

        if (!pPlayer.getInventory().add(new ItemStack(Items.WATER_BUCKET))) {
          ItemEntity itemEntity =
              new ItemEntity(
                  pLevel,
                  pPlayer.getX(),
                  pPlayer.getY(),
                  pPlayer.getZ(),
                  new ItemStack(Items.WATER_BUCKET));
          pLevel.addFreshEntity(itemEntity);
        }
      }
    }
    return InteractionResult.SUCCESS;
  }

  @Override
  public void appendHoverText(
      ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
    if (Screen.hasShiftDown()) {
      pTooltip.add(Component.literal("Uses power!"));
      return;
    }
    pTooltip.add(Component.literal("Infinite Water Source"));
    super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
  }
}
