package com.hexagram2021.inheritable_coat_color.fabric;

import com.hexagram2021.chromosomelib.common.trait.Trait;
import com.hexagram2021.chromosomelib.fabric.event.CLFabricEvents;
import com.hexagram2021.inheritable_coat_color.InheritableCoatColor;
import com.hexagram2021.inheritable_coat_color.common.trait.CoatColorTrait;
import com.hexagram2021.inheritable_coat_color.registry.ICCRelations;
import com.hexagram2021.inheritable_coat_color.registry.ICCTraitTypes;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.animal.Sheep;

public class InheritableCoatColorFabric implements ModInitializer {
	@Override
	public void onInitialize() {
		InheritableCoatColor.modConstruct();
		ICCRelations.init();

		CLFabricEvents.AFTER_ASSIGNING_TRAIT_SOLVER.register((entity, map, hasTrait) -> {
			if(entity instanceof Sheep sheep) {
				Holder<Trait> trait = map.get(ICCTraitTypes.COLOR);
				if(trait != null && trait.value() instanceof CoatColorTrait colorTrait) {
					sheep.setColor(colorTrait.getColor());
				}
			}
		});
	}
}
