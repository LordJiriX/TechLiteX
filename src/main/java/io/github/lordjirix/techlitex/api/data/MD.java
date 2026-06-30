package io.github.lordjirix.techlitex.api.data;

import static io.github.lordjirix.techlitex.loader.TLXBlockEntitys.*;

import io.github.lordjirix.techlitex.loader.TLXBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;

public class MD {
  public static enum MachineType {
    GRINDER(GRINDER_BLOCK_ENTITY, "Grinder", TLXBlocks.GRINDER_BLOCK_1),
    SEPARATOR(SEPARATOR_BLOCK_ENTITY, "Separator", TLXBlocks.SEPARATOR_BLOCK_1),
    TIME_COMPRESSOR(TIME_COMPRESSOR_BLOCK_ENTITY, "Time Compressor", TLXBlocks.TIME_COMPRESSOR_BLOCK_1),
    GREENHOUSE(GREENHOUSE_BLOCK_ENTITY, "Greenhouse", TLXBlocks.GREENHOUSE_BLOCK_1),
    ;

    private final RegistryObject<? extends BlockEntityType<?>> blockEntityType;
    private final String name;
    private final RegistryObject<Block> icon;

    MachineType(
        RegistryObject<? extends BlockEntityType<?>> blockEntityType,
        String name,
        RegistryObject<Block> icon) {
      this.blockEntityType = blockEntityType;
      this.name = name;
      this.icon = icon;
    }

    public RegistryObject<? extends BlockEntityType<?>> getBlockEntityType() {
      return blockEntityType;
    }

    /*public Object getRecipe() {
        return recipe;
    }*/
    public String getName() {
      return name;
    }

    public RegistryObject<Block> getIcon() {
      return icon;
    }
  }
}
