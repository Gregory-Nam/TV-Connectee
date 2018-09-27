package fr.univ_amu.iut;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Cette classe permet l'ajout d'une liste de note dans la TvConnecte
 */
public class AjouterNoteController implements Initializable {
    /**
     * TextArea où est stocké le nom de la matiere
     * @see #getMatiere()
     */
    private televisionController tc = new televisionController();

    public TextArea matiereTexte;

    /**
     * Liste des télévisions disponible
     * @see #LoadData()
     */

    ObservableList list= FXCollections.observableArrayList();

    /**
     * Liste des diffèrentes dispositions disponibles
     * @see #LoadData()
     */

    ObservableList list2= FXCollections.observableArrayList();

    /**
     * ChoiceBox permettant de choisir la tele sur laquelle afficher les notes
     * @see #getTeleviseur()
     */

    @FXML
    private ChoiceBox televiseur;

    /**
     * ChoiceBox permettant de choisir la disposition pour les notes
     * @see #getDisposition()
     */

    @FXML
    private ChoiceBox disposition;

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
     * String contenant le chemin absolue du fichier excel contenant les notes
     */
    private String cheminFichier="";

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

        list2.removeAll(list2);
        String disposition1 = "Haut";
        String disposition2 = "Bas";
        String disposition3 = "Gauche";
        String disposition4 = "Droite";
        list2.addAll(disposition1,disposition2,disposition3,disposition4);
        disposition.getItems().addAll(list2);
    }


    /**
     * Methode qui permet d'obtenir l'adresse du fichier à ajouter à la Tv
     * Cette methode utilise un filtre permettant d'afficher uniquement les .xlsx soit les fichiers excel
     */
    public void ChoisirFichier(){
        JFileChooser fichier = new JFileChooser();
        fichier.setCurrentDirectory(new File("."));

        fichier.setFileFilter(new javax.swing.filechooser.FileFilter(){
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".xlsx")
                        || f.isDirectory();
            }

            public String getDescription() {
                return "Fichier excel";
            }

        });

        int r = fichier.showOpenDialog(new JFrame());
        if(r == JFileChooser.APPROVE_OPTION){
             cheminFichier = fichier.getSelectedFile().getName();
//            System.out.println(cheminFichier);
        }

    }

    /**
     * Methode qui ajoute le document a la Tv en instanciant un objet de la classe ListNote
     * Si le chemin de fichier est nul , un message d'erreur apparait
     */
    public void Valider(){
        if(cheminFichier.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Oups, nous rencontrons un problème");
            alert.setContentText("Sélectionner un document !");

            alert.showAndWait();
        }
        else{
           new ListNote(Main.getBaseDeDonnee(),cheminFichier);
//            System.out.println("Document ajouté");


            try {
                BorderPane root = FXMLLoader.load(getClass().getResource("televisionView.fxml"));
                stage = Main.getPrimaryStage();
                stage.setTitle("TV Connecté");
                stage.setScene(new Scene(root));
                stage.centerOnScreen();
                Main.getBaseDeDonnee().setMatiereDeNote(getMatiere());

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
        EventHandler<javafx.event.ActionEvent> annuler = event -> {
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
     * Accesseur permettant d'obtenir le nom de la matiere
     * @return Le nom de la matiere
     */
    public String getMatiere(){
        return matiereTexte.getText();
    }

    /**
     * Accesseur permettant d'obtenir la valeur du slider
     * @return L'importance du document
     */
    public double getImportance(){
        return importanceSlider.getValue();

    }

    /**
     * Accesseur permettant d'obtenir le string correspondant à la disposition
     * @return La disposition du document
     */
    public String getDisposition(){
        return disposition.getValue().toString();
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





