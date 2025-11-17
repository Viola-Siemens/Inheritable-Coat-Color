package com.hexagram2021.inheritable_coat_color.mixin;

import com.hexagram2021.inheritable_coat_color.common.ILongShortHair;
import net.minecraft.client.model.SheepFurModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.animal.Sheep;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings({"java:S100", "java:S116", "NotNullFieldNotInitialized"})
@Mixin(SheepFurModel.class)
public class SheepFurModelMixin {
	@Unique
	private ModelPart icc$body;

	@Inject(method = "<init>", at = @At(value = "RETURN"))
	private void icc$init(ModelPart root, CallbackInfo ci) {
		this.icc$body = root.getChild("body");
	}

	@Inject(method = "setupAnim(Lnet/minecraft/world/entity/animal/Sheep;FFFFF)V", at = @At(value = "HEAD"))
	private void icc$setupAnim(Sheep entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
		if(entity instanceof ILongShortHair longShortHair) {
			float xzScale = longShortHair.icc$hasLongHair() ? 1.35F : 1.0F;
			this.icc$body.xScale = xzScale;
			this.icc$body.yScale = longShortHair.icc$hasLongHair() ? 1.05F : 1.0F;
			this.icc$body.zScale = xzScale;
		}
	}
}
