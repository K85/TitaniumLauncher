package com.sakurawald.plugin;


import com.sakurawald.Titanium;
import com.sakurawald.debug.LoggerManager;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class PluginManager {

    private static final ArrayList<PluginBase> loadedPlugins = new ArrayList<>();


    public static int loadPlugins() {

        File pluginsFolder = new File(Titanium.getLauncherPluginsPath());

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

                // Call -> onLoad()
                Method onLoadMethod = clazz.getMethod("onLoad");   // Get Method.
                onLoadMethod.invoke(clazz.getDeclaredConstructor().newInstance());

                loadedPluginCount++;
            } catch (Exception e) {
                LoggerManager.reportException(e);
            }

        }

        return loadedPluginCount;
    }

    public static ArrayList<PluginBase> getLoadedPlugins() {
        return PluginManager.loadedPlugins;
    }

    public static void addLoadedPlugin(PluginBase pluginBase) {
        PluginManager.loadedPlugins.add(pluginBase);
    }
}
