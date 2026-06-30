package io.github.lordjirix.techlitex.api.data.recipe;

import io.github.lordjirix.techlitex.api.data.MD;
import net.minecraft.world.item.ItemStack;

public class GrinderRecipe extends SimpleInOutRecipeBase{
    private final ItemStack input;
    private final ItemStack[] output;
    private final int timePerRecipe;
    private final int rfPerTick;

    public GrinderRecipe(ItemStack input,ItemStack[] output, int rf, int time) {
      super(output, rf, time, MD.MachineType.GRINDER);
    this.output = output;
    this.rfPerTick = rf;
    this.timePerRecipe = time;
    this.input = input;
  }

  public ItemStack[] getOutput() {
    return output;
  }

  public int getRFPerTick() {
    return rfPerTick;
  }

  public int getTimePerRecipe() {
    return timePerRecipe;
  }
  public ItemStack getInput() {
        return input;
  }

}
