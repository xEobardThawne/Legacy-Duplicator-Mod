package xreversef1ash.legacyduplicatormod.util;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import xreversef1ash.legacyduplicatormod.blocks.DuplicatorBlockRegistry;

import java.util.ArrayList;
import java.util.List;

public class BasicDuplicatorBlockList {

    private static boolean isWhitelist = false;
    private static final ArrayList<Block> Blocklist = new ArrayList<>(
            List.of(
                    DuplicatorBlockRegistry.BASIC_DUPLICATOR,
                    DuplicatorBlockRegistry.ITEM_DUPLICATOR_LVL_ONE,
                    DuplicatorBlockRegistry.ITEM_DUPLICATOR_LVL_TWO,
                    DuplicatorBlockRegistry.ITEM_DUPLICATOR_LVL_THREE,
                    DuplicatorBlockRegistry.ITEM_DUPLICATOR_LVL_FOUR,
                    Blocks.NETHERITE_BLOCK,
                    Blocks.DIAMOND_BLOCK,
                    Blocks.EMERALD_BLOCK,
                    Blocks.GOLD_BLOCK,
                    Blocks.LAPIS_BLOCK
            )
    );

    public static boolean isBasicDuplicatorOnWhitelist() {
        return isWhitelist;
    }

    public static ArrayList<Block> getBlocklist() {
        return Blocklist;
    }

    public static boolean isBlockInBlocklist(Block block) {
        return Blocklist.contains(block);
    }

    public static void setBlocklist(ArrayList<Block> list) {
        Blocklist.clear();
        Blocklist.addAll(list);
    }

    public static ArrayList<Block> convertIdsToBlocks(ArrayList<Identifier> list) {
        ArrayList<Block> blocks = new ArrayList<>();
        for (Identifier id : list) {
            Block block = Registries.BLOCK.get(id);
            blocks.add(block);
        }
        return blocks;
    }
}
