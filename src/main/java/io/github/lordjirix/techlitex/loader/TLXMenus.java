package io.github.lordjirix.techlitex.loader;

import static io.github.lordjirix.techlitex.TechLiteX.MODID;

import io.github.lordjirix.techlitex.gui.menu.CokeOvenMenu;
import io.github.lordjirix.techlitex.gui.menu.MultipleOutSlotMenu;
import io.github.lordjirix.techlitex.gui.menu.SimpleInOutMenu;
import io.github.lordjirix.techlitex.gui.menu.SimpleOneMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TLXMenus {
  public static final DeferredRegister<MenuType<?>> MENUS =
      DeferredRegister.create(ForgeRegistries.MENU_TYPES, MODID);

  public static final RegistryObject<MenuType<MultipleOutSlotMenu>> MULTIPLE_INOUTSLOT_MENU =
      MENUS.register(
          "multiple_inoutslot_menu", () -> IForgeMenuType.create(MultipleOutSlotMenu::new));
  public static final RegistryObject<MenuType<SimpleOneMenu>> SIMPLE_ONESLOT_MENU =
      MENUS.register("oneslot_menu", () -> IForgeMenuType.create(SimpleOneMenu::new));
  public static final RegistryObject<MenuType<CokeOvenMenu>> COKE_OVEN_MENU =
      MENUS.register("coke_oven_menu", () -> IForgeMenuType.create(CokeOvenMenu::new));
  public static final RegistryObject<MenuType<SimpleInOutMenu>> SIMPLE_INOUT_MENU =
      MENUS.register("simple_inout_menu", () -> IForgeMenuType.create(SimpleInOutMenu::new));
}
