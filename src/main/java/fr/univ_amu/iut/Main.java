package fr.univ_amu.iut;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static BaseDeDonnee baseDeDonnee = new BaseDeDonnee();

    private static Stage pStage;

    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * Pour ce connecter utiliser les identifiants admin, mot de passe admin
     * @param primaryStage
     */

    public void start(Stage primaryStage) {
        Main.baseDeDonnee.insererDansBD(new Etudiant("admin","admin", "iut",3,2));

        setPrimaryStage(pStage);
         pStage=primaryStage;
        primaryStage.setResizable(false);
        pStage.setTitle("Page de connexion");

        try {
            FXMLLoader test = new FXMLLoader(getClass().getResource("ConnexionPage.fxml"));
            GridPane root = test.load();

            ConnexionControl connexion = test.getController();
            connexion.setStage(primaryStage);


            pStage.setScene(new Scene(root));

            pStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Stage getPrimaryStage(){
        return pStage;
    }

    public static void setPrimaryStage(Stage stage){
        Main.pStage = stage;
    }

    public static BaseDeDonnee getBaseDeDonnee() {
        return baseDeDonnee;
    }

}