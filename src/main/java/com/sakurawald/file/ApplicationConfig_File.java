package com.sakurawald.file;

public class ApplicationConfig_File extends ConfigFile<ApplicationConfig_Data> {

    public ApplicationConfig_File(String filePath, String fileName, Class<ApplicationConfig_Data> configDataClass) throws IllegalArgumentException {
        super(filePath, fileName, configDataClass);
    }
}
