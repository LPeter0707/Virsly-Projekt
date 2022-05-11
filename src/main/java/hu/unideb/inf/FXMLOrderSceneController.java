package hu.unideb.inf;

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
import java.util.List;

public class FXMLOrderSceneController {

    private ObservableList<Integer> valasztasok = FXCollections.observableArrayList(0,1,2,3,4,5);
    public List<ChoiceBox> cborder = new ArrayList<>();

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
        cborder.add(kifliCB);

        virsliCB.setValue(0);
        virsliCB.setItems(valasztasok);
        cborder.add(kifliCB);

        grillkolbaszCB.setValue(0);
        grillkolbaszCB.setItems(valasztasok);
        cborder.add(grillkolbaszCB);

        debreceniparosCB.setValue(0);
        debreceniparosCB.setItems(valasztasok);
        cborder.add(debreceniparosCB);

        kacsakolbaszCB.setValue(0);
        kacsakolbaszCB.setItems(valasztasok);
        cborder.add(kacsakolbaszCB);

        mangalicahurkaCB.setValue(0);
        mangalicahurkaCB.setItems(valasztasok);
        cborder.add(mangalicahurkaCB);

        baranymarhakolbaszCB.setValue(0);
        baranymarhakolbaszCB.setItems(valasztasok);
        cborder.add(baranymarhakolbaszCB);

        cheddarCB.setValue(0);
        cheddarCB.setItems(valasztasok);
        cborder.add(cheddarCB);

        piritotthagymaCB.setValue(0);
        piritotthagymaCB.setItems(valasztasok);
        cborder.add(piritotthagymaCB);

        tortillachipsCB.setValue(0);
        tortillachipsCB.setItems(valasztasok);
        cborder.add(tortillachipsCB);

        baconCB.setValue(0);
        baconCB.setItems(valasztasok);
        cborder.add(baconCB);

        uborkaCB.setValue(0);
        uborkaCB.setItems(valasztasok);
        cborder.add(uborkaCB);

        sushigyomberCB.setValue(0);
        sushigyomberCB.setItems(valasztasok);
        cborder.add(sushigyomberCB);

        jalapenoCB.setValue(0);
        jalapenoCB.setItems(valasztasok);
        cborder.add(jalapenoCB);

        paradicsomCB.setValue(0);
        paradicsomCB.setItems(valasztasok);
        cborder.add(paradicsomCB);

        fetaCB.setValue(0);
        fetaCB.setItems(valasztasok);
        cborder.add(fetaCB);

        hagymaCB.setValue(0);
        hagymaCB.setItems(valasztasok);
        cborder.add(hagymaCB);

        kukoricaCB.setValue(0);
        kukoricaCB.setItems(valasztasok);
        cborder.add(kukoricaCB);

        babCB.setValue(0);
        babCB.setItems(valasztasok);
        cborder.add(babCB);

        mexikoisalsaCB.setValue(0);
        mexikoisalsaCB.setItems(valasztasok);
        cborder.add(mexikoisalsaCB);

        zoldsegmixCB.setValue(0);
        zoldsegmixCB.setItems(valasztasok);
        cborder.add(zoldsegmixCB);

        ketchupCB.setValue(0);
        ketchupCB.setItems(valasztasok);
        cborder.add(ketchupCB);

        majonezCB.setValue(0);
        majonezCB.setItems(valasztasok);
        cborder.add(majonezCB);

        mustarCB.setValue(0);
        mustarCB.setItems(valasztasok);
        cborder.add(mustarCB);

        szojaszoszCB.setValue(0);
        szojaszoszCB.setItems(valasztasok);
        cborder.add(szojaszoszCB);

        magyaroskremCB.setValue(0);
        magyaroskremCB.setItems(valasztasok);
        cborder.add(magyaroskremCB);

        padlizsankremCB.setValue(0);
        padlizsankremCB.setItems(valasztasok);
        cborder.add(padlizsankremCB);

        wasabiCB.setValue(0);
        wasabiCB.setItems(valasztasok);
        cborder.add(wasabiCB);

        cocaCB.setValue(0);
        cocaCB.setItems(valasztasok);
        cborder.add(cocaCB);

        colaliteCB.setValue(0);
        colaliteCB.setItems(valasztasok);
        cborder.add(colaliteCB);

        fantaCB.setValue(0);
        fantaCB.setItems(valasztasok);
        cborder.add(fantaCB);

        cappyCB.setValue(0);
        cappyCB.setItems(valasztasok);
        cborder.add(cappyCB);

        mentesvizCB.setValue(0);
        mentesvizCB.setItems(valasztasok);
        cborder.add(mentesvizCB);

        savasvizCB.setValue(0);
        savasvizCB.setItems(valasztasok);
        cborder.add(savasvizCB);

        redbullCB.setValue(0);
        redbullCB.setItems(valasztasok);
        cborder.add(redbullCB);

        heinekenCB.setValue(0);
        heinekenCB.setItems(valasztasok);
        cborder.add(heinekenCB);

        soproniCB.setValue(0);
        soproniCB.setItems(valasztasok);
        cborder.add(soproniCB);

        dreherCB.setValue(0);
        dreherCB.setItems(valasztasok);
        cborder.add(dreherCB);

    }

    @FXML
    void addElementPushed(ActionEvent event) throws IOException {

    }


}
