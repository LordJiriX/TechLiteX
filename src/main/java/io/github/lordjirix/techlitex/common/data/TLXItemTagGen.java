package io.github.lordjirix.techlitex.common.data;

import static io.github.lordjirix.techlitex.TechLiteX.MODID;

import io.github.lordjirix.techlitex.common.data.tag.RCTags;
import io.github.lordjirix.techlitex.loader.TLXItems;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class TLXItemTagGen extends ItemTagsProvider {

  public TLXItemTagGen(
      PackOutput pOutput,
      CompletableFuture<HolderLookup.Provider> pLookupProvider,
      CompletableFuture<TagLookup<Block>> pBlockTags,
      @Nullable ExistingFileHelper existingFileHelper) {
    super(pOutput, pLookupProvider, pBlockTags, MODID, existingFileHelper);
  }

  @Override
  protected void addTags(HolderLookup.Provider pProvider) {
    this.tag(RCTags.I.IRON_DUST).add(TLXItems.IRON_DUST.get());
    this.tag(RCTags.I.STEEL_INGOT).add(TLXItems.STEEL_INGOT.get());

    this.tag(RCTags.I.CARBON_BASE_DUST)
        .add(TLXItems.COAL_DUST.get())
        .add(TLXItems.CHARCOAL_DUST.get());
  }
}
