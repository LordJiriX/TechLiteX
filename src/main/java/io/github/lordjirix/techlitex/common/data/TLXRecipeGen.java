package io.github.lordjirix.techlitex.common.data;

import static io.github.lordjirix.techlitex.TechLiteX.MODID;

import io.github.lordjirix.techlitex.common.data.tag.TLXTags;
import io.github.lordjirix.techlitex.loader.TLXBlocks;
import io.github.lordjirix.techlitex.loader.TLXItems;
import java.util.function.Consumer;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class TLXRecipeGen extends RecipeProvider implements IConditionBuilder {
  public TLXRecipeGen(PackOutput pOutput) {
    super(pOutput);
  }

  @SuppressWarnings("removal")
  @Override
  protected void buildRecipes(Consumer<FinishedRecipe> pw) {
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TLXItems.BEDROCKIUM_DRILL.get())
        .pattern(" B ")
        .pattern("SSB")
        .pattern(" B ")
        .define('S', Items.STICK)
        .define('B', TLXItems.BEDROCKIUM_INGOT.get())
        .unlockedBy(getHasName(TLXItems.BEDROCKIUM_INGOT.get()), has(TLXItems.BEDROCKIUM_DUST.get()))
        .save(pw);
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
        .pattern("SIS")
        .pattern("SSS")
        .define('S', TLXTags.I.STEEL_PLATE)
        .define('I', Blocks.STONE)
        .unlockedBy(getHasName(TLXItems.STEEL_INGOT.get()), has(TLXTags.I.STEEL_INGOT))
        .save(pw);
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
              .requires(TLXItems.STEEL_INGOT.get())
              .requires(TLXItems.SIMPLE_HAMMER.get())
              .unlockedBy(getHasName(TLXItems.SIMPLE_HAMMER.get()), has(TLXItems.SIMPLE_HAMMER.get()))
              .save(pw, new ResourceLocation(MODID, "steel_plate_simple_hammer"));
    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TLXItems.STEEL_DUST.get())
        .requires(TLXTags.I.IRON_DUST)
        .requires(TLXTags.I.CARBON_BASE_DUST)
        .unlockedBy(getHasName(TLXItems.IRON_DUST.get()), has(TLXTags.I.IRON_DUST))
        .save(pw, new ResourceLocation(MODID, "steel_dust_crafting_carbonbased"));
      ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TLXItems.STEEL_DUST.get(),2)
              .requires(TLXTags.I.IRON_DUST)
              .requires(TLXTags.I.IRON_DUST)
              .requires(TLXTags.I.COAL_COKE_DUST)
              .unlockedBy(getHasName(TLXItems.IRON_DUST.get()), has(TLXTags.I.IRON_DUST))
              .save(pw, new ResourceLocation(MODID, "steel_dust_crafting_coke"));
      ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TLXBlocks.COKE_OVEN_BRICK_BLOCK.get())
              .requires(TLXItems.COKE_OVEN_BRICK.get(),4)
              .unlockedBy(getHasName(TLXItems.COKE_OVEN_BRICK.get()), has(TLXItems.COKE_OVEN_BRICK.get()))
              .save(pw);
      ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TLXBlocks.COKE_OVEN_BLOCK.get())
              .pattern("   ")
              .pattern("IFI")
              .pattern("BBB")
              .define('F', Blocks.BLAST_FURNACE)
              .define('B', TLXItems.COKE_OVEN_BRICK.get())
              .define('I', Items.IRON_INGOT)
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
            Ingredient.of(TLXItems.STEEL_DUST.get()),
            RecipeCategory.MISC,
            TLXItems.STEEL_INGOT.get(),
            1.0f,
            20 * 8)
        .unlockedBy(getHasName(TLXItems.STEEL_DUST.get()), has(TLXItems.STEEL_DUST.get()))
        .save(pw, new ResourceLocation(MODID, "smelting/steel_ingot_from_dust"));
  }
}
