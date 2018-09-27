package fr.univ_amu.iut;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.acl.AclNotFoundException;
import java.util.ResourceBundle;

/**
 * Cette classe permet l'ajout d'une information dans la TvConnecte
 */
public class ajouterInformationController implements Initializable {

    /**
     * TextArea où est stocké l'information
     * @see #getInfo() ()
     */
    public TextArea informationTexte;
    ObservableList list= FXCollections.observableArrayList();

    ObservableList list2= FXCollections.observableArrayList();

    /**
     * ChoiceBox permettant de choisir la tele sur laquelle afficher les notes
     * @see #getTeleviseur()
     */
    @FXML
    private ChoiceBox televiseur;

    /**
     * Slider permettant de déterminer l'importance des notes
     * @see #getImportance()
     */
    @FXML
    private Slider importanceSlider;

    /**
     * DatePicker permettant de déterminer la durée de l'affichage des notes
     * @see #getDuree()
     */
    @FXML
    private DatePicker duree;


    /**
     * Button pour annuler l'ajout d'un document
     * @see #Annuler()
     */
    @FXML
    private Button annulerBouton;

    /**
     * Stage actuel
     */
    private Stage stage;





    /**
     * Permet d'initialiser les ChoiceBox et la méthode Annuler()
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        LoadData();
        Annuler();
    }


    /**
     * Methode qui initialise les ChoiceBox avec les bonnes valeurs
     */
    private void LoadData(){
        list.removeAll(list);
        String tele1 = "Tele 1re année";
        String tele2 = "Tele 2eme année";
        list.addAll(tele1,tele2);
        televiseur.getItems().addAll(list);
    }



    /**
     * Methode qui ajoute l'information a la Tv en instanciant un objet de la classe InformationImportante
     * Si l'information est nulle , un message d'erreur apparait
     */

    public void ValiderInfo(){
        if(getInfo().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Oups, nous rencontrons un problème");
            alert.setContentText("Entrer une information !");

            alert.showAndWait();
        }
        else{
            Main.getBaseDeDonnee().insererDansBD(new InformationImportante(getInfo(),0,0,true,0));
//            System.out.println("Information ajouté ajouté");


            try {
                BorderPane root = FXMLLoader.load(getClass().getResource("televisionView.fxml"));
                stage = Main.getPrimaryStage();
                stage.setTitle("Tv connecté");
                stage.setScene(new Scene(root));
                stage.centerOnScreen();
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    /**
     * Methode lié au bouton annuler présent dans le FXML
     * Elle permet de nous ramener sur le stage de la TVConnecte
     */
    public void Annuler()
    {
        EventHandler<ActionEvent> annuler = event -> {
            try {
                BorderPane root = FXMLLoader.load(getClass().getResource("televisionView.fxml"));
                stage = Main.getPrimaryStage();
                stage.setTitle("TV connecté");
                stage.setScene(new Scene(root));
                stage.centerOnScreen();
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        annulerBouton.setOnAction(annuler);
    }

    /**
     *Accesseur permettant de récuperer le texte du TextArea
     * @return Le texte rentrer dans le TextArea
     */
    public String getInfo(){
        return informationTexte.getText();
    }

    /**
     * Accesseur permettant d'obtenir la valeur du slider
     * @return L'importance de l'information
     */
    public double getImportance(){
        return importanceSlider.getValue();

    }

    /**
     * Accesseur permettant d'obtenir le valeur de la ChoiceBox Televiseur
     * @return La television sélectionné
     */
    public String getTeleviseur(){
        return televiseur.getValue().toString();
    }

    /**
     * Accesseur permettant d'obtenir la duree du document
     * @return La duree du document sous forme de string
     */
    public String getDuree(){
        return duree.getValue().toString();
    }

    /**
     * Accesseur permettant d'obtenir le stage
     * @return le stage du document
     */
    public Stage getStageAjoutDocument(){return stage; }

    /**
     * Modificateur affectant au stage le stage passé en parametre
     * @param stage
     */
    public void setStageAjoutDoc(Stage stage){this.stage = stage;}

    /**
     * Modificateur affectant au stage le stage passé en parametre
     * @param stage
     */
    public void setStage(Stage stage){
        this.stage = stage;
    }

    /**
     * Accesseur permettant d'obtenir le stage actuel
     * @return le stage
     */
    public Stage getStage(){return stage;}

}
