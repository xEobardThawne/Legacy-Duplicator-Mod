package xreversef1ash.legacyduplicatormod;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import xreversef1ash.legacyduplicatormod.screens.ItemDuplicatorHandledScreen;
import xreversef1ash.legacyduplicatormod.screens.ScreenDuplicatorRegistry;

public class LegacyDuplicatorModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.

		HandledScreens.register(ScreenDuplicatorRegistry.ITEM_DUPLICATION, ItemDuplicatorHandledScreen::new);
	}
}