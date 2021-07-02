package com.sakurawald.file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sakurawald.debug.LoggerManager;
import com.sakurawald.util.FileUtil;

import java.io.*;

public class ConfigFile<DO> {

    private Class<DO> configDataClass = null;
    private String filePath = null;
    private String fileName = null;
    private DO configDataClassInstance = null;
    private boolean initialized = false;

    public ConfigFile(String filePath, String fileName, Class<DO> configDataClass)
            throws IllegalArgumentException {
        super();
        this.filePath = filePath;
        this.fileName = fileName;
        this.configDataClass = configDataClass;
    }

    /**
     * @return 该应用程序的[配置文件存储路径].
     */
    public static String getApplicationConfigPath() {

        String result = null;

        result = FileUtil.getJavaRunPath();
        result = result + "\\Titanium\\";

        return result;
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void createConfigDataClassInstance() {

        LoggerManager.getLogger().info("FileSystem >> Use Reflect to Create the instance of Data Class >> " + configDataClass.getSimpleName());
        try {
            this.configDataClassInstance = this.configDataClass.newInstance();
        } catch (Exception e) {
            LoggerManager.reportException(e);
        }

    }

    public void createConfigEmptyFileOnDisk() {
        File file = new File(filePath + fileName);

        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            LoggerManager.reportException(e);
        }
    }

    private Class<?> getConfigDataClass() {
        return configDataClass;
    }

    public DO getConfigDataClassInstance() {

        if (this.configDataClassInstance == null) {
            this.createConfigDataClassInstance();
        }

        return this.configDataClassInstance;
    }

    private File getFile() {
        return new File(filePath + fileName);
    }

    private String getFileName() {
        return fileName;
    }

    private String getFilePath() {
        return filePath;
    }

    public void init() throws IllegalArgumentException, IllegalAccessException,
            IOException {

        // 调用方法, 给该File的Data的静态变量进行赋值
        if (!isConfigExistOnDisk()) {
            createConfigEmptyFileOnDisk();
            saveDefaultConfigToDisk();
        }

        LoggerManager.getLogger().info("FileSystem >> Load Local File to Memory >> " + this.getFileName());

        // 从本地存储加载相应的配置文件
        loadConfigToMemoryFromDisk();

        // Set Flag.
        this.initialized = true;
    }


    public boolean isConfigExistOnDisk() {
        File file = new File(filePath + fileName);
        return file.exists();
    }

    public void loadConfigToMemoryFromDisk() throws IllegalArgumentException {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(this.getFile()));

            this.configDataClassInstance = new Gson().fromJson(reader,
                    this.configDataClass);
        } catch (FileNotFoundException e) {
            LoggerManager.reportException(e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                LoggerManager.reportException(e);
            }
        }
    }

    public void saveMemoryConfigToDisk() {
        LoggerManager.getLogger().info("FileSystem >> Save Memory Data to Local File >> " + this.getFileName());

        File file = new File(filePath + fileName);
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            Gson gson = new GsonBuilder().serializeNulls().create();
            String nowJson = gson.toJson(this.getConfigDataClassInstance());

            fos.write(nowJson.getBytes());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            LoggerManager.reportException(e);
        }

    }

    public void saveDefaultConfigToDisk() {

        LoggerManager.getLogger().info("FileSystem >> Start to Write Default ConfigFile Data >> " + this.getFileName());

        // 定义要写出的本地配置文件
        File file = new File(filePath + fileName);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            Gson gson = new GsonBuilder().serializeNulls()
                    .setPrettyPrinting().create();

            String defaultJson = gson.toJson(this.getConfigDataClassInstance());

            fos.write(defaultJson.getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            LoggerManager.reportException(e);
        }

    }

}
