package io.github.lordjirix.techlitex.common.data;

import static net.minecraftforge.versions.forge.ForgeVersion.MOD_ID;

import io.github.lordjirix.techlitex.TechLiteX;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TechLiteX.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenMain {
  @SubscribeEvent
  public static void gatherData(final GatherDataEvent event) {
    DataGenerator gen = event.getGenerator();
    PackOutput output = gen.getPackOutput();
    ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
    CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
    gen.addProvider(event.includeServer(), TLXBlockLoot.create(output));
    gen.addProvider(event.includeServer(), new TLXRecipeGen(output));
    gen.addProvider(event.includeClient(), new TLXBlockModelGen(output, existingFileHelper));
    gen.addProvider(
        event.includeClient(), new TLXItemModelGen(output, TechLiteX.MODID, existingFileHelper));
    event
        .getGenerator()
        .addProvider(
            event.includeClient(),
            (DataProvider.Factory<TLXLangGen>) output2 -> new TLXLangGen(output2, MOD_ID, "en_us"));
    TLXBlockTagGen btg =
        gen.addProvider(
            event.includeServer(), new TLXBlockTagGen(output, lookupProvider, existingFileHelper));
    gen.addProvider(
        event.includeServer(),
        new TLXItemTagGen(output, lookupProvider, btg.contentsGetter(), existingFileHelper));
  }
}
