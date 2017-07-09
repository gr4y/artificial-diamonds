package de.gr4yweb.coaldust.items;

import de.gr4yweb.coaldust.CoalDustMod;
import de.gr4yweb.coaldust.core.IItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by gr4y on 13.07.2016.
 */
public class ArtificialDiamondItem extends Item implements IItem {

    static final String OREDICT_NAME = "gemDiamond";
    static final String ITEM_NAME = "artificial_diamond";

    public ArtificialDiamondItem(String unlocalizedName) {
        super();
        setUnlocalizedName(unlocalizedName);
        setRegistryName(CoalDustMod.MODID, ITEM_NAME);
        setCreativeTab(CreativeTabs.MATERIALS);
    }

    @Override
    public void registerItem() {
        GameRegistry.register(this);
        OreDictionary.registerOre(OREDICT_NAME, this);
    }

    @Override
    public void registerRecipes() {
        GameRegistry.addRecipe(new ShapedOreRecipe(this, "#C#", "CGC", "#C#", Character.valueOf('C'), Blocks.GLASS, Character.valueOf('C'), "dustCoal"));
    }

    @Override
    public void registerModels() {
        if (getRegistryName() == null) {
            throw new IllegalArgumentException("Can't register an item variant without the registry name being null!");
        }
        ModelLoader.registerItemVariants(this, getRegistryName());
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
