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
    }
    public static List<Drink> itallistap = new ArrayList<>();

    static String[] italKiir()
    {
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
        return tartalom;
    }

    static void Napiforgalomital(List<Drink> itallistafoo)
    {
        List<Dailysale> forgalom = new ArrayList<>();
        try(DailysaleDAO dDao = new JpaDailysaleDAO();) {
            forgalom = dDao.getDailysale();
            if (forgalom.size() == 8) {

                Dailysale cocacola = new Dailysale();
                cocacola.setName("Coca cola");
                cocacola.setCount(0);
                forgalom.add(cocacola);

                Dailysale colalight = new Dailysale();
                colalight.setName("Cola light");
                colalight.setCount(0);
                forgalom.add(colalight);

                Dailysale fanta = new Dailysale();
                fanta.setName("Fanta");
                fanta.setCount(0);
                forgalom.add(fanta);

                Dailysale cappy = new Dailysale();
                cappy.setName("Cappy narancs");
                cappy.setCount(0);
                forgalom.add(cappy);

                Dailysale mentesviz = new Dailysale();
                mentesviz.setName("Szénsavmentes víz");
                mentesviz.setCount(0);
                forgalom.add(mentesviz);

                Dailysale savasviz = new Dailysale();
                savasviz.setName("Szénsavas víz");
                savasviz.setCount(0);
                forgalom.add(savasviz);

                Dailysale redbull = new Dailysale();
                redbull.setName("Redbull");
                redbull.setCount(0);
                forgalom.add(redbull);

                Dailysale heineken = new Dailysale();
                heineken.setName("Heineken");
                heineken.setCount(0);
                forgalom.add(heineken);

                Dailysale soproni = new Dailysale();
                soproni.setName("Soproni");
                soproni.setCount(0);
                forgalom.add(soproni);

                Dailysale dreher = new Dailysale();
                dreher.setName("Dreher");
                dreher.setCount(0);
                forgalom.add(dreher);
            }
            for (int i = 0; i < itallistafoo.size(); i++){
                for (int j = 0; j < forgalom.size(); j++){
                    if (forgalom.get(j).getName().equals(itallistafoo.get(i).getName())){
                        forgalom.get(j).setCount(forgalom.get(j).getCount() + count_ital(itallistafoo.get(i).getName()));
                    }
                }
            }
            for (Dailysale item:forgalom) {
                dDao.updateDailysale(item);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void kajaRendeles(int kajaindex, int darab){
        for (int i = 0; i < darab; i++)
        {
            kajalista.add(kajak.get(kajaindex));
        }

        FXMLScenes object = new FXMLScenes();
        Pane view = object.getPage("FXMLKosar");
        mainPane_static.getChildren().setAll(view);
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
        return tartalom;
    }

    static void Napiforgalomkaja(List<Food> kajalistafoo)
    {
        List<Dailysale> forgalom = new ArrayList<>();
        try(DailysaleDAO dDao = new JpaDailysaleDAO();){
            forgalom = dDao.getDailysale();

            if (forgalom.size() == 0)
            {
                Dailysale newyorkhotdogd = new Dailysale();
                newyorkhotdogd.setName("New York Hot Dog");
                newyorkhotdogd.setCount(0);
                forgalom.add(newyorkhotdogd);

                Dailysale chicagohotdogd = new Dailysale();
                chicagohotdogd.setName("Chicago Hot Dog");
                chicagohotdogd.setCount(0);
                forgalom.add(chicagohotdogd);

                Dailysale amsterdamhotdogd = new Dailysale();
                amsterdamhotdogd.setName("Amsterdam Hot Dog");
                amsterdamhotdogd.setCount(0);
                forgalom.add(amsterdamhotdogd);

                Dailysale debrecenihotdogd = new Dailysale();
                debrecenihotdogd.setName("Debreceni Hot Dog");
                debrecenihotdogd.setCount(0);
                forgalom.add(debrecenihotdogd);

                Dailysale athenhotdogd = new Dailysale();
                athenhotdogd.setName("Athén Hot Dog");
                athenhotdogd.setCount(0);
                forgalom.add(athenhotdogd);

                Dailysale tokiohotdogd = new Dailysale();
                tokiohotdogd.setName("Tokió Hot Dog");
                tokiohotdogd.setCount(0);
                forgalom.add(tokiohotdogd);

                Dailysale mexikohotdogd = new Dailysale();
                mexikohotdogd.setName("Mexikó Hot Dog");
                mexikohotdogd.setCount(0);
                forgalom.add(mexikohotdogd);

                Dailysale kijevhotdogd = new Dailysale();
                kijevhotdogd.setName("Kijev Hot Dog");
                kijevhotdogd.setCount(0);
                forgalom.add(kijevhotdogd);

            }
            for (int i = 0; i < kajalistafoo.size(); i++){
                for (int j = 0; j < forgalom.size(); j++){
                    if (forgalom.get(j).getName().equals(kajalistafoo.get(i).getName())){
                        forgalom.get(j).setCount(forgalom.get(j).getCount() + count_kaja(kajalistafoo.get(i).getName()));
                    }
                }
            }
            for (Dailysale item:forgalom) {
                dDao.updateDailysale(item);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
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
        Napiforgalomkaja(kajalistap);
        Napiforgalomital(itallistap);
        storage.updateStorage(raktar);
        basket_static.clear();
        kajalista.clear();
        kajalistap.clear();
        itallista.clear();
        itallistap.clear();
        italosszeg = 0;
        kajaosszeg = 0;
        FXMLScenes object = new FXMLScenes();
        Pane view = object.getPage("FXMLKapcsolat");
        mainPane_static.getChildren().setAll(view);
    }
}
