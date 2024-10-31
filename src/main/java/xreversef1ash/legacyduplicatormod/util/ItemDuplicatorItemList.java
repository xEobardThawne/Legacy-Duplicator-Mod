package xreversef1ash.legacyduplicatormod.util;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import xreversef1ash.legacyduplicatormod.blocks.DuplicatorBlockRegistry;
import xreversef1ash.legacyduplicatormod.items.DuplicatorItemRegistry;

import java.util.ArrayList;
import java.util.List;

public class ItemDuplicatorItemList {

    private static boolean isWhitelist = false;

    private static final ArrayList<Item> itemList = new ArrayList<>(
            List.of(
                    DuplicatorBlockRegistry.BASIC_DUPLICATOR.asItem(),
                    DuplicatorBlockRegistry.ITEM_DUPLICATOR_LVL_ONE.asItem(),
                    DuplicatorBlockRegistry.ITEM_DUPLICATOR_LVL_TWO.asItem(),
                    DuplicatorBlockRegistry.ITEM_DUPLICATOR_LVL_THREE.asItem(),
                    DuplicatorBlockRegistry.ITEM_DUPLICATOR_LVL_FOUR.asItem(),
                    DuplicatorItemRegistry.DUPLICATOR_STICK,
                    DuplicatorItemRegistry.INFINIDUPLICATOR_STICK
            )
    );

    public static boolean isItemDuplicatorOnWhitelist() {
        return isWhitelist;
    }

    public static ArrayList<Item> getItemList() {
        return itemList;
    }

    public static boolean isItemInItemList(Item item) {
        return itemList.contains(item);
    }

    public static void setItemList(ArrayList<Item> list) {
        itemList.clear();
        itemList.addAll(list);
    }

    public static ArrayList<Item> convertIdsToItems(ArrayList<Identifier> list) {
        ArrayList<Item> items = new ArrayList<>();
        for (Identifier id : list) {
            Item item = Registries.ITEM.get(id);
            items.add(item);
        }
        return items;
    }
}
