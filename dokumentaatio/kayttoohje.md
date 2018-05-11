# Käyttöohje

Lataa tiedosto []()

### Konfigurointi
Sovellus ei tarvitse muuta kuin yllämainitun jar.tiedoston ladattuna.

### Ohjelman käynnistäminen
Ohjelma käynnistyy komennolla ```java -jar minesweeper.jar```

### Valikko
Sovellus käynistyy valikko-näkymään:

![Valikkonäkymä](https://github.com/Viannaiv/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/menu.PNG)

Pelin aloittaminen tapahtuu painamalla jotain näkymän kolmesta nappista. "New Game (Easy)" aloittaa vaikeudeltaan helpon pelin, jossa ruudukon koko on 9x9 ja miinoja on 10. "New Game (Intermediate)" aloittaa vaikeudeltaan keskivaikean pelin, jossa ruudukon koko on 16x16 ja miinoja on 40. "New Game (Hard)" aloittaa vaikeudeltaan vaikean pelin, jossa ruudukon koko on 30x16 ja miinoja on 99.

### Pelin alku ja ruutujen avaaminen
Keskivaikea peli näyttää alussa seuraavalta: 

![Pelin alku](https://github.com/Viannaiv/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/starting.PNG)

Pelin pelaaminen aloitetaan klikkaamalla hiiren vasemmalla näppäimellä jotakin ruutua, joka tällöin avautuu.
Avautuneessa ruudussa voi olla numero joka kertoo, kuinka monta miinaa ruudussa kiinni olevissa ruuduissa on yhteensä. 
Ruutu voi myös olla tyhjä, jolloin yhdessäkään sen viereisessä ruudussa ei ole miinaa. Tyhjän ruudun avaaminen avaa myös kaikki vieressä olevat tyhjät ruudut sekä niden vieressä olevat ruudut. Jos avautuneessa ruudussa taas on kirjain M, on kyseessä oleva ruutu miinoitettu ja peli hävitty. Pelaaja ei koskaan M-kirjainta näe, sillä peli siirtyy tällöin automaattisesti näkmään, jossa pelaajalle kerrotaan tämän osuneen miinaan ja hävinneen pelin.

![Peli hävitty](https://github.com/Viannaiv/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/gameover.PNG)

### Lippujen asettaminen ja pelin tarkoitus
Jonkin aikaa pelattuna tasoltaan helppo peli näyttää esimerkiksi tältä:

![Peli](https://github.com/Viannaiv/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/playing.PNG)

Kuvassa näkyvät F kirjaimet edustavat lippuja, joilla merkitään miinoitettuja ruutuja. Pelissä miinoja on vaikeustasosta riippuen yhteensä joko 10, 40 tai 99 miinaa, jotka kaikki tulisi paikantaa miinotetut ruudut liputtamalla tai vaihtoehtoisesti avaamalla kaikki miinoittamattomat ruudut. Liputtaminen onnistuu hiiren oikealla näppäimellä. Peli päättyy häviöön, jos pelaaja osuu miinaan (siirrytään yllä esitettyyn häviönäkymään) ja voittoon jos pelaaja onnistuu liputtamaan kaikki miinoiteut ruudut/ avaamaan kaikki miinoittamattomat ruudut. Pelin päättyessä voittoon ilmoitetaan siitä pelaajalle siirtymällä voittonäkymään: 

![Peli voitettu](https://github.com/Viannaiv/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/win.PNG)

Sekä voitto, että häviönäkymässä on nappi "Return to menu", jota painamalla pääsee takaisin aloitusvalikkoon, josta voi jälleen aloitaa uuden pelin.
