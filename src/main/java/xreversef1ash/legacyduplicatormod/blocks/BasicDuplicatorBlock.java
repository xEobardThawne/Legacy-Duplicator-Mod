package xreversef1ash.legacyduplicatormod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BasicDuplicatorBlock extends Block {
    public BasicDuplicatorBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        BlockState blockBelow = world.getBlockState(pos.down());
        BlockState blockAbove = world.getBlockState(pos.up());
        ItemStack heldItem = player.getMainHandStack();

        if (
                player.getAbilities().allowModifyWorld &&
                        blockBelow.isAir() &&
                        !blockAbove.isAir() &&
                        (heldItem.isIn(TagKey.of(RegistryKeys.ITEM, Identifier.of("legacyduplicatormod", "duplicator_fuel"))))
        ) {
            if (!heldItem.isIn(TagKey.of(RegistryKeys.ITEM, Identifier.of("legacyduplicatormod", "infinite_duplicator_fuel")))) {
                player.getMainHandStack().decrement(1);
            }
            world.setBlockState(pos.down(), blockAbove);

            return ActionResult.SUCCESS;
        }
            else {
            return ActionResult.PASS;
        }
    }
}
