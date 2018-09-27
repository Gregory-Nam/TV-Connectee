package fr.univ_amu.iut;
import java.util.*;

/**
 * Classe etendu d'Utilisateur
 */
public class Secrétariat extends Utilisateur{

    /**
     * Default constructor
     * @param email email de la secretaire
     * @param mdp mot de passe de la secretaire
     */
    public Secrétariat(String email, String mdp) {
        super(email, mdp);
    }

    /**
     * Methode pour envoyer un mail a un destinataire avec un contenu
     * @param destinataire
     * @param contenu
     */
    public void envoyerMail(String destinataire, String contenu) {
        // TODO implement here

    }

}