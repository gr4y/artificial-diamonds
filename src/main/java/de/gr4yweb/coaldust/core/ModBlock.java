package de.gr4yweb.coaldust.core;

import de.gr4yweb.coaldust.CoalDustMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by gr4y on 21.06.2017.
 */
public class ModBlock extends Block implements IBlock {

    public ModBlock (Material material, String name) {
        super(material);
        setUnlocalizedName(name);
        setDefaultState(pickDefaultBlockState());
        setRegistryName(new ResourceLocation(CoalDustMod.MODID, name));
        registerBlock();

        if (registerInCreative()) {
            setCreativeTab(CreativeTabs.MISC);
        }

    }

    @Override
    public IBlockState pickDefaultBlockState() {
        return blockState.getBaseState();
    }

    protected boolean registerInCreative() {
        return true;
    }

    @Override
    public boolean eventReceived(IBlockState state, World world, BlockPos pos, int id, int param) {
        super.eventReceived(state, world, pos, id, param);
        TileEntity tileentity = world.getTileEntity(pos);
        return tileentity != null ? tileentity.receiveClientEvent(id, param) : false;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerModels() {

    }

    @Override
    public void registerBlock() {
        GameRegistry.register(this);
    }

    @Override
    public void registerItem() {

    }

    @Override
    public void registerRecipes() {

    }
}
