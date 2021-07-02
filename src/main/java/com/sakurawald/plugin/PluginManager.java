package com.sakurawald.plugin;


import com.sakurawald.debug.LoggerManager;
import com.sakurawald.file.ConfigFile;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginManager {


    public static int loadPlugins() {

        File pluginsFolder = new File(ConfigFile.getApplicationConfigPath() + "\\Plugins");

        int loadedPluginCount = 0;

        for (File file : pluginsFolder.listFiles()) {

            if (!file.isFile()) continue;

            LoggerManager.logDebug("ScanPlugin: " + file.getName());

            try {
                URL[] urls = new URL[]{new URL("file:" + file.getAbsolutePath())};
                URLClassLoader ucl = new URLClassLoader(urls);

                /** Load Plugin File: 要求Plugin File的FileName为SiliconPlugin类的全限定名.
                 * 且不带有后缀 .jar
                 */
                Class<?> clazz = ucl.loadClass(file.getName());   // Load Class.

                Method onLoadMethod = clazz.getMethod("onLoad");   // Get Method.
                onLoadMethod.invoke(clazz.getDeclaredConstructor().newInstance());

                loadedPluginCount++;
            } catch (Exception e) {
                LoggerManager.reportException(e);
            }

        }

        return loadedPluginCount;
    }

}
