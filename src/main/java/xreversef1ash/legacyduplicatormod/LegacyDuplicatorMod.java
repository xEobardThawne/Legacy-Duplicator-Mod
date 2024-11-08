package xreversef1ash.legacyduplicatormod;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xreversef1ash.legacyduplicatormod.blocks.DuplicatorBlockRegistry;
import xreversef1ash.legacyduplicatormod.items.DuplicatorItemRegistry;
import xreversef1ash.legacyduplicatormod.screens.ScreenDuplicatorRegistry;

public class LegacyDuplicatorMod implements ModInitializer {
	public static final String MOD_ID = "legacyduplicatormod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		DuplicatorBlockRegistry.init();
		DuplicatorItemRegistry.init();
		DuplicatorTab.createTab();
		ScreenDuplicatorRegistry.init();


		LOGGER.info("Loaded Legacy Duplicator Mod");
	}
}