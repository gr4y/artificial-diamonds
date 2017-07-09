package de.gr4yweb.coaldust.proxy;

import de.gr4yweb.coaldust.CoalDustModBlocks;
import de.gr4yweb.coaldust.CoalDustModItems;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by gr4y on 28.07.2016.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void PreInit(FMLPreInitializationEvent e) {
        super.PreInit(e);
        CoalDustModItems.registerRenders();
    }
}
