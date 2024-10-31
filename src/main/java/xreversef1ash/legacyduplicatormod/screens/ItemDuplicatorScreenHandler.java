package xreversef1ash.legacyduplicatormod.screens;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import xreversef1ash.legacyduplicatormod.LegacyDuplicatorMod;
import xreversef1ash.legacyduplicatormod.blocks.DuplicatorBlockRegistry;
import xreversef1ash.legacyduplicatormod.util.ItemDuplicatorItemList;

public class ItemDuplicatorScreenHandler extends ScreenHandler {
    private final ScreenHandlerContext context;
    private final PlayerEntity player;
    private final int duplicatorLevel;
    @Nullable
    private Block block;
    private final SimpleInventory inventory = new SimpleInventory(3);

    public ItemDuplicatorScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY, 0);
    }
    public ItemDuplicatorScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context, int duplicatorLevel) {
        super(ScreenDuplicatorRegistry.ITEM_DUPLICATION, syncId);
        this.context = context;
        this.player = playerInventory.player;
        this.duplicatorLevel = duplicatorLevel;
        context.run((world, blockPos) -> this.block = world.getBlockState(blockPos).getBlock());


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
        if (id == 1) {
            ItemStack duplicatee = this.inventory.getStack(0);
            ItemStack fuel = this.inventory.getStack(1);
            ItemStack product = this.inventory.getStack(2);
            if (!duplicatee.isEmpty() && !fuel.isEmpty() && product.isEmpty()) {
                if (fuel.isIn(TagKey.of(RegistryKeys.ITEM, Identifier.of(LegacyDuplicatorMod.MOD_ID, "duplicator_fuel")))) {
                    if (ItemDuplicatorItemList.isItemDuplicatorOnWhitelist() && !ItemDuplicatorItemList.isItemInItemList(duplicatee.getItem())) {
                        return false;
                    }
                    if (!ItemDuplicatorItemList.isItemDuplicatorOnWhitelist() && ItemDuplicatorItemList.isItemInItemList(duplicatee.getItem())) {
                        return false;
                    }
                    this.context.run((world, blockPos) -> {
                        if (!fuel.isIn(TagKey.of(RegistryKeys.ITEM, Identifier.of(LegacyDuplicatorMod.MOD_ID, "infinite_duplicator_fuel")))) {
                            fuel.decrement(1);
                            if (fuel.isEmpty()) {
                                this.inventory.setStack(1, ItemStack.EMPTY);
                            }
                        }
                        ItemStack duplicatedStack = duplicatee.copyWithCount(Math.min(duplicatee.getCount(), 4));
                        this.inventory.setStack(2, duplicatedStack);

                        this.inventory.markDirty();
                        this.sendContentUpdates();
                        world.playSound(null, blockPos, SoundEvents.BLOCK_BELL_RESONATE, SoundCategory.BLOCKS, 1.0F, 1.0F);
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
        return canUse(context, player, this.block);
    }
}
