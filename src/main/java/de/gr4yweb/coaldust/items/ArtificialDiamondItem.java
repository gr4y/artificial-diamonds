package de.gr4yweb.coaldust.items;

import de.gr4yweb.coaldust.CoalDustMod;
import de.gr4yweb.coaldust.core.IItem;
import de.gr4yweb.coaldust.core.ModItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by gr4y on 13.07.2016.
 */
public class ArtificialDiamondItem extends Item implements IItem {

    static final String OREDICT_NAME = "gemDiamond";
    static final String ITEM_NAME = "artificialDiamond";

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
    public void registerModels() {
        ModelLoader.registerItemVariants(this, getRegistryName());
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public void registerRecipes() {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(this, 1), "#C#", "CGC", "#C#", 'G', Blocks.GLASS, 'C', ModItems.coalDustItem));
    }
}
