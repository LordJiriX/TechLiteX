package io.github.lordjirix.techlitex.api.data;

import static io.github.lordjirix.techlitex.loader.TLXBlockEntitys.*;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;

public class MD {
  public static enum MachineType {
    GRINDER(GRINDER_BLOCK_ENTITY),
    SEPARATOR(SEPARATOR_BLOCK_ENTITY),
    TIME_COMPRESSOR(TIME_COMPRESSOR_BLOCK_ENTITY),
    BEDROCK_MINER(BEDROCK_MINER_BLOCK_ENTITY),
    GREENHOUSE(GREENHOUSE_BLOCK_ENTITY);
    private final RegistryObject<? extends BlockEntityType<?>> blockEntityType;

    MachineType(RegistryObject<? extends BlockEntityType<?>> blockEntityType) {
      this.blockEntityType = blockEntityType;
    }

    public RegistryObject<? extends BlockEntityType<?>> getBlockEntityType() {
      return blockEntityType;
    }
  }
}
