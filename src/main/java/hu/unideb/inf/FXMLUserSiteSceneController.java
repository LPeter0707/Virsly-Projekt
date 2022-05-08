package hu.unideb.inf;

import hu.unideb.inf.model.Drink;
import hu.unideb.inf.model.Food;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FXMLUserSiteSceneController {

    public static List<Food> kajak = new ArrayList<>();

    @FXML
    private AnchorPane mainPane;
    public static AnchorPane mainPane_static;

    @FXML
    private Button buttonVissza;

    @FXML
    private Label username;
    public static Label username_static;

    @FXML
    public void initialize(){
        username_static = username;
        mainPane_static = mainPane;
    }

    @FXML
    void menuPushed(ActionEvent event) throws IOException {
        FXMLScenes object = new FXMLScenes();
        Pane view = object.getPage("FXMLMenu");
        mainPane.getChildren().setAll(view);
        GridpaneFood();
        GridpaneDrink();
    }

    @FXML
    void kosarPushed(ActionEvent event) throws IOException {
        FXMLScenes object = new FXMLScenes();
        Pane view = object.getPage("FXMLKosar");
        mainPane.getChildren().setAll(view);
    }

    @FXML
    void kapcsolatPushed(ActionEvent event) throws IOException {
        FXMLScenes object = new FXMLScenes();
        Pane view = object.getPage("FXMLKapcsolat");
        mainPane.getChildren().setAll(view);
    }

    @FXML
    void VisszaPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLUserSite.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                buttonVissza.getScene().getWindow();
        stage2.close();
        stage.setTitle("LoginUser");
        stage.setScene(scene);
        stage.show();
    }

    public void GridpaneFood()
    {
        Food newyorkhotdog = new Food("New York Hot Dog", List.of("hot dog kifli, virsli, cheddar szósz, pirított hagyma, ketchup, majonéz"), 1100);
        kajak.add(newyorkhotdog);
        FXMLMenuSceneController.nyhdName_static.setText(newyorkhotdog.getName());
        FXMLMenuSceneController.nyhdPrice_static.setText("" + newyorkhotdog.getPrice());
        FXMLMenuSceneController.nyhdList_static.setText(("" + newyorkhotdog.getList()).substring(1, ("" + newyorkhotdog.getList()).length() - 1));

        Food chicagohotdog = new Food("Chicago Hot Dog", List.of("hot dog kifli, grill kolbász, mustár, pirított hagyma, uborka, jalapeno"), 1300);
        kajak.add(chicagohotdog);
        FXMLMenuSceneController.chdName_static.setText(chicagohotdog.getName());
        FXMLMenuSceneController.chdPrice_static.setText("" + chicagohotdog.getPrice());
        FXMLMenuSceneController.chdList_static.setText(("" + chicagohotdog.getList()).substring(1, ("" + chicagohotdog.getList()).length() - 1));

        Food amsterdamhotdog = new Food("Amsterdam Hot Dog", List.of("hot dog kifli, virsli, paradicsom, házi zöldség mix, majonéz, ketchup, mustár"), 1450);
        FXMLMenuSceneController.ahdName_static.setText(amsterdamhotdog.getName());
        FXMLMenuSceneController.ahdPrice_static.setText("" + amsterdamhotdog.getPrice());
        FXMLMenuSceneController.ahdList_static.setText(("" + amsterdamhotdog.getList()).substring(1, ("" + amsterdamhotdog.getList()).length() - 1));

        Food debrecenihotdog = new Food("Debreceni Hot Dog", List.of("hot dog kifli, debreceni páros, bacon, paradicsom, pirított hagyma, magyaroskrém"), 1300);
        FXMLMenuSceneController.dhdName_static.setText(debrecenihotdog.getName());
        FXMLMenuSceneController.dhdPrice_static.setText("" + debrecenihotdog.getPrice());
        FXMLMenuSceneController.dhdList_static.setText(("" + debrecenihotdog.getList()).substring(1, ("" + debrecenihotdog.getList()).length() - 1));

        Food athenhotdog = new Food("Athén Hot Dog", List.of("hot dog kifli, bárány-marha kolbász, padlizsánkrém, feta, paradicsom, hagyma, uborka"), 1100);
        FXMLMenuSceneController.athdName_static.setText(athenhotdog.getName());
        FXMLMenuSceneController.athdPrice_static.setText("" + athenhotdog.getPrice());
        FXMLMenuSceneController.athdList_static.setText(("" + athenhotdog.getList()).substring(1, ("" + athenhotdog.getList()).length() - 1));

        Food tokiohotdog = new Food("Tokió Hot Dog", List.of("hot dog kifli, kacsa kolbász, sushi gyömbér, wasabi, pirított hagyma, szója szósz"), 1550);
        FXMLMenuSceneController.thdName_static.setText(tokiohotdog.getName());
        FXMLMenuSceneController.thdPrice_static.setText("" + tokiohotdog.getPrice());
        FXMLMenuSceneController.thdList_static.setText(("" + tokiohotdog.getList()).substring(1, ("" + tokiohotdog.getList()).length() - 1));

        Food mexikohotdog = new Food("Mexikó Hot Dog", List.of("hot dog kifli, virsli, jalapeno, kukorica, bab, mexikói salsa, tortilla chips"), 1550);
        FXMLMenuSceneController.mhdName_static.setText(mexikohotdog.getName());
        FXMLMenuSceneController.mhdPrice_static.setText("" + mexikohotdog.getPrice());
        FXMLMenuSceneController.mhdList_static.setText(("" + mexikohotdog.getList()).substring(1, ("" + mexikohotdog.getList()).length() - 1));

        Food kijevhotdog = new Food("Kijev Hot Dog", List.of("hot dog kifli, mangalica hurka, majonéz, mustár, jalapeno, uborka "), 1100);
        FXMLMenuSceneController.khdName_static.setText(kijevhotdog.getName());
        FXMLMenuSceneController.khdPrice_static.setText("" + kijevhotdog.getPrice());
        FXMLMenuSceneController.khdList_static.setText(("" + kijevhotdog.getList()).substring(1, ("" + kijevhotdog.getList()).length() - 1));
    }

    private void GridpaneDrink()
    {
        Drink cocacola = new Drink("Coca Cola 0.5l", 450);
        FXMLMenuSceneController.cocacolaName_static.setText(cocacola.getName());
        FXMLMenuSceneController.cocacolaPrice_static.setText("" + cocacola.getPrice());

        Drink colalite = new Drink("Cola light 0.5l", 450);
        FXMLMenuSceneController.colaliteName_static.setText(colalite.getName());
        FXMLMenuSceneController.colalitePrice_static.setText("" + colalite.getPrice());

        Drink fanta = new Drink("Fanta 0.5l", 450);
        FXMLMenuSceneController.fantaName_static.setText(fanta.getName());
        FXMLMenuSceneController.fantaPrice_static.setText("" + fanta.getPrice());

        Drink cappynarancs = new Drink("Cappy Narancs 0.5l", 450);
        FXMLMenuSceneController.cappynName_static.setText(cappynarancs.getName());
        FXMLMenuSceneController.cappynPrice_static.setText("" + cappynarancs.getPrice());

        Drink szensavmentesviz = new Drink("Szénsavmentes víz 0.5l", 300);
        FXMLMenuSceneController.mentesvizName_static.setText(szensavmentesviz.getName());
        FXMLMenuSceneController.mentesvizPrice_static.setText("" + szensavmentesviz.getPrice());

        Drink szensavasviz = new Drink("Szénsavas víz 0.5l", 300);
        FXMLMenuSceneController.savasvizName_static.setText(szensavasviz.getName());
        FXMLMenuSceneController.savasvizPrice_static.setText("" + szensavasviz.getPrice());

        Drink redbull = new Drink("Redbull 0.25l", 600);
        FXMLMenuSceneController.redbullName_static.setText(redbull.getName());
        FXMLMenuSceneController.redbullPrice_static.setText("" + redbull.getPrice());

        Drink heineken = new Drink("Heineken 0.33l", 500);
        FXMLMenuSceneController.heinekenName_static.setText(heineken.getName());
        FXMLMenuSceneController.heinekenPrice_static.setText("" + heineken.getPrice());

        Drink soproni = new Drink("Soproni 0.5l", 690);
        FXMLMenuSceneController.soproniName_static.setText(soproni.getName());
        FXMLMenuSceneController.soproniPrice_static.setText("" + soproni.getPrice());

        Drink dreher = new Drink("Dreher 0.5l", 690);
        FXMLMenuSceneController.dreherName_static.setText(dreher.getName());
        FXMLMenuSceneController.dreherPrice_static.setText("" + dreher.getPrice());
    }
}
