package io.github.lordjirix.techlitex.loader;

import static io.github.lordjirix.techlitex.TechLiteX.MODID;

import io.github.lordjirix.techlitex.gui.menu.CokeOvenMenu;
import io.github.lordjirix.techlitex.gui.menu.GreenHouseMenu;
import io.github.lordjirix.techlitex.gui.menu.SimpleOneMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TLXMenus {
  public static final DeferredRegister<MenuType<?>> MENUS =
      DeferredRegister.create(ForgeRegistries.MENU_TYPES, MODID);

  public static final RegistryObject<MenuType<GreenHouseMenu>> GREEN_HOUSE =
      MENUS.register("green_house_menu", () -> IForgeMenuType.create(GreenHouseMenu::new));
  public static final RegistryObject<MenuType<SimpleOneMenu>> SIMPLE_ONESLOT_MENU =
      MENUS.register("oneslot_menu", () -> IForgeMenuType.create(SimpleOneMenu::new));
    public static final RegistryObject<MenuType<CokeOvenMenu>> COKE_OVEN_MENU =
            MENUS.register("coke_oven_menu", () -> IForgeMenuType.create(CokeOvenMenu::new));
}
