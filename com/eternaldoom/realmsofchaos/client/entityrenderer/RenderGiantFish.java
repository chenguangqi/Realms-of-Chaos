package com.eternaldoom.realmsofchaos.client.entityrenderer;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderGiantFish extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("realmsofchaos:textures/entity/giant_fish.png");

	public RenderGiantFish() {
		super(new ModelGiantFish(), 3f);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

	protected void preRenderCallback(EntityLivingBase entity, float p_77041_2_) {
		float scale = 3.0f;
		GL11.glTranslatef(0f, 1f, 0f);
		if (entity.worldObj.getBlock((int) Math.round(entity.posX),
				(int) Math.floor(entity.posY), (int) Math.round(entity.posZ)) == Blocks.air
				|| entity.worldObj.getBlock((int) Math.round(entity.posX),
						(int) Math.floor(entity.posY),
						(int) Math.round(entity.posZ)).getMaterial() == Material.plants){
			GL11.glRotatef(90, 0, 0, 1f);
			GL11.glTranslatef(0f, 3.5f, 0f);
		}
		GL11.glScalef(scale, scale, scale);
	}
}