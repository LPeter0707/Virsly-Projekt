package hu.unideb.inf;

import hu.unideb.inf.model.JpaStorageDAO;
import hu.unideb.inf.model.Storage;
import hu.unideb.inf.model.StorageDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class FXMLDailyInventorySceneController {

    @FXML
    private TextArea dailyinventory;
    public static TextArea dailyinventory_static;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonNext;

    @FXML
    public void initialize(){
        dailyinventory_static = dailyinventory;
        DailyinventoryTextAreaFill();
    }

    @FXML
    void backPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLDailySales.fxml"));
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
    void nextPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLClose.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                buttonNext.getScene().getWindow();
        stage2.close();
        stage.setTitle("Virsly");
        Image image = new Image("/icon/icon_admin.png");
        stage.getIcons().add(image);
        stage.setTitle("Close");
        stage.setScene(scene);
        stage.show();
    }

    public static void DailyinventoryTextAreaFill()
    {
        try(StorageDao sDao = new JpaStorageDAO();){
            List<Storage> leltarlista = sDao.getStorage();
            String[] leltar = new String[leltarlista.size()];
            for (int i = 0; i < leltarlista.size(); i++)
            {
                leltar[i] = leltarlista.get(i).getName() + "\t\t" + leltarlista.get(i).getPiece() + "db";
            }
            FXMLDailyInventorySceneController.dailyinventory_static.setText(String.join("\n", leltar));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
