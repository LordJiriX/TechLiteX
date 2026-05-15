package io.github.lordjirix.techlitex.api.data.recipe;

import net.minecraft.world.item.ItemStack;

public class GrinderRecipe {
  ItemStack[] output;
  private int RFPerTick;
  private int timePerRecipe;

  public GrinderRecipe(ItemStack[] output, int rf, int time) {
    this.output = output;
    this.RFPerTick = rf;
    this.timePerRecipe = time;
  }

  public ItemStack[] getOutput() {
    return output;
  }

  public int getRFPerTick() {
    return RFPerTick;
  }

  public int getTimePerRecipe() {
    return timePerRecipe;
  }

  public void setOutput(ItemStack[] output) {
    this.output = output;
  }
}
