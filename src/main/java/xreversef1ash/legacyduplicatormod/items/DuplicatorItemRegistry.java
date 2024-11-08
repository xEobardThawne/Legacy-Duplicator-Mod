package xreversef1ash.legacyduplicatormod.items;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import xreversef1ash.legacyduplicatormod.LegacyDuplicatorMod;

public class DuplicatorItemRegistry {
    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(LegacyDuplicatorMod.MOD_ID, id);

        return Registry.register(Registries.ITEM, itemID, item);
    }

    public static void init() {}

    public static final Item DUPLICATOR_STICK = register(
            new Item(new Item.Settings().rarity(Rarity.RARE)),
            "duplicator_stick"
    );
    public static final Item INFINIDUPLICATOR_STICK = register(
            new Item(new Item.Settings().rarity(Rarity.EPIC).maxCount(1)),
            "infiniduplicator_stick"
    );

    public static final Item INFINIDUPLICATOR_STICK_PART = register(
            new Item(new Item.Settings().rarity(Rarity.EPIC).maxCount(16)),
            "infiniduplicator_stick_part"
    );

    public static final Item UNDUPLICATABLE_ITEM_ONE = register(
            new Item(new Item.Settings().rarity(Rarity.RARE)),
            "unduplicatable_item_one"
    );

    public static final Item UNDUPLICATABLE_ITEM_TWO = register(
            new Item(new Item.Settings().rarity(Rarity.RARE)),
            "unduplicatable_item_two"
    );
}
