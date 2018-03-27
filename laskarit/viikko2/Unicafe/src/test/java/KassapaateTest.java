
import com.mycompany.unicafe.Kassapaate;
import com.mycompany.unicafe.Maksukortti;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class KassapaateTest {
    Kassapaate kassa;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(500);
    }
    
    @Test
    public void kassassaRahaaAlussaOikein() {
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void myytyjenLounaidenMaaraAlussaOikein() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoEdullisestiKasvattaaRahamaaraaKateisellaOikein() {
        kassa.syoEdullisesti(250);
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    @Test
    public void syoMaukaastiKasvattaaRahamaaraaKateisellaOikein() {
        kassa.syoMaukkaasti(410);
        assertEquals(100400, kassa.kassassaRahaa());
    }
    
    @Test
    public void syoMaukkaastiPalauttaaOikeanVaihtorahanKateisella() {
        assertEquals(10, kassa.syoMaukkaasti(410));
    }
    
    @Test
    public void syoEdullisestiPalauttaaOikeanVaihtorahanKateisella() {
        assertEquals(10, kassa.syoEdullisesti(250));
    }
    
    @Test
    public void edullisiaLounaitaMyytyKasvaaOikeinKateisella() {
        kassa.syoEdullisesti(240);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukkaitaLounaitaMyytyKasvaaOikeinKateisella() {
        kassa.syoMaukkaasti(400);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoEdullisestiEiMuutaRahamaaraaKunKateinenEiRiita() {
        kassa.syoEdullisesti(10);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void syoMaukkastiEiMuutaRahamaaraaKunKateinenEiRiita() {
        kassa.syoMaukkaasti(10);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void syoMaukkaastiPalauttaaRahatKunKateinenEiRiita() {
        assertEquals(20, kassa.syoMaukkaasti(20));
    }
    
    @Test
    public void syoEdullisestiPalauttaaRahatKunKateinenEiRiita() {
        assertEquals(20, kassa.syoEdullisesti(20));
    }
    
    @Test
    public void syoEdullisestiEiKasvataMyytyjaLounaitaKunKateinenEiRiita() {
        kassa.syoEdullisesti(30);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoMaukkastiEiKasvataMyytyjaLounaitaKunKateinenEiRiita() {
        kassa.syoMaukkaasti(30);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoEdullisestiVeloittaaKortiltaOikeanSumman() {
        kassa.syoEdullisesti(kortti);
        assertEquals(260, kortti.saldo());
    }
    
    @Test
    public void syoMaukkaastiVeloittaaKortiltaOikeanSumman() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(100, kortti.saldo());
    }
    
    @Test
    public void syoEdullisestiPalauttaaTrueKunKortillaRahaaTarpeeksi() {
        assertEquals(true, kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void syoMaukkaastiPalauttaaTrueKunKortillaRahaaTarpeeksi() {
        assertEquals(true, kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void syoEdullisestiKasvattaaMyytyjaLounaita() {
        kassa.syoEdullisesti(kortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoMaukkaastiKasvattaaMyytyjaLounaita() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoEdullisestiEiVeloitaKortiltaSaldonOllessaLiianPieni() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoEdullisesti(kortti);
        assertEquals(100, kortti.saldo());
    }
    
    @Test
    public void syoMaukkaastiEiVeloitaKortiltaSaldonOllessaLiianPieni() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(100, kortti.saldo());
    }
    
    @Test
    public void syoEdullisestiEiLisaaMyytyjaLounaitaKortinSaldonOllessaLiianPieni() {
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        assertEquals(2, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void syoMaukkaastiEiLisaaMyytyjaLounaitaKortinSaldonOllessaLiianPieni() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoEdullisestiPalauttaaFalseKortinSaldonOllessaLiianPieni() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(false, kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void syoMaukkaastiPalauttaaFalseKortinSaldonOllessaLiianPieni() {
        kassa.syoMaukkaasti(kortti);
        assertEquals(false, kassa.syoMaukkaasti(kortti));
    }
    
    @Test
    public void kassanRahamaaraEiMuutuKortillaOstettaessa() {
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void lataaRahaaKortilleLataaOikeanSummanKortille() {
        kassa.lataaRahaaKortille(kortti, 50);
        assertEquals(550, kortti.saldo());
    }
    
    @Test
    public void lataaRahaaKortilleLisaaOikeanSummanKassaan() {
        kassa.lataaRahaaKortille(kortti, 50);
        assertEquals(100050, kassa.kassassaRahaa());
    }
    
    @Test
    public void lataaRahaaKortilleEiLisaaKortilleNegatiivistaArvoa() {
        kassa.lataaRahaaKortille(kortti, -10);
        assertEquals(500, kortti.saldo());
    }
}
