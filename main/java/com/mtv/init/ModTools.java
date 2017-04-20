package com.mtv.init;

import com.mtv.Mtv;
import com.mtv.Reference;
import com.mtv.Utils;
import com.mtv.item.ItemModAxe;
import com.mtv.item.ItemModHoe;
import com.mtv.item.ItemModPickaxe;
import com.mtv.item.ItemModShovel;
import com.mtv.item.ItemModSword;
import com.mtv.item.ItemTerminator;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTools {
	
	public static final ToolMaterial zincMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":zincMaterial", 2, 624, 5.0F, 2.0F, 120);
	
	public static ItemPickaxe zincPickaxe;
	public static ItemModAxe zincAxe;
	public static ItemHoe zincHoe;
	public static ItemSpade zincShovel;
	public static ItemSword zincSword;
	public static ItemTerminator terminator;
	
	
	public static void init() {
		zincPickaxe = new ItemModPickaxe(zincMaterial, "zinc_pickaxe");
		zincAxe = new ItemModAxe(zincMaterial, "zinc_axe");
		zincHoe = new ItemModHoe(zincMaterial, "zinc_hoe");
		zincShovel = new ItemModShovel(zincMaterial, "zinc_shovel");
		zincSword = new ItemModSword(zincMaterial, "zinc_sword");
		terminator = new ItemTerminator("terminator");
	}
	
	public static void register() {
		registerItem(zincPickaxe);
		registerItem(zincAxe);
		registerItem(zincHoe);
		registerItem(zincShovel);
		registerItem(zincSword);
		registerItem(terminator);
	}
	
	public static void registerRenders() {
		registerRender(zincPickaxe);
		registerRender(zincAxe);
		registerRender(zincHoe);
		registerRender(zincShovel);
		registerRender(zincSword);
		registerRender(terminator);
	}
	public static void registerItem(Item item) {
		item.setCreativeTab(Mtv.mtv);
		GameRegistry.register(item);
		Utils.getLogger().info("Registered Item: " + item.getUnlocalizedName().substring(5));
	}
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Register Render For " + item.getUnlocalizedName().substring(5));
	}


}
