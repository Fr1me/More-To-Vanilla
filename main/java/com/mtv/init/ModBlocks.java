package com.mtv.init;

import com.mtv.Mtv;
import com.mtv.Reference;
import com.mtv.Utils;
import com.mtv.block.BlockBreaker;
import com.mtv.block.BlockZincOre;
import com.mtv.block.item.ItemBlockBreaker;
import com.mtv.block.item.ItemBlockMeta;
import com.mtv.handler.EnumHandler;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block zinc_ore;

	public static void init() {
		zinc_ore = new BlockZincOre("zinc_ore", "zinc_ore");
		
	}
	
	public static void registerRenders() {
		for(int i = 0; i < EnumHandler.OreType.values().length; i++) {
			registerRender(zinc_ore, i, "zinc_ore_" + EnumHandler.OreType.values()[i].getName());
		}
		
	}
	
	public static void register() {
		registerBlock(zinc_ore, new ItemBlockMeta(zinc_ore));

	}
	
	public static void registerBlock(Block block) {
		block.setCreativeTab(Mtv.mtv);
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered Block: " + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerBlock(Block block, ItemBlock itemBlock) {
		block.setCreativeTab(Mtv.mtv);
		GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered Block: " + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, block.getUnlocalizedName().substring(5)), null));
		Utils.getLogger().info("Registered Render For " + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Block block, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, fileName), "inventory"));
		Utils.getLogger().info("Register Render For " + block.getUnlocalizedName().substring(5));
	}
	
}
