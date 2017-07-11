package de.gr4yweb.coaldust.blocks;

import de.gr4yweb.coaldust.CoalDustMod;
import de.gr4yweb.coaldust.CoalDustModGUI;
import de.gr4yweb.coaldust.core.IBlock;
import de.gr4yweb.coaldust.core.ModBlock;
import de.gr4yweb.coaldust.items.GrinderItemBlock;
import de.gr4yweb.coaldust.tile.TileBase;
import de.gr4yweb.coaldust.tile.TileEntityGrinder;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * Created by gr4y on 28.07.2016.
 */
public class GrinderBlock extends ModBlock implements IBlock, ITileEntityProvider {

    public static final PropertyDirection FACING = BlockHorizontal.FACING;

    private final boolean isGrinding = false;
    private static boolean keepInventory = false;

    public GrinderBlock() {
        super(Material.ROCK, "grinder_block");
        setUnlocalizedName("grinder");
        getDefaultState().withProperty(FACING, EnumFacing.NORTH);
        setTickRandomly(true);
    }

    // region Vanilla Methods
    @Nullable
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(this);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote) {
            return true;
        }
        TileEntity te = worldIn.getTileEntity(pos);
        if (!(te instanceof TileEntityGrinder)) {
            return false;
        }
        playerIn.openGui(CoalDustMod.INSTANCE, CoalDustModGUI.GRINDER, worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileBase entity = (TileBase) worldIn.getTileEntity(pos);
        InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), entity.getInputItemHandler().getStackInSlot(0));
        InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), entity.getFuelItemHandler().getStackInSlot(0));
        InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), entity.getOutputItemHandler().getStackInSlot(0));
        super.breakBlock(worldIn, pos, state);
    }
    //endregion

    // region Tile Entity Methods
    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityGrinder();
    }
    // endregion

    // region BlockState
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing facing = EnumFacing.getFront(meta);
        if (facing.getAxis() == EnumFacing.Axis.Y) {
            facing = EnumFacing.NORTH;
        }
        return getDefaultState().withProperty(FACING, facing);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }

    // endregion

    // region IBlock Methods
    @Override
    public void registerBlock() {
        GameRegistry.register(this);
        GameRegistry.registerTileEntity(TileEntityGrinder.class, CoalDustMod.MODID + "-grinder_block");
    }

    @Override
    public void registerItem() {
        GameRegistry.register(new GrinderItemBlock(this), this.getRegistryName());
    }

    @Override
    public void registerModels() {
        GrinderItemBlock itemBlock = new GrinderItemBlock(this);
        ModelLoader.registerItemVariants(itemBlock, getRegistryName());
        ModelLoader.setCustomModelResourceLocation(itemBlock, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public void registerRecipes() {

    }
    // endregion
}
