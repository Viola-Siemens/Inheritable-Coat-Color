package com.hexagram2021.inheritable_coat_color.registry;

import com.hexagram2021.chromosomelib.common.chromosome.BuiltInChromosomes;
import com.hexagram2021.chromosomelib.common.trait.TraitHandler;
import com.hexagram2021.chromosomelib.registry.RegistryRelations;
import com.hexagram2021.chromosomelib.registry.StableWeightedGeneList;
import net.minecraft.world.entity.EntityType;

public final class ICCRelations {
	private ICCRelations() {
	}

	@SuppressWarnings("java:S3776")
	public static void init() {
		// ---- Start: Register Chromosome to Gene Locus Relations ----
		RegistryRelations.registerChromosome2GeneLocus(BuiltInChromosomes.Sheep.SHEEP_1, ICCGeneLoci.MELANIN_ENZYME);
		RegistryRelations.registerChromosome2GeneLocus(BuiltInChromosomes.Sheep.SHEEP_XY, ICCGeneLoci.URANIDIN_ENZYME);
		RegistryRelations.registerChromosome2GeneLocus(BuiltInChromosomes.Sheep.SHEEP_6, ICCGeneLoci.MELANIN_METABOLIC_ENZYME);
		RegistryRelations.registerChromosome2GeneLocus(BuiltInChromosomes.Sheep.SHEEP_7, ICCGeneLoci.DILUTION);
		RegistryRelations.registerChromosome2GeneLocus(BuiltInChromosomes.Sheep.SHEEP_1, ICCGeneLoci.PINK);
		RegistryRelations.registerChromosome2GeneLocus(BuiltInChromosomes.Sheep.SHEEP_20, ICCGeneLoci.ABNORMAL);
		RegistryRelations.registerChromosome2GeneLocus(BuiltInChromosomes.Sheep.SHEEP_XY, ICCGeneLoci.SRY);
		// ---- End: Register Chromosome to Gene Locus Relations ----

		// ---- Start: Register Gene Locus to Gene Relations ----
		RegistryRelations.registerGeneLocus2Gene(ICCGeneLoci.MELANIN_ENZYME, ICCGenes.MELANIN_D);
		RegistryRelations.registerGeneLocus2Gene(ICCGeneLoci.MELANIN_ENZYME, ICCGenes.MELANIN_R);
		RegistryRelations.registerGeneLocus2Gene(ICCGeneLoci.URANIDIN_ENZYME, ICCGenes.URANIDIN_D);
		RegistryRelations.registerGeneLocus2Gene(ICCGeneLoci.URANIDIN_ENZYME, ICCGenes.URANIDIN_R);
		RegistryRelations.registerGeneLocus2Gene(ICCGeneLoci.MELANIN_METABOLIC_ENZYME, ICCGenes.MELANIN_METABOLIC_D);
		RegistryRelations.registerGeneLocus2Gene(ICCGeneLoci.MELANIN_METABOLIC_ENZYME, ICCGenes.MELANIN_METABOLIC_R);
		RegistryRelations.registerGeneLocus2Gene(ICCGeneLoci.DILUTION, ICCGenes.DILUTION_ID);
		RegistryRelations.registerGeneLocus2Gene(ICCGeneLoci.DILUTION, ICCGenes.DILUTION_R);
		RegistryRelations.registerGeneLocus2Gene(ICCGeneLoci.PINK, ICCGenes.NONE_PINK_D);
		RegistryRelations.registerGeneLocus2Gene(ICCGeneLoci.PINK, ICCGenes.PINK_R);
		RegistryRelations.registerGeneLocus2Gene(ICCGeneLoci.ABNORMAL, ICCGenes.MAGENTA_D);
		RegistryRelations.registerGeneLocus2Gene(ICCGeneLoci.ABNORMAL, ICCGenes.GREEN_D);
		RegistryRelations.registerGeneLocus2Gene(ICCGeneLoci.ABNORMAL, ICCGenes.NORMAL_COLOR_R);
		RegistryRelations.registerGeneLocus2Gene(ICCGeneLoci.SRY, ICCGenes.SRY);
		// ---- End: Register Gene Locus to Gene Relations ----

		// ---- Start: Register Disable Relations ----
		RegistryRelations.registerDisableRelation(ICCGenes.MELANIN_D, ICCGenes.MELANIN_R);
		RegistryRelations.registerDisableRelation(ICCGenes.URANIDIN_D, ICCGenes.URANIDIN_R);
		RegistryRelations.registerDisableRelation(ICCGenes.MELANIN_METABOLIC_D, ICCGenes.MELANIN_METABOLIC_R);
		RegistryRelations.registerDisableRelation(ICCGenes.NONE_PINK_D, ICCGenes.PINK_R);
		RegistryRelations.registerDisableRelation(ICCGenes.MAGENTA_D, ICCGenes.NORMAL_COLOR_R);
		RegistryRelations.registerDisableRelation(ICCGenes.GREEN_D, ICCGenes.NORMAL_COLOR_R);

		// Not expected, but we can test our code.
		// RegistryRelations.registerDisableRelation(ICCGenes.MELANIN_R, ICCGenes.NONE_PINK_D);
		// RegistryRelations.registerDisableRelation(ICCGenes.URANIDIN_R, ICCGenes.NONE_PINK_D);
		// ---- End: Register Disable Relations ----

		// ---- Start: Register Entity Type to Trait Type Relations ----
		RegistryRelations.registerEntityType2TraitType(EntityType.SHEEP, ICCTraitTypes.COLOR);
		// ---- End: Register Entity Type to Trait Type Relations ----

		// ---- Start: Register Gene Frequencies ----
		RegistryRelations.registerGeneFrequency(
				ICCGeneLoci.MELANIN_ENZYME,
				StableWeightedGeneList.stableBuilder()
						.add(ICCGenes.MELANIN_D, 1)
						.add(ICCGenes.MELANIN_R, 9)
		);
		RegistryRelations.registerGeneFrequency(
				ICCGeneLoci.URANIDIN_ENZYME,
				StableWeightedGeneList.stableBuilder()
						.add(ICCGenes.URANIDIN_D, 1)
						.add(ICCGenes.URANIDIN_R, 19)
		);
		RegistryRelations.registerGeneFrequency(
				ICCGeneLoci.MELANIN_METABOLIC_ENZYME,
				StableWeightedGeneList.stableBuilder()
						.add(ICCGenes.MELANIN_METABOLIC_D, 1)
						.add(ICCGenes.MELANIN_METABOLIC_R, 15)
		);
		RegistryRelations.registerGeneFrequency(
				ICCGeneLoci.DILUTION,
				StableWeightedGeneList.stableBuilder()
						.add(ICCGenes.DILUTION_ID, 1)
						.add(ICCGenes.DILUTION_R, 3)
		);
		RegistryRelations.registerGeneFrequency(
				ICCGeneLoci.PINK,
				StableWeightedGeneList.stableBuilder()
						.add(ICCGenes.NONE_PINK_D, 59)
						.add(ICCGenes.PINK_R, 1)
		);
		RegistryRelations.registerGeneFrequency(
				ICCGeneLoci.ABNORMAL,
				StableWeightedGeneList.stableBuilder()
						.add(ICCGenes.MAGENTA_D, 3)
						.add(ICCGenes.GREEN_D, 2)
						.add(ICCGenes.NORMAL_COLOR_R, 95)
		);
		RegistryRelations.registerGeneFrequency(
				ICCGeneLoci.SRY,
				StableWeightedGeneList.stableBuilder().add(ICCGenes.SRY, 1)
		);
		// ---- End: Register Gene Frequencies ----

		// ---- Start: Register Trait Handlers ----
		TraitHandler.registerHandler(ICCTraitTypes.COLOR, hasActiveGene -> {
			int melanin = hasActiveGene.applyAsInt(ICCGenes.MELANIN_D);
			int uranidin = hasActiveGene.applyAsInt(ICCGenes.URANIDIN_D);
			int dilution = hasActiveGene.applyAsInt(ICCGenes.DILUTION_ID);
			int melaninMetabolic = hasActiveGene.applyAsInt(ICCGenes.MELANIN_METABOLIC_D);
			int magenta = hasActiveGene.applyAsInt(ICCGenes.MAGENTA_D);
			int green = hasActiveGene.applyAsInt(ICCGenes.GREEN_D);
			int pink = hasActiveGene.applyAsInt(ICCGenes.PINK_R);
			if(melanin > 0) {
				if(uranidin > 0) {
					// 黑 + 橙 = 棕色底色
					if(dilution == 0) {
						return ICCTraits.BROWN;
					}
					if(melaninMetabolic == 0) {
						if(dilution == 1) {
							return ICCTraits.RED;
						}
						return ICCTraits.YELLOW;
					}
					if(magenta > 0) {
						if(green > 0) {
							return ICCTraits.LIME;
						}
						if(dilution == 1) {
							return ICCTraits.MAGENTA;
						}
						return ICCTraits.PURPLE;
					}
					if(green > 0) {
						if(dilution == 1) {
							return ICCTraits.YELLOW;
						}
						return ICCTraits.GREEN;
					}
					if(dilution == 1) {
						return ICCTraits.RED;
					}
					return ICCTraits.YELLOW;
				}
				// 黑色底色
				if(dilution == 0) {
					return ICCTraits.BLACK;
				}
				if(melaninMetabolic == 0) {
					if(dilution == 1) {
						return ICCTraits.GRAY;
					}
					return ICCTraits.LIGHT_GRAY;
				}
				if(magenta > 0) {
					if(green > 0) {
						return ICCTraits.LIME;
					}
					return ICCTraits.MAGENTA;
				}
				if(green > 0) {
					if(dilution == 1) {
						return ICCTraits.YELLOW;
					}
					return ICCTraits.GREEN;
				}
				if(dilution == 1) {
					return ICCTraits.GRAY;
				}
				return ICCTraits.LIGHT_GRAY;
			}
			if(uranidin > 0) {
				// 橙色底色
				if(dilution == 0) {
					return ICCTraits.ORANGE;
				}
				if(magenta > 0) {
					if(green > 0) {
						return ICCTraits.LIME;
					}
					if(dilution == 1) {
						return ICCTraits.PURPLE;
					}
					return ICCTraits.LIGHT_BLUE;
				}
				if(green > 0) {
					if(dilution == 1) {
						return ICCTraits.BLUE;
					}
					return ICCTraits.LIME;
				}
				if(dilution == 1) {
					return ICCTraits.BLUE;
				}
				return ICCTraits.CYAN;
			}
			//白色底色
			if(magenta > 0) {
				if(green > 0) {
					return ICCTraits.LIME;
				}
				return ICCTraits.MAGENTA;
			}
			if(green > 0) {
				return ICCTraits.GREEN;
			}
			if(pink > 0) {
				return ICCTraits.PINK;
			}
			return ICCTraits.WHITE;
		});
		// ---- End: Register Trait Handlers ----
	}
}
