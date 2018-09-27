package fr.univ_amu.iut;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Classe Calendar qui permet d'afficher l'agenda
 */

public class Calendar extends Application {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Création d'une WebView pour afficher l'agenda
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        WebView maPageWeb = new WebView();
        WebEngine engine = maPageWeb.getEngine();
        engine.load("http://ivax.alwaysdata.net/calendar.html");

        VBox root = new VBox();
        root.getChildren().addAll(maPageWeb);

        Scene scene = new Scene(root, 800,600);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
