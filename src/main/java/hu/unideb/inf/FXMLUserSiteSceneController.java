package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class FXMLUserSiteSceneController {

    @FXML
    public AnchorPane mainPane;

    @FXML
    private Button buttonVissza;

    @FXML
    void menuPushed(ActionEvent event) throws IOException {
        FXMLScenes object = new FXMLScenes();
        Pane view = object.getPage("FXMLMenu");
        mainPane.getChildren().setAll(view);
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
}
