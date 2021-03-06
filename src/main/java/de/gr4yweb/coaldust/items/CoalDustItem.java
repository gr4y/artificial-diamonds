package de.gr4yweb.coaldust.items;

import de.gr4yweb.coaldust.CoalDustMod;
import de.gr4yweb.coaldust.CoalDustModItems;
import de.gr4yweb.coaldust.core.IItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by gr4y on 12.07.2016.
 */
public class CoalDustItem extends Item implements IItem {

    private static final String OREDICT_NAME = "coal_dust";
    private static final String ITEM_NAME = "coal_dust";

    public CoalDustItem(String unlocalizedName){
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
        GameRegistry.addShapelessRecipe(new ItemStack(this, 3), new ItemStack(CoalDustModItems.HAMMER, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.COAL));
        GameRegistry.addRecipe(new ItemStack(Items.COAL, 1), "DDD", "DDD", "DDD", 'D', this);
    }

    @Override
    public void registerModels() {
        ModelLoader.registerItemVariants(this, getRegistryName());
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
