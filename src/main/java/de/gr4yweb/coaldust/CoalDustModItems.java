package de.gr4yweb.coaldust;

import de.gr4yweb.coaldust.items.ArtificialDiamondItem;
import de.gr4yweb.coaldust.items.CoalDustItem;
import de.gr4yweb.coaldust.items.GrindingStoneItem;
import de.gr4yweb.coaldust.items.HammerItem;

/**
 * Mod Item Registration Class
 */
public class CoalDustModItems {

    public static final CoalDustItem DUST_COAL = new CoalDustItem("dust_coal");
    public static final ArtificialDiamondItem ARTIFICIAL_DIAMOND = new ArtificialDiamondItem("artificial_diamond");
    public static final HammerItem HAMMER = new HammerItem("hammer");

    public static final GrindingStoneItem GRINDING_STONE_ITEM_T1 = new GrindingStoneItem("grinding_stone", GrindingStoneItem.Tier.ONE);
    public static final GrindingStoneItem GRINDING_STONE_ITEM_T2 = new GrindingStoneItem("grinding_stone", GrindingStoneItem.Tier.TWO);
    public static final GrindingStoneItem GRINDING_STONE_ITEM_T3 = new GrindingStoneItem("grinding_stone", GrindingStoneItem.Tier.THREE);

    public static void registerRenders() {
        DUST_COAL.registerModels();
        ARTIFICIAL_DIAMOND.registerModels();
        HAMMER.registerModels();
    }

}
