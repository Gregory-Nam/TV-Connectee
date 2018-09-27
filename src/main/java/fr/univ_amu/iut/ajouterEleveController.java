package fr.univ_amu.iut;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ajouterEleveController implements Initializable {
    private Stage stage;


    @FXML
    private ChoiceBox televiseur;

    @FXML
    private Button annulerBouton;

    private String cheminFichier;

    ObservableList list= FXCollections.observableArrayList();


    ObservableList list2= FXCollections.observableArrayList();

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
            Main.baseDeDonnee.insererDansBDUtilisateur(cheminFichier);


            try {
                BorderPane root = FXMLLoader.load(getClass().getResource("televisionView.fxml"));
                stage = Main.getPrimaryStage();
                stage.setTitle("Ajouter liste d'élève");
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
}
