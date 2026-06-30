package io.github.lordjirix.techlitex.compact.jei.provider;

import io.github.lordjirix.techlitex.api.data.MD;
import io.github.lordjirix.techlitex.api.data.recipe.SimpleInOutRecipeBase;
import io.github.lordjirix.techlitex.loader.TLXBlocks;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class SimpleInOutCategory implements IRecipeCategory<SimpleInOutRecipeBase> {
  private final SimpleInOutRecipeBase recipe;
  private final IDrawable background;
  private final IDrawable icon;

  public SimpleInOutCategory(IGuiHelper guiHelper, SimpleInOutRecipeBase recipe) {
    this.background = guiHelper.createBlankDrawable(150, 120);
    this.icon = guiHelper.createDrawableItemStack(getIconStack());
    this.recipe = recipe;
  }

  @Override
  public RecipeType<SimpleInOutRecipeBase> getRecipeType() {
    return null;
  }

  @Override
  public Component getTitle() {
    return Component.literal(recipe.getMachineType().getName());
  }

  @Override
  public @Nullable IDrawable getIcon() {
    return icon;
  }

  @Override
  public void setRecipe(
      IRecipeLayoutBuilder iRecipeLayoutBuilder,
      SimpleInOutRecipeBase simpleInOutRecipeBase,
      IFocusGroup iFocusGroup) {}

  public ItemStack getIconStack() {
    if (recipe.getMachineType() == MD.MachineType.GRINDER) {
      return new ItemStack(TLXBlocks.GRINDER_BLOCK_1.get());
    }
    return ItemStack.EMPTY;
  }
}
