package io.github.lordjirix.techlitex.common.item;

import io.github.lordjirix.techlitex.api.wrench.IWrenchMinable;
import io.github.lordjirix.techlitex.api.wrench.IWrenchableEntity;
import java.util.List;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.Nullable;

public class WrenchItem extends Item {
  public WrenchItem(Properties properties) {
    super(properties);
  }

  @Override
  public InteractionResult useOn(UseOnContext pContext) {
    if (pContext.getLevel().isClientSide) {
      return InteractionResult.PASS;
    }
    ItemStack itemstack = pContext.getItemInHand();
    checkNBT(itemstack);
    int mode = itemstack.getTag().getInt("mode");
    if (mode == 0) {
      mode0Task(pContext.getClickedPos(), pContext.getLevel());
      itemstack.hurtAndBreak(
          1, pContext.getPlayer(), (p) -> p.broadcastBreakEvent(pContext.getHand()));
      return InteractionResult.SUCCESS;
    }
    if (mode == 1) {
      mode1task(pContext.getClickedPos(), pContext.getLevel(), pContext.getClickedFace());
      itemstack.hurtAndBreak(
          1, pContext.getPlayer(), (p) -> p.broadcastBreakEvent(pContext.getHand()));
      return InteractionResult.SUCCESS;
    }
    return InteractionResult.SUCCESS;
  }

  @Override
  public InteractionResultHolder<ItemStack> use(
      Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
    ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
    if (itemstack == null) {
      return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }
    if (!(itemstack.getItem() instanceof WrenchItem)) {
      return InteractionResultHolder.pass(itemstack);
    }
    if (!pPlayer.isShiftKeyDown()) {
      return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }
    int mode = getMode(itemstack);
    mode++;
    switch (mode) {
      case 2:
        {
          mode = 0;
          break;
        }
      case 1:
        {
        }
    }
    itemstack.getTag().putInt("mode", mode);
    pPlayer.displayClientMessage(Component.literal("Mode: " + mode), true);
    return InteractionResultHolder.consume(itemstack);
  }

  @Override
  public void appendHoverText(
      ItemStack pStack,
      @Nullable Level pLevel,
      List<Component> pTooltipComponents,
      TooltipFlag pIsAdvanced) {
    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    if (Screen.hasShiftDown()) {
      pTooltipComponents.add(Component.literal("Press Shift + Right-Click to change mode"));
      return;
    }
    pTooltipComponents.add(Component.literal("Mode: " + getMode(pStack)));
  }

  void checkNBT(ItemStack stack) {
    if (!stack.hasTag()) {
      CompoundTag tag = new CompoundTag();
      stack.setTag(tag);
    }
  }

  int getMode(ItemStack stack) {
    checkNBT(stack);
    return stack.getTag().getInt("mode");
  }

  void mode0Task(BlockPos pos, Level level) {
    Block block = level.getBlockState(pos).getBlock();
    if (block instanceof IWrenchMinable) {
      level.destroyBlock(pos, true);
    }
  }

  void mode1task(BlockPos pos, Level level, Direction direction) {
    BlockEntity blockEntity = level.getBlockEntity(pos);
    if (blockEntity instanceof IWrenchableEntity) {
      ((IWrenchableEntity) blockEntity).setSide((byte) direction.get3DDataValue());
    }
  }
}
