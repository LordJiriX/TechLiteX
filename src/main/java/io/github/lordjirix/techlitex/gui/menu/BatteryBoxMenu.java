package io.github.lordjirix.techlitex.gui.menu;

import io.github.lordjirix.techlitex.loader.TLXMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class BatteryBoxMenu extends AbstractContainerMenu {
  private ContainerData data;

  public BatteryBoxMenu(int id, Inventory inv, FriendlyByteBuf buf) {
    super(TLXMenus.BATTERYBOX_MENU.get(), id);
    this.data = new SimpleContainerData(2);
    addPlayerInventory(inv);
    addPlayerHotbar(inv);
    addDataSlots(this.data);
  }

  public BatteryBoxMenu(int id, Inventory playerInv, ContainerData data) {
    super(TLXMenus.BATTERYBOX_MENU.get(), id);
    this.data = data;
    addPlayerInventory(playerInv);
    addPlayerHotbar(playerInv);
    addDataSlots(data);
  }

  private void addPlayerInventory(Inventory inv) {
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 9; col++) {
        this.addSlot(new Slot(inv, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
      }
    }
  }

  private void addPlayerHotbar(Inventory inv) {
    for (int i = 0; i < 9; i++) {
      this.addSlot(new Slot(inv, i, 8 + i * 18, 142));
    }
  }

  @Override
  public boolean stillValid(Player player) {
    return true;
  }

  @Override
  public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
    return null;
  }

  public int getScaledProgress() {
    int energyStored = data.get(0);
    int maxEnergyStored = data.get(1);
    int arrowSize = 25*2;

    return maxEnergyStored > 0 ? energyStored * arrowSize / maxEnergyStored : 0;
  }



  public int getEnergyStored() {
    return data.get(0);
  }

  public int getMaxEnergyStored() {
    return data.get(1);
  }
}
