package io.github.lordjirix.randomcontent.compact.jade.provider;

import io.github.lordjirix.randomcontent.common.entity.CokeOvenBlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

import static io.github.lordjirix.randomcontent.Randomcontent.MODID;

public enum CokeOvenComponentProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        boolean isValid = blockAccessor.getServerData().getBoolean("isValid");
        int timeToRunRecipe =blockAccessor.getServerData().getInt("timeToRunRecipe");
        int currentRunTime = blockAccessor.getServerData().getInt("currentRunTime");
        if (!isValid) {
            iTooltip.add(Component.literal("Structure: " + isValid));
            return;
        }
        iTooltip.add(Component.literal("Structure: " + isValid));
        if (currentRunTime == 0) {
            return;
        }
        iTooltip.add(
                Component.literal(
                        "Time : "
                                + currentRunTime / 20
                                + "/"
                                + timeToRunRecipe / 20
                                + " s"));
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, BlockAccessor blockAccessor) {
        CokeOvenBlockEntity cokeOvenBlockEntity = (CokeOvenBlockEntity) blockAccessor.getBlockEntity();
        compoundTag.putBoolean("isValid",cokeOvenBlockEntity.isValid());
        compoundTag.putInt("timeToRunRecipe", cokeOvenBlockEntity.timeToRunRecipe);
        compoundTag.putInt("currentRunTime", cokeOvenBlockEntity.currentRunTime);
    }
    @Override
    public ResourceLocation getUid() {
        return new ResourceLocation(MODID, "coke_oven_jade");
    }
}
