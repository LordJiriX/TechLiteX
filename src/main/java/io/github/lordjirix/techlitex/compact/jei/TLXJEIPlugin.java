package io.github.lordjirix.techlitex.compact.jei;

import static io.github.lordjirix.techlitex.TechLiteX.MODID;

import io.github.lordjirix.techlitex.TLXData;
import io.github.lordjirix.techlitex.compact.jei.provider.GrinderCategory;
import io.github.lordjirix.techlitex.compact.jei.provider.MultiInOutCategory;
import io.github.lordjirix.techlitex.loader.TLXBlocks;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@JeiPlugin
@OnlyIn(Dist.CLIENT)
public class TLXJEIPlugin implements IModPlugin {

  public static final ResourceLocation UID = new ResourceLocation(MODID, "jei_plugin");

  @Override
  public ResourceLocation getPluginUid() {
    return UID;
  }

  @Override
  public void registerCategories(IRecipeCategoryRegistration registration) {
    registration.addRecipeCategories(
        new GrinderCategory(registration.getJeiHelpers().getGuiHelper()));
    registration.addRecipeCategories(
        new MultiInOutCategory.Separator(registration.getJeiHelpers().getGuiHelper()));
    registration.addRecipeCategories(
        new MultiInOutCategory.Greenhouse(registration.getJeiHelpers().getGuiHelper()));
  }

  @Override
  public void registerRecipes(IRecipeRegistration registration) {
    registration.addRecipes(GrinderCategory.TYPE, TLXData.grinderRecipes);
    registration.addRecipes(MultiInOutCategory.Greenhouse.TYPE_A, TLXData.greenHouseRecipes);
    registration.addRecipes(MultiInOutCategory.Separator.TYPE_B, TLXData.separatorRecipes);
  }

  @Override
  public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
    registration.addRecipeCatalyst(
        new ItemStack(TLXBlocks.GRINDER_BLOCK_1.get()), GrinderCategory.TYPE);

    registration.addRecipeCatalyst(
        new ItemStack(TLXBlocks.GRINDER_BLOCK_2.get()), GrinderCategory.TYPE);
    /*registration.addRecipeCatalyst(
            new ItemStack(TLXBlocks.GRINDER_BLOCK_1.get()),
            MultiInOutCategory.TYPE_A
    );*/

    registration.addRecipeCatalyst(
        new ItemStack(TLXBlocks.SEPARATOR_BLOCK_1.get()), MultiInOutCategory.Separator.TYPE_B);
    registration.addRecipeCatalyst(
        new ItemStack(TLXBlocks.GREENHOUSE_BLOCK_1.get()), MultiInOutCategory.Greenhouse.TYPE_A);
    registration.addRecipeCatalyst(
        new ItemStack(TLXBlocks.GREENHOUSE_BLOCK_2.get()), MultiInOutCategory.Greenhouse.TYPE_A);
  }
}
