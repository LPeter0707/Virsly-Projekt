package hu.unideb.inf;

import hu.unideb.inf.model.Drink;
import hu.unideb.inf.model.Food;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FXMLUserSiteSceneController {

    public static List<Food> kajak = new ArrayList<>();
    public static List<Drink> italok = new ArrayList<>();

    @FXML
    private AnchorPane mainPane;
    public static AnchorPane mainPane_static;

    @FXML
    private Button buttonVissza;

    @FXML
    private Label name;
    public static Label name_static;

    @FXML
    public void initialize(){
        name_static = name;
        mainPane_static = mainPane;
    }

    @FXML
    void menuPushed(ActionEvent event) throws IOException {
        FXMLScenes object = new FXMLScenes();
        Stage stage = new Stage();
        stage.setTitle("Virsly");
        Image image = new Image("/icon/icon_user.png");
        stage.getIcons().add(image);
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
        Stage stage = new Stage();
        stage.setTitle("Virsly");
        Image image = new Image("/icon/icon_user.png");
        stage.getIcons().add(image);
    }

    @FXML
    void kapcsolatPushed(ActionEvent event) throws IOException {
        FXMLScenes object = new FXMLScenes();
        Pane view = object.getPage("FXMLKapcsolat");
        mainPane.getChildren().setAll(view);
        Stage stage = new Stage();
        stage.setTitle("Virsly");
        Image image = new Image("/icon/icon_user.png");
        stage.getIcons().add(image);
    }

    @FXML
    void VisszaPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/FXMLLogin.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        Stage stage2 = (Stage)
                buttonVissza.getScene().getWindow();
        stage2.close();
        stage.setTitle("Virsly");
        Image image = new Image("/icon/icon_user.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
    }

    public void GridpaneFood()
    {
        Food newyorkhotdog = new Food("New York Hot Dog", List.of("Hot Dog kifli, Virsli, Cheddar szósz, Pirított hagyma, Ketchup, Majonéz"), 1100);
        kajak.add(newyorkhotdog);
        FXMLMenuSceneController.nyhdName_static.setText(newyorkhotdog.getName());
        FXMLMenuSceneController.nyhdPrice_static.setText(newyorkhotdog.getPrice() + "Ft");
        FXMLMenuSceneController.nyhdList_static.setText(("" + newyorkhotdog.getList()).substring(1, ("" + newyorkhotdog.getList()).length() - 1));

        Food chicagohotdog = new Food("Chicago Hot Dog", List.of("Hot Dog kifli, Grillkolbász, Mustár, Pirított hagyma, Uborka, Jalapeno"), 1300);
        kajak.add(chicagohotdog);
        FXMLMenuSceneController.chdName_static.setText(chicagohotdog.getName());
        FXMLMenuSceneController.chdPrice_static.setText(chicagohotdog.getPrice() + "Ft");
        FXMLMenuSceneController.chdList_static.setText(("" + chicagohotdog.getList()).substring(1, ("" + chicagohotdog.getList()).length() - 1));

        Food amsterdamhotdog = new Food("Amsterdam Hot Dog", List.of("Hot Dog kifli, Virsli, Paradicsom, Házi zöldség mix, Majonez, Ketchup, Mustár"), 1450);
        kajak.add(amsterdamhotdog);
        FXMLMenuSceneController.ahdName_static.setText(amsterdamhotdog.getName());
        FXMLMenuSceneController.ahdPrice_static.setText(amsterdamhotdog.getPrice() + "Ft");
        FXMLMenuSceneController.ahdList_static.setText(("" + amsterdamhotdog.getList()).substring(1, ("" + amsterdamhotdog.getList()).length() - 1));

        Food debrecenihotdog = new Food("Debreceni Hot Dog", List.of("Hot Dog kifli, Debreceni páros, Bacon, Paradicsom, Pirított hagyma, Magyaros krém"), 1300);
        kajak.add(debrecenihotdog);
        FXMLMenuSceneController.dhdName_static.setText(debrecenihotdog.getName());
        FXMLMenuSceneController.dhdPrice_static.setText(debrecenihotdog.getPrice() + "Ft");
        FXMLMenuSceneController.dhdList_static.setText(("" + debrecenihotdog.getList()).substring(1, ("" + debrecenihotdog.getList()).length() - 1));

        Food athenhotdog = new Food("Athén Hot Dog", List.of("Hot Dog kifli, Bárány-marha kolbász, Padlizsankrém, Feta, Paradicsom, Hagyma, Uborka"), 1100);
        kajak.add(athenhotdog);
        FXMLMenuSceneController.athdName_static.setText(athenhotdog.getName());
        FXMLMenuSceneController.athdPrice_static.setText(athenhotdog.getPrice() + "Ft");
        FXMLMenuSceneController.athdList_static.setText(("" + athenhotdog.getList()).substring(1, ("" + athenhotdog.getList()).length() - 1));

        Food tokiohotdog = new Food("Tokió Hot Dog", List.of("Hot Dog kifli, Kacsa kolbász, Sushi gyömbér, Wasabi, Pirított hagyma, Szoja szósz"), 1550);
        kajak.add(tokiohotdog);
        FXMLMenuSceneController.thdName_static.setText(tokiohotdog.getName());
        FXMLMenuSceneController.thdPrice_static.setText(tokiohotdog.getPrice() + "Ft");
        FXMLMenuSceneController.thdList_static.setText(("" + tokiohotdog.getList()).substring(1, ("" + tokiohotdog.getList()).length() - 1));

        Food mexikohotdog = new Food("Mexikó Hot Dog", List.of("Hot Dog kifli, Virsli, Jalapeno, Kukorica, Bab, Mexikói salsa, Tortilla chips"), 1550);
        kajak.add(mexikohotdog);
        FXMLMenuSceneController.mhdName_static.setText(mexikohotdog.getName());
        FXMLMenuSceneController.mhdPrice_static.setText(mexikohotdog.getPrice() + "Ft");
        FXMLMenuSceneController.mhdList_static.setText(("" + mexikohotdog.getList()).substring(1, ("" + mexikohotdog.getList()).length() - 1));

        Food kijevhotdog = new Food("Kijev Hot Dog", List.of("Hot Dog kifli, Mangalica hurka, Majonéz, Mustár, Jalapeno, Uborka "), 1100);
        kajak.add(kijevhotdog);
        FXMLMenuSceneController.khdName_static.setText(kijevhotdog.getName());
        FXMLMenuSceneController.khdPrice_static.setText(kijevhotdog.getPrice() + "Ft");
        FXMLMenuSceneController.khdList_static.setText(("" + kijevhotdog.getList()).substring(1, ("" + kijevhotdog.getList()).length() - 1));
    }

    private void GridpaneDrink()
    {
        Drink cocacola = new Drink("Coca cola", 450);
        italok.add(cocacola);
        FXMLMenuSceneController.cocacolaName_static.setText(cocacola.getName());
        FXMLMenuSceneController.cocacolaPrice_static.setText(cocacola.getPrice() + "Ft");

        Drink colalight = new Drink("Cola light", 450);
        italok.add(colalight);
        FXMLMenuSceneController.colaliteName_static.setText(colalight.getName());
        FXMLMenuSceneController.colalitePrice_static.setText(colalight.getPrice() + "Ft");

        Drink fanta = new Drink("Fanta", 450);
        italok.add(fanta);
        FXMLMenuSceneController.fantaName_static.setText(fanta.getName());
        FXMLMenuSceneController.fantaPrice_static.setText(fanta.getPrice() + "Ft");

        Drink cappynarancs = new Drink("Cappy narancs", 450);
        italok.add(cappynarancs);
        FXMLMenuSceneController.cappynName_static.setText(cappynarancs.getName());
        FXMLMenuSceneController.cappynPrice_static.setText(cappynarancs.getPrice() + "Ft");

        Drink szensavmentesviz = new Drink("Szénsavmentes víz", 300);
        italok.add(szensavmentesviz);
        FXMLMenuSceneController.mentesvizName_static.setText(szensavmentesviz.getName());
        FXMLMenuSceneController.mentesvizPrice_static.setText(szensavmentesviz.getPrice() + "Ft");

        Drink szensavasviz = new Drink("Szénsavas víz", 300);
        italok.add(szensavasviz);
        FXMLMenuSceneController.savasvizName_static.setText(szensavasviz.getName());
        FXMLMenuSceneController.savasvizPrice_static.setText(szensavasviz.getPrice() + "Ft");

        Drink redbull = new Drink("Redbull", 600);
        italok.add(redbull);
        FXMLMenuSceneController.redbullName_static.setText(redbull.getName());
        FXMLMenuSceneController.redbullPrice_static.setText(redbull.getPrice() + "Ft");

        Drink heineken = new Drink("Heineken", 500);
        italok.add(heineken);
        FXMLMenuSceneController.heinekenName_static.setText(heineken.getName());
        FXMLMenuSceneController.heinekenPrice_static.setText(heineken.getPrice() + "Ft");

        Drink soproni = new Drink("Soproni", 690);
        italok.add(soproni);
        FXMLMenuSceneController.soproniName_static.setText(soproni.getName());
        FXMLMenuSceneController.soproniPrice_static.setText(soproni.getPrice() + "Ft");

        Drink dreher = new Drink("Dreher", 690);
        italok.add(dreher);
        FXMLMenuSceneController.dreherName_static.setText(dreher.getName());
        FXMLMenuSceneController.dreherPrice_static.setText(dreher.getPrice() + "Ft");
    }
}
