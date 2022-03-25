package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLLoginAdminSceneController {

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonLogin;

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
    void loginPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLMainmenu.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                buttonLogin.getScene().getWindow();
        stage2.close();
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }
}
