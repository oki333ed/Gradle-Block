package rf.gd.cmds.gradle_block;

import rf.gd.cmds.gradle_block.init.GradleBlockModTabs;
import rf.gd.cmds.gradle_block.init.GradleBlockModItems;
import rf.gd.cmds.gradle_block.init.GradleBlockModBlocks;

import org.jetbrains.annotations.Nullable;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraft.world.entity.player.Player;
import net.minecraft.util.Tuple;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.api.EnvType;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;

import java.lang.invoke.MethodType;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandle;

public class GradleBlockMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger(GradleBlockMod.class);
	public static final String MODID = "gradle_block";

	@Override
	public void onInitialize() {
		// Start of user code block mod constructor
		// End of user code block mod constructor
		LOGGER.info("Initializing GradleBlockMod");
		GradleBlockModTabs.load();

		GradleBlockModBlocks.load();

		GradleBlockModItems.load();

		tick();
		// Start of user code block mod init
		// End of user code block mod init
	}

	// Start of user code block mod methods
	// End of user code block mod methods
	private static final Collection<Tuple<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		workQueue.add(new Tuple<>(action, tick));
	}

	public void tick() {
		ServerTickEvents.END_SERVER_TICK.register((server) -> {
			List<Tuple<Runnable, Integer>> actions = new ArrayList<>();
			workQueue.forEach(work -> {
				work.setB(work.getB() - 1);
				if (work.getB() == 0)
					actions.add(work);
			});
			actions.forEach(e -> e.getA().run());
			workQueue.removeAll(actions);
		});
	}

	private static Object minecraft;
	private static MethodHandle playerHandle;

	@Nullable
	public static Player clientPlayer() {
		if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
			try {
				if (minecraft == null || playerHandle == null) {
					Class<?> minecraftClass = Class.forName("net.minecraft.client.Minecraft");
					minecraft = MethodHandles.publicLookup().findStatic(minecraftClass, "getInstance", MethodType.methodType(minecraftClass)).invoke();
					playerHandle = MethodHandles.publicLookup().findGetter(minecraftClass, "player", Class.forName("net.minecraft.client.player.LocalPlayer"));
				}
				return (Player) playerHandle.invoke(minecraft);
			} catch (Throwable e) {
				LOGGER.error("Failed to get client player", e);
				return null;
			}
		} else {
			return null;
		}
	}
}