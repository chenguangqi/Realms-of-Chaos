package com.eternaldoom.realmsofchaos.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.eternaldoom.realmsofchaos.blocks.TileEntityDisplayCase;
import com.eternaldoom.realmsofchaos.blocks.TileEntityFrozenChest;
import com.eternaldoom.realmsofchaos.blocks.TileEntityNetherChest;
import com.eternaldoom.realmsofchaos.blocks.TileEntityOceanChest;
import com.eternaldoom.realmsofchaos.client.blockrenderers.DisplayCaseItemRenderer;
import com.eternaldoom.realmsofchaos.client.blockrenderers.RenderFrozenChest;
import com.eternaldoom.realmsofchaos.client.blockrenderers.RenderNetherChest;
import com.eternaldoom.realmsofchaos.client.blockrenderers.RenderOceanChest;
import com.eternaldoom.realmsofchaos.client.entityrenderer.RenderAquaticGolem;
import com.eternaldoom.realmsofchaos.client.entityrenderer.RenderBullet;
import com.eternaldoom.realmsofchaos.client.entityrenderer.RenderFish;
import com.eternaldoom.realmsofchaos.client.entityrenderer.RenderFrozenWarrior;
import com.eternaldoom.realmsofchaos.client.entityrenderer.RenderROCArrow;
import com.eternaldoom.realmsofchaos.client.entityrenderer.RenderScorpioid;
import com.eternaldoom.realmsofchaos.client.entityrenderer.RenderScorpius;
import com.eternaldoom.realmsofchaos.client.entityrenderer.RenderStag;
import com.eternaldoom.realmsofchaos.client.entityrenderer.RenderVoidCrawler;
import com.eternaldoom.realmsofchaos.entity.EntityAquaticGolem;
import com.eternaldoom.realmsofchaos.entity.EntityFrozenWarrior;
import com.eternaldoom.realmsofchaos.entity.EntityGiantFish;
import com.eternaldoom.realmsofchaos.entity.EntityKelpFish;
import com.eternaldoom.realmsofchaos.entity.EntityScorpioid;
import com.eternaldoom.realmsofchaos.entity.EntityScorpius;
import com.eternaldoom.realmsofchaos.entity.EntityStag;
import com.eternaldoom.realmsofchaos.entity.EntityVoidCrawler;
import com.eternaldoom.realmsofchaos.entity.projectile.EntityBullet;
import com.eternaldoom.realmsofchaos.entity.projectile.EntityROCArrow;

public class Renderers {
		
	public static void init(){
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOceanChest.class, new RenderOceanChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNetherChest.class, new RenderNetherChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFrozenChest.class, new RenderFrozenChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDisplayCase.class, new DisplayCaseItemRenderer());

		RenderManager manager = Minecraft.getMinecraft().getRenderManager();
		
		RenderingRegistry.registerEntityRenderingHandler(EntityAquaticGolem.class, new RenderAquaticGolem());
		RenderingRegistry.registerEntityRenderingHandler(EntityScorpioid.class, new RenderScorpioid());
		RenderingRegistry.registerEntityRenderingHandler(EntityScorpius.class, new RenderScorpius());
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidCrawler.class, new RenderVoidCrawler());
		RenderingRegistry.registerEntityRenderingHandler(EntityGiantFish.class, new RenderFish("giant_fish", 3, 3, 3));
		RenderingRegistry.registerEntityRenderingHandler(EntityKelpFish.class, new RenderFish("kelp_fish", 0.5f, 0.5f, 1));
		RenderingRegistry.registerEntityRenderingHandler(EntityFrozenWarrior.class, new RenderFrozenWarrior());
		RenderingRegistry.registerEntityRenderingHandler(EntityStag.class, new RenderStag());

		RenderingRegistry.registerEntityRenderingHandler(EntityROCArrow.class, new RenderROCArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet());
	}
}
