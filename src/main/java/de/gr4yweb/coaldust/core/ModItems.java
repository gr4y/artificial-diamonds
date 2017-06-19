package de.gr4yweb.coaldust.core;

import de.gr4yweb.coaldust.items.ArtificialDiamondItem;
import de.gr4yweb.coaldust.items.CoalDustItem;

/**
 * Mod Item Registration Class
 */
public class ModItems {

    public static CoalDustItem coalDustItem = new CoalDustItem("dust_coal");
    public static ArtificialDiamondItem diamondItem = new ArtificialDiamondItem("artificial_diamond");

    public static void PreInit() {
        coalDustItem.registerItem();
        diamondItem.registerItem();
        coalDustItem.registerModels();
        diamondItem.registerModels();
    }

    public static void Init() {
        coalDustItem.registerRecipes();
        diamondItem.registerRecipes();
    }

    public static void PostInit() {
    }

}
