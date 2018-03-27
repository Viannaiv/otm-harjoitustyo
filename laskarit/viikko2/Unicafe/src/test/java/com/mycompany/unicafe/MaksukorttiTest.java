package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlussaOikein() {
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void lataaRahaaKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(100);
        assertEquals("saldo: 1.10", kortti.toString());
    }
    
    @Test
    public void otaRahaaPienentaaSaldoaOikein() {
        kortti.otaRahaa(10);
        assertEquals("saldo: 0.0", kortti.toString());
    }
    
    @Test
    public void otaRahaaEiMuutaSaldoaJosRahaaLiianVahan() {
        kortti.otaRahaa(20);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void otaRahaaPalauttaaTrueKunRahatRiittivat() {
        assertEquals(true, kortti.otaRahaa(10));
    }
    
    @Test
    public void otaRahaaPalauttaaFalseKunRahatEiRiita() {
        assertEquals(false, kortti.otaRahaa(20));
    }
}
