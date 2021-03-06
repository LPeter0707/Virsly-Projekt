package hu.unideb.inf;

import hu.unideb.inf.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FXMLLoginAdminSceneController {

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonLogin;

    @FXML
    private TextField GetUsername;

    @FXML
    private PasswordField GetPassword;

    @FXML
    void backPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLLogin.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                buttonBack.getScene().getWindow();
        stage2.close();
        stage.setTitle("Virsly");
        Image image = new Image("/icon/icon_user.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void loginPushed(ActionEvent event) throws IOException {
        if (ValidateUser(GetUsername.getText(), GetPassword.getText())) {
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
    }

    @FXML
    void kerelemPushed(ActionEvent event) {
        TextInputDialog textInput = new TextInputDialog();
        textInput.setTitle("K??relem");
        textInput.setHeaderText("K??relem k??ld??s??hez, adja meg a felhaszn??l??nev??t");
        textInput.getDialogPane().setContentText("Felhaszn??l??n??v:");
        Optional<String> result = textInput.showAndWait();
        TextField input = textInput.getEditor();

        if(input.getText() != null && input.getText().toString().length() != 0)
        {
            System.out.println("Bemeneti: " + input.getText().toString().length());
        }
        else
        {
            System.out.println("Nem ??rt be semmit");
        }

    }

    private boolean ValidateUser(String username, String password){
        try(AdminsDAO aDAO = new JpaAdminsDao();) {
            List<Admins> AdminsList = new ArrayList<>(aDAO.getAdmin());
            for (Admins admin : AdminsList) {
                if (admin.getUsername().equals(username) && admin.getPassword().equals(password)){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
