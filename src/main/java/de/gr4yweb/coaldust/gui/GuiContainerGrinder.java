package de.gr4yweb.coaldust.gui;

import de.gr4yweb.coaldust.CoalDustMod;
import de.gr4yweb.coaldust.container.ContainerCompressor;
import de.gr4yweb.coaldust.container.ContainerGrinder;
import de.gr4yweb.coaldust.tile.TileEntityCompressor;
import de.gr4yweb.coaldust.tile.TileEntityGrinder;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class GuiContainerGrinder extends GuiContainer {

    public static final int WIDTH = 176;
    public static final int HEIGHT = 141;

    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(CoalDustMod.MODID, "textures/gui/grinder.png");

    private TileEntityGrinder tileEntityGrinder;

    public GuiContainerGrinder(TileEntityGrinder tileEntityGrinderIn, ContainerGrinder containerGrinderIn) {
        super(containerGrinderIn);
        tileEntityGrinder = tileEntityGrinderIn;
        xSize = WIDTH;
        ySize = HEIGHT;
    }

//    @Override
//    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
//        String s = tileEntityGrinder.getDisplayName().getUnformattedText();
//        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
//    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(GUI_TEXTURE);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

}


