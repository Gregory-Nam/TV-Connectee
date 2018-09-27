package fr.univ_amu.iut;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MenuController extends GridPane implements Initializable {

    Stage stage;

    @FXML
    Button ajoutDocButton;
    @FXML
    Button ajoutNoteButton;
    @FXML
    Button decoButton;

    @FXML
    Button ajoutElevesButton;

    private FXMLLoader fxmlloader;


    public MenuController() {
        fxmlloader = new FXMLLoader(getClass().getResource("MenuView.fxml"));
        fxmlloader.setRoot(this);
        fxmlloader.setController(this);


        try {
            fxmlloader.load();
        }
        catch(IOException ex)
        {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        createListenerAndSetListener();
    }

    public void createListenerAndSetListener(){


        EventHandler<ActionEvent> buttonNoteOnClick = event -> {
            try{
                GridPane root;
                root = FXMLLoader.load(getClass().getResource("AjouterNote.fxml"));
                stage = Main.getPrimaryStage();

                stage.setTitle("Ajouter note");
                stage.setScene(new Scene(root));
                stage.centerOnScreen();
                stage.show();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        };

        ajoutNoteButton.setOnAction(buttonNoteOnClick);

        EventHandler<ActionEvent> buttonInfoOnClick = event -> {
            try{
                GridPane root;
                root = FXMLLoader.load(getClass().getResource("ajouterInformations.fxml"));
                stage = Main.getPrimaryStage();

                stage.setTitle("Ajouter une information");
                stage.setScene(new Scene(root));
                stage.centerOnScreen();
                stage.show();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        };
        ajoutDocButton.setOnAction(buttonInfoOnClick);


        EventHandler<ActionEvent> buttonDecoOnClick = event -> {
            try{
                GridPane root;
                root = FXMLLoader.load(getClass().getResource("ConnexionPage.fxml"));
                stage = Main.getPrimaryStage();

                stage.setTitle("Page de connexion");
                stage.setScene(new Scene(root));
                stage.centerOnScreen();
                stage.show();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        };

        decoButton.setOnAction(buttonDecoOnClick);

        EventHandler<ActionEvent> buttonAjoutEleveOnClick = event -> {
            try{
                GridPane root;
                root = FXMLLoader.load(getClass().getResource("ajouterEleveview.fxml"));
                stage = Main.getPrimaryStage();

                stage.setTitle("Ajouter des élèves");
                stage.setScene(new Scene(root));
                stage.centerOnScreen();
                stage.show();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        };

        ajoutElevesButton.setOnAction(buttonAjoutEleveOnClick);



    }

    public void setStageMenu(Stage stage)
    {
        this.stage = stage;
    }


}