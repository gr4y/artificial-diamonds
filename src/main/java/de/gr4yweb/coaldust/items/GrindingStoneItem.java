package de.gr4yweb.coaldust.items;

import de.gr4yweb.coaldust.CoalDustMod;
import de.gr4yweb.coaldust.core.IItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GrindingStoneItem extends Item implements IItem {

    public enum EnumGrindingTier implements IStringSerializable {

        ONE(0, 256, "tier_one", "tier.one"),
        TWO(0, 1024, "tier_one", "tier.two"),
        THREE(0, 256, "tier_one", "tier.three");

        private final int meta;
        private final int maxDamage;
        private final String name;
        private final String unlocalizedName;

        EnumGrindingTier(int metaIn, int maxDamageIn, String nameIn, String unlocalizedNameIn){
            this.meta = metaIn;
            this.maxDamage = maxDamageIn;
            this.name = nameIn;
            this.unlocalizedName = unlocalizedNameIn;
        }

        @Override
        public String toString()
        {
            return this.unlocalizedName;
        }

        @Override
        public String getName()
        {
            return this.name;
        }

    }

    public enum Tier {
        ONE, TWO, THREE
    }

    private static final String ITEM_NAME = "grindingStone";
    private final Tier tier;

    public GrindingStoneItem(String unlocalizedNameIn, Tier tierIn) {
        super();
        setUnlocalizedName(unlocalizedNameIn);
        setRegistryName(CoalDustMod.MODID, ITEM_NAME);
        setHasSubtypes(true);
        tier = tierIn;
    }

    @Override
    public void registerItem() {
        GameRegistry.register(this);
    }

    @Override
    public void registerModels() {
        ModelLoader.registerItemVariants(this, getRegistryName());
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public void registerRecipes() {
    }

}