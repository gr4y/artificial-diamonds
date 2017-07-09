package de.gr4yweb.coaldust.items;

import de.gr4yweb.coaldust.CoalDustMod;
import de.gr4yweb.coaldust.core.IItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by gr4y on 15.07.2016.
 */
public class HammerItem extends Item implements IItem {

    public static String ITEM_NAME = "hammer";

    public HammerItem(String unlocalizedName) {
        super();
        setUnlocalizedName(unlocalizedName);
        setRegistryName(CoalDustMod.MODID, ITEM_NAME);
        setCreativeTab(CreativeTabs.TOOLS);
        setMaxDamage(31);
        setMaxStackSize(1);

    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        if (itemStack.getMaxDamage() == itemStack.getItemDamage()) {
            return null;
        } else {
            ItemStack newStack = itemStack.copy();
            newStack.setItemDamage(itemStack.getItemDamage() + 1);
            return newStack;
        }
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repairStack) {
        return isDamaged(toRepair) && toRepair.getItem() instanceof HammerItem && repairStack.getItem() == Items.IRON_INGOT;
    }

    @Override
    public void registerItem() {
        GameRegistry.register(this);
    }

    @Override
    public void registerRecipes() {
        GameRegistry.addRecipe(new ItemStack(this, 1), "ISI", "ISI", "#S#", 'I', Items.IRON_INGOT, 'S', Items.STICK);
    }

    @Override
    public void registerModels() {
        ModelLoader.registerItemVariants(this, getRegistryName());
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }


}
