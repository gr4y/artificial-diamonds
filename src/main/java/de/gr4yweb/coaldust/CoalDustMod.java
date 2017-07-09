package de.gr4yweb.coaldust;

import de.gr4yweb.coaldust.proxy.CommonProxy;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = CoalDustMod.MODID, version = CoalDustMod.VERSION)
public class CoalDustMod {

    public static final String MODID = "coaldust";
    public static final String VERSION = "1.0";

    @Mod.Instance
    public static CoalDustMod INSTANCE;

    @SuppressWarnings("unused")
    @SidedProxy(clientSide = "de.gr4yweb.coaldust.proxy.ClientProxy", serverSide = "de.gr4yweb.coaldust.proxy.ServerProxy")
    public static CommonProxy PROXY;

    @EventHandler
    @SuppressWarnings("unused")
    public void preInit(FMLPreInitializationEvent event) {
        PROXY.PreInit(event);
    }

    @EventHandler
    @SuppressWarnings("unused")
    public void Init(FMLInitializationEvent event) {
        PROXY.Init(event);
    }


    @EventHandler
    @SuppressWarnings("unused")
    public void PostInit(FMLPostInitializationEvent event) {
        PROXY.PostInit(event);
    }


}
