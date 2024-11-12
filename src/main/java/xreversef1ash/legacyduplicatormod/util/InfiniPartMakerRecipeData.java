package xreversef1ash.legacyduplicatormod.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import xreversef1ash.legacyduplicatormod.LegacyDuplicatorMod;
import xreversef1ash.legacyduplicatormod.config.DuplicatorConfigData;
import xreversef1ash.legacyduplicatormod.items.DuplicatorItemRegistry;

public class InfiniPartMakerRecipeData {

    private ItemStack slot0Data;
    private ItemStack slot1Data;
    private ItemStack slot2Data;

    @SuppressWarnings("ConstantValue")
    public void build(DuplicatorConfigData configData) {
        Identifier slot0id = Identifier.tryParse(configData.infiniduplicatorStickPartSlotOneItem);
        Item slot0Item = Registries.ITEM.get(slot0id);
        if (slot0Item == null || slot0Item == Items.AIR) {
            slot0Data = new ItemStack(DuplicatorItemRegistry.UNDUPLICATABLE_ITEM_ONE, Math.clamp(configData.infiniduplicatorStickPartSlotOneCount, 1, 99));
        } else {
            slot0Data = new ItemStack(slot0Item, Math.clamp(configData.infiniduplicatorStickPartSlotOneCount, 1, 99));
        }


        Identifier slot1id = Identifier.tryParse(configData.infiniduplicatorStickPartSlotTwoItem);
        Item slot1Item = Registries.ITEM.get(slot1id);
        if (slot1Item == null || slot1Item == Items.AIR) {
            slot1Data = new ItemStack(DuplicatorItemRegistry.UNDUPLICATABLE_ITEM_TWO, Math.clamp(configData.infiniduplicatorStickPartSlotTwoCount, 1, 99));
        } else {
            slot1Data = new ItemStack(slot1Item, Math.clamp(configData.infiniduplicatorStickPartSlotTwoCount, 1, 99));
        }


        Identifier slot2id = Identifier.tryParse(configData.infiniduplicatorStickPartSlotThreeItem);
        Item slot2Item = Registries.ITEM.get(slot2id);
        if (slot2Item == null || slot2Item == Items.AIR) {
            slot2Data = new ItemStack(Items.STICKY_PISTON, Math.clamp(configData.infiniduplicatorStickPartSlotThreeCount, 1, 99));
        } else {
            slot2Data = new ItemStack(slot2Item, Math.clamp(configData.infiniduplicatorStickPartSlotThreeCount, 1, 99));
        }
    }

    public ItemStack getSlotData(int slot) {
        return switch (slot) {
            case 1 -> slot1Data;
            case 2 -> slot2Data;
            default -> slot0Data;
        };
    }
}
