package de.gr4yweb.coaldust.container;

import de.gr4yweb.coaldust.container.slot.grinder.SlotGrinderHeadHandler;
import de.gr4yweb.coaldust.container.slot.grinder.SlotGrinderInputHandler;
import de.gr4yweb.coaldust.container.slot.grinder.SlotGrinderOutputHandler;
import de.gr4yweb.coaldust.tile.TileEntityGrinder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;

public class ContainerGrinder extends Container {

    private static final int GUI_PADDING = 8;
    private static final int SLOT_WIDTH = 18;

    private static final int ROWS = 3;
    private static final int COLUMNS = 9;

    private static final int INPUT_SLOT_X = 35;
    private static final int INPUT_SLOT_Y = 21;

    private static final int FUEL_SLOT_X = 81;
    private static final int FUEL_SLOT_Y = 21;

    private static final int OUTPUT_SLOT_X = 125;
    private static final int OUTPUT_SLOT_Y = 21;


    private TileEntityGrinder tileEntityGrinder;

    public ContainerGrinder(InventoryPlayer playerInventoryIn, TileEntityGrinder tileEntityGrinderIn) {
        tileEntityGrinder = tileEntityGrinderIn;
        addInputSlot();
        addFuelSlot();
        addOutputSlot();
        addInventorySlots(playerInventoryIn);
    }

    private void addInventorySlots(IInventory playerInventoryIn) {

        // Slots for the main inventory
        for (int col = 0; col < COLUMNS; ++col) {
            for (int row = 0; row < ROWS; ++row) {
                int xPos = GUI_PADDING + col * SLOT_WIDTH;
                int yPos = row * SLOT_WIDTH + 59;
                this.addSlotToContainer(new Slot(playerInventoryIn, col + row * COLUMNS + 9, xPos, yPos));

            }
        }

        // Slots for the hotbar
        for (int col = 0; col < COLUMNS; ++col) {
            int xPos = GUI_PADDING + col * SLOT_WIDTH;
            this.addSlotToContainer(new Slot(playerInventoryIn, col, xPos, 117));
        }

    }

    private void addInputSlot() {
        IItemHandler itemHandler = tileEntityGrinder.getInputItemHandler();
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            addSlotToContainer(new SlotGrinderInputHandler(itemHandler, i, INPUT_SLOT_X, INPUT_SLOT_Y));
        }
        System.out.println(itemHandler);
    }

    private void addFuelSlot() {
        IItemHandler itemHandler = tileEntityGrinder.getFuelItemHandler();
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            addSlotToContainer(new SlotGrinderHeadHandler(itemHandler, i, FUEL_SLOT_X, FUEL_SLOT_Y));
        }
        System.out.println(itemHandler);
    }

    private void addOutputSlot() {
        IItemHandler itemHandler = tileEntityGrinder.getOutputItemHandler();
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            addSlotToContainer(new SlotGrinderOutputHandler(itemHandler, i, OUTPUT_SLOT_X, OUTPUT_SLOT_Y));
        }
        System.out.println(itemHandler);
    }

    @Nullable
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemStack = null;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack slotStack = slot.getStack();
            itemStack = slotStack.copy();

            if (index < 1) {
                if (!this.mergeItemStack(slotStack, 1, this.inventorySlots.size(), true)) {
                    return null;
                }
            } else if (!this.mergeItemStack(slotStack, 0, 1, false)) {
                return null;
            }

            if (slotStack.isEmpty()) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemStack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return tileEntityGrinder.canInteractWith(playerIn);
    }
}
