
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.random.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.random.RandomMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class RandomModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RandomMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RANDOM_PART_1_TAB = REGISTRY.register("random_part_1_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.random.random_part_1_tab")).icon(() -> new ItemStack(RandomModItems.RANDOM_PART_1.get())).displayItems((parameters, tabData) -> {
				tabData.accept(RandomModBlocks.THE_LUCKY_GOD_STATUE.get().asItem());
			}).withSearchBar().build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RANDOM_PART_2_TAB = REGISTRY.register("random_part_2_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.random.random_part_2_tab")).icon(() -> new ItemStack(RandomModItems.RANDOM_PART_2.get())).displayItems((parameters, tabData) -> {
				tabData.accept(RandomModItems.DIY.get());
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {

			tabData.accept(RandomModItems.RANDOM_CORE.get());

		}
	}
}
