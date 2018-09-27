package fr.univ_amu.iut;
import java.util.*;

/**
 * 
 */
public class Système {

    /**
     * Default constructor
     */
    public Système() {
    }




    /**
     * 
     */
    public void actualiser() {
        // TODO implement here
    }

    /**
     * @param info
     * @return
     */
    public boolean isValideInfoBDE(Information info) {


        if(info.getValide()) {
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * @param email string 
     * @param mdp string
     */
    public void insertLogin(String email, String mdp) {
        // TODO implement here
    }

    /**
     * @param dimension Dimension
     */
    public void modifierDimensionBloc(int height, int width) {
        // TODO implement here
    }

}