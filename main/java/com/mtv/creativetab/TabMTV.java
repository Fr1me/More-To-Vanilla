package com.mtv.creativetab;

import com.mtv.init.ModBlocks;
import com.mtv.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TabMTV extends CreativeTabs {

	public TabMTV(String label) {
		super("mtv");
		
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.zincIngot);
	}

	

}
