package io.github.lordjirix.techlitex.loader;

import static io.github.lordjirix.techlitex.TechLiteX.MODID;

import io.github.lordjirix.techlitex.TLXData;
import io.github.lordjirix.techlitex.common.item.ItemGameModeSwapper;
import io.github.lordjirix.techlitex.common.item.ItemLootBag;
import io.github.lordjirix.techlitex.common.item.ItemMultiTool;
import io.github.lordjirix.techlitex.common.item.SimpleDurableItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TLXItems {
  public static final DeferredRegister<Item> ITEMS =
      DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

  public static final RegistryObject<Item> MULTI_TOOL =
      ITEMS.register("multi_tool", () -> new ItemMultiTool(new Item.Properties()));
  public static final RegistryObject<Item> GAME_MODE_SWAPPER =
      ITEMS.register("game_mode_swapper", () -> new ItemGameModeSwapper(new Item.Properties()));
  public static final RegistryObject<Item> EXAMPLE_LOOTBAG =
      ITEMS.register(
          "example_lootbag",
          () -> new ItemLootBag(new Item.Properties(), TLXData.exampleLootbagDrops));

  public static final RegistryObject<Item> BEDROCKIUM_DUST =
      ITEMS.register("bedrockium_dust", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> BEDROCKIUM_INGOT =
      ITEMS.register("bedrockium_ingot", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> BEDROCKIUM_DRILL =
      ITEMS.register("bedrockium_drill", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> DIAMOND_DRILL =
      ITEMS.register("diamond_drill", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LASER_CORE =
      ITEMS.register("laser_core", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> PROCESSING_CORE_T1 =
      ITEMS.register("processing_core_t1", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> PROCESSING_CORE_T2 =
      ITEMS.register("processing_core_t2", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> STEEL_DUST =
      ITEMS.register("steel_dust", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> STEEL_INGOT =
      ITEMS.register("steel_ingot", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> IRON_DUST =
      ITEMS.register("iron_dust", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> SIMPLE_GRINDER =
      ITEMS.register("simple_grinder", () -> new SimpleDurableItem(new Item.Properties().durability(64 * 2)));
  public static final RegistryObject<Item> SIMPLE_HAMMER = ITEMS.register("simple_hammer", () -> new SimpleDurableItem(new Item.Properties().durability(64 * 2)));
  public static final RegistryObject<Item> TIME_NUGGET =
      ITEMS.register("time_nugget", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> TIME_INGOT =
      ITEMS.register("time_ingot", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> COAL_DUST =
      ITEMS.register("coal_dust", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> CHARCOAL_DUST =
      ITEMS.register("charcoal_dust", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> COAL_COKE =
      ITEMS.register("coal_coke", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COKE_OVEN_BRICK =
            ITEMS.register("coke_oven_brick", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_PLATE =
            ITEMS.register("steel_plate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COAL_COKE_DUST =
            ITEMS.register("coke_coal_dust", () -> new Item(new Item.Properties()));

  public static void init(IEventBus bus) {
    ITEMS.register(bus);
  }
}
