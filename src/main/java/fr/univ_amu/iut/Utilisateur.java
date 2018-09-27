package fr.univ_amu.iut;




/**
 * Class Utilisateur qui correspond à un utilisateur du logiciel
 */
public class Utilisateur {

    /**
     * Default constructor
     * @param email Email de connexion
     * @param mdp Mot de passe de connexion
     */
    public Utilisateur(String email, String mdp) {

        this.email = email;
        this.mdp = mdp;

    }

    /**
     * String contenant l'email de l'etudiant
     */
    protected String email;
    public String getEmail(){
        return this.email;
    }

    public String getMdp() {
        return mdp;
    }

    public int getIdUser() {
        return IdUser;
    }

    /**
     * String contenant le mot de passe de l'étudiant
     * @see #changementMdp(String, String)
     */
    protected String mdp;


    /**
     * int correspondant à l'ID de l'Utilisateur
     */
    protected int IdUser;


    /**
     * Methode permettant de changer de mot de passe à partir de l'ancien
     * @param mdp Notre mot de passe
     * @param newmdp Nouveau mot de passe
     */
    public void changementMdp(String mdp, String newmdp) {
        if (mdp == this.mdp)
        {
            this.mdp = newmdp;
        }
//        System.out.println("Changement de mots de passe");
    }










    /**
     * Methode qui affiche les erreurs suivant le type d'erreur
     * @param typeErreur
     * @return
     */
    public String afficherErreur(String typeErreur) {
        if (typeErreur == "bigVolume")
        {
            return "Le fichier est trop volumineux, le fichier ne doit pas dépasser la taille de 300 mb";
        }
        if (typeErreur == "badId")
        {
            return "Les identifiants saisie sont invalides";
        }
        if (typeErreur == "badGateWayBD")
        {
            return "Connection à la base de donnée échouer";
        }
        return "code erreur non renseigner";
    }

}