package xreversef1ash.legacyduplicatormod.config;

import net.minecraft.util.Identifier;
import xreversef1ash.legacyduplicatormod.LegacyDuplicatorMod;

import java.util.ArrayList;
import java.util.List;

public class DuplicatorConfigData {
    public int configVersion = 1;
    public boolean isBasicDuplicatorOnWhitelist = false;
    public ArrayList<String> basicDuplicatorBlockList = new ArrayList<>(
            List.of(
                    Identifier.of(LegacyDuplicatorMod.MOD_ID, "basic_duplicator").toString(),
                    Identifier.of(LegacyDuplicatorMod.MOD_ID, "item_duplicator_lvl_one").toString(),
                    Identifier.of(LegacyDuplicatorMod.MOD_ID, "item_duplicator_lvl_two").toString(),
                    Identifier.of(LegacyDuplicatorMod.MOD_ID, "item_duplicator_lvl_three").toString(),
                    Identifier.of(LegacyDuplicatorMod.MOD_ID, "item_duplicator_lvl_four").toString(),
                    "minecraft:netherite_block",
                    "minecraft:diamond_block",
                    "minecraft:emerald_block",
                    "minecraft:gold_block",
                    "minecraft:lapis_block"
            )
    );
    public boolean areItemDuplicatorsOnWhitelist = false;
    public ArrayList<String> itemDuplicatorItemList = new ArrayList<>(
            List.of(
                    Identifier.of(LegacyDuplicatorMod.MOD_ID, "basic_duplicator").toString(),
                    Identifier.of(LegacyDuplicatorMod.MOD_ID, "item_duplicator_lvl_one").toString(),
                    Identifier.of(LegacyDuplicatorMod.MOD_ID, "item_duplicator_lvl_two").toString(),
                    Identifier.of(LegacyDuplicatorMod.MOD_ID, "item_duplicator_lvl_three").toString(),
                    Identifier.of(LegacyDuplicatorMod.MOD_ID, "item_duplicator_lvl_four").toString(),
                    Identifier.of(LegacyDuplicatorMod.MOD_ID, "duplicator_stick").toString(),
                    Identifier.of(LegacyDuplicatorMod.MOD_ID, "infiniduplicator_stick").toString(),
                    Identifier.of(LegacyDuplicatorMod.MOD_ID, "infiniduplicator_stick_part").toString(),
                    Identifier.of(LegacyDuplicatorMod.MOD_ID, "unduplicatable_item_one").toString(),
                    Identifier.of(LegacyDuplicatorMod.MOD_ID, "unduplicatable_item_two").toString(),
                    "minecraft:shulker_box",
                    "minecraft:white_shulker_box",
                    "minecraft:orange_shulker_box",
                    "minecraft:magenta_shulker_box",
                    "minecraft:light_blue_shulker_box",
                    "minecraft:yellow_shulker_box",
                    "minecraft:lime_shulker_box",
                    "minecraft:pink_shulker_box",
                    "minecraft:gray_shulker_box",
                    "minecraft:light_gray_shulker_box",
                    "minecraft:cyan_shulker_box",
                    "minecraft:purple_shulker_box",
                    "minecraft:blue_shulker_box",
                    "minecraft:brown_shulker_box",
                    "minecraft:green_shulker_box",
                    "minecraft:red_shulker_box",
                    "minecraft:black_shulker_box",
                    "minecraft:bundle"
            )
    );
    public String infiniduplicatorStickPartSlotOneItem = Identifier.of(LegacyDuplicatorMod.MOD_ID, "unduplicatable_item_one").toString();
    public int infiniduplicatorStickPartSlotOneCount = 10;
    public String infiniduplicatorStickPartSlotTwoItem = Identifier.of(LegacyDuplicatorMod.MOD_ID, "unduplicatable_item_two").toString();
    public int infiniduplicatorStickPartSlotTwoCount = 4;
    public String infiniduplicatorStickPartSlotThreeItem = "minecraft:sticky_piston";
    public int infiniduplicatorStickPartSlotThreeCount = 5;
}
