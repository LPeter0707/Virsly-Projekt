package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.Optional;

public class FXMLLoginAdminSceneController {

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonLogin;

    @FXML
    private Button buttonKerelem;

    @FXML
    void backPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLLogin.fxml"));
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
    void loginPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLMainmenu.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                buttonLogin.getScene().getWindow();
        stage2.close();
        stage.setTitle("Virsly");
        Image image = new Image("/icon/icon_admin.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void kerelemPushed(ActionEvent event) {
        TextInputDialog textInput = new TextInputDialog();
        textInput.setTitle("Kérelem");
        textInput.setHeaderText("Kérelem küldéséhez, adja meg a felhasználónevét");
        textInput.getDialogPane().setContentText("Felhasználónév:");
        Optional<String> result = textInput.showAndWait();
        TextField input = textInput.getEditor();

        if(input.getText() != null && input.getText().toString().length() != 0)
        {
            System.out.println("Bemeneti: " + input.getText().toString().length());
        }
        else
        {
            System.out.println("Nem írt be semmit");
        }

    }
}
