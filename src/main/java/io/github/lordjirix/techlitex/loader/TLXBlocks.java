package io.github.lordjirix.techlitex.loader;

import static io.github.lordjirix.techlitex.TechLiteX.MODID;

import io.github.lordjirix.techlitex.api.block.BaseMachineBlock;
import io.github.lordjirix.techlitex.api.data.MD;
import io.github.lordjirix.techlitex.common.block.*;
import java.util.function.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TLXBlocks {

  public static final DeferredRegister<Block> BLOCKS =
      DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
  // TO REMOVE
  public static final RegistryObject<Block> BEDROCK_MINER_BLOCK =
      createBlock(
          "bedrock_miner_block",
          () ->
              new BlockBedrockMiner(
                  BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(4.0f)));

  public static final RegistryObject<Block> GREENHOUSE_BLOCK_1 =
      createBlock(
          "greenhouse_1",
          () ->
              new BaseMachineBlock(
                  BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(4.0f),
                  MD.MachineType.GREENHOUSE,1));
  public static final RegistryObject<Block> GREENHOUSE_BLOCK_2 =
      createBlock(
          "greenhouse_2",
          () ->
              new BaseMachineBlock(
                  BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(4.0f),
                  MD.MachineType.GREENHOUSE,2));
  public static final RegistryObject<Block> ELEVATOR_BLOCK =
      createBlock(
          "elevator_block",
          () -> new BlockElevator(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));
  public static final RegistryObject<Block> TIME_COMPRESSOR_BLOCK_1 =
      createBlock(
          "time_compressor_block_1",
          () ->
              new TimeCompressorBlock(
                  BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(4.0f)));
  public static final RegistryObject<Block> GRINDER_BLOCK_1 =
      createBlock(
          "grinder_1",
          () ->
              new BaseMachineBlock(
                  BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(4.0f),
                  MD.MachineType.GRINDER,1) {});
  public static final RegistryObject<Block> GRINDER_BLOCK_2 =
      createBlock(
          "grinder_2",
          () ->
              new BaseMachineBlock(
                  BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(4.0f),
                  MD.MachineType.GRINDER,2) {});

  public static final RegistryObject<Block> SEPARATOR_BLOCK_1 =
      createBlock(
          "separator_1",
          () ->
              new BaseMachineBlock(
                  BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(4.0f),
                  MD.MachineType.SEPARATOR,1) {});

  public static final RegistryObject<Block> COKE_OVEN_BLOCK =
      createBlock(
          "coke_oven_block",
          () ->
              new CokeOvenBlock(
                  BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(3.5f)));

  public static final RegistryObject<Block> MACHINE_CASING_STEEL =
      createBlock(
          "machine_casing_steel",
          () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(4.0f)));
  public static final RegistryObject<Block> MACHINE_CASING_ALUMINIUM =
      createBlock(
          "machine_casing_aluminium",
          () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(4.0f)));

  public static final RegistryObject<Block> CASING_WOODEN =
      createBlock(
          "casing_wooden",
          () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(4.0f)));

  public static final RegistryObject<Block> COKE_OVEN_BRICK_BLOCK =
      createBlock(
          "coke_oven_brick_block",
          () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(3.5f)));

  public static final RegistryObject<Block> COKE_OVEN_FIREBOX =
      createBlock(
          "coke_oven_firebox",
          () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(3.5f)));

  private static <T extends Block> RegistryObject<T> createBlock(String name, Supplier<T> block) {
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    createBlockItem(name, toReturn);
    return toReturn;
  }

  private static <T extends Block> RegistryObject<Item> createBlockItem(
      String name, RegistryObject<T> block) {
    return TLXItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
  }

  public static void init(IEventBus bus) {
    BLOCKS.register(bus);
  }
}
