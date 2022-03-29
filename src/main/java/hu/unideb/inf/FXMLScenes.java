package hu.unideb.inf;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.net.URL;

public class FXMLScenes {
    private Pane view;

    public Pane getPage(String fileName){
        try {
            URL fileUrl = FXMLUserSiteSceneController.class.getResource("/fxml/" + fileName + ".fxml");
            if (fileUrl == null){
                throw new java.io.FileNotFoundException("Nem tudja megnyitni a fájlt");
            }
            else{
                view = new FXMLLoader().load(fileUrl);
            }

        }
        catch (Exception e)
        {
            System.out.println("Nem tudja megnyitni a fájlt");
        }
        return view;
    }
}
