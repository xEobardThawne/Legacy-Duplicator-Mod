package xreversef1ash.legacyduplicatormod.util;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import xreversef1ash.legacyduplicatormod.config.DuplicatorConfigData;

import java.util.ArrayList;

public class ItemDuplicatorItemList {

    public static void init(DuplicatorConfigData configData) {
        isWhitelist = configData.areItemDuplicatorsOnWhitelist;
        setItemList(convertIdsToItems(IdConversionUtil.convertStringsToIds(configData.itemDuplicatorItemList)));
    }

    private static boolean isWhitelist = false;

    private static final ArrayList<Item> itemList = new ArrayList<>();

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
