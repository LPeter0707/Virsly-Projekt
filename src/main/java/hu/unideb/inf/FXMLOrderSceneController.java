package hu.unideb.inf;

import hu.unideb.inf.model.JpaStorageDAO;
import hu.unideb.inf.model.Storage;
import hu.unideb.inf.model.StorageDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class FXMLOrderSceneController {

    private ObservableList<Integer> valasztasok = FXCollections.observableArrayList(0,1,2,3,4,5);

    @FXML
    private ChoiceBox<Integer> nyhdp;

    @FXML
    private Button buttonBack;

    @FXML
    private Button addElement;

    @FXML
    private Button buttonNext;

    @FXML
    private TextArea OrderScene;
    public static TextArea OrderScene_static;

    @FXML
    void backPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLMainmenu.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                buttonBack.getScene().getWindow();
        stage2.close();
        stage.setTitle("Main menu");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void nextPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLDailyInventory.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                buttonNext.getScene().getWindow();
        stage2.close();
        stage.setTitle("Daily Inventory");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initialize(){
        OrderScene_static = OrderScene;
        nyhdp.setValue(0);
        nyhdp.setItems(valasztasok);

        AlapanyagKiir();
    }

    static void AlapanyagKiir(){
        StorageDao sdao = new JpaStorageDAO();
        List<Storage> alapanyagok = sdao.getStorage();

    }

    @FXML
    void addElementPushed(ActionEvent event) throws IOException {

    }


}
