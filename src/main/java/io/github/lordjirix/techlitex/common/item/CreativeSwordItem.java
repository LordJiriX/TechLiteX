package io.github.lordjirix.techlitex.common.item;

import java.util.List;
import javax.swing.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class CreativeSwordItem extends Item {
  public CreativeSwordItem(Item.Properties properties) {
    super(properties);
  }

  @Override
  public InteractionResult interactLivingEntity(
      ItemStack pStack,
      Player pPlayer,
      LivingEntity pInteractionTarget,
      InteractionHand pUsedHand) {
    super.interactLivingEntity(pStack, pPlayer, pInteractionTarget, pUsedHand);
    if (pPlayer.level().isClientSide) {
      return InteractionResult.SUCCESS;
    }
    DamageSource damageSource = pInteractionTarget.level().damageSources().generic();
    pInteractionTarget.hurt(damageSource, Float.POSITIVE_INFINITY);
    return InteractionResult.SUCCESS;
  }

  @Override
  public void appendHoverText(
      ItemStack pStack,
      @Nullable Level pLevel,
      List<Component> pTooltipComponents,
      TooltipFlag pIsAdvanced) {
    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    pTooltipComponents.add(Component.literal(Float.POSITIVE_INFINITY + " Damage"));
    pTooltipComponents.add(Component.literal("Best sword in the game!"));
    pTooltipComponents.add(Component.literal("by LordJiriX"));
  }
}
