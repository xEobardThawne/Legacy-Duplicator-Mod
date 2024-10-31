package xreversef1ash.legacyduplicatormod.screens;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Identifier;
import xreversef1ash.legacyduplicatormod.LegacyDuplicatorMod;

public class DuplicatorFuelSlot extends Slot {
    public DuplicatorFuelSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.isIn(TagKey.of(RegistryKeys.ITEM, Identifier.of(LegacyDuplicatorMod.MOD_ID, "duplicator_fuel")));
    }
}
