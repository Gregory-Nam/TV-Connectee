package fr.univ_amu.iut;
import java.util.*;

/**
 * Sous classe d'information5
 */
public class InformationImportante extends Information {

    /**
     *  Titre de l'information
     */
    private String titre;

    /**
     * Niveau d'inportance de l'information
     */
    private int niveauImportance;

    /**
     * Default constructor
     * @param titre
     * @param niveauImportance
     * @param taille
     * @param valide
     * @param dureeDeValidite
     */
    public InformationImportante(String titre, int niveauImportance, int taille,
                                 boolean valide, int dureeDeValidite) {
        this.niveauImportance = niveauImportance;
        this.titre = titre;
        this.taille = taille;
        this.valide = valide;
        this.dureeDeValidite = dureeDeValidite;
    }

    /**
     * Accesseur du titre
     * @return le titre de l'information
     */
    public String getTitre() {
        return titre;
    }
}