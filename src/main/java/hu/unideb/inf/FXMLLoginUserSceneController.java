package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLLoginUserSceneController {

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonSignin;

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
    void signinPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLSignIn.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                buttonSignin.getScene().getWindow();
        stage2.close();
        stage.setTitle("Sign in");
        stage.setScene(scene);
        stage.show();
    }
}
