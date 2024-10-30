package xreversef1ash.legacyduplicatormod.screens;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import xreversef1ash.legacyduplicatormod.LegacyDuplicatorMod;

public class ScreenDuplicatorRegistry {
    public static final ScreenHandlerType<ItemDuplicatorScreenHandler> ITEM_DUPLICATION =
            Registry.register(
                    Registries.SCREEN_HANDLER,
                    Identifier.of(LegacyDuplicatorMod.MOD_ID, "item_duplication"),
                    new ScreenHandlerType<>(ItemDuplicatorScreenHandler::new, FeatureFlags.VANILLA_FEATURES));

    public static void init() {}
}
