package xreversef1ash.legacyduplicatormod.screens;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import xreversef1ash.legacyduplicatormod.LegacyDuplicatorMod;

public class ScreenDuplicatorRegistry {
    public static final ScreenHandlerType<ItemDuplicatorScreenHandler> ITEM_DUPLICATION =
            Registry.register(
                    Registries.SCREEN_HANDLER,
                    Identifier.of(LegacyDuplicatorMod.MOD_ID, "item_duplication"),
                    new ScreenHandlerType<>(ItemDuplicatorScreenHandler::new, FeatureSet.empty()));
    public static final ScreenHandlerType<InfDupStickPartMakerScreenHandler> INFDUP_STICK_MAKING =
            Registry.register(
                    Registries.SCREEN_HANDLER,
                    Identifier.of(LegacyDuplicatorMod.MOD_ID, "infiniduplicator_stick_part_making"),
                    new ScreenHandlerType<>(InfDupStickPartMakerScreenHandler::new, FeatureSet.empty()));

    public static void init() {}
}
