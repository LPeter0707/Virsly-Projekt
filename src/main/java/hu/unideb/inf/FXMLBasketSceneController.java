package hu.unideb.inf;

import hu.unideb.inf.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FXMLBasketSceneController extends FXMLUserSiteSceneController{

    @FXML
    private TextArea basket;
    public static TextArea basket_static;

    @FXML
    private Label vegosszeg;
    private static Label vegosszeg_static;

    @FXML
    private Button buttonRendel;

    public static List<Food> lista = new ArrayList<>();

    static void Rendeles(int kajaindex, int darab) throws SQLException {
        for (int i = 0; i < darab; i++)
        {
            lista.add(kajak.get(kajaindex));
        }

        /*for (int j = 0; j < lista.size(); j++)
        {
            System.out.println(lista.get(j).getName());
        }*/

        FXMLScenes object = new FXMLScenes();
        Pane view = object.getPage("FXMLKosar");
        mainPane_static.getChildren().setAll(view);

        Kiir();
    }

    static int count_fun(String name){
        int db = 0;
        for (Food item : lista) {
            if (item.getName()==name){
                db++;
            }
        }
        return db;
    }

    static void Kiir() throws SQLException
    {
        int osszeg = 0;
        Set<Food> szurtlista = new HashSet<>(lista);
        String[] tartalom = new String[szurtlista.size()];
        List<Food> kajalista = new ArrayList<>(szurtlista);
        for (int i = 0; i < kajalista.size(); i++)
        {
            int db = count_fun(kajalista.get(i).getName());
            //////Napi forgalom /////////////////////////////EZT KELL ÁTNÉZNED SANYI///////////////////////////////////////////////////////////////
            List<Dailysale> forgalom = new ArrayList<>();
            try(DailysaleDAO dDao = new JpaDailysaleDAO();){
                forgalom = dDao.getDailysale();
                Dailysale dailysale = new Dailysale();
                if (forgalom.size() == 0)
                {
                    dailysale.setName(kajalista.get(i).getName());
                    dailysale.setCount(db);
                    dDao.saveDailysale(dailysale);
                }
                else {
                    for (int j = 0; j < forgalom.size(); j++) {
                        if (forgalom.get(j).getName().contains(kajalista.get(i).getName())) {
                            dailysale.setCount(forgalom.get(j).getCount() + db);
                        }
                        else
                        {
                            dailysale.setName(kajalista.get(i).getName());
                            dailysale.setCount(db);
                            dDao.saveDailysale(dailysale);
                        }
                    }
                    dDao.updateDailysale(dailysale);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            ////////////////////////////////////////////////////////////////////////
            tartalom[i] = kajalista.get(i).getName() + "\t\t\t" + db + "db" + "\t" + db * kajalista.get(i).getPrice() + " ft";
            osszeg += db * kajalista.get(i).getPrice();
        }
        vegosszeg_static.setText(osszeg + " Ft");
        basket_static.setText(String.join("\n", tartalom));
    }

    @FXML
    public void initialize(){
        basket_static = basket;
        vegosszeg_static = vegosszeg;
    }

    @FXML
    void rendelPushed(ActionEvent event) throws IOException{
        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.WARNING);
        a.setContentText("Nincs elég alapanyag az étel elkészítéséhez!\n");
        List<Storage> raktar = new ArrayList<>();
        StorageDao storage = new JpaStorageDAO();
        raktar = storage.getStorage();
        for(int i = 0; i < lista.size(); i++){
            for (int j = 0; j < lista.get(i).getList().size(); j++){
                for (int k = 0; k < raktar.size(); k++){
                    if (lista.get(i).getList().get(j).contains(raktar.get(k).getName())) {
                        if (raktar.get(k).getPiece() < 1){
                            a.show();
                        }else {
                            raktar.get(k).setPiece(raktar.get(k).getPiece() - 1);

                        }
                    }
                }
            }
        }
        storage.updateStorage(raktar);
        basket_static.clear();
        FXMLScenes object = new FXMLScenes();
        Pane view = object.getPage("FXMLKapcsolat");
        mainPane_static.getChildren().setAll(view);
    }
}
