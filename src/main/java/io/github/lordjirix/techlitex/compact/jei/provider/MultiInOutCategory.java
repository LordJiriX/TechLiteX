package io.github.lordjirix.techlitex.compact.jei.provider;

import io.github.lordjirix.techlitex.api.data.MD;
import io.github.lordjirix.techlitex.api.data.recipe.MultiOutRecipe;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import static io.github.lordjirix.techlitex.TechLiteX.MODID;

public class MultiInOutCategory implements IRecipeCategory<MultiOutRecipe> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation("techlitex", "textures/gui/greenhouse_gui.png");


    private final IDrawable background;
    private final IDrawable icon;
    private final MD.MachineType machineType;
    private final RecipeType<MultiOutRecipe> type;

    public MultiInOutCategory(IGuiHelper guiHelper, MD.MachineType recipe_type,RecipeType<MultiOutRecipe> type) {
        this.background = guiHelper.createDrawable(TEXTURE, 0, 0, 150, 70);
        this.icon = guiHelper.createDrawableItemStack(
                new ItemStack(recipe_type.getIcon().get())
        );
        this.machineType = recipe_type;
        this.type = type;

    }
    @Override
    public RecipeType<MultiOutRecipe> getRecipeType() {
        return type;
    }

    @Override
    public Component getTitle() {
        return Component.literal(machineType.getName());
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }
    @SuppressWarnings("removal")
    @Override
    public IDrawable getBackground() {
        return background;
    }
    @Override
    public void setRecipe(
            IRecipeLayoutBuilder builder,
            MultiOutRecipe recipe,
            IFocusGroup focuses) {

        builder.addSlot(
                RecipeIngredientRole.INPUT,
                24,
                35
        ).addItemStack(new ItemStack(recipe.getInput(),recipe.getInputCount()));

        for (int i = 0; i < recipe.getOutput().length; i++) {
            builder.addSlot(
                    RecipeIngredientRole.OUTPUT,
                    80 + i * 18,
                    35
            ).addItemStack(recipe.getOutput()[i]);
        }
    }


    @Override
    public void draw(MultiOutRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        IRecipeCategory.super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
        guiGraphics.drawString(Minecraft.getInstance().font,"Time: " + recipe.getTimePerRecipe() / 20 + "s",10,55,0);
        guiGraphics.drawString(Minecraft.getInstance().font,"Energy: " + recipe.getRFPerTick()+ " RF/t",10,65,0);

    }
    public static class Separator extends MultiInOutCategory {
        private IGuiHelper guiHelper;
        public Separator(IGuiHelper guiHelper) {
            super(guiHelper, MD.MachineType.SEPARATOR,TYPE_B);
        }
        public static final RecipeType<MultiOutRecipe> TYPE_B =
                RecipeType.create(MODID, "api_multiout_b", MultiOutRecipe.class);
    }
    public static class Greenhouse extends MultiInOutCategory {
        private IGuiHelper guiHelper;
        public Greenhouse(IGuiHelper guiHelper) {
            super(guiHelper, MD.MachineType.GREENHOUSE,TYPE_A);
        }
        public static final RecipeType<MultiOutRecipe> TYPE_A =
                RecipeType.create(MODID, "api_multiout_a", MultiOutRecipe.class);
    }
}
