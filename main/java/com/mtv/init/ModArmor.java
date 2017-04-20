package com.mtv.init;

import com.mtv.Mtv;
import com.mtv.Reference;
import com.mtv.Utils;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModArmor {
	
	public static ArmorMaterial zincMaterial = EnumHelper.addArmorMaterial("zinc", Reference.MODID + ":zinc", 27, new int[] {2,6,5,2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F);
	
	public static ItemArmor zincHelmet;
	public static ItemArmor zincChestplate;
	public static ItemArmor zincLeggings;
	public static ItemArmor zincBoots;
	
	public static void init() {
		zincHelmet = new ItemModArmor(zincMaterial, 1, EntityEquipmentSlot.HEAD, "zinc_helmet");
		zincChestplate = new ItemModArmor(zincMaterial, 1, EntityEquipmentSlot.CHEST, "zinc_chestplate");
		zincLeggings = new ItemModArmor(zincMaterial, 2, EntityEquipmentSlot.LEGS, "zinc_leggings");
		zincBoots = new ItemModArmor(zincMaterial, 1, EntityEquipmentSlot.FEET, "zinc_boots");
	}
	
	public static void register() {
		registerItem(zincHelmet);
		registerItem(zincChestplate);
		registerItem(zincLeggings);
		registerItem(zincBoots);
	}
	
	public static void registerRenders() {
		registerRender(zincHelmet);
		registerRender(zincChestplate);
		registerRender(zincLeggings);
		registerRender(zincBoots);
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
