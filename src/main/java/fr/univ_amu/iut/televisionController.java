package fr.univ_amu.iut;

import javafx.animation.AnimationTimer;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class televisionController extends BorderPane {


    /**
     * BorderPane racine de televisionView
     *
     * @see #initialize()
     */
    public BorderPane borderRoot;
    /**
     * GridPane du bas de la télévision ( text, label, heure )
     *
     * @see #initialize()
     */
    public GridPane gridPaneCenter;
    /**
     * WebView de l'agenda
     *
     * @see #initialize()
     */
    public WebView webViewCalendar;
    /**
     * Label message important (en bas de l'image )
     *
     * @see #initialize()
     * @see #setMessageImportant(String)
     */
    public Label messageImportant;
    /**
     * ImageView image en Bas de l'écran (logo IUT )
     *
     * @see #initialize()
     */
    public ImageView imageBot1;
    /**
     * ImageView image en Bas de l'écran à droite (logo IUT)
     *
     * @see #initialize()
     */
    public ImageView imageBot2;
    /**
     * Label pour l'horloge de la télévision (en bas en droite )
     *
     * @see #initialize()
     * @see #updateDate()
     */
    public Label heureSystem;
    @FXML
    /**
     * nameCol, colone des noms prénoms des étudiants
     * @see #initialize()
     */
    private TableColumn<Note, String> nameCol;
    @FXML
    /**
     * NoteCol, colonne des notes des étudiants
     * @see #initialize()
     */
    private TableColumn<Note, String> noteCol;
    @FXML
    /**
     * listTableView, list des notes et noms des étudiants
     * @see #initialize()
     * @see #updateScrollBar()
     */
    public TableView<Note> listTableView;

    /**
     * scrollPosition, position du scroll de La liste de note
     *
     * @see #updateScrollBar()
     */
    private Double scrollPositionX = 0.0;
    /**
     * entier utiliser pour gèrer le déplacement du scroll de la liste de note
     *
     * @see #updateDate()
     */
    private int rateForScrollMovement = 0;
    /**
     * Dimension de l'écran
     *
     * @see televisionController
     */
    private Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * taille en hauteur de l'écran
     *
     * @see #initialize()
     */
    public int height = (int) dimension.getHeight();
    /**
     * taille en largeur de l'écran
     *
     * @see #initialize()
     */
    public int width = (int) dimension.getWidth();

    private static ObservableList<Note> noteData = FXCollections.observableArrayList();
    private int rateInformationImportante = 1;
    private int nbInformationImportante = 0;


    public televisionController() {


    }

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns
        try {
            AnimationTimer animation = createAnimation();
            animation.start();

            for (ListNote i : Main.getBaseDeDonnee().getVectorListNotes()) {
                noteData = i.getNoteData();
            }


            initializeVectorInformation(Main.getBaseDeDonnee());

        } catch (Exception e) {
            e.printStackTrace();
        }

        nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        noteCol.setCellValueFactory(cellData -> cellData.getValue().noteProperty());

        listTableView.setItems(getNoteData());
        borderRoot.setPrefHeight(height);
        borderRoot.setPrefWidth(width);
        gridPaneCenter.setPrefWidth(width);
        double gridPaneCenterHeight = (double) height / 4.5;
        gridPaneCenter.setPrefHeight(gridPaneCenterHeight);
        listTableView.setPrefSize(gridPaneCenter.getPrefWidth() / 4, 700);
        noteCol.setMinWidth(width / 8);
        nameCol.setMinWidth(width / 8);
        webViewCalendar.setPrefSize(width - listTableView.getPrefWidth() - 230, 700);


        WebEngine engine = webViewCalendar.getEngine();
        engine.load("http://ivax.alwaysdata.net/calendar.html");
        webViewCalendar.setZoom(1.1);
        webViewCalendar.setMaxHeight(700);
        imageBot1.setFitHeight(height / 6);
        imageBot2.setFitHeight(height / 6);
        Image imageInfo = new Image("logo.png");
        Image imageInfo2 = new Image("information.png");
        imageBot1.setImage(imageInfo);
        imageBot2.setImage(imageInfo2);
        heureSystem.setPrefWidth(width / 10);
        messageImportant.setPrefWidth(width - ((imageBot1.getFitHeight() * 2) + heureSystem.getWidth() + 150));
        messageImportant.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");


    }

    private void updateDate() {
        if (rateForScrollMovement % 50 == 0) {
            Date tempDate = new Date();
            int myMin = tempDate.getMinutes();

            String myMinStr = Long.toString(tempDate.getMinutes());
            if (myMin <= 9) {
                myMinStr = "0" + Long.toString(tempDate.getMinutes());
            }
            int myHour = tempDate.getHours();
            String myHourStr = Long.toString(tempDate.getHours());
            if (myHour <= 9) {
                myHourStr = "0" + Long.toString(tempDate.getHours());
            }
            int mySec = tempDate.getSeconds();
            String mySecStr = Long.toString(tempDate.getSeconds());
            if (mySec <= 9) {
                mySecStr = "0" + Long.toString(tempDate.getSeconds());
            }
            String txtDate = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE).format(new Date());
            String txtHeure = myHourStr + ":" +
                    myMinStr + ":" +
                    mySecStr + "\n" + txtDate;
            heureSystem.setText(txtHeure);
            heureSystem.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
            noteCol.setText("Note de : " + Main.getBaseDeDonnee().getMatiereDeNote());
        }
    }

    private void updateScrollBar() {
        rateForScrollMovement++;
        scrollPositionX = scrollPositionX + 0.01;
        listTableView.scrollTo(scrollPositionX.intValue());
        if (scrollPositionX >= noteData.size()) {
            scrollPositionX = 0.0;
        }

    }

    private void setMessageImportant(String text) {
        messageImportant.setText(text);
    }

    private AnimationTimer createAnimation() {
        final LongProperty lastUpdateTime = new SimpleLongProperty(0);

        return new
                AnimationTimer() {
                    @Override
                    public void handle(long timestamp) {
                        if (lastUpdateTime.get() > 0) {
                            updateDate();
                            updateScrollBar();
                            initializeVectorInformation(Main.getBaseDeDonnee());


                        }

                        lastUpdateTime.set(timestamp);
                    }

                    @Override
                    public void start() {
                        lastUpdateTime.set(System.nanoTime());
                        super.start();
                    }

                    @Override
                    public void stop() {
                        lastUpdateTime.set(System.nanoTime());
                        super.stop();
                    }
                };
    }

    private static ObservableList<Note> getNoteData() {
        return noteData;
    }

    private void initializeVectorInformation(BaseDeDonnee baseDeDonnee) {

        Vector<InformationImportante> infos;
        infos = baseDeDonnee.getInfos();

        rateInformationImportante++;

        if (rateInformationImportante > 300) {


            if (nbInformationImportante >= infos.size() - 1) {
                nbInformationImportante = 0;
            } else {
                ++nbInformationImportante;
            }
            rateInformationImportante = 0;
        }
        setMessageImportant(infos.get(nbInformationImportante).getTitre());

    }


}

