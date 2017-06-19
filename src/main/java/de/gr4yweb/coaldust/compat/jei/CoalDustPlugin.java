
package de.gr4yweb.coaldust.compat.jei;

import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;

import javax.annotation.Nonnull;

@JEIPlugin
@SuppressWarnings("unused")
public class CoalDustPlugin extends BlankModPlugin {

    @Override
    public void register(@Nonnull IModRegistry registry) {
//        registry.addDescription(new ItemStack(CoalDustModItems.HAMMER), "item.hammer.description");
    }

}