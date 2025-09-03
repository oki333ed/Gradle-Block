package rf.gd.cmds.gradle_block.block;

import rf.gd.cmds.gradle_block.init.GradleBlockModBlocks;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

public class GradleblockBlock extends Block {
	public GradleblockBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(1f, 10f).instrument(NoteBlockInstrument.BASEDRUM));
	}

	@Environment(EnvType.CLIENT)
	public static void registerRenderLayer() {
		BlockRenderLayerMap.putBlock(GradleBlockModBlocks.GRADLEBLOCK, ChunkSectionLayer.CUTOUT_MIPPED);
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}