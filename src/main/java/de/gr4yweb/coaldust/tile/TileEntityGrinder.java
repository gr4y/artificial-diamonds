package de.gr4yweb.coaldust.tile;

import de.gr4yweb.coaldust.CoalDustModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;

public class TileEntityGrinder extends TileBase implements ITickable {

    private int grindTime = 0;

    @Override
    public void update() {

        if (hasInputItems() && hasGrindingStone() && !isOutputFull()) {
            return;
        }



        while (hasInputItems() && hasGrindingStone() && !isOutputFull()) {

            for (int i = getInputItems().getCount(); i >= 0; i--) {
                if (!isOutputFull()) {
                    return;
                }

                // set count of input items to new value
                getInputItems().setCount(i);

                // Set ItemStack with CoalDust in slot 0
                getOutputItemHandler().setStackInSlot(0, new ItemStack(CoalDustModItems.DUST_COAL, i));
            }
        }

    }

//        ItemStack stack = getOutputItems().getStackInSlot(0);
//        if (stack != null) {
//            ItemStack newStack = stack.copy();
//            newStack.stackSize++;
//            getOutputItems().setStackInSlot(0, newStack);
//        } else {
//            ItemStack newStack = new ItemStack(CoalDustModItems.DUST_COAL, 9);
//            getOutputItems().setStackInSlot(0, newStack);
//        }

    private boolean isOutputFull() {
        return getOutputItems().getCount() <= getOutputItems().getMaxStackSize();
    }

    private boolean hasInputItems() {
        return getInputItems() != null && getInputItems().getCount() > 0;
    }

    private boolean hasGrindingStone() {
        return getFuelItems() != null; //&& getFuelItems().getItemDamage() > 0;
    }

    public void dropItems() {

    }


}