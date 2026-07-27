package io.github.lordjirix.techlitex.gui.screen;

import static io.github.lordjirix.techlitex.TechLiteX.MODID;

import io.github.lordjirix.techlitex.gui.menu.BatteryBoxMenu;
import java.util.List;
import java.util.Optional;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BatteryBoxScreen extends AbstractContainerScreen<BatteryBoxMenu> {
  private static final ResourceLocation TEXTURE =
      new ResourceLocation(MODID, "textures/gui/empty_gui.png");

  public BatteryBoxScreen(BatteryBoxMenu menu, Inventory inv, Component title) {
    super(menu, inv, title);
    this.imageWidth = 176;
    this.imageHeight = 166;
  }

  @Override
  protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
    int xo = leftPos;
    int yo = topPos;

    guiGraphics.blit(TEXTURE, xo, yo, 0, 0, imageWidth, imageHeight);
    int barWidth = 100;
    int barHeight = 50;

    int x = leftPos + 35;
    int y = topPos + 20;
    guiGraphics.fill(x, y, x + barWidth, y + barHeight, 0xFF202020);
    int height = menu.getScaledProgress();
    guiGraphics.fill(x, y + barHeight - height, x + barWidth, y + barHeight, 0xFF00FF00);
  }

  @Override
  public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
    renderBackground(guiGraphics);
    super.render(guiGraphics, mouseX, mouseY, partialTick);
    int barX = leftPos + 35;
    int barY = topPos + 20;
    int barWidth = 100;
    int barHeight = 50;
    if (mouseX >= barX && mouseX < barX + barWidth && mouseY >= barY && mouseY < barY + barHeight) {
      int energyStored = menu.getEnergyStored();
      int maxEnergyStored = menu.getMaxEnergyStored();
      guiGraphics.renderTooltip(
          font, List.of(Component.literal(energyStored + "/" + maxEnergyStored + " RF")), Optional.empty(), mouseX, mouseY);
    }
    renderTooltip(guiGraphics, mouseX, mouseY);
  }
}
