package io.github.lordjirix.techlitex;

import static io.github.lordjirix.techlitex.loader.TLXItems.*;

import io.github.lordjirix.techlitex.api.data.recipe.GreenHouseRecipe;
import io.github.lordjirix.techlitex.loader.TLXBlocks;
import io.github.lordjirix.techlitex.loader.TLXItems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class TLXData {
  public static int timePerCokeOvenRecipe = Config.timePerCokeOvenRecipe;
  // core

  public static final ArrayList<RegistryObject<Item>> allItemList =
      new ArrayList<>(
          List.of(
              TLXItems.GAME_MODE_SWAPPER,
              TLXItems.GAME_MODE_SWAPPER,
              TLXItems.EXAMPLE_LOOTBAG,
              TLXItems.BEDROCKIUM_INGOT,
              TLXItems.BEDROCKIUM_DRILL,
              TLXItems.DIAMOND_DRILL,
              TLXItems.LASER_CORE,
              TLXItems.PROCESSING_CORE_T1,
              TLXItems.PROCESSING_CORE_T2,
              TLXItems.BEDROCKIUM_DUST,
              TLXItems.STEEL_DUST,
              TLXItems.STEEL_INGOT,
              TLXItems.IRON_DUST,
              TLXItems.SIMPLE_GRINDER,
              TLXItems.TIME_NUGGET,
              TLXItems.TIME_INGOT,
              TLXItems.CHARCOAL_DUST,
              TLXItems.COAL_DUST,
              TLXItems.COKE_OVEN_BRICK,
              TLXItems.COAL_COKE,
              TLXItems.STEEL_PLATE,
              TLXItems.SIMPLE_HAMMER));

  public static final ArrayList<RegistryObject<Block>> allBlockItemsList =
      new ArrayList<>(
          List.of(
              TLXBlocks.BEDROCK_MINER_BLOCK,
              TLXBlocks.ELEVATOR_BLOCK,
              TLXBlocks.GREENHOUSE_BLOCK_1,
              TLXBlocks.TIME_COMPRESSOR_BLOCK_1,
              TLXBlocks.MACHINE_CASING_STEEL,
              TLXBlocks.COKE_OVEN_BLOCK,
              TLXBlocks.COKE_OVEN_BRICK_BLOCK,
              TLXBlocks.COKE_OVEN_FIREBOX));

  // Lootbags data
  public static List<Item> exampleLootbagDrops =
      List.of(Items.COAL, Items.IRON_INGOT, Items.DIAMOND, Items.TORCH);

  // Recipes data
  public static final HashMap<Item, GreenHouseRecipe> greenHouseRecipes =
      new HashMap<>() {
        {
          put(
              Items.OAK_SAPLING,
              new GreenHouseRecipe(
                  new ItemStack[] {
                    new ItemStack(Items.OAK_LOG, 8),
                    new ItemStack(Items.OAK_LEAVES, 4),
                    new ItemStack(Items.APPLE, 1)
                  },
                  60,
                  200));
          put(
              Items.SPRUCE_SAPLING,
              new GreenHouseRecipe(
                  new ItemStack[] {
                    new ItemStack(Items.SPRUCE_LOG, 12), new ItemStack(Items.SPRUCE_LEAVES, 4)
                  },
                  60,
                  200));
          put(
              Items.BIRCH_SAPLING,
              new GreenHouseRecipe(
                  new ItemStack[] {
                    new ItemStack(Items.BIRCH_LOG, 6), new ItemStack(Items.BIRCH_LEAVES, 4)
                  },
                  60,
                  200));
          put(
              Items.JUNGLE_SAPLING,
              new GreenHouseRecipe(
                  new ItemStack[] {
                    new ItemStack(Items.JUNGLE_LOG, 16), new ItemStack(Items.JUNGLE_LEAVES, 8)
                  },
                  60,
                  200));
          put(
              Items.ACACIA_SAPLING,
              new GreenHouseRecipe(
                  new ItemStack[] {
                    new ItemStack(Items.ACACIA_LOG, 8), new ItemStack(Items.ACACIA_LEAVES, 4)
                  },
                  60,
                  200));
          put(
              Items.DARK_OAK_SAPLING,
              new GreenHouseRecipe(
                  new ItemStack[] {
                    new ItemStack(Items.DARK_OAK_LOG, 10), new ItemStack(Items.DARK_OAK_LEAVES, 4)
                  },
                  60,
                  200));
        }
      };
}
