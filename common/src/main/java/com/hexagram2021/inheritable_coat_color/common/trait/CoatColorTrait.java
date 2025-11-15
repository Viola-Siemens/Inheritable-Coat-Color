package com.hexagram2021.inheritable_coat_color.common.trait;

import com.hexagram2021.chromosomelib.common.trait.Trait;
import com.hexagram2021.chromosomelib.common.trait.TraitType;
import com.hexagram2021.inheritable_coat_color.registry.ICCTraitTypes;
import net.minecraft.core.Holder;
import net.minecraft.world.item.DyeColor;

public class CoatColorTrait implements Trait {
	private final DyeColor color;

	public CoatColorTrait(DyeColor color) {
		this.color = color;
	}

	@Override
	public Holder<TraitType> getType() {
		return ICCTraitTypes.COLOR;
	}

	public DyeColor getColor() {
		return this.color;
	}
}
