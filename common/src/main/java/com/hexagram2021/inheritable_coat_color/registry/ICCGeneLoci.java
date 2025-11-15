package com.hexagram2021.inheritable_coat_color.registry;

import com.hexagram2021.chromosomelib.common.gene_locus.GeneLocus;
import com.hexagram2021.chromosomelib.platform.Services;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;

import static com.hexagram2021.chromosomelib.ChromosomeLib.MODID;

public final class ICCGeneLoci {
	public static final Holder<GeneLocus> MELANIN_ENZYME = registerHomologous("melanin_enzyme", 14, 0.000625D, 0.050000D);
	public static final Holder<GeneLocus> URANIDIN_ENZYME = registerLeft("uranidin_enzyme", 3, 0.001750D, 0.031250D);
	public static final Holder<GeneLocus> MELANIN_METABOLIC_ENZYME = registerHomologous("melanin_metabolic_enzyme", 5, 0.000250D, 0.003500D);
	public static final Holder<GeneLocus> DILUTION = registerHomologous("dilution", 19, 0.001500D, 0.003500D);
	public static final Holder<GeneLocus> PINK = registerHomologous("pink", 6, 0.000250D, 0.000250D);
	public static final Holder<GeneLocus> ABNORMAL = registerHomologous("abnormal", 7, 0.000300D, 0.000275D);
	public static final Holder<GeneLocus> SRY = registerRight("sry", 8, 0.000250D, 0.000250D);

	private ICCGeneLoci() {
	}

	private static Holder<GeneLocus> registerHomologous(String name, int index, double possibilityOfMutation, double possibilityOfCrossingOver) {
		return Services.PLATFORM.registerGeneLocus(new ResourceLocation(MODID, name), () -> GeneLocus.homologous(index, possibilityOfMutation, possibilityOfCrossingOver));
	}

	@SuppressWarnings("SameParameterValue")
	private static Holder<GeneLocus> registerLeft(String name, int index, double possibilityOfMutation, double possibilityOfCrossingOver) {
		return Services.PLATFORM.registerGeneLocus(new ResourceLocation(MODID, name), () -> GeneLocus.left(index, possibilityOfMutation, possibilityOfCrossingOver));
	}

	@SuppressWarnings("SameParameterValue")
	private static Holder<GeneLocus> registerRight(String name, int index, double possibilityOfMutation, double possibilityOfCrossingOver) {
		return Services.PLATFORM.registerGeneLocus(new ResourceLocation(MODID, name), () -> GeneLocus.right(index, possibilityOfMutation, possibilityOfCrossingOver));
	}

	public static void init() {
		// Lazy init
	}
}
