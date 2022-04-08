package hu.unideb.inf;

import hu.unideb.inf.model.*;
import hu.unideb.inf.model.JpaUsersDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FXMLSignInSceneController<usernameValue> {

    @FXML
    private Button buttonSave;

    @FXML
    private Button buttonBack;
/*
    @FXML
    private Label FirtName;

    @FXML
    private Label LastName;
*/
    @FXML
    private TextField uname;
    public String usernameValue;

    @FXML
    private TextField pass;
    public String passwordValue;

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
        DataSave();
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
    public void DataSave(){

        usernameValue = uname.getText();
        passwordValue = pass.getText();
        System.out.println(usernameValue);
        System.out.println(passwordValue);
        try(UsersDAO aDAO = new JpaUsersDao();) {
            Users a = new Users();
            a.setUsername(usernameValue);
            a.setPassword(passwordValue);
            if (Duplicate(a, aDAO)){
                System.out.println("Már létezik felhasználó ezzel a felhasználónévvel.");
            }else {
                aDAO.saveUser(a);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean Duplicate(Users a, UsersDAO aDAO){
        List<Users> UsersList = new ArrayList<>(aDAO.getUser());
        for (Users user : UsersList) {
            System.out.println(user.getUsername());
            if (user.getUsername().equals(a.getUsername())){
                return true;
            }
        }
        return false;
    }
}
