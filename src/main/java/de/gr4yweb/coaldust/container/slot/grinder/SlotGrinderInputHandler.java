package de.gr4yweb.coaldust.container.slot.grinder;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

/**
 * Created by gr4y on 10.08.2016.
 */
public class SlotGrinderInputHandler extends SlotItemHandler {

    public SlotGrinderInputHandler(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return (stack.getItem() == Items.COAL);
    }

}

