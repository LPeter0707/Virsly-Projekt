package hu.unideb.inf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class FXMLUserSiteSceneController {
    @FXML
    private Button buttonMenu;

    @FXML
    private Button buttonKosar;

    @FXML
    private Button buttonKapcsolat;

    @FXML
    private BorderPane mainPane;

    @FXML
    void menuPushed(ActionEvent event) throws IOException {
        FXMLScenes object = new FXMLScenes();
        Pane view = object.getPage("FXMLMenu");
        mainPane.setCenter(view);
    }

    @FXML
    void kosarPushed(ActionEvent event) throws IOException {
        FXMLScenes object = new FXMLScenes();
        Pane view = object.getPage("FXMLproba");
        mainPane.setCenter(view);
    }
    @FXML
    void kapcsolatPushed(ActionEvent event) throws IOException {
        FXMLScenes object = new FXMLScenes();
        Pane view = object.getPage("FXMLKapcsolat");
        mainPane.setCenter(view);
    }
}
