package io.github.lordjirix.techlitex.common.data;

import static io.github.lordjirix.techlitex.TechLiteX.MODID;
import static io.github.lordjirix.techlitex.loader.TLXItems.*;

import io.github.lordjirix.techlitex.common.data.tag.TLXTags;
import io.github.lordjirix.techlitex.loader.TLXBlocks;
import io.github.lordjirix.techlitex.loader.TLXBlocks.*;
import io.github.lordjirix.techlitex.loader.TLXItems;
import java.util.function.Consumer;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Items.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Blocks.*;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class TLXRecipeGen extends RecipeProvider implements IConditionBuilder {
  public TLXRecipeGen(PackOutput pOutput) {
    super(pOutput);
  }

  @SuppressWarnings("removal")
  @Override
  protected void buildRecipes(Consumer<FinishedRecipe> pw) {
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TLXItems.SIMPLE_GRINDER.get())
        .pattern(" I ")
        .pattern("SIS")
        .pattern("SSS")
        .define('S', Blocks.STONE)
        .define('I', Items.IRON_INGOT)
        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
        .save(pw);
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TLXBlocks.MACHINE_CASING_STEEL.get())
        .pattern("SSS")
        .pattern("SBS")
        .pattern("SSS")
        .define('S', TLXTags.I.STEEL_PLATE)
        .define('B', TLXBlocks.CASING_WOODEN.get())
        .unlockedBy(getHasName(TLXItems.STEEL_INGOT.get()), has(TLXTags.I.STEEL_INGOT))
        .save(pw);
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TLXBlocks.MACHINE_CASING_ALUMINIUM.get())
        .pattern("AAA")
        .pattern("ABA")
        .pattern("AAA")
        .define('A', TLXItems.ALUMINIUM_PLATE.get())
        .define('B', TLXBlocks.CASING_WOODEN.get())
        .unlockedBy(getHasName(TLXItems.ALUMINIUM_PLATE.get()), has(TLXItems.ALUMINIUM_PLATE.get()))
        .save(pw);
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TLXItems.BASIC_BOARD.get())
        .pattern("SSS")
        .pattern("PPP")
        .pattern("SSS")
        .define('P', Blocks.OAK_PLANKS)
        .define('S', Items.STICK)
        .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
        .save(pw);
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TLXItems.PROCESSOR.get())
        .pattern("WRW")
        .pattern("RBR")
        .pattern("WRW")
        .define('B', TLXItems.BASIC_BOARD.get())
        .define('R', Items.REDSTONE)
        .define('W', TLXItems.COPPER_WIRE.get())
        .unlockedBy(getHasName(TLXItems.BASIC_BOARD.get()), has(TLXItems.BASIC_BOARD.get()))
        .save(pw);
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TLXBlocks.GRINDER_BLOCK_1.get())
        .pattern("WSW")
        .pattern("PBP")
        .pattern("WSW")
        .define('W', TLXItems.COPPER_WIRE.get())
        .define('S', TLXItems.DIAMOND_SAWBLADE.get())
        .define('P', TLXTags.I.PROCESSOR_I)
        .define('B', TLXBlocks.MACHINE_CASING_STEEL.get())
        .unlockedBy(getHasName(TLXItems.PROCESSOR.get()), has(TLXItems.PROCESSOR.get()))
        .save(pw);
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TLXBlocks.GREENHOUSE_BLOCK_1.get())
        .pattern("WSW")
        .pattern("PBP")
        .pattern("WDW")
        .define('W', TLXItems.COPPER_WIRE.get())
        .define('S', TLXItems.DIAMOND_SAWBLADE.get())
        .define('P', TLXTags.I.PROCESSOR_I)
        .define('D', Blocks.DIRT)
        .define('B', TLXBlocks.MACHINE_CASING_STEEL.get())
        .unlockedBy(getHasName(TLXItems.PROCESSOR.get()), has(TLXItems.PROCESSOR.get()))
        .save(pw);
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TLXBlocks.BATTERY_BOX_I.get())
        .pattern(" W ")
        .pattern(" B ")
        .pattern(" C ")
        .define('W', TLXItems.COPPER_WIRE.get())
        .define('B', SMALL_BATTERY.get())
        .define('C', TLXBlocks.MACHINE_CASING_COPPER.get())
        .unlockedBy(getHasName(SMALL_BATTERY.get()), has(SMALL_BATTERY.get()))
        .save(pw);
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TLXBlocks.BATTERY_BOX_II.get())
        .pattern(" W ")
        .pattern("BBB")
        .pattern(" C ")
        .define('W', TLXItems.COPPER_WIRE.get())
        .define('B', SMALL_BATTERY.get())
        .define('C', TLXBlocks.MACHINE_CASING_STEEL.get())
        .unlockedBy(getHasName(SMALL_BATTERY.get()), has(SMALL_BATTERY.get()))
        .save(pw);
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TLXBlocks.CASING_WOODEN.get())
        .pattern("PPP")
        .pattern("ISI")
        .pattern("PPP")
        .define('P', Items.STICK)
        .define('I', Items.IRON_INGOT)
        .define('S', Blocks.STONE)
        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
        .save(pw);
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RAW_BRICK_FORM.get())
        .pattern("CCC")
        .pattern("CIC")
        .pattern("CCC")
        .define('C', Items.CLAY_BALL)
        .define('I', TLXTags.I.ANY_INGOT)
        .unlockedBy(getHasName(Items.CLAY_BALL), has(Items.CLAY_BALL))
        .save(pw);
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RAW_COKE_OVEN_BRICK.get(), 4)
        .pattern("CSC")
        .pattern("SFS")
        .pattern("CSC")
        .define('C', Items.CLAY_BALL)
        .define('S', Blocks.SAND)
        .define('F', BRICK_FORM.get())
        .unlockedBy(getHasName(BRICK_FORM.get()), has(BRICK_FORM.get()))
        .save(pw);
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DIAMOND_SAWBLADE.get())
        .pattern(" P ")
        .pattern("PDP")
        .pattern(" P ")
        .define('D', Items.DIAMOND)
        .define('P', DIAMOND_PLATE.get())
        .unlockedBy(getHasName(DIAMOND_PLATE.get()), has(DIAMOND_PLATE.get()))
        .save(pw);
    SmithingTransformRecipeBuilder.smithing(
            Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
            Ingredient.of(DIAMOND_SAWBLADE.get()),
            Ingredient.of(Items.NETHERITE_INGOT),
            RecipeCategory.TOOLS,
            NETHERITE_SAWBLADE.get())
        .unlocks("has_diamond_sawblade", has(DIAMOND_SAWBLADE.get()))
        .save(pw, new ResourceLocation("diamond_sawblade"));
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TLXItems.IRON_DUST.get())
        .requires(Items.IRON_INGOT)
        .requires(TLXItems.SIMPLE_GRINDER.get())
        .unlockedBy(getHasName(TLXItems.SIMPLE_GRINDER.get()), has(TLXItems.SIMPLE_GRINDER.get()))
        .save(pw, new ResourceLocation(MODID, "iron_dust_simple_grinder"));
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TLXItems.COAL_DUST.get())
        .requires(Items.COAL)
        .requires(TLXItems.SIMPLE_GRINDER.get())
        .unlockedBy(getHasName(TLXItems.SIMPLE_GRINDER.get()), has(Items.COAL))
        .save(pw, new ResourceLocation(MODID, "coal_dust_simple_grinder"));
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TLXItems.CHARCOAL_DUST.get())
        .requires(Items.CHARCOAL)
        .requires(TLXItems.SIMPLE_GRINDER.get())
        .unlockedBy(getHasName(TLXItems.SIMPLE_GRINDER.get()), has(TLXItems.SIMPLE_GRINDER.get()))
        .save(pw, new ResourceLocation(MODID, "charcoal_dust_simple_grinder"));
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TLXItems.STEEL_PLATE.get())
        .requires(TLXTags.I.STEEL_INGOT)
        .requires(TLXItems.SIMPLE_HAMMER.get())
        .unlockedBy(getHasName(TLXItems.SIMPLE_HAMMER.get()), has(TLXItems.SIMPLE_HAMMER.get()))
        .save(pw, new ResourceLocation(MODID, "steel_plate_simple_hammer"));
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TLXItems.ALUMINIUM_PLATE.get())
        .requires(TLXTags.I.ALUMINIUM_INGOT)
        .requires(TLXItems.SIMPLE_HAMMER.get())
        .unlockedBy(getHasName(TLXItems.ALUMINIUM_INGOT.get()), has(TLXItems.ALUMINIUM_INGOT.get()))
        .save(pw, new ResourceLocation(MODID, "aluminium_plate_simple_hammer"));
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, IRON_PLATE.get())
        .requires(Items.IRON_INGOT)
        .requires(TLXItems.SIMPLE_HAMMER.get())
        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
        .save(pw, new ResourceLocation(MODID, "iron_plate_simple_hammer"));
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TLXItems.COPPER_WIRE.get(), 2)
        .requires(Items.COPPER_INGOT)
        .requires(TLXItems.WIRECUTTER.get())
        .unlockedBy(getHasName(TLXItems.WIRECUTTER.get()), has(TLXItems.WIRECUTTER.get()))
        .save(pw, new ResourceLocation(MODID, "copper_wire_wirecutter"));

    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TLXItems.STEEL_DUST.get())
        .requires(TLXTags.I.IRON_DUST)
        .requires(TLXTags.I.CARBON_BASE_DUST)
        .unlockedBy(getHasName(TLXItems.IRON_DUST.get()), has(TLXTags.I.IRON_DUST))
        .save(pw, new ResourceLocation(MODID, "steel_dust_crafting_carbonbased"));
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TLXItems.STEEL_DUST.get(), 2)
        .requires(TLXTags.I.IRON_DUST)
        .requires(TLXTags.I.IRON_DUST)
        .requires(TLXTags.I.COAL_COKE_DUST)
        .unlockedBy(getHasName(TLXItems.IRON_DUST.get()), has(TLXTags.I.IRON_DUST))
        .save(pw, new ResourceLocation(MODID, "steel_dust_crafting_coke"));
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TLXBlocks.COKE_OVEN_BRICK_BLOCK.get())
        .requires(TLXItems.COKE_OVEN_BRICK.get(), 4)
        .unlockedBy(getHasName(TLXItems.COKE_OVEN_BRICK.get()), has(TLXItems.COKE_OVEN_BRICK.get()))
        .save(pw);
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TLXBlocks.COKE_OVEN_BLOCK.get())
        .pattern("   ")
        .pattern("IFI")
        .pattern("BBB")
        .define('F', Blocks.BLAST_FURNACE)
        .define('B', TLXItems.COKE_OVEN_BRICK.get())
        .define('I', Items.IRON_INGOT)

        /*   SMELTING   */

        .unlockedBy(getHasName(TLXItems.COKE_OVEN_BRICK.get()), has(TLXItems.COKE_OVEN_BRICK.get()))
        .save(pw);
    SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(TLXItems.BEDROCKIUM_DUST.get()),
            RecipeCategory.MISC,
            TLXItems.BEDROCKIUM_INGOT.get(),
            1.0f,
            20 * 32)
        .unlockedBy(getHasName(TLXItems.BEDROCKIUM_DUST.get()), has(TLXItems.BEDROCKIUM_DUST.get()))
        .save(pw, new ResourceLocation(MODID, "smelting/bedrockium_ingot_from_dust"));
    SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(TLXItems.ALUMINIUM_DUST.get()),
            RecipeCategory.MISC,
            TLXItems.ALUMINIUM_INGOT.get(),
            1.0f,
            20 * 20)
        .unlockedBy(getHasName(TLXItems.ALUMINIUM_DUST.get()), has(TLXItems.ALUMINIUM_DUST.get()))
        .save(pw, new ResourceLocation(MODID, "smelting/aluminium_ingot_from_dust"));
    SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(TLXItems.IRON_DUST.get()),
            RecipeCategory.MISC,
            Items.IRON_INGOT,
            1.0f,
            20 * 10)
        .unlockedBy(getHasName(TLXItems.IRON_DUST.get()), has(TLXItems.IRON_DUST.get()))
        .save(pw, new ResourceLocation(MODID, "smelting/iron_ingot_from_dust"));
    SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(TLXItems.STEEL_DUST.get()),
            RecipeCategory.MISC,
            TLXItems.STEEL_INGOT.get(),
            1.0f,
            20 * 16)
        .unlockedBy(getHasName(TLXItems.STEEL_DUST.get()), has(TLXItems.STEEL_DUST.get()))
        .save(pw, new ResourceLocation(MODID, "smelting/steel_ingot_from_dust"));
    SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(RAW_BRICK_FORM.get()),
            RecipeCategory.MISC,
            BRICK_FORM.get(),
            1.0f,
            20 * 10)
        .unlockedBy(getHasName(RAW_BRICK_FORM.get()), has(RAW_BRICK_FORM.get()))
        .save(pw);
    SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(RAW_COKE_OVEN_BRICK.get()),
            RecipeCategory.MISC,
            COKE_OVEN_BRICK.get(),
            1.0f,
            20 * 10)
        .unlockedBy(getHasName(RAW_COKE_OVEN_BRICK.get()), has(RAW_COKE_OVEN_BRICK.get()))
        .save(pw);
  }
}
