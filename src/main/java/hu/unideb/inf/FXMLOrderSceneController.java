package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLOrderSceneController {
    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonNext;

    @FXML
    void backPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLMainmenu.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                buttonBack.getScene().getWindow();
        stage2.close();
        stage.setTitle("Virsly");
        Image image = new Image("/icon/icon_admin.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void nextPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLDailyInventory.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                buttonNext.getScene().getWindow();
        stage2.close();
        stage.setTitle("Virsly");
        Image image = new Image("/icon/icon_admin.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
    }
}
