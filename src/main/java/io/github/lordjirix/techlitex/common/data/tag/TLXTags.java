package io.github.lordjirix.techlitex.common.data.tag;

import static io.github.lordjirix.techlitex.TechLiteX.MODID;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TLXTags {
  public class I {

    // DUSTS
    public static final TagKey<Item> IRON_DUST =
        ItemTags.create(new ResourceLocation("forge", "dusts/iron"));
    public static final TagKey<Item> ALUMINIUM_DUST =
        ItemTags.create(new ResourceLocation("forge", "dusts/aluminium"));
    public static final TagKey<Item> COAL_COKE_DUST =
        ItemTags.create(new ResourceLocation("forge", "coal_coke_dust"));
    public static final TagKey<Item> CARBON_BASE_DUST =
        ItemTags.create(new ResourceLocation(MODID, "dusts/carbon_base"));

    // INGOTS
    public static final TagKey<Item> STEEL_INGOT =
        ItemTags.create(new ResourceLocation("forge", "ingots/steel"));
    public static final TagKey<Item> ALUMINIUM_INGOT =
        ItemTags.create(new ResourceLocation("forge", "ingots/aluminium"));

    // PLATES
    public static final TagKey<Item> STEEL_PLATE =
        ItemTags.create(new ResourceLocation("forge", "plates/steel"));
    public static final TagKey<Item> ALUMINIUM_PLATE =
        ItemTags.create(new ResourceLocation("forge", "plates/aluminium"));

    // MATERIALS
    public static final TagKey<Item> COAL_COKE =
        ItemTags.create(new ResourceLocation("forge", "coal_coke"));

    // ELECTRONICS
    public static final TagKey<Item> PROCESSOR_I =
        ItemTags.create(new ResourceLocation("techlitex", "processors/_t1"));
    public static final TagKey<Item> PROCESSOR_II =
        ItemTags.create(new ResourceLocation("techlitex", "processors/_t2"));
  }

  public class B {
    public static final TagKey<Block> MINEABLE_PICKAXE =
        BlockTags.create(new ResourceLocation("minecraft", "mineable/pickaxe"));
  }
}
