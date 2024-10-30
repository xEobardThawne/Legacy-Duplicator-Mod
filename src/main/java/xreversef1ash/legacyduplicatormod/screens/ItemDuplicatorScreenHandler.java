package xreversef1ash.legacyduplicatormod.screens;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
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
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
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
