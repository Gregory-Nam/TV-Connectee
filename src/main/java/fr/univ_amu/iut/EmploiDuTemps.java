package fr.univ_amu.iut;
import java.util.*;
import fr.univ_amu.iut.Information;

/**
 * 
 */
public class EmploiDuTemps extends Information {

    /**
     * Contructeur de l'EmploiDuTemps
     * @param groupe groupe de l'étudiant
     * @param annee int de l'année
     * @param dureeDeValidite int dureeDeValidite dans le temps
     * @param taille int taille (en bit) de l'EmploieDuTemps
     * @param valide Boolean, information valide ou non
     */
    public EmploiDuTemps( int groupe, int annee, int dureeDeValidite, int taille, boolean valide) {
        this.groupe = groupe;
        this.annee = annee;
        this.dureeDeValidite = dureeDeValidite;
        this.taille = taille;
        this.valide = valide;
    }

    /**
     * groupe de l'étudiant
     * @see EmploiDuTemps
     */
    private int groupe;


    /**
     * Emploi du temps suivant l'annee
     */
    private int annee;

    /**
     * Accesseur
     * @return l'annee
     */
    public int getAnne(){
        return this.annee;
    }

    /**
     * Accesseur
     * @return le groupe
     */
    public int getGroupe() {
        return groupe;
    }

    /**
     * Modificateur du groupe
     * @param groupe
     */
    public void setGroupe(int groupe) {
        this.groupe = groupe;
    }
}