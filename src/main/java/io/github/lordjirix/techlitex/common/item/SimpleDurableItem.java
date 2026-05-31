package io.github.lordjirix.techlitex.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class SimpleDurableItem extends Item {
  public SimpleDurableItem(Properties properties) {
    super(properties);
  }

  @Override
  public boolean hasCraftingRemainingItem(ItemStack stack) {
    return true;
  }

  @Override
  public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
    ItemStack copy = itemStack.copy();
    copy.setDamageValue(copy.getDamageValue() + 1);
    if (copy.getDamageValue() >= copy.getMaxDamage()) {
      return ItemStack.EMPTY;
    }
    return copy;
  }

    @Override
    public boolean isEnchantable(ItemStack pStack) {
        return false;
    }
}
