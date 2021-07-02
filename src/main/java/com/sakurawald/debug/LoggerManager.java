package com.sakurawald.debug;


import com.sakurawald.file.FileManager;
import com.sakurawald.util.JavaFxUtil;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;


public class LoggerManager {

    public static final String SAD_FACIAL_EXPRESSION = "(ó﹏ò｡)";

    private static final Logger local_Logger = LogManager.getLogger(LoggerManager.class);

    public static Logger getLogger() {
        return local_Logger;
    }

    public static void logDebug(String type, String msg, boolean forceLog) {
        logDebug("[" + type + "] " + msg, forceLog);
    }

    public static void logDebug(String content, boolean forceLog) {

        if (forceLog) {

            local_Logger.debug(content);
            return;
        }

        // 如果不存在ApplicationConfig.json文件, 则默认开启Debug模式
        if (FileManager.applicationConfig_File == null ||
                !FileManager.applicationConfig_File.isInitialized() ||
                FileManager.applicationConfig_File.getConfigDataClassInstance().Debug.enable) {
            local_Logger.debug(content);
        }
    }

    public static void logDebug(String content) {
        logDebug(content, false);
    }


    public static void logDebug(String type, String msg) {

        logDebug(type, msg, false);
    }

    public static void logError(Exception e) {
        LoggerManager.getLogger().error(getExceptionInfo(e));
    }

    /**
     * 输出Exception到本地存储, 并且展示错误对话框.
     */
    public static void reportException(Exception e) {

        // 输出到<本地存储>
        LoggerManager.getLogger().error(getExceptionInfo(e));

        // Show Dialog
        showErrorDialog(e);
    }


    public static String getExceptionInfo(Exception e) {

        // 添加Exception基础信息
        String result = "Type: " + e.getClass() + "\nReason: " + e.getCause() +
                "\nMessage: " + e.getMessage() +
                "\nStackTrace: " +

                // 添加栈追踪记录
                "\n" +
                getExceptionStack(e);
        return result;
    }

    public static String getExceptionStack(Exception e) {
        StringBuilder result = new StringBuilder();
        for (StackTraceElement s : e.getStackTrace()) {
            result.append("\tat ").append(s).append("\r\n");
        }
        return result.toString();
    }

    public static void showErrorDialog(Exception e) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Alert alert = new Alert(Alert.AlertType.ERROR);


                JavaFxUtil.DialogTools.setIcon(alert);
                alert.setTitle("An Error Occurs...");
                alert.setHeaderText("Something must be wrong. " + SAD_FACIAL_EXPRESSION);
                alert.setContentText("ErrorType：" + e.getClass() + "\nErrorReason：" + e.getCause() + "\nErrorMessage：" + e.getMessage());

                // Create expandable Exception.
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                String exceptionText = sw.toString();

                Label label = new Label("ErrorStack：");
                TextArea textArea = new TextArea(exceptionText);
                textArea.setEditable(false);
                textArea.setWrapText(true);
                textArea.setText(getExceptionStack(e));

                textArea.setMaxWidth(Double.MAX_VALUE);
                textArea.setMaxHeight(Double.MAX_VALUE);
                GridPane.setVgrow(textArea, Priority.ALWAYS);
                GridPane.setHgrow(textArea, Priority.ALWAYS);

                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                expContent.add(label, 0, 0);
                expContent.add(textArea, 0, 1);

                // Set expandable Exception into the dialog pane.
                alert.getDialogPane().setExpandableContent(expContent);
                alert.show();
            }
        });


    }


}
