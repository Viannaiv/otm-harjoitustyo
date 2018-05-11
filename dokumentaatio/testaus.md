# Testausdokumentti

Ohjelmaa on testattu sekä automatisoiduin testein JUnitilla. Sekä testaamalla itse sovelluksen toimivuutta. Sovelluksen manuaaliset toimivuus testit on suoritettu Windows-ympäristössä.

## JUnit testit
### Sovelluslogiikka

Automatisoidut testit testaavat sovelluslogiikkaa eli pakkauksen minesweeper.domain luokkia. TileTest testaa luokkaa Tile, FieldTest miinakentän ja siihen kuuluvat Tilet muuodostavaa Field-luokkaa ja GamaLogicTest luokkaa GameLogicTest.

### Testauskattavuus
Testauksen rivikattavuus on 79% ja haaraumakattavuus 71%

![Jacoco-report](https://github.com/Viannaiv/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/jacoco.PNG)

Käyttöliittymään liittyvän pakkauksen minesweeper.ui sisältämät käyttöliittymää rakentavat luokat on jätetty pois testikattavuusraportista.

Muutamat tapaukset, kuten GameLogic luokan metodin getMinesNearAsStringForTile(int x, int y) palauttama arvo tai saman luokan metodin  openEmptyTiles(int x, int y) on jätetty testaamatta automaattisesti. Metodientoiminta on kuienkin kattavasti testattu manuaalisesti pelaamalla peliä ja tarkastelemalla niiden toimintaa pelissä.

### Asennus ja kanfigurointi
Sovellus on haettu ja sitä on testattu käyttöohjeen kuvaamalla tavalla sekä Windows-ympäristöön.

### Toiminnallisuudet
Kaikki määrittelydokumentin ja käyttöohjeen listaamat toiminnallisuudet on käyty läpi. Ja mahdollisia virhetilanteita pelin päättymisen kannalta testattu.
