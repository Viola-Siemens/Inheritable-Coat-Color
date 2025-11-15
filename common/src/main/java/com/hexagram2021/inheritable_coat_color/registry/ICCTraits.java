package com.hexagram2021.inheritable_coat_color.registry;

import com.hexagram2021.chromosomelib.common.trait.Trait;
import com.hexagram2021.chromosomelib.platform.Services;
import com.hexagram2021.inheritable_coat_color.common.trait.CoatColorTrait;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;

import static com.hexagram2021.chromosomelib.ChromosomeLib.MODID;

public final class ICCTraits {
	public static final Holder<Trait> BLACK = registerColorTrait("black", DyeColor.BLACK);
	public static final Holder<Trait> BLUE = registerColorTrait("blue", DyeColor.BLUE);
	public static final Holder<Trait> BROWN = registerColorTrait("brown", DyeColor.BROWN);
	public static final Holder<Trait> CYAN = registerColorTrait("cyan", DyeColor.CYAN);
	public static final Holder<Trait> GRAY = registerColorTrait("gray", DyeColor.GRAY);
	public static final Holder<Trait> GREEN = registerColorTrait("green", DyeColor.GREEN);
	public static final Holder<Trait> LIGHT_BLUE = registerColorTrait("light_blue", DyeColor.LIGHT_BLUE);
	public static final Holder<Trait> LIGHT_GRAY = registerColorTrait("light_gray", DyeColor.LIGHT_GRAY);
	public static final Holder<Trait> LIME = registerColorTrait("lime", DyeColor.LIME);
	public static final Holder<Trait> MAGENTA = registerColorTrait("magenta", DyeColor.MAGENTA);
	public static final Holder<Trait> ORANGE = registerColorTrait("orange", DyeColor.ORANGE);
	public static final Holder<Trait> PINK = registerColorTrait("pink", DyeColor.PINK);
	public static final Holder<Trait> PURPLE = registerColorTrait("purple", DyeColor.PURPLE);
	public static final Holder<Trait> RED = registerColorTrait("red", DyeColor.RED);
	public static final Holder<Trait> WHITE = registerColorTrait("white", DyeColor.WHITE);
	public static final Holder<Trait> YELLOW = registerColorTrait("yellow", DyeColor.YELLOW);

	private ICCTraits() {
	}

	private static Holder<Trait> registerColorTrait(String code, DyeColor color) {
		return Services.PLATFORM.registerTrait(new ResourceLocation(MODID, code), () -> new CoatColorTrait(color));
	}

	public static void init() {
		// Lazy init
	}
}
