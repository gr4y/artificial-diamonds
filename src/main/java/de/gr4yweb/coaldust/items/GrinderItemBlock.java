package de.gr4yweb.coaldust.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

/**
 * Created by gr4y on 28.07.2016.
 */
public class GrinderItemBlock extends ItemBlock {

    public GrinderItemBlock(Block block) {
        super(block);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

}
