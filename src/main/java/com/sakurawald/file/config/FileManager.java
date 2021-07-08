package com.sakurawald.file.config;


import com.sakurawald.Titanium;
import com.sakurawald.debug.LoggerManager;

import java.io.File;
import java.io.IOException;

public class FileManager {

    /**
     * Config Instances.
     **/
    public static ApplicationConfig_File applicationConfig_File = null;

    /**
     * Call when: Application Launch.
     **/
    public static void initFileManager() {

        LoggerManager.getLogger().info("Init >> All Configs...");

        // Mkdirs.
        new File(Titanium.getLauncherMapsPath()).mkdirs();
        new File(Titanium.getLauncherPluginsPath()).mkdirs();

        // ApplicationConfig.json
        LoggerManager.getLogger().info("Init >> ApplicationConfig.json");
        try {
            applicationConfig_File = new ApplicationConfig_File(ConfigFile.getApplicationConfigPath(),
                    "ApplicationConfig.json", ApplicationConfig_Data.class);
            applicationConfig_File.init();
        } catch (IllegalAccessException | IOException e) {
            LoggerManager.reportException(e);
        }

    }


}
