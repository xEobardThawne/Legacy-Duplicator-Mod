package xreversef1ash.legacyduplicatormod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import xreversef1ash.legacyduplicatormod.screens.ItemDuplicatorScreenHandler;

public class ItemDuplicatorBlock extends Block {
    private final Text blockName;
    private final int blockLevel;
    public ItemDuplicatorBlock(Settings settings, Text name, int blockLevel) {
        super(settings);
        this.blockName = name;
        this.blockLevel = blockLevel;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient()) {
            return ActionResult.SUCCESS;
        } else {
            player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
            return ActionResult.CONSUME;
        }
    }

    @Nullable
    @Override
    protected NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory(
                ((syncId, playerInventory, player) -> new ItemDuplicatorScreenHandler(syncId, playerInventory, ScreenHandlerContext.create(world, pos), blockLevel)), blockName
        );
    }
}
