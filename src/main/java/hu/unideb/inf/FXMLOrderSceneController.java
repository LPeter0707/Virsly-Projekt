package hu.unideb.inf;

import hu.unideb.inf.model.JpaStorageDAO;
import hu.unideb.inf.model.Storage;
import hu.unideb.inf.model.StorageDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FXMLOrderSceneController {

    private ObservableList<Integer> valasztasok = FXCollections.observableArrayList(0,1,2,3,4,5);
    public List<ChoiceBox> cborder = new ArrayList<>();
    public HashMap<String, ChoiceBox<Integer>> Arufeltoltes = new HashMap<String, ChoiceBox<Integer>>();

    @FXML
    private ChoiceBox<Integer> kifliCB;

    @FXML
    private ChoiceBox<Integer> virsliCB;

    @FXML
    private ChoiceBox<Integer> grillkolbaszCB;

    @FXML
    private ChoiceBox<Integer> debreceniparosCB;

    @FXML
    private ChoiceBox<Integer> kacsakolbaszCB;

    @FXML
    private ChoiceBox<Integer> mangalicahurkaCB;

    @FXML
    private ChoiceBox<Integer> baranymarhakolbaszCB;

    @FXML
    private ChoiceBox<Integer> cheddarCB;

    @FXML
    private ChoiceBox<Integer> piritotthagymaCB;

    @FXML
    private ChoiceBox<Integer> tortillachipsCB;

    @FXML
    private ChoiceBox<Integer> baconCB;

    @FXML
    private ChoiceBox<Integer> uborkaCB;

    @FXML
    private ChoiceBox<Integer> sushigyomberCB;

    @FXML
    private ChoiceBox<Integer> jalapenoCB;

    @FXML
    private ChoiceBox<Integer> paradicsomCB;

    @FXML
    private ChoiceBox<Integer> fetaCB;

    @FXML
    private ChoiceBox<Integer> hagymaCB;

    @FXML
    private ChoiceBox<Integer> kukoricaCB;

    @FXML
    private ChoiceBox<Integer> babCB;

    @FXML
    private ChoiceBox<Integer> mexikoisalsaCB;

    @FXML
    private ChoiceBox<Integer> zoldsegmixCB;

    @FXML
    private ChoiceBox<Integer> ketchupCB;

    @FXML
    private ChoiceBox<Integer> majonezCB;

    @FXML
    private ChoiceBox<Integer> mustarCB;

    @FXML
    private ChoiceBox<Integer> szojaszoszCB;

    @FXML
    private ChoiceBox<Integer> magyaroskremCB;

    @FXML
    private ChoiceBox<Integer> padlizsankremCB;

    @FXML
    private ChoiceBox<Integer> wasabiCB;

    @FXML
    private ChoiceBox<Integer> cocaCB;

    @FXML
    private ChoiceBox<Integer> colaliteCB;

    @FXML
    private ChoiceBox<Integer> fantaCB;

    @FXML
    private ChoiceBox<Integer> cappyCB;

    @FXML
    private ChoiceBox<Integer> mentesvizCB;

    @FXML
    private ChoiceBox<Integer> savasvizCB;

    @FXML
    private ChoiceBox<Integer> redbullCB;

    @FXML
    private ChoiceBox<Integer> heinekenCB;

    @FXML
    private ChoiceBox<Integer> soproniCB;

    @FXML
    private ChoiceBox<Integer> dreherCB;


    @FXML
    private Button buttonBack;

    @FXML
    private Button addElement;

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

        kifliCB.setValue(0);
        kifliCB.setItems(valasztasok);
        //Arufeltoltes.put("Hot Dog kifli", kifliCB);
        cborder.add(kifliCB);

        virsliCB.setValue(0);
        virsliCB.setItems(valasztasok);
        //Arufeltoltes.put("Virsli", virsliCB);
        cborder.add(virsliCB);

        grillkolbaszCB.setValue(0);
        grillkolbaszCB.setItems(valasztasok);
        //Arufeltoltes.put("Grillkolbász", grillkolbaszCB);
        cborder.add(grillkolbaszCB);

        debreceniparosCB.setValue(0);
        debreceniparosCB.setItems(valasztasok);
        //Arufeltoltes.put("Debreceni páros", debreceniparosCB);
        cborder.add(debreceniparosCB);

        kacsakolbaszCB.setValue(0);
        kacsakolbaszCB.setItems(valasztasok);
        //Arufeltoltes.put("Kacsa kolbász", kacsakolbaszCB);
        cborder.add(kacsakolbaszCB);

        mangalicahurkaCB.setValue(0);
        mangalicahurkaCB.setItems(valasztasok);
        //Arufeltoltes.put("Mangalica hurka", mangalicahurkaCB);
        cborder.add(mangalicahurkaCB);

        baranymarhakolbaszCB.setValue(0);
        baranymarhakolbaszCB.setItems(valasztasok);
        //Arufeltoltes.put("Bárány-marha kolbász", baranymarhakolbaszCB);
        cborder.add(baranymarhakolbaszCB);

        cheddarCB.setValue(0);
        cheddarCB.setItems(valasztasok);
        //Arufeltoltes.put("Cheddar szósz", cheddarCB);
        cborder.add(cheddarCB);

        piritotthagymaCB.setValue(0);
        piritotthagymaCB.setItems(valasztasok);
        //Arufeltoltes.put("Pirított hagyma", piritotthagymaCB);
        cborder.add(piritotthagymaCB);

        tortillachipsCB.setValue(0);
        tortillachipsCB.setItems(valasztasok);
        //Arufeltoltes.put("Tortilla chips", tortillachipsCB);
        cborder.add(tortillachipsCB);

        baconCB.setValue(0);
        baconCB.setItems(valasztasok);
        //Arufeltoltes.put("Bacon", baconCB);
        cborder.add(baconCB);

        uborkaCB.setValue(0);
        uborkaCB.setItems(valasztasok);
        //Arufeltoltes.put("Uborka", uborkaCB);
        cborder.add(uborkaCB);

        sushigyomberCB.setValue(0);
        sushigyomberCB.setItems(valasztasok);
        //Arufeltoltes.put("Sushi gyömbér", sushigyomberCB);
        cborder.add(sushigyomberCB);

        jalapenoCB.setValue(0);
        jalapenoCB.setItems(valasztasok);
        //Arufeltoltes.put("Jalapeno", jalapenoCB);
        cborder.add(jalapenoCB);

        paradicsomCB.setValue(0);
        paradicsomCB.setItems(valasztasok);
        //Arufeltoltes.put("Paradicsom", paradicsomCB);
        cborder.add(paradicsomCB);

        fetaCB.setValue(0);
        fetaCB.setItems(valasztasok);
        //Arufeltoltes.put("Feta", fetaCB);
        cborder.add(fetaCB);

        hagymaCB.setValue(0);
        hagymaCB.setItems(valasztasok);
        //Arufeltoltes.put("Hagyma", hagymaCB);
        cborder.add(hagymaCB);

        kukoricaCB.setValue(0);
        kukoricaCB.setItems(valasztasok);
        //Arufeltoltes.put("Kukorica", kukoricaCB);
        cborder.add(kukoricaCB);

        babCB.setValue(0);
        babCB.setItems(valasztasok);
        //Arufeltoltes.put("Bab", babCB);
        cborder.add(babCB);

        mexikoisalsaCB.setValue(0);
        mexikoisalsaCB.setItems(valasztasok);
        //Arufeltoltes.put("Mexikói salsa", mexikoisalsaCB);
        cborder.add(mexikoisalsaCB);

        zoldsegmixCB.setValue(0);
        zoldsegmixCB.setItems(valasztasok);
        //Arufeltoltes.put("Házi zöldség mix", zoldsegmixCB);
        cborder.add(zoldsegmixCB);

        ketchupCB.setValue(0);
        ketchupCB.setItems(valasztasok);
        //Arufeltoltes.put("Ketchup", ketchupCB);
        cborder.add(ketchupCB);

        majonezCB.setValue(0);
        majonezCB.setItems(valasztasok);
        //Arufeltoltes.put("Majonéz", majonezCB);
        cborder.add(majonezCB);

        mustarCB.setValue(0);
        mustarCB.setItems(valasztasok);
        //Arufeltoltes.put("Mustár", mustarCB);
        cborder.add(mustarCB);

        szojaszoszCB.setValue(0);
        szojaszoszCB.setItems(valasztasok);
        //Arufeltoltes.put("Szoja szósz", szojaszoszCB);
        cborder.add(szojaszoszCB);

        magyaroskremCB.setValue(0);
        magyaroskremCB.setItems(valasztasok);
        //Arufeltoltes.put("Magyaros krém", magyaroskremCB);
        cborder.add(magyaroskremCB);

        padlizsankremCB.setValue(0);
        padlizsankremCB.setItems(valasztasok);
        //Arufeltoltes.put("Padlizsankrém", padlizsankremCB);
        cborder.add(padlizsankremCB);

        wasabiCB.setValue(0);
        wasabiCB.setItems(valasztasok);
        //Arufeltoltes.put("Wasabi", wasabiCB);
        cborder.add(wasabiCB);

        cocaCB.setValue(0);
        cocaCB.setItems(valasztasok);
        //Arufeltoltes.put("Coca cola", cocaCB);
        cborder.add(cocaCB);

        colaliteCB.setValue(0);
        colaliteCB.setItems(valasztasok);
        //Arufeltoltes.put("Cola light", colaliteCB);
        cborder.add(colaliteCB);

        fantaCB.setValue(0);
        fantaCB.setItems(valasztasok);
        //Arufeltoltes.put("Fanta", fantaCB);
        cborder.add(fantaCB);

        cappyCB.setValue(0);
        cappyCB.setItems(valasztasok);
        //Arufeltoltes.put("Cappy narancs", cappyCB);
        cborder.add(cappyCB);

        mentesvizCB.setValue(0);
        mentesvizCB.setItems(valasztasok);
        //Arufeltoltes.put("Szénsavmentes víz", mentesvizCB);
        cborder.add(mentesvizCB);

        savasvizCB.setValue(0);
        savasvizCB.setItems(valasztasok);
        //Arufeltoltes.put("Szénsavas víz", savasvizCB);
        cborder.add(savasvizCB);

        redbullCB.setValue(0);
        redbullCB.setItems(valasztasok);
        //Arufeltoltes.put("Redbull", redbullCB);
        cborder.add(redbullCB);

        heinekenCB.setValue(0);
        heinekenCB.setItems(valasztasok);
        //Arufeltoltes.put("Heineken", heinekenCB);
        cborder.add(heinekenCB);

        soproniCB.setValue(0);
        soproniCB.setItems(valasztasok);
        //Arufeltoltes.put("Soproni", soproniCB);
        cborder.add(soproniCB);

        dreherCB.setValue(0);
        dreherCB.setItems(valasztasok);
        //Arufeltoltes.put("Dreher", dreherCB);
        cborder.add(dreherCB);

    }

    @FXML
    void addElementPushed(ActionEvent event) throws IOException {
        StorageDao sDao = new JpaStorageDAO();
        List<Storage> aru = sDao.getStorage();
        for (int i = 0; i < aru.size(); i++){
            if ((int)cborder.get(i).getValue() != 0){
                aru.get(i).setPiece(aru.get(i).getPiece() + (int)cborder.get(i).getValue());
            }
        }

        sDao.updateStorage(aru);
    }


}
