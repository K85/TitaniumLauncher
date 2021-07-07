package com.sakurawald.ui;


import com.sakurawald.debug.LoggerManager;
import com.sakurawald.ui.bean.JavaFXInstance;
import com.sakurawald.ui.controller.AppController;
import com.sakurawald.ui.controller.SettingsController;
import com.sakurawald.util.JavaFxUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class App extends Application {

    /**
     * JavaFXInstance: App
     **/
    public static final JavaFXInstance<AppController> appInstance = new JavaFXInstance<AppController>();
    public static final JavaFXInstance<SettingsController> settingsInstance = new JavaFXInstance<SettingsController>();

    @Override
    public void start(Stage appStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("App.fxml"));
        Parent root = loader.load();

        App.appInstance.updateInstance(loader, appStage, loader.getController());

        JavaFxUtil.WindowTools.setWindowIcon(appStage);
        appStage.setTitle("Titanium Launcher");
        appStage.setScene(new Scene(root));
        appStage.setResizable(false);

        // Show Window.
        appStage.show();

        // Add Listeners.
        appStage.setOnCloseRequest(event -> {
            Alert askAlert = new Alert(Alert.AlertType.CONFIRMATION);
            JavaFxUtil.DialogTools.setIcon(askAlert);
            askAlert.setTitle("Exit");
            askAlert.setHeaderText("Are you sure to exit the program?");
            Optional<ButtonType> result = askAlert.showAndWait();
            if (result.get() == ButtonType.OK) {
                // Call: BeforeJVMExit().
                LoggerManager.logDebug("Shutdown >> Start", true);
                beforeJVMEXit();
                LoggerManager.logDebug("Shutdown >> End", true);
                LoggerManager.logDebug("End Application...", true);

                // Exit JVM.
                System.exit(0);
            } else {
                event.consume();
            }
        });


        /** AfterInit. **/
        App.appInstance.getController().afterInitialize();
    }

    public void beforeJVMEXit() {
        // Do nothing.
    }
}
