package klijent;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MessageBox {
    public static void show(String message, String title) {
    Stage stage = new Stage();
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.setTitle(title);
    stage.setMinWidth(350);
    Label lbl = new Label();
    lbl.setText(message);
    Button btnOK = new Button();
    btnOK.setText("OK");
    btnOK.setOnAction(e -> stage.close());
    VBox pane = new VBox(20);
    pane.getChildren().addAll(lbl, btnOK);
    pane.setAlignment(Pos.CENTER);
    Scene scene = new Scene(pane);
    stage.setScene(scene);
    stage.showAndWait();
    }
}
