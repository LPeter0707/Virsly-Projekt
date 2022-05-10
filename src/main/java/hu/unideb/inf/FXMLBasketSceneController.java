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

    public static List<Food> kajalista = new ArrayList<>();
    public static List<Drink> itallista = new ArrayList<>();

    private static Integer italosszeg = 0;
    private static Integer kajaosszeg = 0;

    static void OsszegKiir()
    {
        vegosszeg_static.setText(italosszeg + kajaosszeg + "Ft");
    }

    static void Kiir()
    {
        String[] italtartalom = italKiir();
        String[] kajatartalom = kajaKiir();

        int meret = italtartalom.length + kajatartalom.length;
        String[] teljes = new String[meret];

        for (int i = 0; i < italtartalom.length; i++)
        {
            teljes[i] = italtartalom[i];
        }

        for (int j = 0; j < kajatartalom.length; j++)
        {
            teljes[j+italtartalom.length] = kajatartalom[j];
        }

        basket_static.setText(String.join("\n", teljes));
    }

    static void italRendeles(int italindex, int darab){
        for (int i = 0; i < darab; i++)
        {
            itallista.add(italok.get(italindex));
        }

        FXMLScenes object = new FXMLScenes();
        Pane view = object.getPage("FXMLKosar");
        mainPane_static.getChildren().setAll(view);

        //italKiir();
        for (int i = 0; i < itallista.size(); i++)
        {
            Napiforgalomital(itallista, count_ital(itallista.get(i).getName()), i);
        }
    }
    public static List<Drink> itallistap = new ArrayList<>();

    static String[] italKiir()
    {
        //int italosszeg = 0;
        Set<Drink> szurtlista = new HashSet<>(itallista);
        String[] tartalom = new String[szurtlista.size()];
        List<Drink> itallista = new ArrayList<>(szurtlista);
        itallistap.addAll(itallista);
        for (int i = 0; i < itallista.size(); i++)
        {
            int db = count_ital(itallista.get(i).getName());
            tartalom[i] = itallista.get(i).getName() + "\t\t\t" + db + "db" + "\t" + db * itallista.get(i).getPrice() + " ft";
            italosszeg += db * itallista.get(i).getPrice();
        }
        //vegosszeg_static.setText(italosszeg + " Ft");
        //basket_static.setText(String.join("\n", tartalom));
        return tartalom;
    }

    static void Napiforgalomital(List<Drink> itallista, int db, int i)
    {
        ///////
    }

    static void kajaRendeles(int kajaindex, int darab){
        for (int i = 0; i < darab; i++)
        {
            kajalista.add(kajak.get(kajaindex));
        }

        FXMLScenes object = new FXMLScenes();
        Pane view = object.getPage("FXMLKosar");
        mainPane_static.getChildren().setAll(view);

        //kajaKiir();

            Napiforgalomkaja(kajalistap);

    }

    static int count_ital(String name){
        int db = 0;
        for (Drink item : itallista) {
            if (item.getName()==name){
                db++;
            }
        }
        return db;
    }

    static int count_kaja(String name){
        int db = 0;
        for (Food item : kajalista) {
            if (item.getName()==name){
                db++;
            }
        }
        return db;
    }
    public static List<Food> kajalistap = new ArrayList<>();
    static String[] kajaKiir()
    {
        //int kajaosszeg = 0;
        Set<Food> szurtlista = new HashSet<>(kajalista);
        String[] tartalom = new String[szurtlista.size()];
        List<Food> kajalista = new ArrayList<>(szurtlista);
        kajalistap.addAll(kajalista);
        for (int i = 0; i < kajalista.size(); i++)
        {
            int db = count_kaja(kajalista.get(i).getName());
            tartalom[i] = kajalista.get(i).getName() + "\t\t\t" + db + "db" + "\t" + db * kajalista.get(i).getPrice() + " ft";
            kajaosszeg += db * kajalista.get(i).getPrice();
        }
        //vegosszeg_static.setText(osszeg + " Ft");
        //basket_static.setText(String.join("\n", tartalom));
        return tartalom;
    }

    static void Napiforgalomkaja(List<Food> kajalista)
    {
        //////Napi forgalom /////////////////////////////EZT KELL ÁTNÉZNED SANYI///////////////////////////////////////////////////////////////
        //Fasza csak annyi a hiba hogy új sorrba menti és nem irja felül a régebbit
            List<Dailysale> forgalom = new ArrayList<>();
            try(DailysaleDAO dDao = new JpaDailysaleDAO();){
                forgalom = dDao.getDailysale();
                Dailysale dailysale = new Dailysale();
                if (forgalom.size() == 0)
                {
                    dailysale.setName(kajalista.get(0).getName());
                    dailysale.setCount(count_kaja(kajalista.get(0).getName()));
                    dDao.saveDailysale(dailysale);
                    for (int i = 1; i < kajalista.size(); i++){
                        dailysale.setName(kajalista.get(i).getName());
                        dailysale.setCount(count_kaja(kajalista.get(i).getName()));
                        dDao.saveDailysale(dailysale);
                    }
                }/*
                else {
                    for (int j = 0; j < forgalom.size(); j++) {
                        //System.out.println("forgalom: " + forgalom.get(j).getName());
                        //System.out.println("kajalista: " + kajalista.get(i).getName());
                        if (forgalom.get(j).getName().contains(kajalista.get().getName())) {
                            //System.out.println("ok");
                            dailysale.setCount(forgalom.get(j).getCount() + db);
                            dailysale.setName(forgalom.get(j).getName());
                            dDao.updateDailysale(dailysale);
                            break;
                        }
                        else
                        {
                            dailysale.setName(kajalista.get(i).getName());
                            dailysale.setCount(db);
                            dDao.saveDailysale(dailysale);
                        }
                    }
                }*/
            }catch (Exception e) {
                e.printStackTrace();
            }
        ////////////////////////////////////////////////////////////////////////
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
        boolean hiba = false;
        for(int i = 0; i < kajalistap.size(); i++){
            for (int j = 0; j < kajalistap.get(i).getList().size(); j++){
                for (int k = 0; k < raktar.size(); k++){
                    if (kajalistap.get(i).getList().get(j).contains(raktar.get(k).getName())) {
                        if (raktar.get(k).getPiece() < count_kaja(kajalistap.get(i).getName())){
                            hiba = true;
                            a.show();
                            break;
                        }
                    }
                }
            }
        }
        if (hiba == false) {
            for (int i = 0; i < kajalistap.size(); i++) {
                for (int j = 0; j < kajalistap.get(i).getList().size(); j++) {
                    for (int k = 0; k < raktar.size(); k++) {
                        if (kajalistap.get(i).getList().get(j).contains(raktar.get(k).getName())) {


                                raktar.get(k).setPiece(raktar.get(k).getPiece() - count_kaja(kajalistap.get(i).getName()));



                        }
                    }
                }
            }
        }
        boolean italhiba = false;
        for(int i = 0; i < itallista.size(); i++){
            for (int j = 0; j < raktar.size(); j++){
                if (itallista.get(i).getName().contains(raktar.get(j).getName())) {
                    if (raktar.get(j).getPiece() < count_ital(itallistap.get(i).getName())){
                        italhiba = true;
                        a.show();
                        break;
                    }

                }
            }
        }

        if (italhiba == false){
            for(int i = 0; i < itallistap.size(); i++){
                for (int j = 0; j < raktar.size(); j++){
                    if (itallistap.get(i).getName().contains(raktar.get(j).getName())) {

                            raktar.get(j).setPiece(raktar.get(j).getPiece() - count_ital(itallistap.get(i).getName()));


                    }
                }
            }
        }
        storage.updateStorage(raktar);
        basket_static.clear();
        kajalista.clear();
        FXMLScenes object = new FXMLScenes();
        Pane view = object.getPage("FXMLKapcsolat");
        mainPane_static.getChildren().setAll(view);
    }
}
