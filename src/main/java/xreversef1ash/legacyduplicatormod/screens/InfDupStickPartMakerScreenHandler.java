package xreversef1ash.legacyduplicatormod.screens;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import xreversef1ash.legacyduplicatormod.blocks.DuplicatorBlockRegistry;
import xreversef1ash.legacyduplicatormod.items.DuplicatorItemRegistry;

public class InfDupStickPartMakerScreenHandler extends ScreenHandler {

    private final ScreenHandlerContext context;
    private final PlayerEntity player;
    private final SimpleInventory inventory = new SimpleInventory(4);

    public InfDupStickPartMakerScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }
    public InfDupStickPartMakerScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(ScreenDuplicatorRegistry.INFDUP_STICK_MAKING, syncId);
        this.context = context;
        this.player = playerInventory.player;

        this.addSlot(new FilteredInputSlot(inventory, 0, 17, 43, DuplicatorItemRegistry.UNDUPLICATABLE_ITEM_ONE));
        this.addSlot(new FilteredInputSlot(inventory, 1, 53, 43, DuplicatorItemRegistry.UNDUPLICATABLE_ITEM_TWO));
        this.addSlot(new FilteredInputSlot(inventory, 2, 89, 43, Items.STICKY_PISTON));

        this.addSlot(new DuplicatorResultSlot(inventory, 3, 143, 43));

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
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public void onClosed(PlayerEntity player) {
        this.context.run(((world, blockPos) -> this.dropInventory(player, this.inventory)));
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return canUse(context, player, DuplicatorBlockRegistry.INFINIDUPLICATOR_STICK_PART_MAKER);
    }
}
