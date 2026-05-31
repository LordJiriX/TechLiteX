package io.github.lordjirix.techlitex.common.data;

import static io.github.lordjirix.techlitex.TechLiteX.MODID;
import static io.github.lordjirix.techlitex.loader.TLXItems.*;

import io.github.lordjirix.techlitex.common.data.tag.TLXTags;
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
    this.tag(TLXTags.I.IRON_DUST).add(TLXItems.IRON_DUST.get());
    this.tag(TLXTags.I.STEEL_INGOT).add(TLXItems.STEEL_INGOT.get());

    this.tag(TLXTags.I.CARBON_BASE_DUST)
        .add(TLXItems.COAL_DUST.get())
        .add(TLXItems.CHARCOAL_DUST.get())
        .add(TLXItems.CARBON_DUST.get());
    this.tag(TLXTags.I.STEEL_PLATE).add(TLXItems.STEEL_PLATE.get());
    this.tag(TLXTags.I.COAL_COKE).add(TLXItems.COAL_COKE.get());
    this.tag(TLXTags.I.COAL_COKE_DUST).add(TLXItems.COAL_COKE_DUST.get());
    this.tag(TLXTags.I.ALUMINIUM_DUST).add(TLXItems.ALUMINIUM_DUST.get());
    this.tag(TLXTags.I.ALUMINIUM_INGOT).add(TLXItems.ALUMINIUM_INGOT.get());
    this.tag(TLXTags.I.ALUMINIUM_PLATE).add(TLXItems.ALUMINIUM_PLATE.get());
    this.tag(TLXTags.I.PROCESSOR_I).add(TLXItems.PROCESSOR.get());
    this.tag(TLXTags.I.ANY_INGOT).add(ALUMINIUM_INGOT.get()).add(STEEL_INGOT.get());
  }
}
