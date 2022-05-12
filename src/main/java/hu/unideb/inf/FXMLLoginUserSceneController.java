package hu.unideb.inf;

import hu.unideb.inf.model.JpaUsersDao;
import hu.unideb.inf.model.Users;
import hu.unideb.inf.model.UsersDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javassist.expr.NewExpr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FXMLLoginUserSceneController{

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonSignin;

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

    @FXML
    void loginPushed(ActionEvent event) throws Exception {

        if (ValidateUser(GetUsername.getText(), GetPassword.getText())){
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLUserSite.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            Stage stage2 = (Stage)
                    buttonLogin.getScene().getWindow();
            stage2.close();
            stage.setTitle("UserSite");
            NevKiir();
            stage.setScene(scene);
            stage.show();
        }
    }

    private boolean ValidateUser(String username, String password){
        try(UsersDAO aDAO = new JpaUsersDao();) {
            List<Users> UsersList = new ArrayList<>(aDAO.getUser());
            for (Users user : UsersList) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public void NevKiir() {
        try(UsersDAO aDAO = new JpaUsersDao();) {
            List<Users> userslist = new ArrayList<>(aDAO.getUser());
            for (int i = 0; i < userslist.size(); i++)
            {
                if (userslist.get(i).getUsername().equals(GetUsername.getText()))
                {
                    FXMLUserSiteSceneController.name_static.setText(userslist.get(i).getFirstname() + " " + userslist.get(i).getLastname());
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}