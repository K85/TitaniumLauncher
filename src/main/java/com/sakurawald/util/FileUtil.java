package com.sakurawald.util;

import java.io.File;

public class FileUtil {

    /**
     * 可能的输出结果:
     * D:\LocalWorkSpace\Java\workspace\Silicon
     *
     * @return 应用程序的运行路径.
     */
    public static String getJavaRunPath() {
        return new File("").getAbsolutePath();
    }

}
