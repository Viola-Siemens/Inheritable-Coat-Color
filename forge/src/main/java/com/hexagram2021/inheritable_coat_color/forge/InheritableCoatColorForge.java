package com.hexagram2021.inheritable_coat_color.forge;

import com.hexagram2021.chromosomelib.common.trait.Trait;
import com.hexagram2021.chromosomelib.forge.event.SolveAfterAssigningTraitEvent;
import com.hexagram2021.inheritable_coat_color.InheritableCoatColor;
import com.hexagram2021.inheritable_coat_color.common.ILongShortHair;
import com.hexagram2021.inheritable_coat_color.common.trait.CoatColorTrait;
import com.hexagram2021.inheritable_coat_color.common.trait.HairLengthTrait;
import com.hexagram2021.inheritable_coat_color.registry.ICCRelations;
import com.hexagram2021.inheritable_coat_color.registry.ICCTraitTypes;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.ModLoadingStage;
import net.minecraftforge.fml.common.Mod;

import java.util.Optional;

@Mod(InheritableCoatColor.MODID)
public class InheritableCoatColorForge {
	public InheritableCoatColorForge() {
		InheritableCoatColor.modConstruct();
		DeferredWorkQueue queue = DeferredWorkQueue.lookup(Optional.of(ModLoadingStage.CONSTRUCT)).orElseThrow();
		queue.enqueueWork(ModLoadingContext.get().getActiveContainer(), ICCRelations::init);

		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onTraitAssigned(SolveAfterAssigningTraitEvent event) {
		LivingEntity livingEntity = event.getEntity();
		if(livingEntity instanceof Sheep sheep) {
			event.accept((ignored, map, hasTrait) -> {
				Holder<Trait> trait = map.get(ICCTraitTypes.COLOR);
				if(trait != null && trait.value() instanceof CoatColorTrait colorTrait) {
					sheep.setColor(colorTrait.getColor());
				}
				trait = map.get(ICCTraitTypes.HAIR_LENGTH);
				if(trait != null && trait.value() instanceof HairLengthTrait lengthTrait && sheep instanceof ILongShortHair longShortHair) {
					longShortHair.icc$setLongHair(lengthTrait.longHair());
				}
			});
		}
	}
}
