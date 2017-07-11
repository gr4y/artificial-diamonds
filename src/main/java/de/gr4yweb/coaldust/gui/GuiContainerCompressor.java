package de.gr4yweb.coaldust.gui;

import de.gr4yweb.coaldust.CoalDustMod;
import de.gr4yweb.coaldust.container.ContainerCompressor;
import de.gr4yweb.coaldust.tile.TileEntityCompressor;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class GuiContainerCompressor extends GuiContainer {

    public static final int WIDTH = 176;
    public static final int HEIGHT = 141;

    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(CoalDustMod.MODID, "textures/gui/compressor.png");

    public GuiContainerCompressor(TileEntityCompressor tileEntityCompressor, ContainerCompressor containerCompressor){
        super(containerCompressor);
        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(GUI_TEXTURE);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, this.xSize, this.ySize);
    }
}


