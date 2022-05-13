package hu.unideb.inf;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FXMLMenuSceneController {

    private ObservableList<Integer> valasztasok = FXCollections.observableArrayList(0,1,2,3,4,5);
    public List<ChoiceBox> cbkaja = new ArrayList<>();
    public List<ChoiceBox> cbital = new ArrayList<>();

    @FXML
    private Button buttonOrder;

    ///////////////////Food//////////////////////

    //New York Hot Dog
    @FXML
    private Label nyhdName;
    public static Label nyhdName_static;

    @FXML
    private Label nyhdPrice;
    public static Label nyhdPrice_static;

    @FXML
    private Label nyhdList;
    public static Label nyhdList_static;

    @FXML
    private ChoiceBox<Integer> nyhdCB;

    //Chicago Hot Dog
    @FXML
    private Label chdName;
    public static Label chdName_static;

    @FXML
    private Label chdPrice;
    public static Label chdPrice_static;

    @FXML
    private Label chdList;
    public static Label chdList_static;

    @FXML
    private ChoiceBox<Integer> chdCB;

    //Amsterdam Hot Dog
    @FXML
    private Label ahdName;
    public static Label ahdName_static;

    @FXML
    private Label ahdPrice;
    public static Label ahdPrice_static;

    @FXML
    private Label ahdList;
    public static Label ahdList_static;

    @FXML
    private ChoiceBox<Integer> ahdCB;

    //Debreceni Hot Dog
    @FXML
    private Label dhdName;
    public static Label dhdName_static;

    @FXML
    private Label dhdPrice;
    public static Label dhdPrice_static;

    @FXML
    private Label dhdList;
    public static Label dhdList_static;

    @FXML
    private ChoiceBox<Integer> dhdCB;

    //Athén Hot Dog
    @FXML
    private Label athdName;
    public static Label athdName_static;

    @FXML
    private Label athdPrice;
    public static Label athdPrice_static;

    @FXML
    private Label athdList;
    public static Label athdList_static;

    @FXML
    private ChoiceBox<Integer> athdCB;

    //Tokió Hot Dog
    @FXML
    private Label thdName;
    public static Label thdName_static;

    @FXML
    private Label thdPrice;
    public static Label thdPrice_static;

    @FXML
    private Label thdList;
    public static Label thdList_static;

    @FXML
    private ChoiceBox<Integer> thdCB;

    //Mexikó Hot Dog
    @FXML
    private Label mhdName;
    public static Label mhdName_static;

    @FXML
    private Label mhdPrice;
    public static Label mhdPrice_static;

    @FXML
    private Label mhdList;
    public static Label mhdList_static;

    @FXML
    private ChoiceBox<Integer> mhdCB;

    //Kijev Hot Dog
    @FXML
    private Label khdName;
    public static Label khdName_static;

    @FXML
    private Label khdPrice;
    public static Label khdPrice_static;

    @FXML
    private Label khdList;
    public static Label khdList_static;

    @FXML
    private ChoiceBox<Integer> khdCB;

    ///////////////////Drink//////////////////////

    //Coca Cola
    @FXML
    private Label cocacolaName;
    public static Label cocacolaName_static;

    @FXML
    private Label cocacolaPrice;
    public static Label cocacolaPrice_static;

    @FXML
    private ChoiceBox<Integer> cocacolaCB;

    //Coca Lite
    @FXML
    private Label colaliteName;
    public static Label colaliteName_static;

    @FXML
    private Label colalitePrice;
    public static Label colalitePrice_static;

    @FXML
    private ChoiceBox<Integer> colalightCB;

    //Fanta
    @FXML
    private Label fantaName;
    public static Label fantaName_static;

    @FXML
    private Label fantaPrice;
    public static Label fantaPrice_static;

    @FXML
    private ChoiceBox<Integer> fantaCB;

    //Cappy Narancs
    @FXML
    private Label cappynName;
    public static Label cappynName_static;

    @FXML
    private Label cappynPrice;
    public static Label cappynPrice_static;

    @FXML
    private ChoiceBox<Integer> cappynCB;

    //Szénsavmentesvíz
    @FXML
    private Label mentesvizName;
    public static Label mentesvizName_static;

    @FXML
    private Label mentesvizPrice;
    public static Label mentesvizPrice_static;

    @FXML
    private ChoiceBox<Integer> mentesvizCB;

    //Szénsavasvíz
    @FXML
    private Label savasvizName;
    public static Label savasvizName_static;

    @FXML
    private Label savasvizPrice;
    public static Label savasvizPrice_static;

    @FXML
    private ChoiceBox<Integer> savasvizCB;

    //Redbull
    @FXML
    private Label redbullName;
    public static Label redbullName_static;

    @FXML
    private Label redbullPrice;
    public static Label redbullPrice_static;

    @FXML
    private ChoiceBox<Integer> redbullCB;

    //Heineken
    @FXML
    private Label heinekenName;
    public static Label heinekenName_static;

    @FXML
    private Label heinekenPrice;
    public static Label heinekenPrice_static;

    @FXML
    private ChoiceBox<Integer> heinekenCB;

    //Soproni
    @FXML
    private Label soproniName;
    public static Label soproniName_static;

    @FXML
    private Label soproniPrice;
    public static Label soproniPrice_static;

    @FXML
    private ChoiceBox<Integer> soproniCB;

    //Dreher
    @FXML
    private Label dreherName;
    public static Label dreherName_static;

    @FXML
    private Label dreherPrice;
    public static Label dreherPrice_static;

    @FXML
    private ChoiceBox<Integer> dreherCB;



    @FXML
    public void initialize(){

        nyhdCB.setValue(0);
        nyhdCB.setItems(valasztasok);
        cbkaja.add(nyhdCB);

        chdCB.setValue(0);
        chdCB.setItems(valasztasok);
        cbkaja.add(chdCB);

        ahdCB.setValue(0);
        ahdCB.setItems(valasztasok);
        cbkaja.add(ahdCB);

        dhdCB.setValue(0);
        dhdCB.setItems(valasztasok);
        cbkaja.add(dhdCB);

        athdCB.setValue(0);
        athdCB.setItems(valasztasok);
        cbkaja.add(athdCB);

        thdCB.setValue(0);
        thdCB.setItems(valasztasok);
        cbkaja.add(thdCB);

        mhdCB.setValue(0);
        mhdCB.setItems(valasztasok);
        cbkaja.add(mhdCB);

        khdCB.setValue(0);
        khdCB.setItems(valasztasok);
        cbkaja.add(khdCB);

        cocacolaCB.setValue(0);
        cocacolaCB.setItems(valasztasok);
        cbital.add(cocacolaCB);

        colalightCB.setValue(0);
        colalightCB.setItems(valasztasok);
        cbital.add(colalightCB);

        fantaCB.setValue(0);
        fantaCB.setItems(valasztasok);
        cbital.add(fantaCB);

        cappynCB.setValue(0);
        cappynCB.setItems(valasztasok);
        cbital.add(cappynCB);

        mentesvizCB.setValue(0);
        mentesvizCB.setItems(valasztasok);
        cbital.add(mentesvizCB);

        savasvizCB.setValue(0);
        savasvizCB.setItems(valasztasok);
        cbital.add(savasvizCB);

        redbullCB.setValue(0);
        redbullCB.setItems(valasztasok);
        cbital.add(redbullCB);

        heinekenCB.setValue(0);
        heinekenCB.setItems(valasztasok);
        cbital.add(heinekenCB);

        soproniCB.setValue(0);
        soproniCB.setItems(valasztasok);
        cbital.add(soproniCB);

        dreherCB.setValue(0);
        dreherCB.setItems(valasztasok);
        cbital.add(dreherCB);

        //Food
        nyhdName_static = nyhdName;
        nyhdPrice_static = nyhdPrice;
        nyhdList_static = nyhdList;

        chdName_static = chdName;
        chdPrice_static = chdPrice;
        chdList_static = chdList;

        ahdName_static = ahdName;
        ahdPrice_static = ahdPrice;
        ahdList_static = ahdList;

        dhdName_static = dhdName;
        dhdPrice_static = dhdPrice;
        dhdList_static = dhdList;

        athdName_static = athdName;
        athdPrice_static = athdPrice;
        athdList_static = athdList;

        thdName_static = thdName;
        thdPrice_static = thdPrice;
        thdList_static = thdList;

        mhdName_static = mhdName;
        mhdPrice_static = mhdPrice;
        mhdList_static = mhdList;

        khdName_static = khdName;
        khdPrice_static = khdPrice;
        khdList_static = khdList;

        //Drink
        cocacolaName_static = cocacolaName;
        cocacolaPrice_static = cocacolaPrice;

        colaliteName_static = colaliteName;
        colalitePrice_static = colalitePrice;

        fantaName_static = fantaName;
        fantaPrice_static = fantaPrice;

        cappynName_static = cappynName;
        cappynPrice_static = cappynPrice;

        mentesvizName_static = mentesvizName;
        mentesvizPrice_static = mentesvizPrice;

        savasvizName_static = savasvizName;
        savasvizPrice_static = savasvizPrice;

        redbullName_static = redbullName;
        redbullPrice_static = redbullPrice;

        heinekenName_static = heinekenName;
        heinekenPrice_static = heinekenPrice;

        soproniName_static = soproniName;
        soproniPrice_static = soproniPrice;

        dreherName_static = dreherName;
        dreherPrice_static = dreherPrice;
    }

    @FXML
    void orderPushed(ActionEvent event) throws IOException, SQLException {
        for (int i = 0; i < cbkaja.size(); i++)
        {
            if ((int)(cbkaja.get(i)).getValue() != 0)
            {
                int darab = (int)(cbkaja.get(i)).getValue();
                FXMLBasketSceneController.kajaRendeles(i,darab);
            }
        }
        Stage stage = new Stage();
        stage.setTitle("Virsly");
        Image image = new Image("/icon/icon_user.png");
        stage.getIcons().add(image);
        for (int j = 0; j < cbital.size(); j++)
        {
            if ((int)(cbital.get(j)).getValue() != 0)
            {
                int darab = (int)(cbital.get(j)).getValue();
                FXMLBasketSceneController.italRendeles(j,darab);
            }

        }
        FXMLBasketSceneController.Kiir();
        FXMLBasketSceneController.OsszegKiir();
    }
}
