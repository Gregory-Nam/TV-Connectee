package fr.univ_amu.iut;

import org.junit.Test;
import org.junit.*;

import static org.junit.Assert.*;

public class AdministrateurTest {


   @Test
    public void souldReturnCompleteClass(){
        Administrateur testAdmin = new Administrateur("admin","1324");
        assertEquals("admin",testAdmin.getEmail());
        assertEquals("1324", testAdmin.getMdp());

    }
}