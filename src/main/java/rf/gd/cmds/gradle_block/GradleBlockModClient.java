package rf.gd.cmds.gradle_block;

import rf.gd.cmds.gradle_block.init.GradleBlockModBlocksRenderers;

import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ClientModInitializer;

@Environment(EnvType.CLIENT)
public class GradleBlockModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Start of user code block mod constructor
		// End of user code block mod constructor

		GradleBlockModBlocksRenderers.clientLoad();

		// Start of user code block mod init
		// End of user code block mod init
	}
	// Start of user code block mod methods
	// End of user code block mod methods
}