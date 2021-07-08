package com.sakurawald;

import com.sakurawald.debug.LoggerManager;
import com.sakurawald.file.config.ConfigFile;
import com.sakurawald.file.config.FileManager;
import com.sakurawald.plugin.PluginManager;
import com.sakurawald.ui.App;
import com.sakurawald.util.FileUtil;
import javafx.application.Application;


public class Titanium {

    private static final String APPLICATION_VERSION = "Origin";
    private static final String OPEN_SOURCE = "https://github.com/K85";


    public static void main(String[] args) {

        /** Init Logger Path. **/
        String rootPath = FileUtil.getJavaRunPath();
        System.setProperty("local_logger.base_path", rootPath);

        LoggerManager.logDebug("Start Application...", true);
        LoggerManager.logDebug("Init >> Start", true);

        /** Init FileSystem. **/
        FileManager.initFileManager();

        /** Load Plugins. **/
        LoggerManager.logDebug("Load Titanium Plugins", true);
        PluginManager.loadPlugins();

        LoggerManager.logDebug("Init >> End", true);

        LoggerManager.logDebug("JavaFX Application >> Launch", true);

        /** Launch JavaFX Application. **/
        Application.launch(App.class);
    }

    public static String getLauncherMapsPath() {
        return ConfigFile.getApplicationConfigPath() + "Maps\\";
    }

    public static String getLauncherPluginsPath() {
        return ConfigFile.getApplicationConfigPath() + "Plugins\\";
    }
}
