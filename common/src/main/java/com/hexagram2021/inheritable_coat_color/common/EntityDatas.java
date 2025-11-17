package com.hexagram2021.inheritable_coat_color.common;

import net.minecraft.network.syncher.EntityDataAccessor;

@SuppressWarnings({"NotNullFieldNotInitialized", "java:S1104", "java:S1444", "java:S3008"})
public class EntityDatas {
	public static EntityDataAccessor<Boolean> LONG_HAIR;

	private EntityDatas() {
	}

	static {
		try {
			EntityDatas.class.getClassLoader().loadClass("net.minecraft.world.entity.animal.Sheep");
		} catch (ClassNotFoundException ignored) {
			// Where is minecraft?
		}
	}
}
