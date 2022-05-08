package hu.unideb.inf;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FXMLMenuSceneController {

    private ObservableList<Integer> valasztasok = FXCollections.observableArrayList(0,1,2,3,4,5);
    public List<ChoiceBox> cb = new ArrayList<>();

    @FXML
    private ChoiceBox<Integer> kaja1;

    @FXML
    private ChoiceBox<Integer> kaja2;

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

    ///////////////////Drink//////////////////////

    //Coca Cola
    @FXML
    private Label cocacolaName;
    public static Label cocacolaName_static;

    @FXML
    private Label cocacolaPrice;
    public static Label cocacolaPrice_static;

    //Coca Lite
    @FXML
    private Label colaliteName;
    public static Label colaliteName_static;

    @FXML
    private Label colalitePrice;
    public static Label colalitePrice_static;

    //Fanta
    @FXML
    private Label fantaName;
    public static Label fantaName_static;

    @FXML
    private Label fantaPrice;
    public static Label fantaPrice_static;

    //Cappy Narancs
    @FXML
    private Label cappynName;
    public static Label cappynName_static;

    @FXML
    private Label cappynPrice;
    public static Label cappynPrice_static;

    //Szénsavmentesvíz
    @FXML
    private Label mentesvizName;
    public static Label mentesvizName_static;

    @FXML
    private Label mentesvizPrice;
    public static Label mentesvizPrice_static;

    //Szénsavasvíz
    @FXML
    private Label savasvizName;
    public static Label savasvizName_static;

    @FXML
    private Label savasvizPrice;
    public static Label savasvizPrice_static;

    //Redbull
    @FXML
    private Label redbullName;
    public static Label redbullName_static;

    @FXML
    private Label redbullPrice;
    public static Label redbullPrice_static;

    //Heineken
    @FXML
    private Label heinekenName;
    public static Label heinekenName_static;

    @FXML
    private Label heinekenPrice;
    public static Label heinekenPrice_static;

    //Soproni
    @FXML
    private Label soproniName;
    public static Label soproniName_static;

    @FXML
    private Label soproniPrice;
    public static Label soproniPrice_static;

    //Dreher
    @FXML
    private Label dreherName;
    public static Label dreherName_static;

    @FXML
    private Label dreherPrice;
    public static Label dreherPrice_static;



    @FXML
    public void initialize(){

        kaja1.setValue(0);
        kaja1.setItems(valasztasok);
        cb.add(kaja1);

        kaja2.setValue(0);
        kaja2.setItems(valasztasok);
        cb.add(kaja2);

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
    void orderPushed(ActionEvent event) throws IOException {
        for (int i = 0; i < cb.size(); i++)
        {
            if ((int)(cb.get(i)).getValue() != 0)
            {
                int darab = (int)(cb.get(i)).getValue();
                //System.out.println((int)(cb.get(i)).getValue());
                /*System.out.println(darab);
                System.out.println(i);*/
                FXMLBasketSceneController.Rendeles(i,darab);
            }

        }
    }
}
