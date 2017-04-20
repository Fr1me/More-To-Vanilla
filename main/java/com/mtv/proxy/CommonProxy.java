package com.mtv.proxy;

import com.mtv.Reference;
import com.mtv.init.ModItems;
import com.mtv.worldgen.OreGen;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public void init() {
		
	}
	
	public void registerTileEntities() {
		
	}

	public void registerRenders() {
		
	}
	
	public void registerModelBakeryVariants() {
		ModelBakery.registerItemVariants(ModItems.core, new ResourceLocation(Reference.MODID, "core_basic"), new ResourceLocation(Reference.MODID, "core_advanced"));
	}
	
}
