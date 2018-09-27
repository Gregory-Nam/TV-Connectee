package fr.univ_amu.iut;
import java.util.*;

/**
 * Classe Information
 */
public class Information {

    /**
     * Default constructor
     */
    public Information() {

    }

    /**
     * Duree de l'information
     * @see #getDureeDeValidite()
     * @see #setDureeDeValidite(int)
     */
    protected int dureeDeValidite;

    /**
     * Taille de l'information
     * @see #getTaille()
     */
    protected int taille;

    /**
     * L'information est accepte ou non
     * @see #getValide()
     */
    protected boolean valide;


    /**
     * Accesseur
     * @return si valide ou non
     */
    public boolean getValide() {
        return  this.valide;
    }

    /**
     * Accesseur d'information
     * @return l'information
     */
    public Information getInformation() {
        return this;
    }

    /**
     * Accesseur de duree de validite
     * @return la duree de validite
     */
    public int getDureeDeValidite() {
        return this.dureeDeValidite;
    }

    /**
     * Accesseur de taile
     * @return la taille de l'information
     */
    public int getTaille() {
        return this.taille;
    }

    /**
     * Modificateur de la duree
     * @param newDuree la nouvelle duree
     */
    public void setDureeDeValidite(int newDuree) {
        this.dureeDeValidite = newDuree;
    }

}