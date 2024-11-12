package xreversef1ash.legacyduplicatormod.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import xreversef1ash.legacyduplicatormod.LegacyDuplicatorMod;

import java.io.File;
import java.nio.file.Files;

public class DuplicatorConfigFileReader {

    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    private final File configFile = new File("config", "legacyduplicatormod-common.json");
    public DuplicatorConfigData configData;

    public DuplicatorConfigFileReader() {
    }

    public void init() {
        if (configFile.exists()) {
            try {
                configData = gson.fromJson(Files.readString(configFile.toPath()), DuplicatorConfigData.class);
            } catch (Exception e) {
                LegacyDuplicatorMod.LOGGER.error("Config file read error, rebuilding");
            }
        }
        if (configData == null) {
            configData = new DuplicatorConfigData();
            createConfigFile();
        }
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void createConfigFile() {
        if (configFile.exists()) {
            configFile.delete();
        }
        try {
            Files.writeString(configFile.toPath(), gson.toJson(configData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
