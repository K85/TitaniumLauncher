package com.sakurawald;

import com.sakurawald.debug.LoggerManager;
import com.sakurawald.file.ConfigFile;
import com.sakurawald.file.FileManager;
import com.sakurawald.ui.App;
import com.sakurawald.util.FileUtil;
import javafx.application.Application;


public class Titanium {

    private static final String SILICON_VERSION = "Origin";
    private static final String OPEN_SOURCE = "https://github.com/K85";


    public static void main(String[] args) {

        /** Init Logger Path. **/
        String rootPath = FileUtil.getJavaRunPath();
        System.setProperty("local_logger.base_path", rootPath);

        LoggerManager.logDebug("Start Application...", true);
        LoggerManager.logDebug("Init >> Start", true);

        /** Init FileSystem. **/
        FileManager.initFileManager();

//        /** Load Plugins. **/
//        LoggerManager.logDebug("Load Silicon Plugins", true);
//        if (PluginManager.loadPlugins() == 0) {
//            throw new RuntimeException("No Plugin Found!");
//        }

        LoggerManager.logDebug("Init >> End", true);

        LoggerManager.logDebug("JavaFX Application >> Launch", true);

        /** Launch JavaFX Application. **/
        Application.launch(App.class);
    }

    public static String getLauncherMapsPath() {
        return ConfigFile.getApplicationConfigPath() + "Maps\\";
    }
}
