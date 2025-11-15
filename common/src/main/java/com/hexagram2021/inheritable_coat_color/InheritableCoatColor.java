package com.hexagram2021.inheritable_coat_color;

import com.hexagram2021.inheritable_coat_color.registry.ICCGeneLoci;
import com.hexagram2021.inheritable_coat_color.registry.ICCGenes;
import com.hexagram2021.inheritable_coat_color.registry.ICCTraitTypes;
import com.hexagram2021.inheritable_coat_color.registry.ICCTraits;

public class InheritableCoatColor {
	public static final String MODID = "inheritable_coat_color";

	private InheritableCoatColor() {
	}

	public static void modConstruct() {
		ICCGenes.init();
		ICCGeneLoci.init();
		ICCTraitTypes.init();
		ICCTraits.init();
	}
}
