package com.eternaldoom.realmsofchaos.event;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

import com.eternaldoom.realmsofchaos.overworld.items.ROCItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class ArmorBonusEvent {
	public boolean lavaWPressed, lavaAPressed, lavaSPressed, lavaDPressed;
	public static boolean hasAquatic;
	@SubscribeEvent
	public void tickEvent(PlayerTickEvent evt){
		Item helmet = null, chestplate = null, leggings = null, boots = null;
		ItemStack stackBoots = evt.player.inventory.armorItemInSlot(0);
		ItemStack stackLeggings = evt.player.inventory.armorItemInSlot(1);
		ItemStack stackChestplate = evt.player.inventory.armorItemInSlot(2);
		ItemStack stackHelmet = evt.player.inventory.armorItemInSlot(3);
		
		if(stackHelmet != null) helmet = stackHelmet.getItem();
		if(stackChestplate != null) chestplate = stackChestplate.getItem();
		if(stackLeggings != null) leggings = stackLeggings.getItem();
		if(stackBoots != null) boots = stackBoots.getItem();
		
		if (helmet == ROCItems.flame_helmet && chestplate == ROCItems.flame_chestplate && leggings == ROCItems.flame_leggings && boots == ROCItems.flame_boots){
			evt.player.addPotionEffect(new PotionEffect(12, 20, 0, true));
			if (evt.player.worldObj.getBlock((int)evt.player.posX, (int)evt.player.posY - 1, (int)evt.player.posZ) == Blocks.lava){
				if (evt.player.motionX < 0.2f && evt.player.motionX > -0.2f){
					if(lavaWPressed && evt.player.motionX >= 0){
						evt.player.motionX += 0.1f;
						evt.player.motionX *= 1.5f;
					}
					
					if(lavaSPressed && evt.player.motionX <= 0){
						evt.player.motionX -= 0.1f;
						evt.player.motionX *= 1.5f;
					}
				}
				
				if (evt.player.motionZ < 0.2f && evt.player.motionZ > -0.2f){
					if(lavaAPressed)
					evt.player.motionZ *= 1.5f;
				}
			}
		}
		
		if (helmet == ROCItems.aquatic_helmet && chestplate == ROCItems.aquatic_chestplate && leggings == ROCItems.aquatic_leggings && boots == ROCItems.aquatic_boots){
			hasAquatic = true;
			if(evt.player.isInWater()){
				evt.player.capabilities.isFlying = true;
				evt.player.addPotionEffect(new PotionEffect(13, 1, 0, true));
			}else{
				if(!evt.player.capabilities.isCreativeMode){
					evt.player.capabilities.isFlying = false;
				}
			}
		}else{
			hasAquatic = false;
		}
	}
	
	public static boolean getAquatic(){
		return hasAquatic;
	}

	@SubscribeEvent
	public void keyPressed(InputEvent.KeyInputEvent evt){
		if(Minecraft.getMinecraft().gameSettings.keyBindForward.isPressed()) lavaWPressed = true;
		else lavaWPressed = false;
		
		if(Minecraft.getMinecraft().gameSettings.keyBindLeft.isPressed()) lavaAPressed = true;
		else lavaAPressed = false;
		
		if(Minecraft.getMinecraft().gameSettings.keyBindBack.isPressed()) lavaSPressed = true;
		else lavaSPressed = false;
		
		if(Minecraft.getMinecraft().gameSettings.keyBindRight.isPressed()) lavaDPressed = true;
		else lavaDPressed = false;
	}
}