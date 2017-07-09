package de.gr4yweb.coaldust.gui;

import de.gr4yweb.coaldust.CoalDustModGUI;
import de.gr4yweb.coaldust.container.ContainerCompressor;
import de.gr4yweb.coaldust.container.ContainerGrinder;
import de.gr4yweb.coaldust.tile.TileEntityCompressor;
import de.gr4yweb.coaldust.tile.TileEntityGrinder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
        switch (ID) {
            case CoalDustModGUI.GRINDER:
                return new ContainerGrinder(player.inventory, (TileEntityGrinder) tile);
            case CoalDustModGUI.COMPRESSOR:
                return new ContainerCompressor(player.inventory, (TileEntityCompressor) tile);
            default:
                return null;

        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));
        switch (ID) {
            case CoalDustModGUI.GRINDER:
                return new GuiContainerGrinder((TileEntityGrinder) tile, new ContainerGrinder(player.inventory, (TileEntityGrinder) tile));
            case CoalDustModGUI.COMPRESSOR:
                return new GuiContainerCompressor((TileEntityCompressor) tile, new ContainerCompressor(player.inventory, (TileEntityCompressor) tile));
            default:
                return null;
        }
    }

}
