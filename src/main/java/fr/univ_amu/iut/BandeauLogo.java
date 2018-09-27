package fr.univ_amu.iut;
import java.util.*;

/**
 * 
 */
public class BandeauLogo extends Information {

    private String titre;

    /**
     * /**
     * BandeauLogo extends d'Information
     * @param dureeDeValiditee Durée de validitée de l'information
     * @param taille taille du bandeauLogo
     * @param valide Bool valide ou non
     * @param titre Titre (contenu) de l'information
     */
    public BandeauLogo(int dureeDeValiditee, int taille,
                       boolean valide, String titre) {
        this.titre = titre;
        this.dureeDeValidite = dureeDeValiditee;
        this.valide = valide;
        this.taille = taille;

    }

}