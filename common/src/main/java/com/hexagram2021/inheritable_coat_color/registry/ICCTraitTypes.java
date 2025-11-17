package com.hexagram2021.inheritable_coat_color.registry;

import com.hexagram2021.chromosomelib.common.trait.AbstractTraitType;
import com.hexagram2021.chromosomelib.common.trait.Trait;
import com.hexagram2021.chromosomelib.common.trait.TraitType;
import com.hexagram2021.chromosomelib.platform.Services;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;

import static com.hexagram2021.chromosomelib.ChromosomeLib.MODID;

public final class ICCTraitTypes {
	public static final Holder<TraitType> COLOR = register("color");
	public static final Holder<TraitType> HAIR_LENGTH = register("hair_length");

	private ICCTraitTypes() {
	}

	@SuppressWarnings("SameParameterValue")
	private static Holder<TraitType> register(String code) {
		ResourceLocation name = new ResourceLocation(MODID, code);
		return Services.PLATFORM.registerTraitType(name, () -> new AbstractTraitType(name) {
			@Override
			public Holder<Trait> example() {
				return ICCTraits.WHITE;
			}
		});
	}

	public static void init() {
		// Lazy init
	}
}
