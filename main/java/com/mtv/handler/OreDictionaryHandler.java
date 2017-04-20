package com.mtv.handler;

import com.mtv.init.ModBlocks;
import com.mtv.init.ModItems;

import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHandler {
	
	public static void registerOreDictionary() {
		
		OreDictionary.registerOre("ingotZinc", ModItems.zincIngot);
		OreDictionary.registerOre("oreZinc", ModBlocks.zinc_ore);
		OreDictionary.registerOre("ingotTin", ModItems.tinIngot);
		OreDictionary.registerOre("ingotMagnesium", ModItems.magnesiumIngot);
	}

}
