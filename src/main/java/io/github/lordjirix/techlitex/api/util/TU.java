package io.github.lordjirix.techlitex.api.util;

import java.util.List;
import net.minecraft.network.chat.Component;

public class TU {
  public static void addRecipeVoidTimeWhenInvFull(List<Component> l) {
    l.add(Component.translatable("tooltip.tlx.machine.recipe_voiding"));
  }
}
