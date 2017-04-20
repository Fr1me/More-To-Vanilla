package com.mtv.init;

import com.mtv.Mtv;
import com.mtv.Reference;
import com.mtv.Utils;
import com.mtv.handler.EnumHandler;
import com.mtv.item.ItemCuttingKnife;
import com.mtv.item.ItemMachineCore;
import com.mtv.item.ItemModFood;
import com.mtv.item.ItemZincIngot;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item zincIngot;
	public static Item zincNugget;
	public static Item tinIngot;
	public static Item magnesiumIngot;
	public static Item core;
	public static Item corn;
	public static Item candyCane;
	public static Item cuttingKnife;
	
	public static void init() {
		zincIngot = new ItemZincIngot("zinc_ingot", "zinc_ingot");
		zincNugget = new ItemZincIngot("zinc_nugget", "zinc_nugget");	
		tinIngot = new ItemZincIngot("tin_ingot", "tin_ingot");		
		magnesiumIngot = new ItemZincIngot("magnesium_ingot", "magnesium_ingot");
		core = new ItemMachineCore("machine_core");
		corn = new ItemModFood("corn", 5, 3, false);
		candyCane = new ItemModFood("candy_cane", 1, 1, false, new PotionEffect(Potion.getPotionById(1), 100, 2), new PotionEffect(Potion.getPotionById(3), 100, 2));
		cuttingKnife = new ItemCuttingKnife("cutting_knife", "cutting_knife");
		
	}	
	public static void register() {
		registerItem(zincIngot);
		registerItem(zincNugget);		
		registerItem(tinIngot);		
		registerItem(magnesiumIngot);
		registerItem(core);
		registerItem(corn);
		registerItem(candyCane);
		registerItem(cuttingKnife);
	}
	
	public static void registerRenders() {
		registerRender(zincIngot, 0, null);
		registerRender(zincNugget, 0, null);	
		registerRender(tinIngot, 0, null);		
		registerRender(magnesiumIngot, 0, null);
		registerRender(corn, 0, null);
		registerRender(candyCane, 0, null);
		registerRender(cuttingKnife, 0, null);
		for(int i = 0; i < EnumHandler.CoreTypes.values().length; i++) {
			registerRender(core, i, "core_" + EnumHandler.CoreTypes.values()[i].getName());
		}
		
	}
	
	public static void registerItem(Item item) {
		item.setCreativeTab(Mtv.mtv);
		GameRegistry.register(item);
		Utils.getLogger().info("Registered Item: " + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, fileName), "inventory"));
		Utils.getLogger().info("Register Render For: " + item.getUnlocalizedName().substring(5));
	}

}

