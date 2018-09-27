package fr.univ_amu.iut;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Classe qui correspond a une note associé a un nom
 */
public class Note {

    /**
     * Id de la ligne
     */
    private int myId;

    /**
     * Nom de l'étudiant
     */
    private StringProperty name;

    /**
     * Note de l'étudiant
     */
    private StringProperty note;


    /**
     * Accesseur qui permet d'obtenir le nom de l'étudiant
     * @return le nom de l'étudiant
     */
    public StringProperty nameProperty() {
        return name;
    }

    /**
     * Accesseur qui permet d'obtenir la note de l'étudiant
     * @return la note de l'étudiant
     */
    public StringProperty noteProperty(){
        return note;
    }

    /**
     * Default constructor
     * @param id
     * @param listNotes
     */
    Note (int id, Vector <List<String>> listNotes){
        Vector<List<String>> myListNotes = listNotes;
        this.name = new SimpleStringProperty(myListNotes.get(0).get(id));
        this.note = new SimpleStringProperty(myListNotes.get(1).get(id));


    }
}
