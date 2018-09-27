package fr.univ_amu.iut;
import java.util.*;

/**
 * Classe etudiante
 */
public class Etudiant extends Utilisateur {

    /**
     * Default constructor
     * @param email
     * @param mdp
     * @param IUT
     * @param groupe
     * @param annee
     */
    public Etudiant(String email, String mdp,
                    String IUT, int groupe, int annee) {
        super(email,mdp);
        this.annee = annee;
        this.groupe = groupe;
        this.IUT  = IUT;
    }

    /**
     * Nom de l'IUT de l'étudiant
     * @see Etudiant
     */
    private String IUT;

    /**
     * Numero du groupe de l'étudiant
     * @see Etudiant
     */
    private int groupe;

    public String getIUT() {
        return IUT;
    }

    public int getGroupe() {
        return groupe;
    }

    public int getAnnee() {
        return annee;
    }

    /**

     * Annee de l'étudiant
     * @see Etudiant
     */
    private int annee;

}