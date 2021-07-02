package com.sakurawald.file;


import com.sakurawald.Titanium;
import com.sakurawald.debug.LoggerManager;
import com.sakurawald.util.FileUtil;

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

        // ApplicationConfig.json
        LoggerManager.getLogger().info("Init >> ApplicationConfig.json");
        try {
            applicationConfig_File = new ApplicationConfig_File(FileManager.getApplicationConfigPath(),
                    "ApplicationConfig.json", ApplicationConfig_Data.class);
            applicationConfig_File.init();
        } catch (IllegalAccessException | IOException e) {
            LoggerManager.reportException(e);
        }

    }

    private static String getApplicationConfigPath() {
        String result;
        result = FileUtil.getJavaRunPath();
        result = result + "Nekomata" + File.separator + "configs" + File.separator;
        return result;
    }
}
