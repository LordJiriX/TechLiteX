package io.github.lordjirix.techlitex.loader;

import static io.github.lordjirix.techlitex.TechLiteX.MODID;

import io.github.lordjirix.techlitex.common.item.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TLXItems {
  public static final DeferredRegister<Item> ITEMS =
      DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

  public static final RegistryObject<Item> MULTI_TOOL =
      ITEMS.register("multi_tool", () -> new ItemMultiTool(new Item.Properties()));
  public static final RegistryObject<Item> CREATIVE_SWORD =
      ITEMS.register("creative_sword", () -> new CreativeSwordItem(new Item.Properties()));
  public static final RegistryObject<Item> GAME_MODE_SWAPPER =
      ITEMS.register("game_mode_swapper", () -> new ItemGameModeSwapper(new Item.Properties()));
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
  // ELECTRONICS
  public static final RegistryObject<Item> PROCESSOR =
      ITEMS.register("processor", () -> new Item(new Item.Properties())); // I
  public static final RegistryObject<Item> DOUBLE_LAYERED_PROCESSOR =
      ITEMS.register("double_layered_processor", () -> new Item(new Item.Properties())); // II
  public static final RegistryObject<Item> INTEGRATED_PROCESSOR =
      ITEMS.register("integrated_processor", () -> new Item(new Item.Properties())); // I
  public static final RegistryObject<Item> INTEGRATED_ARRAY =
      ITEMS.register("integrated_array", () -> new Item(new Item.Properties())); // II
  public static final RegistryObject<Item> NANO_PROCESSOR =
      ITEMS.register("nano_processor", () -> new Item(new Item.Properties())); // III
  /*public static final RegistryObject<Item> NANO_MAINFRAME =
  ITEMS.register("nano_mainframe", () -> new Item(new Item.Properties())); // III*/
  public static final RegistryObject<Item> QUANTUM_PROCESSOR =
      ITEMS.register("quantum_processor", () -> new Item(new Item.Properties())); // IV
  /* public static final RegistryObject<Item> QUANTUM_MAINFRAME =
          ITEMS.register("quantum_mainframe", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> QUANTUM_MICROCHIP =
          ITEMS.register("quantum_microchip", () -> new Item(new Item.Properties()));*/
  public static final RegistryObject<Item> PICO_CHIP =
      ITEMS.register("pico_chip", () -> new Item(new Item.Properties())); // V
  public static final RegistryObject<Item> FEMTO_CHIP =
      ITEMS.register("femto_chip", () -> new Item(new Item.Properties())); // VI
  public static final RegistryObject<Item> ARTIFICIAL_CHIP =
      ITEMS.register(
          "artificial_chip",
          () ->
              new Item(new Item.Properties()) {
                @Override
                public boolean isFoil(ItemStack pStack) {
                  return true;
                }
              }); // VII
  public static final RegistryObject<Item> UNIVERSAL_CHIP =
      ITEMS.register("universal_chip", () -> new Item(new Item.Properties())); // ALL

  // ELECTRONICS COMPONENTS
  public static final RegistryObject<Item> SMALL_BATTERY =
      ITEMS.register("small_battery", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> BASIC_BOARD =
      ITEMS.register("basic_board", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> REDSTONE_BOARD =
      ITEMS.register("redstone_board", () -> new Item(new Item.Properties()));
  // TOOLS
  public static final RegistryObject<Item> WRENCH =
      ITEMS.register("wrench", () -> new WrenchItem(new Item.Properties().durability(100)));
  public static final RegistryObject<Item> SIMPLE_GRINDER =
      ITEMS.register(
          "simple_grinder", () -> new SimpleDurableItem(new Item.Properties().durability(64 * 2)));
  public static final RegistryObject<Item> SIMPLE_HAMMER =
      ITEMS.register(
          "simple_hammer", () -> new SimpleDurableItem(new Item.Properties().durability(64 * 2)));
  public static final RegistryObject<Item> WIRECUTTER =
      ITEMS.register(
          "wirecutter", () -> new SimpleDurableItem(new Item.Properties().durability(64 * 2)));
  public static final RegistryObject<Item> BRICK_FORM =
      ITEMS.register(
          "brick_form", () -> new SimpleDurableItem(new Item.Properties().durability(64 * 2)));

  public static final RegistryObject<Item> TIME_NUGGET =
      ITEMS.register("time_nugget", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> TIME_INGOT =
      ITEMS.register("time_ingot", () -> new Item(new Item.Properties()));
  // DUSTS
  public static final RegistryObject<Item> STEEL_DUST =
      ITEMS.register("steel_dust", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> STEEL_INGOT =
      ITEMS.register("steel_ingot", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> IRON_DUST =
      ITEMS.register("iron_dust", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> CLAY_DUST =
      ITEMS.register("clay_dust", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> CARBON_DUST =
      ITEMS.register("carbon_dust", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> LITHIUM_DUST =
      ITEMS.register("lithium_dust", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> SODIUM_DUST =
      ITEMS.register("sodium_dust", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> ALUMINIUM_DUST =
      ITEMS.register("aluminium_dust", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> ALUMINIUM_INGOT =
      ITEMS.register("aluminium_ingot", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> COAL_DUST =
      ITEMS.register("coal_dust", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> CHARCOAL_DUST =
      ITEMS.register("charcoal_dust", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> COAL_COKE =
      ITEMS.register("coal_coke", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> COKE_OVEN_BRICK =
      ITEMS.register("coke_oven_brick", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> RAW_COKE_OVEN_BRICK =
      ITEMS.register("raw_coke_oven_brick", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> COAL_COKE_DUST =
      ITEMS.register("coke_coal_dust", () -> new Item(new Item.Properties()));
  // PLATES
  public static final RegistryObject<Item> STEEL_PLATE =
      ITEMS.register("steel_plate", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> DIAMOND_PLATE =
      ITEMS.register("diamond_plate", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> ALUMINIUM_PLATE =
      ITEMS.register("aluminium_plate", () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> IRON_PLATE =
      ITEMS.register("iron_plate", () -> new Item(new Item.Properties()));

  // SAWBLADES
  public static final RegistryObject<Item> DIAMOND_SAWBLADE =
      ITEMS.register(
          "diamond_sawblade",
          () -> new EItem(new Item.Properties(), new String[] {"Tier: diamond"}));
  public static final RegistryObject<Item> NETHERITE_SAWBLADE =
      ITEMS.register(
          "netherite_sawblade",
          () -> new EItem(new Item.Properties(), new String[] {"Tier: netherite"}));
  // WIRES
  public static final RegistryObject<Item> COPPER_WIRE =
      ITEMS.register(
          "copper_wire",
          () -> new EItem(new Item.Properties(), new String[] {"§4This not transfer power"}));
  public static final RegistryObject<Item> GOLD_WIRE =
      ITEMS.register(
          "gold_wire",
          () -> new EItem(new Item.Properties(), new String[] {"§4This not transfer power"}));
  // MISC
  public static final RegistryObject<Item> RAW_BRICK_FORM =
      ITEMS.register("raw_brick_form", () -> new Item(new Item.Properties()));

  public static void init(IEventBus bus) {
    ITEMS.register(bus);
  }
}
