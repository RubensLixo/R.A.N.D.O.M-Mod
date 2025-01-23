
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.random.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.random.block.TheLuckyGodStatueBlock;
import net.mcreator.random.RandomMod;

public class RandomModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(RandomMod.MODID);
	public static final DeferredBlock<Block> THE_LUCKY_GOD_STATUE = REGISTRY.register("the_lucky_god_statue", TheLuckyGodStatueBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
