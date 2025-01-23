
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.random.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.mcreator.random.item.DiyItem;
import net.mcreator.random.RandomMod;

public class RandomModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(RandomMod.MODID);
	public static final DeferredItem<Item> DIY = REGISTRY.register("diy", DiyItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}
