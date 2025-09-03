/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package rf.gd.cmds.gradle_block.init;

import rf.gd.cmds.gradle_block.block.GradleblockBlock;
import rf.gd.cmds.gradle_block.block.EvilgradleblockBlock;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

@Environment(EnvType.CLIENT)
public class GradleBlockModBlocksRenderers {
	public static void clientLoad() {
		GradleblockBlock.registerRenderLayer();
		EvilgradleblockBlock.registerRenderLayer();
	}
	// Start of user code block custom block renderers
	// End of user code block custom block renderers
}