package io.github.lordjirix.techlitex.common.item;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class EItem extends Item {
  private String[] tooltip;

  public EItem(Properties properties, String[] tooltip) {
    super(properties);
    this.tooltip = tooltip;
  }

  @Override
  public void appendHoverText(
      ItemStack pStack,
      @Nullable Level pLevel,
      List<Component> pTooltipComponents,
      TooltipFlag pIsAdvanced) {
    super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    if (tooltip != null) {
      for (String s : tooltip) {
        pTooltipComponents.add(Component.literal(s));
      }
    }
  }
}
