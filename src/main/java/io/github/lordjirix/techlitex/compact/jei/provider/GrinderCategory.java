package io.github.lordjirix.techlitex.compact.jei.provider;

import io.github.lordjirix.techlitex.api.data.recipe.GrinderRecipe;
import io.github.lordjirix.techlitex.api.data.recipe.SimpleInOutRecipeBase;
import io.github.lordjirix.techlitex.loader.TLXBlocks;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.font.FontManager;
import net.minecraft.client.gui.font.FontSet;
import net.minecraft.data.recipes.packs.VanillaRecipeProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import static io.github.lordjirix.techlitex.TechLiteX.MODID;


public class GrinderCategory implements IRecipeCategory<GrinderRecipe> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation("techlitex", "textures/gui/simpleinout_gui.png");
    private static final ResourceLocation FURNACE_GUI =
            new ResourceLocation("minecraft", "textures/gui/container/furnace.png");

    public static final RecipeType<GrinderRecipe> TYPE =
            RecipeType.create(MODID, "grinder", GrinderRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawable arrow;



    public GrinderCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createDrawable(TEXTURE, 0, 0, 150, 70);
        this.icon = guiHelper.createDrawableItemStack(
                new ItemStack(TLXBlocks.GRINDER_BLOCK_1.get())
        );


        arrow = guiHelper.createDrawable(FURNACE_GUI, 176, 15, 24, 20);
    }

    @Override
    public RecipeType<GrinderRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Grinder");
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
            GrinderRecipe recipe,
            IFocusGroup focuses) {

        builder.addSlot(
                RecipeIngredientRole.INPUT,
                24,
                35
        ).addItemStack(recipe.getInput());

        for (int i = 0; i < recipe.getOutput().length; i++) {
            builder.addSlot(
                    RecipeIngredientRole.OUTPUT,
                    80/* + i * 18*/,
                    35
            ).addItemStack(recipe.getOutput()[i]);
        }
    }
    @Override
    public void draw(GrinderRecipe recipe, IRecipeSlotsView slots,
                     GuiGraphics graphics, double mouseX, double mouseY) {
        graphics.drawString(Minecraft.getInstance().font,"Time: " + recipe.getTimePerRecipe() / 20 + "s",10,55,0);
        graphics.drawString(Minecraft.getInstance().font,"Energy: " + recipe.getRFPerTick()+ " RF/t",10,5,0);
        arrow.draw(graphics, 48, 26);
    }

}