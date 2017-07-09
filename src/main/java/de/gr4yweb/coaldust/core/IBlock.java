package de.gr4yweb.coaldust.core;

import net.minecraft.block.state.IBlockState;

/**
 * A basic interface every Block Class in this mod should implement
 */
public interface IBlock extends IItem {

    /**
     * This should register the block in GameRegistry.
     */
    void registerBlock();

    /**
     * This should register the block as an Item.
     */
    void registerItem();

    /**
     * Returns the default BlockState of an block
     */
    IBlockState pickDefaultBlockState();

}
