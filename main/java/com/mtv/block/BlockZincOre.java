package com.mtv.block;

import java.util.Random;

import com.mtv.Reference;
import com.mtv.block.item.IMetaBlockName;
import com.mtv.handler.EnumHandler.CoreTypes;
import com.mtv.handler.EnumHandler.OreType;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockZincOre extends Block implements IMetaBlockName{

	public static final PropertyEnum TYPE = PropertyEnum.create("type", OreType.class);

	public BlockZincOre(String unlocalizedName, String registryName) {
		super(Material.ROCK);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, registryName));
		this.setHardness(3.0F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, OreType.OVERWORLD));
		
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {TYPE});
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		OreType type = (OreType) state.getValue(TYPE);
		return type.getID();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		
		return this.getDefaultState().withProperty(TYPE, OreType.values()[meta]);
	}
	
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list) {
		for(int i = 0; i < OreType.values().length; i++) {
			list.add(new ItemStack(itemIn, 1, i));
		}
		
	}
		
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return OreType.values()[stack.getItemDamage()].getName();
	}

}
