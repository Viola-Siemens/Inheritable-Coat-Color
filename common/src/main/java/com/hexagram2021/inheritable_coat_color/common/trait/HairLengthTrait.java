package com.hexagram2021.inheritable_coat_color.common.trait;

import com.hexagram2021.chromosomelib.common.trait.Trait;
import com.hexagram2021.chromosomelib.common.trait.TraitType;
import com.hexagram2021.inheritable_coat_color.registry.ICCTraitTypes;
import net.minecraft.core.Holder;

public class HairLengthTrait implements Trait {
	private final boolean longHair;

	public HairLengthTrait(boolean longHair) {
		this.longHair = longHair;
	}

	@Override
	public Holder<TraitType> getType() {
		return ICCTraitTypes.HAIR_LENGTH;
	}

	public boolean longHair() {
		return this.longHair;
	}
}
