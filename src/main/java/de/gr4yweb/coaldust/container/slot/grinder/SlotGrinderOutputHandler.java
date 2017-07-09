package de.gr4yweb.coaldust.container.slot.grinder;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

/**
 * Created by gr4y on 21.06.2017.
 */
public class SlotGrinderOutputHandler extends SlotItemHandler {

    public SlotGrinderOutputHandler(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(@Nonnull ItemStack stack) {
        return true;
    }
}
