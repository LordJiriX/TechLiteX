package io.github.lordjirix.randomcontent.common.data;

import io.github.lordjirix.randomcontent.loader.RCBlocks;
import io.github.lordjirix.randomcontent.loader.RCItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.LanguageProvider;

public class RCLangGen extends LanguageProvider {
  public RCLangGen(PackOutput gen, String modid, String locale) {
    super(gen, modid, locale);
  }

  @Override
  protected void addTranslations() {
    // utils
    add("config.jade.plugin_randomcontent.bedrock_miner", "Bedrock Miner");
    add("config.jade.plugin_randomcontent.recipe_runner_base", "RC Recipe Runner (Base)");
    add("itemGroup.randomcontent.random_content_tab", "Random Content");
    add("config.jade.plugin_randomcontent.coke_oven_jade","Coke Oven");

    // MAIN

    // materials
    add(RCItems.BEDROCKIUM_INGOT.get(), "Bedrockium Ingot");
    add(RCItems.BEDROCKIUM_DUST.get(), "Bedrockium Dust");
    add(RCItems.LASER_CORE.get(), "Laser Core");
    add(RCItems.PROCESSING_CORE_T1.get(), "Processing Core T1");
    add(RCItems.PROCESSING_CORE_T2.get(), "Processing Core T2");
    add(RCItems.BEDROCKIUM_DRILL.get(), "Bedrockium Drill");
    add(RCItems.DIAMOND_DRILL.get(), "Diamond Drill");
    add(RCItems.STEEL_DUST.get(), "Steel Dust");
    add(RCItems.STEEL_INGOT.get(), "Steel Ingot");
    add(RCItems.IRON_DUST.get(), "Iron Dust");
    add(RCItems.TIME_NUGGET.get(), "Time Nugget");
    add(RCItems.TIME_INGOT.get(), "Time Ingot");
    add(RCItems.COKE_OVEN_BRICK.get(),  "Coke Oven Brick");
    // tools
    add(RCItems.MULTI_TOOL.get(), "Multi Tool");
    add(RCItems.SIMPLE_GRINDER.get(), "Simple Grinder");
    // blocks
    add(new ItemStack(RCBlocks.BEDROCK_MINER_BLOCK.get()), "Bedrock Miner");
    add(new ItemStack(RCBlocks.GREENHOUSE_BLOCK_1.get()), "Green House I");
    add(new ItemStack(RCBlocks.TIME_COMPRESSOR_BLOCK_1.get()), "Time Compressor I");
    add(new ItemStack(RCBlocks.COKE_OVEN_BLOCK.get()),"Coke Oven");
    add(new ItemStack(RCBlocks.COKE_OVEN_BRICK_BLOCK.get()),"Coke Oven Bricks");
    add(new ItemStack(RCBlocks.COKE_OVEN_FIREBOX.get()),"Coke Oven Firebox");
  }
}
