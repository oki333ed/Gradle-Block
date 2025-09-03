package rf.gd.cmds.gradle_block.event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.fabricmc.fabric.api.event.EventFactory;
import net.fabricmc.fabric.api.event.Event;

import java.util.Arrays;

public class PlayerEvents {
	public static final Event<TickEnd> END_PLAYER_TICK = EventFactory.createArrayBacked(TickEnd.class, (callbacks) -> (entity) -> Arrays.stream(callbacks).forEach(callback -> callback.onEndTick(entity)));
	public static final Event<XPChange> XP_CHANGE = EventFactory.createArrayBacked(XPChange.class, (callbacks) -> (entity, amount) -> Arrays.stream(callbacks).forEach(callback -> callback.onXpChange(entity, amount)));
	public static final Event<LevelChange> LEVEL_CHANGE = EventFactory.createArrayBacked(LevelChange.class, (callbacks) -> (entity, amount) -> Arrays.stream(callbacks).forEach(callback -> callback.onLevelChange(entity, amount)));
	public static final Event<PickupXp> PICKUP_XP = EventFactory.createArrayBacked(PickupXp.class, (callbacks) -> (entity) -> {
		for (PickupXp event : callbacks) {
			boolean result = event.onPickupXp(entity);
			if (!result) {
				return false;
			}
		}
		return true;
	});

	@FunctionalInterface
	public interface TickEnd {
		void onEndTick(Player player);
	}

	@FunctionalInterface
	public interface XPChange {
		void onXpChange(Player player, int amount);
	}

	@FunctionalInterface
	public interface LevelChange {
		void onLevelChange(Player player, int amount);
	}

	@FunctionalInterface
	public interface PickupXp {
		boolean onPickupXp(Entity entity);
	}
}