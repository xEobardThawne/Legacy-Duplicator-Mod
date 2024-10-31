package xreversef1ash.legacyduplicatormod.screens;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import xreversef1ash.legacyduplicatormod.LegacyDuplicatorMod;
import xreversef1ash.legacyduplicatormod.blocks.DuplicatorBlockRegistry;

public class ItemDuplicatorScreenHandler extends ScreenHandler {
    private final ScreenHandlerContext context;
    private final PlayerEntity player;
    private final SimpleInventory inventory = new SimpleInventory(3);

    public ItemDuplicatorScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }
    public ItemDuplicatorScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(ScreenDuplicatorRegistry.ITEM_DUPLICATION, syncId);
        this.context = context;
        this.player = playerInventory.player;


        this.addSlot(new Slot(inventory, 0, 44, 29));

        this.addSlot(new DuplicatorFuelSlot(inventory, 1, 80, 53));

        this.addSlot(new DuplicatorResultSlot(inventory, 2, 116, 29));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        if (id == 0) {
            return true;
        }
        return false;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public void onClosed(PlayerEntity player) {
        this.context.run(((world, blockPos) -> this.dropInventory(player, this.inventory)));
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return canUse(context, player, DuplicatorBlockRegistry.ITEM_DUPLICATOR_LVL_ONE);
    }
}
