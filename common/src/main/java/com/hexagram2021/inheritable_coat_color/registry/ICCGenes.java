package com.hexagram2021.inheritable_coat_color.registry;

import com.hexagram2021.chromosomelib.common.gene.Gene;
import com.hexagram2021.chromosomelib.platform.Services;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;

import java.util.Locale;

import static com.hexagram2021.chromosomelib.ChromosomeLib.MODID;

public final class ICCGenes {
	/**
	 * 黑色素酶生产基因，显性；位于 1 号染色体上
	 */
	public static final Holder<Gene> MELANIN_D = register("MELANIN_D");
	/**
	 * 黑色素酶隐性基因；位于 1 号染色体上
	 */
	public static final Holder<Gene> MELANIN_R = register("MELANIN_R");
	/**
	 * 黄色素酶生产基因，显性；位于 X 性染色体非同源区段上
	 */
	public static final Holder<Gene> URANIDIN_D = register("URANIDIN_D");
	/**
	 * 黄色素酶隐性基因；位于 X 性染色体非同源区段上
	 */
	public static final Holder<Gene> URANIDIN_R = register("URANIDIN_R");
	/**
	 * 黑色素代谢酶基因，使得黑色素被淡化时，品红色和绿色色素更容易附着，显性；位于 6 号染色体上
	 */
	public static final Holder<Gene> MELANIN_METABOLIC_D = register("MELANIN_METABOLIC_D");
	/**
	 * 黑色素代谢酶隐性基因；位于 6 号染色体上
	 */
	public static final Holder<Gene> MELANIN_METABOLIC_R = register("MELANIN_METABOLIC_R");
	/**
	 * 毛色淡化基因，黑->灰->淡灰，棕->红->黄，橙->蓝->青，不完全显性；位于 7 号染色体上
	 */
	public static final Holder<Gene> DILUTION_ID = register("DILUTION_ID");
	/**
	 * 毛色淡化基因，隐性；位于 7 号染色体上
	 */
	public static final Holder<Gene> DILUTION_R = register("DILUTION_R");
	/**
	 * 非粉红色基因，显性；位于 1 号染色体上
	 */
	public static final Holder<Gene> NONE_PINK_D = register("NONE_PINK_D");
	/**
	 * 粉红色突变基因，无其它色素时生效，隐性；位于 1 号染色体上
	 */
	public static final Holder<Gene> PINK_R = register("PINK_R");
	/**
	 * 品红色素基因，仅在黑色素淡化且可被代谢或无黑色素时生效，共显性；位于 20 号染色体上
	 * <p>品红+绿=黄绿</p>
	 * <p>品红+灰/淡灰/红=品红</p>
	 * <p>品红+蓝/黄=紫</p>
	 * <p>品红+青=淡蓝</p>
	 */
	public static final Holder<Gene> MAGENTA_D = register("MAGENTA_D");
	/**
	 * 绿色素基因，仅在黑色素淡化且可被代谢或无黑色素时生效，共显性；位于 20 号染色体上
	 * <p>绿+品红/黄=黄绿</p>
	 * <p>绿+红=黄</p>
	 * <p>绿+灰/淡灰=绿</p>
	 * <p>绿+蓝=蓝</p>
	 * <p>绿+青=黄绿</p>
	 */
	public static final Holder<Gene> GREEN_D = register("GREEN_D");
	/**
	 * 无特殊色素，隐性；位于 20 号染色体上
	 */
	public static final Holder<Gene> NORMAL_COLOR_R = register("NORMAL_COLOR_R");

	/**
	 * 雄性 SRY 基因；位于 Y 性染色体非同源区段上
	 */
	public static final Holder<Gene> SRY = register("SRY");

	private ICCGenes() {
	}

	private static Holder<Gene> register(String code) {
		return Services.PLATFORM.registerGene(new ResourceLocation(MODID, code.toLowerCase(Locale.ROOT)), () -> new Gene(code));
	}

	public static void init() {
		// Lazy init
	}
}
