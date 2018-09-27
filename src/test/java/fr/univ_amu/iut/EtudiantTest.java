package fr.univ_amu.iut;

import org.junit.Test;
import org.junit.*;

import static org.junit.Assert.*;

public class EtudiantTest {

    @Test
    public void souldReturnTristan(){
        assertEquals("tristan", new Etudiant("tristan","1324","informatique",3,4).getEmail());
    }
    @Test
    public void souldReturnCompleteClass(){
        Etudiant TestEtudiant = new Etudiant("tristan","1324","informatique",3,4);
        assertEquals("tristan",TestEtudiant.getEmail());
        assertEquals("1324", TestEtudiant.getMdp());
        assertEquals("informatique",TestEtudiant.getIUT());
        assertEquals(3,TestEtudiant.getGroupe());
        assertEquals(4,TestEtudiant.getAnnee());
    }
}