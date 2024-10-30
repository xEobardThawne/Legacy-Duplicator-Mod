package xreversef1ash.legacyduplicatormod.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import xreversef1ash.legacyduplicatormod.LegacyDuplicatorMod;

public class DuplicatorBlockRegistry {
    public static Block register(Block block, String name) {
        Identifier id = Identifier.of(LegacyDuplicatorMod.MOD_ID, name);

        BlockItem blockItem = new BlockItem(block, new Item.Settings());
        Registry.register(Registries.ITEM, id, blockItem);

        return Registry.register(Registries.BLOCK, id, block);
    }

    public static void init() {}


    public static final Block BASIC_DUPLICATOR = register(
            new BasicDuplicatorBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).hardness(4.0f).requiresTool().resistance(15.0f)),
            "basic_duplicator"
    );
    public static final Block ITEM_DUPLICATOR_LVL_ONE = register(
            new ItemDuplicatorLevelOneBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).hardness(5.0f).requiresTool().resistance(20.0f)),
            "item_duplicator_lvl_one"
    );
    public static final Block ITEM_DUPLICATOR_LVL_TWO = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).hardness(5.0f).requiresTool().resistance(20.0f)),
            "item_duplicator_lvl_two"
    );
    public static final Block ITEM_DUPLICATOR_LVL_THREE = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).hardness(5.0f).requiresTool().resistance(20.0f)),
            "item_duplicator_lvl_three"
    );
    public static final Block ITEM_DUPLICATOR_LVL_FOUR = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).hardness(5.0f).requiresTool().resistance(20.0f)),
            "item_duplicator_lvl_four"
    );

    public static final Block INFINIDUPLICATOR_STICK_PART_MAKER = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).hardness(8.0f).requiresTool().resistance(50.0f)),
            "infiniduplicator_stick_part_maker"
    );

}
