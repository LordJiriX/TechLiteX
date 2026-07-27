package io.github.lordjirix.techlitex;

import static io.github.lordjirix.techlitex.loader.TLXItems.*;

import com.mojang.logging.LogUtils;
import io.github.lordjirix.techlitex.gui.screen.*;
import io.github.lordjirix.techlitex.loader.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(TechLiteX.MODID)
public class TechLiteX {

  public static final String MODID = "techlitex";
  public static final String VERSION = "0.0-preview";
  private static final Logger LOGGER = LogUtils.getLogger();
  public static final DeferredRegister<Block> BLOCKS =
      DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
      DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

  public static final RegistryObject<CreativeModeTab> TECHLITEX_TAB =
      CREATIVE_MODE_TABS.register(
          "techlitex_tab",
          () ->
              CreativeModeTab.builder()
                  .withTabsBefore(CreativeModeTabs.COMBAT)
                  .icon(() -> MULTI_TOOL.get().getDefaultInstance())
                  .displayItems(
                      (parameters, output) -> {
                        output.accept(MULTI_TOOL.get());
                        TLXData.allItemList.forEach(
                            item -> {
                              output.accept(item.get());
                            });
                        TLXData.allBlockItemsList.forEach(
                            item -> {
                              output.accept(item.get());
                            });
                      })
                  .build());

  @SuppressWarnings("removal")
  public TechLiteX() {
    @SuppressWarnings("removal")
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    modEventBus.addListener(this::commonSetup);
    BLOCKS.register(modEventBus);
    TLXItems.init(modEventBus);
    TLXBlocks.init(modEventBus);
    TLXBlockEntitys.init(modEventBus);
    TLXMenus.MENUS.register(modEventBus);
    CREATIVE_MODE_TABS.register(modEventBus);
    MinecraftForge.EVENT_BUS.register(this);

    modEventBus.addListener(this::addCreative);

    //noinspection removal
    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
  }

  private void commonSetup(final FMLCommonSetupEvent event) {
    LOGGER.info(
        "----------------------------------------------------------------------------------------");
    LOGGER.info(
        "                                       TechLiteX                                       ");
    LOGGER.warn("  - This mod is in development, expect bugs and crashes!");
    LOGGER.warn("  - Mod is missing a lot of content");
    LOGGER.warn("  - Thanks for using TechLiteX preview version!");
    LOGGER.info(
        "----------------------------------------------------------------------------------------");
    LOGGER.info("--- Please report bugs to github: https://github.com/LordJiriX/TechLiteX/issues");
    LOGGER.info(
        "----------------------------------------------------------------------------------------");
  }

  private void addCreative(BuildCreativeModeTabContentsEvent event) {}

  @SubscribeEvent
  public void onServerStarting(ServerStartingEvent event) {
    LOGGER.warn("Server is not tested!!!!");
  }

  @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
  public static class ClientModEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {}

    @SubscribeEvent
    public static void registerScreens(FMLClientSetupEvent event) {
      event.enqueueWork(
          () -> {
            MenuScreens.register(
                TLXMenus.MULTIPLE_INOUTSLOT_MENU.get(), MultipleInOutSlotScreen::new);
            MenuScreens.register(TLXMenus.SIMPLE_ONESLOT_MENU.get(), SimpleOneScreen::new);
            MenuScreens.register(TLXMenus.COKE_OVEN_MENU.get(), CokeOvenScreen::new);
            MenuScreens.register(TLXMenus.SIMPLE_INOUT_MENU.get(), SimpleInOutScreen::new);
            MenuScreens.register(TLXMenus.BATTERYBOX_MENU.get(), BatteryBoxScreen::new);
          });
    }
  }
}
