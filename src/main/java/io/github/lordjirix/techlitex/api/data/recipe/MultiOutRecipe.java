package io.github.lordjirix.techlitex.api.data.recipe;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class MultiOutRecipe {
  private final Item input;
  private final int inputCount;

  private ItemStack[] output;

  private final int RFPerTick;
  private final int timePerRecipe;

  public MultiOutRecipe(Item input, int inputCount, ItemStack[] output, int rf, int time) {

    this.input = input;
    this.inputCount = inputCount;
    this.output = output;

    this.RFPerTick = rf;
    this.timePerRecipe = time;
  }

  public Item getInput() {
    return input;
  }

  public int getInputCount() {
    return inputCount;
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
