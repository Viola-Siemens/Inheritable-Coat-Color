package com.hexagram2021.inheritable_coat_color.mixin;

import com.hexagram2021.inheritable_coat_color.common.EntityDatas;
import com.hexagram2021.inheritable_coat_color.common.ILongShortHair;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Sheep.class)
@SuppressWarnings("java:S100")
public class SheepEntityMixin implements ILongShortHair {
	@WrapOperation(method = {"finalizeSpawn", "getBreedOffspring(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/AgeableMob;)Lnet/minecraft/world/entity/animal/Sheep;"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/Sheep;setColor(Lnet/minecraft/world/item/DyeColor;)V"))
	private void icc$setColor(Sheep instance, DyeColor dyeColor, Operation<Void> original) {
		// remove vanilla logic
	}

	@WrapOperation(method = "shear", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/RandomSource;nextInt(I)I"))
	private int icc$shear(RandomSource instance, int i, Operation<Integer> original) {
		Sheep current = (Sheep)(Object)this;
		return original.call(instance, i) + (current.getEntityData().get(EntityDatas.LONG_HAIR) ? 1 : 0);
	}

	@Inject(method = "defineSynchedData", at = @At(value = "TAIL"))
	private void icc$defineSynchedData(CallbackInfo ci) {
		((Sheep)(Object)this).getEntityData().define(EntityDatas.LONG_HAIR, false);
	}

	@Inject(method = "addAdditionalSaveData", at = @At(value = "TAIL"))
	private void icc$addAdditionalSaveData(CompoundTag compound, CallbackInfo ci) {
		compound.putBoolean("ICC_LongHair", this.icc$hasLongHair());
	}

	@Inject(method = "readAdditionalSaveData", at = @At(value = "TAIL"))
	private void icc$readAdditionalSaveData(CompoundTag compound, CallbackInfo ci) {
		this.icc$setLongHair(compound.getBoolean("ICC_LongHair"));
	}

	@Inject(method = "<clinit>", at = @At(value = "TAIL"))
	private static void icc$clinit(CallbackInfo ci) {
		EntityDatas.LONG_HAIR = SynchedEntityData.defineId(Sheep.class, EntityDataSerializers.BOOLEAN);
	}

	@Override
	public boolean icc$hasLongHair() {
		return ((Sheep)(Object)this).getEntityData().get(EntityDatas.LONG_HAIR);
	}

	@Override
	public void icc$setLongHair(boolean longHair) {
		((Sheep)(Object)this).getEntityData().set(EntityDatas.LONG_HAIR, longHair);
	}
}
