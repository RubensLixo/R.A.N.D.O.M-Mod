
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.random.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.mcreator.random.item.RandomPart2Item;
import net.mcreator.random.item.RandomPart1Item;
import net.mcreator.random.item.RandomCoreItem;
import net.mcreator.random.item.DiyItem;
import net.mcreator.random.RandomMod;

public class RandomModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(RandomMod.MODID);
	public static final DeferredItem<Item> DIY = REGISTRY.register("diy", DiyItem::new);
	public static final DeferredItem<Item> RANDOM_PART_1 = REGISTRY.register("random_part_1", RandomPart1Item::new);
	public static final DeferredItem<Item> RANDOM_PART_2 = REGISTRY.register("random_part_2", RandomPart2Item::new);
	public static final DeferredItem<Item> RANDOM_CORE = REGISTRY.register("random_core", RandomCoreItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}
