/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package rf.gd.cmds.gradle_block.init;

import rf.gd.cmds.gradle_block.GradleBlockMod;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import java.util.function.Function;

public class GradleBlockModItems {
	public static Item GRADLEBLOCK;
	public static Item EVILGRADLEBLOCK;

	public static void load() {
		GRADLEBLOCK = block(GradleBlockModBlocks.GRADLEBLOCK, "gradleblock");
		EVILGRADLEBLOCK = block(GradleBlockModBlocks.EVILGRADLEBLOCK, "evilgradleblock");
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> I register(String name, Function<Item.Properties, ? extends I> supplier) {
		return (I) Items.registerItem(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(GradleBlockMod.MODID, name)), (Function<Item.Properties, Item>) supplier);
	}

	private static Item block(Block block, String name) {
		return block(block, name, new Item.Properties());
	}

	private static Item block(Block block, String name, Item.Properties properties) {
		return Items.registerItem(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(GradleBlockMod.MODID, name)), prop -> new BlockItem(block, prop), properties);
	}
}