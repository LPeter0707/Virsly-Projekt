package hu.unideb.inf;

import hu.unideb.inf.model.*;
import hu.unideb.inf.model.JpaUsersDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.*;

public class FXMLSignInSceneController<usernameValue> {

    @FXML
    private Button buttonSave;

    @FXML
    private Button buttonBack;

    @FXML
    private TextField firstname;
    public String firstnameValue;

    @FXML
    private TextField lastname;
    public String lastnameValue;

    @FXML
    private TextField uname;
    public String usernameValue;

    @FXML
    private PasswordField pass;
    public String passwordValue;

    @FXML
    void backPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLLoginUser.fxml"));
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
    void savePushed(ActionEvent event) throws IOException {
        DataSave();
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLLoginUser.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                buttonSave.getScene().getWindow();
        stage2.close();
        stage.setTitle("Virsly");
        Image image = new Image("/icon/icon_user.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();


    }

    boolean name_valid(String name){
        if (isUpperCase(name.charAt(0))){
            return true;
        }
        return false;
    }

    boolean username_valid(String username){
        int pont = 0;
        int kukacpoz = 0;
        if (!username.contains("@") || !username.contains(".")){
            return false;
        }
        for (int i = 0; i < username.length(); i++){
            if (username.charAt(i) == '@'){
                kukacpoz = i;
                break;
            }
        }
        for (int j = kukacpoz + 1; j < username.length(); j++){
            if (username.charAt(j) == '@'){
                return false;
            }
            if (username.charAt(j) == '.'){
                pont++;
            }
        }
        if (pont != 1){
            return false;
        }
        return true;
    }

    boolean pass_valid(String pass){
        int nagybet = 0;
        int kisbetu = 0;
        int szam = 0;
        for (int i = 0; i < pass.length(); i++){
            if (isUpperCase(pass.charAt(i))){
                nagybet++;
            }
            if (isLowerCase(pass.charAt(i))){
                kisbetu++;
            }
            if (isDigit(pass.charAt(i))){
                szam++;
            }
        }
        if(szam >= 2 && kisbetu >= 2 && nagybet >= 2){
            return true;
        }
        return false;
    }

    public void DataSave(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setAlertType(Alert.AlertType.ERROR);
        alert.setContentText("Már létezik felhasználó ezzel a felhasználónévvel.");
        Alert nameAlert = new Alert(Alert.AlertType.ERROR);
        nameAlert.setAlertType(Alert.AlertType.ERROR);
        nameAlert.setContentText("Nagy betűvel kell kezdődnie a névnek.");
        Alert usernameAlert = new Alert(Alert.AlertType.ERROR);
        usernameAlert.setAlertType(Alert.AlertType.ERROR);
        usernameAlert.setContentText("Rossz felhasználónév! Helyes formátum: valami@vmi.com");
        Alert passAlert = new Alert(Alert.AlertType.ERROR);
        passAlert.setAlertType(Alert.AlertType.ERROR);
        passAlert.setContentText("Hibás jelszó! 2 nagybetűt, 2 kisbetűt és 2 számot kell tartalmaznia!");

        firstnameValue = firstname.getText();
        lastnameValue = lastname.getText();
        usernameValue = uname.getText();
        passwordValue = pass.getText();
        try(UsersDAO aDAO = new JpaUsersDao();) {
            Users a = new Users();
            if (!name_valid(firstnameValue) || !name_valid(lastnameValue)){
                nameAlert.show();
            }else if (!username_valid(usernameValue)){
                usernameAlert.show();
            }
            else if(!pass_valid(passwordValue)){
                passAlert.show();
            }
            else
            {
                a.setFirstname(firstnameValue);
                a.setLastname(lastnameValue);
                a.setUsername(usernameValue);
                a.setPassword(passwordValue);
                if (Duplicate(a, aDAO)){
                    alert.show();
                }else {
                    aDAO.saveUser(a);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean Duplicate(Users a, UsersDAO aDAO){
        List<Users> UsersList = new ArrayList<>(aDAO.getUser());
        for (Users user : UsersList) {
            //System.out.println(user.getUsername());
            if (user.getUsername().equals(a.getUsername())){
                return true;
            }
        }
        return false;
    }
}
