package com.mtv.handler;

import com.mtv.Reference;
import com.mtv.Utils;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class MtvSoundHandler {
	
	private static int size = 0;
	
	public static SoundEvent TEST;
	
	public static void init() {
		size = SoundEvent.REGISTRY.getKeys().size();
		
		TEST = register("test");
	}
	
	public static SoundEvent register(String name) {
		ResourceLocation location = new ResourceLocation(Reference.MODID, name);
		SoundEvent e = new SoundEvent(location);
		
		SoundEvent.REGISTRY.register(size, location, e);
		size++;
		Utils.getLogger().info("Registered Sound: " + name);
		return e;
	}

}
