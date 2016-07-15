package de.gr4yweb.coaldust;

import de.gr4yweb.coaldust.core.ModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = CoalDustMod.MODID, version = CoalDustMod.VERSION)
public class CoalDustMod {

    public static final String MODID = "coaldust";
    public static final String VERSION = "1.0";

    @EventHandler
    @SuppressWarnings("unused")
    public void preInit(FMLPreInitializationEvent event) {
        ModItems.PreInit();
    }

    @EventHandler
    @SuppressWarnings("unused")
    public void init(FMLInitializationEvent event) {
        ModItems.Init();
    }

    @EventHandler
    @SuppressWarnings("unused")
    public void postInit(FMLPostInitializationEvent event) {
        ModItems.PostInit();
    }


}
