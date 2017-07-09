package de.gr4yweb.coaldust.proxy;

import de.gr4yweb.coaldust.CoalDustMod;
import de.gr4yweb.coaldust.CoalDustModBlocks;
import de.gr4yweb.coaldust.CoalDustModItems;
import de.gr4yweb.coaldust.gui.GuiHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {

    @SuppressWarnings("unused")
    public void PreInit(FMLPreInitializationEvent e) {

        NetworkRegistry.INSTANCE.registerGuiHandler(CoalDustMod.INSTANCE, new GuiHandler());

        CoalDustModBlocks.GRINDER.registerBlock();
        CoalDustModBlocks.GRINDER.registerItem();

        CoalDustModItems.DUST_COAL.registerItem();
        CoalDustModItems.ARTIFICIAL_DIAMOND.registerItem();
        CoalDustModItems.HAMMER.registerItem();

        CoalDustModItems.DUST_COAL.registerRecipes();
        CoalDustModItems.ARTIFICIAL_DIAMOND.registerRecipes();
        CoalDustModItems.HAMMER.registerRecipes();
        CoalDustModBlocks.GRINDER.registerRecipes();
    }

    @SuppressWarnings("unused")
    public void Init(FMLInitializationEvent e) {
    }

    @SuppressWarnings("unused")
    public void PostInit(FMLPostInitializationEvent e) {
    }
}
