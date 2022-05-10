package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLDailyInventorySceneController {

    @FXML
    private TextArea dailyinventory;
    public static TextArea dailyinventory_static;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonNext;

    @FXML
    public void initialize(){

        dailyinventory_static = dailyinventory;
    }

    @FXML
    void backPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLDailySales.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                buttonBack.getScene().getWindow();
        stage2.close();
        stage.setTitle("Daily Sales");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void nextPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLClose.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                buttonNext.getScene().getWindow();
        stage2.close();
        stage.setTitle("Close");
        stage.setScene(scene);
        stage.show();
    }
}
