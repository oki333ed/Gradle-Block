/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package rf.gd.cmds.gradle_block.init;

import rf.gd.cmds.gradle_block.block.GradleblockBlock;
import rf.gd.cmds.gradle_block.block.EvilgradleblockBlock;
import rf.gd.cmds.gradle_block.GradleBlockMod;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import java.util.function.Function;

public class GradleBlockModBlocks {
	public static Block GRADLEBLOCK;
	public static Block EVILGRADLEBLOCK;

	public static void load() {
		GRADLEBLOCK = register("gradleblock", GradleblockBlock::new);
		EVILGRADLEBLOCK = register("evilgradleblock", EvilgradleblockBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> B register(String name, Function<BlockBehaviour.Properties, B> supplier) {
		return (B) Blocks.register(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(GradleBlockMod.MODID, name)), (Function<BlockBehaviour.Properties, Block>) supplier, BlockBehaviour.Properties.of());
	}
}