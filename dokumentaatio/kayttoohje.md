# Käyttöohje

Lataa tiedosto []()

### Konfigurointi
Sovellus ei tarvitse muuta kuin yllämainitun jar.tiedoston ladattuna.

### Ohjelman käynnistäminen
Ohjelma käynnistyy komennolla ```java -jar minesweeper.jar```

### Valikko
Sovellus käynistyy valikko-näkymään:

![Valikkonäkymä](https://github.com/Viannaiv/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/menu.PNG)

Pelin aloittaminen tapahtuu painamalla nappia "New Game" (alkava peli on suunnilleen tasoltaan keskivaikea)

### Pelin alku ja ruutujen avaaminen
Peli näyttää alussa seuraavalta: 

![Pelin alku](https://github.com/Viannaiv/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/starting.PNG)

Pelin pelaaminen aloitetaan klikkaamalla hiiren vasemmalla näppäimellä jotakin ruutua, joka tällöin avautuu.
Avautuneessa ruudussa voi olla numero joka kertoo, kuinka monta miinaa ruudussa kiinni olevissa ruuduissa on yhteensä. 
Ruutu voi myös olla tyhjä, jolloin yhdessäkään sen viereisessä ruudussa ei ole miinaa. (Tällä hetkellä tyhjän ruudun vieressä olevat ruudut joutuu vielä itse avaamaan, myöhemmin tämä tulee tapahtumaan automaattisesti.) Jos avautuneessa ruudussa taas on kirjain M, on kyseessä oleva ruutu miinoitettu ja peli hävitty. (Peli tulee tulevaisuudessa siirtymään tässä kohtaa näkymään, jossa pelin loppumisesta kerrotaan.

![Pelin päättyminen miinaan](https://github.com/Viannaiv/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/mine.PNG)

### Lippujen asettaminen ja pelin tarkoitus
Jonkin aikaa pelattuna peli näyttää esimerkiksi tältä:

![Peli](https://github.com/Viannaiv/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/playing.PNG)

Kuvassa näkyvät F kirjaimet edustavat lippuja, joilla merkitään miinoitettuja ruutuja. Pelissä miinoja on yhteensä 40 miinaa, jotka kaikki tulisi paikantaa miinotetut ruudut liputtamalla (ruutuja ei siis tule avata). Liputtaminen onnistuu hiiren oikealla näppäimellä. Peli päättyy häviöön, jos pelaaja osuu miinaan ja voittoon jos pelaaja onnistuu liputtamaan kaikki miinoiteut ruudut. (Tähänkin tulee myöhemmin ilmoitus voitosta. Tällä hetkellä vielä mitään ei tapahdu voitettaessa eikä hävittäessä)
