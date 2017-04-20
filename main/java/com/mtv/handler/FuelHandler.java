package com.mtv.handler;

import com.mtv.init.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler{

	@Override
	public int getBurnTime(ItemStack fuel) {
		//if(fuel.getItem() == ModItems.corn)
		return 0;
	}

}
