package com.mtv.block.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemZincOre extends ItemBlock{
	
	public ItemZincOre(Block block) {
		super(block);
		if(!(block instanceof IMetaBlockName)) {
			throw new IllegalArgumentException(String.format("The given block %s is not an instance of IMetaBlockName!", block.getUnlocalizedName()));
		}
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "." + ((IMetaBlockName) this.block).getSpecialName(stack);
	}
	
	public int getMetadata(int damage) {
		return damage;
	}

}
