package rf.gd.cmds.gradle_block.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.item.crafting.RepairItemRecipe;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.HolderLookup;

import java.util.ArrayList;

import com.google.common.collect.Lists;

@Mixin(RepairItemRecipe.class)
public abstract class GradleBlockModRepairItemRecipeMixin {
	@Inject(method = "assemble", at = @At("HEAD"), cancellable = true)
	public void assemble(CraftingInput craftingInput, HolderLookup.Provider provider, CallbackInfoReturnable<ItemStack> cir) {
		ItemStack itemStack3;
		ItemStack itemStack;
		ArrayList<ItemStack> list = Lists.newArrayList();
		for (int i = 0; i < craftingInput.ingredientCount(); ++i) {
			ItemStack itemStack2;
			itemStack = craftingInput.getItem(i);
			if (itemStack.isEmpty())
				continue;
			list.add(itemStack);
		}
	}
}