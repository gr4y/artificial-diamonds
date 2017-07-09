package de.gr4yweb.coaldust.container;

import de.gr4yweb.coaldust.tile.TileEntityCompressor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

/**
 * Created by gr4y on 28.07.2016.
 */
public class ContainerCompressor extends Container {

    private TileEntityCompressor tileEntityCompressor;

    public ContainerCompressor(InventoryPlayer playerInventoryIn, TileEntityCompressor tileEntityCompressorIn) {
        tileEntityCompressor = tileEntityCompressorIn;
//        addSlots();
//        addPlayerSlots(playerInventoryIn);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return false;
    }
}
