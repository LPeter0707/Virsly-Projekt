package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLMainmenuSceneController {

    @FXML
    private Button buttonDailySale;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonDailyInventory;

    @FXML
    private Button buttonOrder;

    @FXML
    void backPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLLogin.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                buttonBack.getScene().getWindow();
        stage2.close();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void dailysalePushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLDailySales.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                buttonDailySale.getScene().getWindow();
        stage2.close();
        stage.setTitle("Daily Sales");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void dailyinventoryPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLDailyInventory.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                buttonDailyInventory.getScene().getWindow();
        stage2.close();
        stage.setTitle("Daily Inventory");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void orderPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLOrder.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                buttonOrder.getScene().getWindow();
        stage2.close();
        stage.setTitle("Order");
        stage.setScene(scene);
        stage.show();
    }
}
