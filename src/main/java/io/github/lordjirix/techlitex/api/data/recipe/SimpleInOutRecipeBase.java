package io.github.lordjirix.techlitex.api.data.recipe;

import io.github.lordjirix.techlitex.api.data.MD;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class SimpleInOutRecipeBase {

    ItemStack[] output;
    private int RFPerTick;
    private int timePerRecipe;
    private MD.MachineType machineType;

    public SimpleInOutRecipeBase(ItemStack[] output, int rf, int time,MD.MachineType machineType) {
        this.output = output;
        this.RFPerTick = rf;
        this.timePerRecipe = time;
        this.machineType = machineType;
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
    public MD.MachineType getMachineType() {
        return machineType;
    }
}

