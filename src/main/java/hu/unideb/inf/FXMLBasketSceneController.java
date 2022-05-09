package hu.unideb.inf;

import hu.unideb.inf.model.Food;
import hu.unideb.inf.model.JpaStorageDAO;
import hu.unideb.inf.model.Storage;
import hu.unideb.inf.model.StorageDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FXMLBasketSceneController extends FXMLUserSiteSceneController{

    @FXML
    private TextArea basket;
    public static TextArea basket_static;

    @FXML
    private Button buttonRendel;

    public static List<Food> lista = new ArrayList<>();

    static void Rendeles(int kajaindex, int darab)
    {
        for (int i = 0; i < darab; i++)
        {
            lista.add(kajak.get(kajaindex));
        }

        /*for (int j = 0; j < lista.size(); j++)
        {
            System.out.println(lista.get(j).getName());
        }*/

        FXMLScenes object = new FXMLScenes();
        Pane view = object.getPage("FXMLKosar");
        mainPane_static.getChildren().setAll(view);

        Kiir();
    }

    static void Kiir()
    {
        int darab = 1;
        int osszeg = 0;
        Set<Food> szurtlista = new HashSet<>(lista);
        String[] tartalom = new String[szurtlista.size()];
        List<Food> kajalista = new ArrayList<>(szurtlista);
        for (int i = 0; i < kajalista.size(); i++)
        {
            tartalom[i] = "" + kajalista.get(i).getName() + "\t\t\t" + darab + "db" + "\t" + darab * kajalista.get(i).getPrice() + " ft";
            osszeg += darab * kajalista.get(i).getPrice();
        }

        basket_static.setText(String.join("\n", tartalom));
    }

    @FXML
    public void initialize(){
        basket_static = basket;
    }

    @FXML
    void rendelPushed(ActionEvent event) throws IOException{
        List<Storage> raktar = new ArrayList<>();
        StorageDao storage = new JpaStorageDAO();
        raktar = storage.getStorage();
        for(int i = 0; i < lista.size(); i++){
            for (int j = 0; j < lista.get(i).getList().size(); j++){
                for (int k = 0; k < raktar.size(); k++){
                    System.out.println(lista.get(i).getList().get(j) == (raktar.get(k).getName()));
                    if (lista.get(i).getList().get(j) == (raktar.get(k).getName())) {
                        raktar.get(k).setPiece(raktar.get(k).getPiece() - 1);

                    }
                }
            }
        }
        for (Storage item: raktar) {
            System.out.println(item.getName()+ " " + item.getPiece());
        }
        storage.updateStorage(raktar);

    }
}
