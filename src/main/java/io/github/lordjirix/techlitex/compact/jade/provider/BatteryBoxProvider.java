package io.github.lordjirix.techlitex.compact.jade.provider;

import io.github.lordjirix.techlitex.api.block.IRecipeRunnable;
import io.github.lordjirix.techlitex.common.entity.BatteryBoxEntity;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

import static io.github.lordjirix.techlitex.TechLiteX.MODID;

public enum BatteryBoxProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;
    @Override
    public void appendTooltip(
            ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        if (blockAccessor.getServerData().contains("outputSide")) {

           iTooltip.add(Component.literal("Output side: " + Direction.from3DDataValue(blockAccessor.getServerData().getByte("outputSide"))));
        }
    }
    @Override
    public void appendServerData(CompoundTag compoundTag, BlockAccessor blockAccessor) {
        BatteryBoxEntity batteryBoxEntity = (BatteryBoxEntity) blockAccessor.getBlockEntity();
        compoundTag.putByte("outputSide",batteryBoxEntity.getSide());
    }

    @Override
    public ResourceLocation getUid() {
        return new ResourceLocation(MODID, "batterybox");
    }
}