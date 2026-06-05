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
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class SimpleInOutMenu extends AbstractContainerMenu {

  private final ItemStackHandler handler;
  private ContainerData data;

  public SimpleInOutMenu(int id, Inventory inv, FriendlyByteBuf buf) {
      super(TLXMenus.SIMPLE_INOUT_MENU.get(), id);

      this.handler = new ItemStackHandler(2);
      this.data = new SimpleContainerData(2);

      this.addSlot(new SlotItemHandler(handler, 0, 24, 35));
      this.addSlot(
              new SlotItemHandler(handler, 1, 80, 35) {
                  @Override
                  public boolean mayPlace(@NotNull ItemStack stack) {
                      return false;
                  }
              });

      addPlayerInventory(inv);
      addPlayerHotbar(inv);

      addDataSlots(this.data);
  }
  public SimpleInOutMenu(
      int id, Inventory playerInv, ItemStackHandler handler, ContainerData data) {
    super(TLXMenus.SIMPLE_INOUT_MENU.get(), id);
    this.handler = handler;
    this.data = data;
    this.addSlot(new SlotItemHandler(handler, 0, 24, 35));
    this.addSlot(
        new SlotItemHandler(handler, 1, 80, 35) {
          @Override
          public boolean mayPlace(@NotNull ItemStack stack) {
            return false;
          }
        });

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
  public ItemStack quickMoveStack(Player player, int index) {
    Slot slot = this.slots.get(index);
    if (slot == null || !slot.hasItem()) return ItemStack.EMPTY;
    ItemStack stack = slot.getItem();
    ItemStack copy = stack.copy();
    int machineSlots = 2;
    if (index < machineSlots) {
      if (!this.moveItemStackTo(stack, machineSlots, this.slots.size(), true)) {
        return ItemStack.EMPTY;
      }
    } else {
      if (!this.moveItemStackTo(stack, 0, machineSlots, false)) {
        return ItemStack.EMPTY;
      }
    }
    if (stack.isEmpty()) {
      slot.set(ItemStack.EMPTY);
    } else {
      slot.setChanged();
    }
    return copy;
  }

  public boolean isCrafting() {
    return data.get(0) > 0;
  }

  public int getScaledProgress() {
    int progress = data.get(0);
    int maxProgress = data.get(1);
    int arrowSize = 24;

    return maxProgress > 0 ? progress * arrowSize / maxProgress : 0;
  }

  public int getScaledProgressVertical() {
    int progress = data.get(0);
    int maxProgress = data.get(1);

    return maxProgress > 0 ? progress * 54 / maxProgress : 0;
  }

  public int getCurrentRunTime() {
    return data.get(0);
  }

  public int getTimeToRunRecipe() {
    return data.get(1);
  }
}
