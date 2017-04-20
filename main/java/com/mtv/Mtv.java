package com.mtv;

import com.mtv.creativetab.TabMTV;
import com.mtv.handler.AchievementHandler;
import com.mtv.handler.OreDictionaryHandler;
import com.mtv.handler.RecipeHandler;
import com.mtv.init.ModArmor;
import com.mtv.init.ModBlocks;
import com.mtv.init.ModItems;
import com.mtv.init.ModTools;
import com.mtv.proxy.CommonProxy;
import com.mtv.worldgen.OreGen;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Mtv {
	
	public static final CreativeTabs mtv = new TabMTV(null);
	
	@Mod.Instance(Reference.MODID)
	public static Mtv instance;
	
	@SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ModItems.init();
		ModBlocks.init();
		ModTools.init();
		ModArmor.init();
		ModItems.register();
		ModBlocks.register();
		ModTools.register();
		ModArmor.register();
		
		proxy.registerRenders();
		proxy.registerTileEntities();
		proxy.init();
		
		AchievementHandler.registerAchievements();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new OreGen(), 0);
		OreDictionaryHandler.registerOreDictionary();
		RecipeHandler.registerCraftingRecipes(null);
		RecipeHandler.registerFurnaceRecipes(null);
		
		proxy.registerModelBakeryVariants();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
}
