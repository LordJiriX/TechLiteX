package io.github.lordjirix.techlitex.gui.screen;

import static io.github.lordjirix.techlitex.TechLiteX.MODID;

import io.github.lordjirix.techlitex.gui.menu.SimpleInOutMenu;
import java.util.List;
import java.util.Optional;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class SimpleInOutScreen extends AbstractContainerScreen<SimpleInOutMenu> {
  private static final ResourceLocation TEXTURE =
      new ResourceLocation(MODID, "textures/gui/simpleinout_gui.png");

  public SimpleInOutScreen(SimpleInOutMenu menu, Inventory inv, Component title) {
    super(menu, inv, title);
    this.imageWidth = 176;
    this.imageHeight = 166;
  }

  @Override
  protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
    int xo = leftPos;
    int yo = topPos;

    guiGraphics.blit(TEXTURE, xo, yo, 0, 0, imageWidth, imageHeight);
    int barWidth = 14;
    int barHeight = 54;

    int x = leftPos + 152;
    int y = topPos + 16;
    guiGraphics.fill(x, y, x + barWidth, y + barHeight, 0xFF202020);

    if (menu.isCrafting()) {

      int height = menu.getScaledProgressVertical();

      guiGraphics.fill(x, y + barHeight - height, x + barWidth, y + barHeight, 0xFF00FF00);
    }
  }

  @Override
  public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
    renderBackground(guiGraphics);

    super.render(guiGraphics, mouseX, mouseY, partialTick);

    int barX = leftPos + 150;
    int barY = topPos + 20;
    int barWidth = 14;
    int barHeight = 54;

    if (mouseX >= barX && mouseX < barX + barWidth && mouseY >= barY && mouseY < barY + barHeight) {

      int progress = menu.getCurrentRunTime();
      int maxProgress = menu.getTimeToRunRecipe();

      int percent = maxProgress > 0 ? progress * 100 / maxProgress : 0;

      guiGraphics.renderTooltip(
          font, List.of(Component.literal(percent + "%")), Optional.empty(), mouseX, mouseY);
    }
    renderTooltip(guiGraphics, mouseX, mouseY);
  }
}
