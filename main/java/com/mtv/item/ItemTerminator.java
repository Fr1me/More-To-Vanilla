package com.mtv.item;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;
import com.mtv.Reference;
import com.mtv.Utils;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.network.play.client.CPacketPlayer.Position;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class ItemTerminator extends ItemTool {
	
	private static final Set<Block> EFFECTIVE_BLOCKS = Sets.newHashSet(new Block[] {Blocks.BEDROCK});

	public ItemTerminator(String unlocalizedName) {
		super (EnumHelper.addToolMaterial(Reference.MODID + ":terminator", 100, 0, 100, 0, 0), EFFECTIVE_BLOCKS);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, player, tooltip, advanced);
		tooltip.add(TextFormatting.AQUA + Utils.getLang().localize("terminator.tooltip"));
	}
	
	@Override
	public boolean canHarvestBlock(IBlockState blockIn) {
		return blockIn == Blocks.BEDROCK;
		
	}
	
}
