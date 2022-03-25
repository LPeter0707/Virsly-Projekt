package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLSignInSceneController {

    @FXML
    private Button buttonSave;

    @FXML
    private Button buttonBack;

    @FXML
    void backPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLLoginUser.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                buttonBack.getScene().getWindow();
        stage2.close();
        stage.setTitle("LoginUser");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void savePushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLLoginUser.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                buttonSave.getScene().getWindow();
        stage2.close();
        stage.setTitle("LoginUser");
        stage.setScene(scene);
        stage.show();
    }
}
