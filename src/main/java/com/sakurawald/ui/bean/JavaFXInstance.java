package com.sakurawald.ui.bean;

import com.sakurawald.ui.controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class JavaFXInstance<T extends Controller> {

    private FXMLLoader loader;
    private Stage stage;
    private T controller;

    public JavaFXInstance() {
        // Do nothing.
    }

    public JavaFXInstance(FXMLLoader loader, Stage stage, T controller) {
        this.loader = loader;
        this.stage = stage;
        this.controller = controller;
    }

    public FXMLLoader getLoader() {
        return loader;
    }

    public Stage getStage() {
        return stage;
    }

    public boolean isEmpty() {
        return this.loader == null && this.stage == null && this.controller == null;
    }

    public T getController() {
        return controller;
    }

    public void updateInstance(FXMLLoader loader, Stage stage, T controller) {
        this.loader = loader;
        this.stage = stage;
        this.controller = controller;
    }

    public void emptyInstance() {
        this.loader = null;
        this.stage = null;
        this.controller = null;
    }


}
