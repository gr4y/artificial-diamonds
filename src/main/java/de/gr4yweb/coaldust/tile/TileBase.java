package de.gr4yweb.coaldust.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

/**
 * Created by gr4y on 10.08.2016.
 */
public class TileBase extends TileEntity {

    private static final String INPUT_ITEMS_NBT_KEY = "inputItems";
    private static final String FUEL_ITEMS_NBT_KEY = "fuelItems";
    private static final String OUTPUT_ITEMS_NBT_KEY = "outputItems";

    protected ItemStackHandler inputItems = new InternalItemStackHandler(1);
    protected ItemStackHandler fuelItems = new InternalItemStackHandler(1);
    protected ItemStackHandler outputItems = new InternalItemStackHandler(1);

    // region NBT Code
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        NBTBase inputItemsTag = compound.getTag(INPUT_ITEMS_NBT_KEY);
        if (inputItemsTag != null) {
            inputItems.deserializeNBT((NBTTagCompound) inputItemsTag);
        }
        NBTBase fuelItemsTag = compound.getTag(FUEL_ITEMS_NBT_KEY);
        if (fuelItemsTag != null) {
            fuelItems.deserializeNBT((NBTTagCompound) fuelItemsTag);
        }
        NBTBase outputItemsTag = compound.getTag(OUTPUT_ITEMS_NBT_KEY);
        if (outputItemsTag != null) {
            outputItems.deserializeNBT((NBTTagCompound) outputItemsTag);
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setTag(INPUT_ITEMS_NBT_KEY, inputItems.serializeNBT());
        compound.setTag(FUEL_ITEMS_NBT_KEY, fuelItems.serializeNBT());
        compound.setTag(OUTPUT_ITEMS_NBT_KEY, outputItems.serializeNBT());
        return compound;

    }
    // endregion

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return facing == EnumFacing.UP || facing == EnumFacing.EAST || facing == EnumFacing.SOUTH;
        }
        return super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {

            if (facing == EnumFacing.UP)
                return (T) inputItems;
            else if (facing == EnumFacing.EAST)
                return (T) fuelItems;
            else if (facing == EnumFacing.SOUTH)
                return (T) outputItems;
        }
        return super.getCapability(capability, facing);
    }

    public ItemStackHandler getInputItemHandler() {
        return inputItems;
    }

    public ItemStackHandler getFuelItemHandler() {
        return fuelItems;
    }

    public ItemStackHandler getOutputItemHandler() {
        return outputItems;
    }

    public ItemStack getInputItems() {
        return getInputItemHandler().getStackInSlot(0);
    }

    public ItemStack getFuelItems() {
        return getFuelItemHandler().getStackInSlot(0);
    }

    public ItemStack getOutputItems() {
        return getOutputItemHandler().getStackInSlot(0);
    }

    public boolean canInteractWith(EntityPlayer playerIn) {
        return !isInvalid() && playerIn.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;
    }

    private class InternalItemStackHandler extends ItemStackHandler {

        public InternalItemStackHandler(int size) {
            super(size);
        }

        /**
         * When a slots content changed, then we have to mark the TileEntity as dirty.
         *
         * @param slot
         */
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            TileBase.this.markDirty();
        }

    }

}
