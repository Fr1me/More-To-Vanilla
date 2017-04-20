package com.mtv.proxy;

import com.mtv.Reference;
import com.mtv.init.ModArmor;
import com.mtv.init.ModBlocks;
import com.mtv.init.ModItems;
import com.mtv.init.ModTools;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenders() {
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		ModTools.registerRenders();
		ModArmor.registerRenders();
	}
	
	@Override
	public void registerModelBakeryVariants() {
		ModelBakery.registerItemVariants(ModItems.core, new ResourceLocation(Reference.MODID, "core_basic"), new ResourceLocation(Reference.MODID, "core_advanced"), new ResourceLocation(Reference.MODID, "core_superior"));
	}
	
}
