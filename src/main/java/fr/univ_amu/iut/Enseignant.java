package fr.univ_amu.iut;
import java.util.*;

/**
 * Classe enseignant qui etend la classe Utilisateur
 */
public class Enseignant extends Utilisateur {

    /**
     * Default constructor
     * @param email
     * @param mdp
     * @param numEn
     */
    public Enseignant(String email, String mdp,
                      int numEn) {
        super(email, mdp);

        this.numEn = numEn;
    }

    /**
     * Numero de l'enseignant
     * @see Enseignant
     */
    private int numEn;

}