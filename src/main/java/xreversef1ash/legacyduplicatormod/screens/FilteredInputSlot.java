package xreversef1ash.legacyduplicatormod.screens;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class FilteredInputSlot extends Slot {
    private final Item allowedItem;

    public FilteredInputSlot(Inventory inventory, int index, int x, int y, Item allowedItem) {
        super(inventory, index, x, y);
        this.allowedItem = allowedItem;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.getItem() == allowedItem;
    }
}
