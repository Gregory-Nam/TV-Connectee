package fr.univ_amu.iut;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConnexionControl extends GridPane implements Initializable {

    private Stage stage;

    @FXML
    TextField emailField;

    @FXML
    PasswordField passwordField;

    @FXML
    Label erreurLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
   @FXML
    private void clicked(){

//       System.out.println("click");

       try {

           BaseDeDonnee bd = Main.getBaseDeDonnee();


           if (bd.verificationUtilisateur(emailField.getText(), passwordField.getText()))
           {
               BorderPane root;
               root = FXMLLoader.load(getClass().getResource("televisionView.fxml"));
               stage = Main.getPrimaryStage();
               stage.setTitle("TV connecté");
               stage.setScene(new Scene(root));
               stage.centerOnScreen();
               stage.show();

           }
           else {
               erreurLabel.setVisible(true);

           }
//           System.out.println(emailField.getText());



       } catch (Exception e) {
           e.printStackTrace();
       }


   }

   public void setStage(Stage stage){
       this.stage = stage;
   }
   public Stage getStage(){return stage;}

}