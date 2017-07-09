package de.gr4yweb.coaldust.container.slot.grinder;

import de.gr4yweb.coaldust.CoalDustModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotGrinderHeadHandler extends SlotItemHandler {

    public SlotGrinderHeadHandler(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return stack.getItem() == CoalDustModItems.HAMMER ||
                stack.getItem() == CoalDustModItems.GRINDING_STONE_ITEM_T1 ||
                stack.getItem() == CoalDustModItems.GRINDING_STONE_ITEM_T2 ||
                stack.getItem() == CoalDustModItems.GRINDING_STONE_ITEM_T3;
    }

}
