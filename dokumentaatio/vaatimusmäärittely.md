# Vaatimusmäärittely

### Sovelluksen tarkoitus
Sovelluksen tarkoituksena on toimia ajankuluna ja viihdykkeenä pulmapeleistä ja erityisesti
Miinaharavasta pitäville ihmisille. Kyseessä on siis Miinaharava-peli, jonka perusidea on
varmasti kaikille tuttu..

### Käyttäjät
Vain normaali käyttäjä eli pelin pelaaja.

### Käyttöliittymä
Sovellus koostuu neljästä eri näkymästä valikko-, peli-, voitto- ja häviö näkymistä. Valikkonäkymä, jossa voi valita kolmesta eri vaikeustasosta (easy, intermediate ja hard) aloitettavan pelin vaikeden. Painamalla jotakin kolmesta napista siirrytään pelinäkymään, jossa miinaharava-peli on pelattavissa. Pelinäkymästä siirrytään pelin voitettessa voittonäkymään, jossa käyttäjäle kerrotaan, että peli on voitettu ja tarjotaan mahdollisuus nappia painamalla siirtyä valikkonäkymään. Jos peli hävitään eli pelaaja avaa miinallisen ruudun, siirrytään häviönäkymään, jossa pelaajalle kerrotaan tämän hävinneen pelin ja tarjotaan mahdollisuus nappia painamalla siirtyä takaisin valikonäkymään.

### Toiminnallisuudet
#### 1. Perusversio
- käyttäjä voi aloittaa pelin (joko vaikeudeltaan helppo, keskivaikea tai vaikea)
- käyttäjä voi valita sijoittaa ruutuun lipun (F), jolla hän merkkaa miinan oletetun sijainnin
- käyttäjä voi poistaa ruudussa olevan lipun
- ruutujen liputtaminen/lipun poistaminen muuttaa pelin ylälaidassa näkyvää lukua, joka kertoo jäljellä olevien liputtamattomien miinojen lukumäärän
- käyttäjä voi valita avata ruudun, jolloin joko ruutu aukeaa tai peli loppuu jos 
  ruudussa oli miina
- käyttäjä näkee avattuissa ruuduissa olevat vihjeet / tyhjät ruudut
- tyhjän ruudun avaaminen avaa myös viereiset tyhjät ruudut ja niiden vihjeet
- peli loppuu, kun kaikki miinoitetut ruudut on liputettu tai kaikki miinoittamattomat ruudut avattu

#### 2. Jatkokehitysideat
- käyttäjä voi luoda kustomoidun pelin, jossa käyttäjän haluama määrä ruutuja ja miinoja
- käyttäjä näkee tilastotietoa voitoistaan ja häviöistään
- sovellukssen voisi lisätä esimerkiksi päivän idean tai jonkin vastaavan vinkki/info-
  toiminnallisuuden
- graafiikan parantaminen
