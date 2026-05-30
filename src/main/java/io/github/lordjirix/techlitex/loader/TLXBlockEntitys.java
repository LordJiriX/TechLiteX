package io.github.lordjirix.techlitex.loader;

import static io.github.lordjirix.techlitex.TechLiteX.MODID;

import io.github.lordjirix.techlitex.common.entity.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TLXBlockEntitys {
  public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
      DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);

  public static final RegistryObject<BlockEntityType<BedrockMinerBlockEntity>>
      BEDROCK_MINER_BLOCK_ENTITY =
          BLOCK_ENTITIES.register(
              "bedrock_miner_block",
              () ->
                  BlockEntityType.Builder.of(
                          BedrockMinerBlockEntity::new, TLXBlocks.BEDROCK_MINER_BLOCK.get())
                      .build(null));
  public static final RegistryObject<BlockEntityType<GreenHouseBlockEntity>>
      GREENHOUSE_BLOCK_ENTITY =
          BLOCK_ENTITIES.register(
              "greenhouse_block",
              () ->
                  BlockEntityType.Builder.of(
                          GreenHouseBlockEntity::new,
                          TLXBlocks.GREENHOUSE_BLOCK_1.get(),
                          TLXBlocks.GREENHOUSE_BLOCK_2.get())
                      .build(null));
  public static final RegistryObject<BlockEntityType<TimeCompressorBlockEntity>>
      TIME_COMPRESSOR_BLOCK_ENTITY =
          BLOCK_ENTITIES.register(
              "time_compressor_block",
              () ->
                  BlockEntityType.Builder.of(
                          TimeCompressorBlockEntity::new, TLXBlocks.TIME_COMPRESSOR_BLOCK_1.get())
                      .build(null));
  public static final RegistryObject<BlockEntityType<GrinderBlockEntity>> GRINDER_BLOCK_ENTITY =
      BLOCK_ENTITIES.register(
          "grinder_block",
          () ->
              BlockEntityType.Builder.of(
                      GrinderBlockEntity::new,
                      TLXBlocks.GRINDER_BLOCK_1.get(),
                      TLXBlocks.GRINDER_BLOCK_2.get())
                  .build(null));
  public static final RegistryObject<BlockEntityType<CokeOvenBlockEntity>> COKE_OVEN_BLOCK_ENTITY =
      BLOCK_ENTITIES.register(
          "coke_oven_block",
          () ->
              BlockEntityType.Builder.of(CokeOvenBlockEntity::new, TLXBlocks.COKE_OVEN_BLOCK.get())
                  .build(null));
  public static final RegistryObject<BlockEntityType<SeparatorBlockEntity>> SEPARATOR_BLOCK_ENTITY =
      BLOCK_ENTITIES.register(
          "separator_block",
          () ->
              BlockEntityType.Builder.of(
                      SeparatorBlockEntity::new, TLXBlocks.SEPARATOR_BLOCK_1.get())
                  .build(null));

  public static void init(IEventBus bus) {
    BLOCK_ENTITIES.register(bus);
  }
}
