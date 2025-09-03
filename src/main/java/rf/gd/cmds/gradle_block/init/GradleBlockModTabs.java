/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package rf.gd.cmds.gradle_block.init;

import rf.gd.cmds.gradle_block.GradleBlockMod;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

public class GradleBlockModTabs {
	public static ResourceKey<CreativeModeTab> TAB_GRADLETAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(GradleBlockMod.MODID, "gradletab"));

	public static void load() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TAB_GRADLETAB,
				FabricItemGroup.builder().title(Component.translatable("item_group.gradle_block.gradletab")).icon(() -> new ItemStack(GradleBlockModBlocks.GRADLEBLOCK)).displayItems((parameters, tabData) -> {
					tabData.accept(GradleBlockModBlocks.GRADLEBLOCK.asItem());
					tabData.accept(GradleBlockModBlocks.EVILGRADLEBLOCK.asItem());
				}).build());
	}
}