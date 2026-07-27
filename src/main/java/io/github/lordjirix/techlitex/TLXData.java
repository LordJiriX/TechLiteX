package io.github.lordjirix.techlitex;

import static io.github.lordjirix.techlitex.loader.TLXBlocks.*;
import static io.github.lordjirix.techlitex.loader.TLXItems.*;

import io.github.lordjirix.techlitex.api.data.recipe.GrinderRecipe;
import io.github.lordjirix.techlitex.api.data.recipe.MultiOutRecipe;
import io.github.lordjirix.techlitex.api.data.recipe.SeparatorRecipe;
import io.github.lordjirix.techlitex.loader.TLXBlocks;
import io.github.lordjirix.techlitex.loader.TLXItems;
import java.util.ArrayList;
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
              TLXItems.BEDROCKIUM_INGOT,
              TLXItems.BEDROCKIUM_DRILL,
              TLXItems.DIAMOND_DRILL,
              TLXItems.LASER_CORE,
              TLXItems.PROCESSOR,
              // TLXItems.INTEGRATED_PROCESSOR,
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
              IRON_PLATE,
              TLXItems.SIMPLE_HAMMER,
              ALUMINIUM_INGOT,
              ALUMINIUM_DUST,
              CLAY_DUST,
              DIAMOND_SAWBLADE,
              COPPER_WIRE,
              ALUMINIUM_PLATE,
              WIRECUTTER,
              BASIC_BOARD,
              REDSTONE_BOARD,
              CARBON_DUST,
              BRICK_FORM,
              RAW_BRICK_FORM,
              RAW_COKE_OVEN_BRICK,
              NETHERITE_SAWBLADE,
              QUANTUM_PROCESSOR,
              NANO_PROCESSOR,
              DOUBLE_LAYERED_PROCESSOR,
              ARTIFICIAL_CHIP,
              CREATIVE_SWORD,
              LITHIUM_DUST,
              SODIUM_DUST,
              WRENCH,
              SMALL_BATTERY));
  public static final ArrayList<RegistryObject<Block>> allBlockItemsList =
      new ArrayList<>(
          List.of(
              /* MACHINES */
              TLXBlocks.GREENHOUSE_BLOCK_1,
              TLXBlocks.GREENHOUSE_BLOCK_2,
              TLXBlocks.GRINDER_BLOCK_1,
              TLXBlocks.GRINDER_BLOCK_2,
              TLXBlocks.SEPARATOR_BLOCK_1,
              TLXBlocks.COKE_OVEN_BLOCK,
              /* JUST BLOCKS*/
              TLXBlocks.MACHINE_CASING_STEEL,
              TLXBlocks.COKE_OVEN_BRICK_BLOCK,
              TLXBlocks.COKE_OVEN_FIREBOX,
              TLXBlocks.CASING_WOODEN,
              TLXBlocks.MACHINE_CASING_ALUMINIUM,
              BATTERY_BOX_I,
              BATTERY_BOX_II,
              MACHINE_CASING_COPPER));
  // Recipes data
  public static final List<MultiOutRecipe> greenHouseRecipes =
      List.of(
          new MultiOutRecipe(
              Items.OAK_SAPLING,
              1,
              new ItemStack[] {
                new ItemStack(Items.OAK_LOG, 8),
                new ItemStack(Items.OAK_LEAVES, 4),
                new ItemStack(Items.APPLE, 1)
              },
              60,
              20 * 20),
          new MultiOutRecipe(
              Items.SPRUCE_SAPLING,
              1,
              new ItemStack[] {
                new ItemStack(Items.SPRUCE_LOG, 12), new ItemStack(Items.SPRUCE_LEAVES, 4)
              },
              60,
              20 * 20),
          new MultiOutRecipe(
              Items.BIRCH_SAPLING,
              1,
              new ItemStack[] {
                new ItemStack(Items.BIRCH_LOG, 6), new ItemStack(Items.BIRCH_LEAVES, 4)
              },
              60,
              20 * 20),
          new MultiOutRecipe(
              Items.JUNGLE_SAPLING,
              1,
              new ItemStack[] {
                new ItemStack(Items.JUNGLE_LOG, 16), new ItemStack(Items.JUNGLE_LEAVES, 8)
              },
              60,
              20 * 20),
          new MultiOutRecipe(
              Items.ACACIA_SAPLING,
              1,
              new ItemStack[] {
                new ItemStack(Items.ACACIA_LOG, 8), new ItemStack(Items.ACACIA_LEAVES, 4)
              },
              60,
              20 * 20),
          new MultiOutRecipe(
              Items.DARK_OAK_SAPLING,
              1,
              new ItemStack[] {
                new ItemStack(Items.DARK_OAK_LOG, 10), new ItemStack(Items.DARK_OAK_LEAVES, 4)
              },
              60,
              20 * 20),
          new MultiOutRecipe(
              Items.WHEAT_SEEDS,
              1,
              new ItemStack[] {new ItemStack(Items.WHEAT, 3), new ItemStack(Items.WHEAT_SEEDS, 4)},
              30,
              20 * 10));
  public static final List<GrinderRecipe> grinderRecipes =
      List.of(
          new GrinderRecipe(
              new ItemStack(Items.COAL),
              new ItemStack[] {new ItemStack(COAL_DUST.get())},
              40,
              20 * 20),
          new GrinderRecipe(
              new ItemStack(Items.CHARCOAL),
              new ItemStack[] {new ItemStack(CHARCOAL_DUST.get())},
              40,
              20 * 20),
          new GrinderRecipe(
              new ItemStack(Items.IRON_INGOT),
              new ItemStack[] {new ItemStack(IRON_DUST.get())},
              40,
              20 * 30),
          new GrinderRecipe(
              new ItemStack(COAL_COKE.get()),
              new ItemStack[] {new ItemStack(COAL_COKE_DUST.get())},
              40,
              20 * 30),
          new GrinderRecipe(
              new ItemStack(ALUMINIUM_INGOT.get()),
              new ItemStack[] {new ItemStack(ALUMINIUM_DUST.get())},
              40,
              20 * 15),
          new GrinderRecipe(
              new ItemStack(STEEL_INGOT.get()),
              new ItemStack[] {new ItemStack(STEEL_DUST.get())},
              40,
              20 * 35),
          new GrinderRecipe(
              new ItemStack(STEEL_PLATE.get()),
              new ItemStack[] {new ItemStack(STEEL_DUST.get())},
              40,
              20 * 35));
  public static List<MultiOutRecipe> separatorRecipes =
      List.of(
          new SeparatorRecipe(
              CLAY_DUST.get(),
              9,
              new ItemStack[] {
                new ItemStack(ALUMINIUM_DUST.get(), 1),
                new ItemStack(LITHIUM_DUST.get(), 3),
                new ItemStack(SODIUM_DUST.get(), 4)
              },
              40,
              20 * 15),
          new SeparatorRecipe(
              STEEL_DUST.get(),
              1,
              new ItemStack[] {new ItemStack(CARBON_DUST.get(), 1), new ItemStack(IRON_DUST.get())},
              40,
              20 * 15));
}
