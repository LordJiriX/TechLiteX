package io.github.lordjirix.techlitex.common.data;

import io.github.lordjirix.techlitex.api.data.TD;
import io.github.lordjirix.techlitex.loader.TLXBlocks;
import io.github.lordjirix.techlitex.loader.TLXItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.LanguageProvider;

public class TLXLangGen extends LanguageProvider {
  public TLXLangGen(PackOutput gen, String modid, String locale) {
    super(gen, modid, locale);
  }

  @Override
  protected void addTranslations() {
    // utils
    add("config.jade.plugin_techlitex.bedrock_miner", "Bedrock Miner");
    add("config.jade.plugin_techlitex.recipe_runner_base", "Recipe Runner (Base)");
    add("itemGroup.techlitex.techlitex_tab", "TechLiteX");
    add("config.jade.plugin_techlitex.coke_oven_jade", "Coke Oven");

    // MAIN

    // materials
    add(TLXItems.BEDROCKIUM_INGOT.get(), "Bedrockium Ingot");
    add(TLXItems.BEDROCKIUM_DUST.get(), "Bedrockium Dust");
    add(TLXItems.LASER_CORE.get(), "Laser Core");
    add(TLXItems.PROCESSOR.get(), "Processing Core T1");
    add(TLXItems.INTEGRATED_PROCESSOR.get(), "Processing Core T2");
    add(TLXItems.BEDROCKIUM_DRILL.get(), "Bedrockium Drill");
    add(TLXItems.DIAMOND_DRILL.get(), "Diamond Drill");
    add(TLXItems.STEEL_DUST.get(), "Steel Dust");
    add(TLXItems.STEEL_INGOT.get(), "Steel Ingot");
    add(TLXItems.IRON_DUST.get(), "Iron Dust");
    add(TLXItems.TIME_NUGGET.get(), "Time Nugget");
    add(TLXItems.TIME_INGOT.get(), "Time Ingot");
    add(TLXItems.COKE_OVEN_BRICK.get(), "Coke Oven Brick");
    add(TLXItems.SIMPLE_HAMMER.get(), "Simple Hammer");
    add(TLXItems.COAL_COKE.get(), "Coal Coke");
    add(TLXItems.STEEL_PLATE.get(), "Steel Plate");
    add(TLXItems.COAL_DUST.get(), "Coal Dust");
    add(TLXItems.CHARCOAL_DUST.get(), "Charcoal Dust");
    add(TLXItems.COAL_COKE_DUST.get(), "Coal Coke Dust");
    add(TLXItems.ALUMINIUM_INGOT.get(), "Aluminium Ingot");
    add(TLXItems.ALUMINIUM_DUST.get(), "Aluminium Dust");
    add(TLXItems.CLAY_DUST.get(), "Clay Dust");
    add(TLXItems.CARBON_DUST.get(), "Carbon Dust");
    add(TLXItems.ALUMINIUM_PLATE.get(), "Aluminium Plate");
    add(TLXItems.RAW_COKE_OVEN_BRICK.get(), "Raw Coke Oven Brick");
    // electronics
    add(TLXItems.BASIC_BOARD.get(), "Basic Board");
    add(TLXItems.REDSTONE_BOARD.get(), "Redstone Board");
    add(TLXItems.COPPER_WIRE.get(), "Copper Wire");
    add(TLXItems.DIAMOND_SAWBLADE.get(), "Diamond Sawblade");
    // misc
    add(TLXItems.BRICK_FORM.get(), "Brick Form");
    add(TLXItems.RAW_BRICK_FORM.get(), "Raw Brick Form");

    // tools
    add(TLXItems.MULTI_TOOL.get(), "Multi Tool");
    add(TLXItems.SIMPLE_GRINDER.get(), "Simple Grinder");
    // blocks
    add(new ItemStack(TLXBlocks.GREENHOUSE_BLOCK_1.get()), "Green House I");
    add(new ItemStack(TLXBlocks.TIME_COMPRESSOR_BLOCK_1.get()), "Time Compressor I");
    add(new ItemStack(TLXBlocks.COKE_OVEN_BLOCK.get()), "Coke Oven");
    add(new ItemStack(TLXBlocks.COKE_OVEN_BRICK_BLOCK.get()), "Coke Oven Bricks");
    add(new ItemStack(TLXBlocks.COKE_OVEN_FIREBOX.get()), "Coke Oven Firebox");
    add(new ItemStack(TLXBlocks.GRINDER_BLOCK_1.get()), "Grinder I");
    add(new ItemStack(TLXBlocks.GRINDER_BLOCK_2.get()), "Grinder II");
    add(new ItemStack(TLXBlocks.SEPARATOR_BLOCK_1.get()), "Separator I");
    add(new ItemStack(TLXBlocks.CASING_WOODEN.get()), "Casing Wooden");
    add(new ItemStack(TLXBlocks.MACHINE_CASING_STEEL.get()), "Machine Casing Steel");
    add(new ItemStack(TLXBlocks.MACHINE_CASING_ALUMINIUM.get()), "Machine Casing Aluminium");
    // tooltips
    add("tooltip.tlx.machine.recipe_voiding", "§4Void items when inventory is full§r");
    add(TD.Tooltip.SEPARATOR_TOOLTIP_MAIN, "Where Compounds Come Undone");
    add(TD.Tooltip.COKEOVEN_TOOLTIP_MAIN, "Cokee Time!");
    add(TD.Tooltip.MB_ISMULTIBLOCK, "MultiBlock");
  }
}
