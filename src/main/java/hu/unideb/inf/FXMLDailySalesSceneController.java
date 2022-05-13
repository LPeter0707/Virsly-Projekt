package hu.unideb.inf;

import hu.unideb.inf.model.Dailysale;
import hu.unideb.inf.model.DailysaleDAO;
import hu.unideb.inf.model.JpaDailysaleDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FXMLDailySalesSceneController {

    @FXML
    private TextArea dailysale;
    public static TextArea dailysale_static;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonNext;

    @FXML
    void backPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLMainmenu.fxml"));
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
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLDailyInventory.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                buttonNext.getScene().getWindow();
        stage2.close();
        stage.setTitle("Virsly");
        Image image = new Image("/icon/icon_admin.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
    }

    public void DailysaleTextAreaFill()
    {
        try(DailysaleDAO dDao = new JpaDailysaleDAO();){
            List<Dailysale> lista = dDao.getDailysale();
            List<Dailysale> napiforgalomlista = new ArrayList<>();
            for (int j = 0; j < lista.size(); j++)
            {
                System.out.println(lista.get(j).getName() + "\t\t" + lista.get(j).getCount() + "db");
                if (lista.get(j).getCount() > 0)
                {
                    napiforgalomlista.add(lista.get(j));
                }
            }
            String[] forgalom = new String[napiforgalomlista.size()];
            for (int i = 0; i < napiforgalomlista.size(); i++)
            {
                if (napiforgalomlista.get(i).getCount() > 0)
                {
                    forgalom[i] = napiforgalomlista.get(i).getName() + "\t\t" + napiforgalomlista.get(i).getCount() + "db";
                }
            }
            FXMLDailySalesSceneController.dailysale_static.setText(String.join("\n", forgalom));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize(){
        dailysale_static = dailysale;
        DailysaleTextAreaFill();
    }
}
