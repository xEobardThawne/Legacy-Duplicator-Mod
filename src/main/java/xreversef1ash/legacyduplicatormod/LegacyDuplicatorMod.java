package xreversef1ash.legacyduplicatormod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xreversef1ash.legacyduplicatormod.blocks.DuplicatorBlockRegistry;
import xreversef1ash.legacyduplicatormod.config.DuplicatorConfigFileReader;
import xreversef1ash.legacyduplicatormod.items.DuplicatorItemRegistry;
import xreversef1ash.legacyduplicatormod.screens.ScreenDuplicatorRegistry;
import xreversef1ash.legacyduplicatormod.util.BasicDuplicatorBlockList;
import xreversef1ash.legacyduplicatormod.util.InfiniPartMakerRecipeData;
import xreversef1ash.legacyduplicatormod.util.ItemDuplicatorItemList;

public class LegacyDuplicatorMod implements ModInitializer {
	public static final String MOD_ID = "legacyduplicatormod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final DuplicatorConfigFileReader configReader = new DuplicatorConfigFileReader();

	public static final InfiniPartMakerRecipeData infiniRecipeData = new InfiniPartMakerRecipeData();

	@Override
	public void onInitialize() {
		configReader.init();
		DuplicatorBlockRegistry.init();
		DuplicatorItemRegistry.init();
		BasicDuplicatorBlockList.init(configReader.configData);
		ItemDuplicatorItemList.init(configReader.configData);
		infiniRecipeData.build(configReader.configData);
		DuplicatorTab.createTab();
		ScreenDuplicatorRegistry.init();


		LOGGER.info("Loaded Legacy Duplicator Mod");
	}
}