package xreversef1ash.legacyduplicatormod.screens;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
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
    public boolean onButtonClick(PlayerEntity player, int id) {
        if (id == 1) {
            ItemStack slot0 = this.inventory.getStack(0);
            ItemStack slot1 = this.inventory.getStack(1);
            ItemStack slot2 = this.inventory.getStack(2);
            ItemStack slot3 = this.inventory.getStack(3);
            if (!slot0.isEmpty() && !slot1.isEmpty() && !slot2.isEmpty()) {
                if (slot3.isEmpty() || (slot3.isOf(DuplicatorItemRegistry.INFINIDUPLICATOR_STICK_PART) && slot3.getCount() < slot3.getMaxCount())) {
                    if (
                            (slot0.isOf(DuplicatorItemRegistry.UNDUPLICATABLE_ITEM_ONE) && slot0.getCount() >= 10) &&
                                    (slot1.isOf(DuplicatorItemRegistry.UNDUPLICATABLE_ITEM_TWO) && slot1.getCount() >= 4) &&
                                    (slot2.isOf(Items.STICKY_PISTON) && slot2.getCount() >= 5)
                    ) {
                        this.context.run((world, blockPos) -> {
                            slot0.decrement(10);
                            if (slot0.isEmpty()) {
                                this.inventory.setStack(0, ItemStack.EMPTY);
                            }
                            slot1.decrement(4);
                            if (slot1.isEmpty()) {
                                this.inventory.setStack(1, ItemStack.EMPTY);
                            }
                            slot2.decrement(5);
                            if (slot2.isEmpty()) {
                                this.inventory.setStack(2, ItemStack.EMPTY);
                            }

                            if (slot3.isEmpty()) {
                                this.inventory.setStack(3, new ItemStack(DuplicatorItemRegistry.INFINIDUPLICATOR_STICK_PART, 1));
                            } else {
                                slot3.increment(1);
                            }

                            this.inventory.markDirty();
                            this.sendContentUpdates();
                            world.playSound(null, blockPos, SoundEvents.ENTITY_EVOKER_PREPARE_SUMMON, SoundCategory.BLOCKS, 2.0F, 1.0F);
                        });
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
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
