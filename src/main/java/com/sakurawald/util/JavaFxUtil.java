package com.sakurawald.util;

import com.sakurawald.Titanium;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class JavaFxUtil {

    public static class ImageTools {
        public static void centerImage(ImageView imgView) {
            Image img = imgView.getImage();

            if (img != null) {
                double w = 0;
                double h = 0;

                double ratioX = imgView.getFitWidth() / img.getWidth();
                double ratioY = imgView.getFitHeight() / img.getHeight();

                double reducCoeff = 0;
                reducCoeff = Math.min(ratioX, ratioY);

                w = img.getWidth() * reducCoeff;
                h = img.getHeight() * reducCoeff;

                imgView.setX((imgView.getFitWidth() - w) / 2);
                imgView.setY((imgView.getFitHeight() - h) / 2);

            }
        }
    }


    public static class WindowTools {
        public static void setWindowIcon(Stage stage) {
            stage.getIcons().add(new Image(Titanium.class.getResourceAsStream("icon.png")));
        }
    }

    public static class HtmlEditorTools {

        public static void clearToolKits(HTMLEditor htmlEditor) {
            Node[] nodes = htmlEditor.lookupAll(".tool-bar").toArray(new Node[0]);
            for (Node node : nodes) {
                node.setVisible(false);
                node.setManaged(false);
            }
        }
    }

    public static class DialogTools {

        public static void warnDialog(String message) {
            DialogTools.alert(Alert.AlertType.WARNING, message, ButtonType.OK).show();
        }

        public static void errorDialog(String message) {
            DialogTools.alert(Alert.AlertType.ERROR, message, ButtonType.OK).show();
        }

        public static void informationDialog(String message) {
            DialogTools.alert(Alert.AlertType.INFORMATION, message, ButtonType.OK).show();
        }

        public static void noneDialog(String message) {
            DialogTools.alert(Alert.AlertType.NONE, message, ButtonType.OK).show();
        }

        public static void unsupportOperationDialog() {
            DialogTools.errorDialog("Unsupported Operation.");
        }

        public static void setIcon(Dialog dialog) {
            // Set Icon
            ((Stage) dialog.getDialogPane().getScene().getWindow()).getIcons().add(new Image(
                    Titanium.class.getResourceAsStream("icon.png")));
        }

        public static Alert alert(Alert.AlertType alertType, String contentText, ButtonType... buttonTypes) {
            Alert a = new Alert(alertType, contentText, buttonTypes);
            setIcon(a);
            return a;
        }
    }

}
