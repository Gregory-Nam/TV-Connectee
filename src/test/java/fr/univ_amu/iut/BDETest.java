package fr.univ_amu.iut;

import org.junit.Test;
import org.junit.*;

import static org.junit.Assert.*;

public class BDETest {


    @Test
    public void souldReturnCompleteClass(){
        BDE test = new BDE("admin","1324");
        assertEquals("admin",test.getEmail());
        assertEquals("1324", test.getMdp());

    }
}