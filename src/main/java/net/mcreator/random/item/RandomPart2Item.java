
package net.mcreator.random.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class RandomPart2Item extends Item {
	public RandomPart2Item() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
	}
}
