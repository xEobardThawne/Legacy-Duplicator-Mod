package xreversef1ash.legacyduplicatormod.util;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import xreversef1ash.legacyduplicatormod.config.DuplicatorConfigData;

import java.util.ArrayList;

public class BasicDuplicatorBlockList {

    public static void init(DuplicatorConfigData configData) {
        isWhitelist = configData.isBasicDuplicatorOnWhitelist;
        setBlocklist(convertIdsToBlocks(IdConversionUtil.convertStringsToIds(configData.basicDuplicatorBlockList)));
    }

    private static boolean isWhitelist = false;
    private static final ArrayList<Block> Blocklist = new ArrayList<>();

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
