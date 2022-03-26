package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

public class FXMLUserSiteSceneController {

    @FXML
    public AnchorPane mainPane;

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
}
