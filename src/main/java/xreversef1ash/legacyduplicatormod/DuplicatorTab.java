package xreversef1ash.legacyduplicatormod;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xreversef1ash.legacyduplicatormod.blocks.DuplicatorBlockRegistry;
import xreversef1ash.legacyduplicatormod.items.DuplicatorItemRegistry;

public class DuplicatorTab {

    public static final RegistryKey<ItemGroup> DUPLICATOR_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(LegacyDuplicatorMod.MOD_ID, "duplicator_item_group"));

    public static final ItemGroup DUPLICATOR_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(DuplicatorBlockRegistry.BASIC_DUPLICATOR.asItem()))
            .displayName(Text.translatable("itemGroup.duplicatorTab"))
            .build();

    public static void createTab() {
        Registry.register(Registries.ITEM_GROUP, DUPLICATOR_ITEM_GROUP_KEY, DUPLICATOR_TAB);

        ItemGroupEvents.modifyEntriesEvent(DUPLICATOR_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(DuplicatorBlockRegistry.BASIC_DUPLICATOR.asItem());
            itemGroup.add(DuplicatorBlockRegistry.ITEM_DUPLICATOR_LVL_ONE.asItem());
            itemGroup.add(DuplicatorBlockRegistry.ITEM_DUPLICATOR_LVL_TWO.asItem());
            itemGroup.add(DuplicatorBlockRegistry.ITEM_DUPLICATOR_LVL_THREE.asItem());
            itemGroup.add(DuplicatorBlockRegistry.ITEM_DUPLICATOR_LVL_FOUR.asItem());
            itemGroup.add(DuplicatorBlockRegistry.INFINIDUPLICATOR_STICK_PART_MAKER.asItem());
            itemGroup.add(DuplicatorItemRegistry.DUPLICATOR_STICK);
            itemGroup.add(DuplicatorItemRegistry.INFINIDUPLICATOR_STICK);

        });
    }
}
