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
    // Forge Tags
    public static final TagKey<Item> IRON_DUST =
        ItemTags.create(new ResourceLocation("forge", "dusts/iron"));

    public static final TagKey<Item> STEEL_INGOT =
        ItemTags.create(new ResourceLocation("forge", "ingots/steel"));

      public static final TagKey<Item> STEEL_PLATE =
              ItemTags.create(new ResourceLocation("forge", "plates/steel"));
      public static final TagKey<Item> COAL_COKE =
              ItemTags.create(new ResourceLocation("forge", "coal_coke"));
      public static final TagKey<Item> COAL_COKE_DUST =
              ItemTags.create(new ResourceLocation("forge", "coal_coke_dust"));

    // RC Tags
    public static final TagKey<Item> CARBON_BASE_DUST =
        ItemTags.create(new ResourceLocation(MODID, "dusts/carbon_base"));
  }
  public class B {
      public static final TagKey<Block> MINEABLE_PICKAXE =
              BlockTags.create(new ResourceLocation("minecraft","mineable/pickaxe"));
  }
}
