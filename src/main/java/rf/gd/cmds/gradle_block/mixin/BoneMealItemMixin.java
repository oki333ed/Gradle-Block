package rf.gd.cmds.gradle_block.mixin;

import rf.gd.cmds.gradle_block.event.ItemEvents;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.server.level.ServerLevel;

@Mixin(BoneMealItem.class)
public abstract class BoneMealItemMixin {
	@Inject(method = "useOn", at = @At("HEAD"), cancellable = true)
	private void useOn(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
		if (context.getLevel() instanceof ServerLevel) {
			boolean result = ItemEvents.BONEMEAL_USED.invoker().onBonemealUsed(context.getClickedPos(), (Entity) context.getPlayer(), context.getItemInHand(), context.getLevel().getBlockState(context.getClickedPos()));
			if (!result)
				cir.setReturnValue(InteractionResult.FAIL);
		}
	}
}