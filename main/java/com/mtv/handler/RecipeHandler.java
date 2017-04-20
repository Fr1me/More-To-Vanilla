package com.mtv.handler;

import com.mtv.Utils;
import com.mtv.init.ModArmor;
import com.mtv.init.ModBlocks;
import com.mtv.init.ModItems;
import com.mtv.init.ModTools;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {
	
	public static void registerCraftingRecipes(GameRegistry registry) {
		registry.addShapelessRecipe(new ItemStack(ModItems.zincNugget, 9), new Object [] {ModItems.zincIngot});
		registerToolRecipes("ingotZinc", null, ModTools.zincPickaxe, ModTools.zincAxe, ModTools.zincShovel, ModTools.zincHoe, ModTools.zincSword, "woodStick");
		registerArmorRecipe("ingotZinc", null, ModArmor.zincHelmet, ModArmor.zincChestplate, ModArmor.zincLeggings, ModArmor.zincBoots);
		Utils.getLogger().info("Registered Crafting Recipes");
	}
	
	public static void registerFurnaceRecipes(GameRegistry registry) {
		registry.addSmelting(ModBlocks.zinc_ore, new ItemStack(ModItems.zincIngot), 0.7F);
		Utils.getLogger().info("Registered Furnace Recipes");
	}
	
	public static void registerToolRecipes(String string, GameRegistry registry, Item pickaxe, Item axe, Item shovel, Item hoe, Item sword, String string2) {
		registry.addRecipe(new ItemStack(pickaxe), new Object [] { "III", " S ", " S ", 'I', string, 'S', string2 });
		registry.addRecipe(new ItemStack(axe), new Object [] { "II ", "IS ", " S ", 'I', string, 'S', string2 });
		registry.addRecipe(new ItemStack(axe), new Object [] { " II", " SI", " S ", 'I', string, 'S', string2 });
		registry.addRecipe(new ItemStack(shovel), new Object [] { "I  ", "S  ", "S  ", 'I', string, 'S', string2 });
		registry.addRecipe(new ItemStack(shovel), new Object [] { " I ", " S ", " S ", 'I', string, 'S', string2 });
		registry.addRecipe(new ItemStack(shovel), new Object [] { "  I", "  S", "  S", 'I', string, 'S', string2 });
		registry.addRecipe(new ItemStack(hoe), new Object [] { "II ", "S  ", "S  ", 'I', string, 'S', string2 });
		registry.addRecipe(new ItemStack(hoe), new Object [] { "II ", " S ", " S ", 'I', string, 'S', string2 });
		registry.addRecipe(new ItemStack(hoe), new Object [] { " II", " S ", " S ", 'I', string, 'S', string2 });
		registry.addRecipe(new ItemStack(hoe), new Object [] { " II", "  S", "  S", 'I', string, 'S', string2 });
		registry.addRecipe(new ItemStack(sword), new Object [] { "I  ", "I  ", "S  ", 'I', string, 'S', string2 });
		registry.addRecipe(new ItemStack(sword), new Object [] { " I ", " I ", " S ", 'I', string, 'S', string2 });
		registry.addRecipe(new ItemStack(sword), new Object [] { "  I", "  I", "  S", 'I', string, 'S', string2 });
	}
	
	public static void registerArmorRecipe(String string, GameRegistry registry, Item helmet, Item chestplate, Item leggings, Item boots) {
		registry.addRecipe(new ItemStack(helmet), new Object[] { "III","I I","   ",'I',string});
		registry.addRecipe(new ItemStack(helmet), new Object[] { "   ","III","I I",'I',string});
		registry.addRecipe(new ItemStack(chestplate), new Object[] { "I I","III","III",'I',string});
		registry.addRecipe(new ItemStack(leggings), new Object[] { "III","I I","I I",'I',string});
		registry.addRecipe(new ItemStack(boots), new Object[] { "I I","I I","   ",'I',string});
		registry.addRecipe(new ItemStack(boots), new Object[] { "   ","I I","I I",'I',string});
	}

}
