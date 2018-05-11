# Arkkitehtuurikuvaus

### Rakenne
Ohjelman pakkausrakenne on seuraava:

![Pakkausrakenne](https://github.com/Viannaiv/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/pakkauskaavio.png)

Pakkaus minesweeper.ui sisältää JavaFX:llä toteutetun käyttöliittymän ja minesweeper.domain sisältää sovelluslogiikan.


### Käyttöliittymä

Käyttöliitymä sisältää tällä hetkellä neljä näkymää:
- valikko
- peli
- voitto
- häviö

Näkymät on jokainen toteutettu omana Scene-olioinaan, jotka ovat yksi kerrallaan sijoitettuina sovelluksen stageen. Kaikki käyttöliittymän rakennukseen liittyvä on toteutettu ohjelmallisesti luokassa minesweeper.ui.MinesweeperUI (MinesweeperUI hyödyntää luokkaa minesweeper.ui.TileStackPane pelinäkymässä olevien Tileja edustavien StackPanien luomiseen) ja pyritty eristämään sovelluslogiikasta, jota se käsittelee lähinnä kutsumalla luokan minesweeper.domain.GameLogic metodeja. 

### Sovelluslogiikka

Sovelluksen luokkakaavio:

![Luokkakaavio](http://yuml.me/da092d7a.png)

Käyttöliittymän toiminnoille löytyy GameLogic luokasta vastaavat metodit (esim. openTile(int x, int y) ja flagTile(int x, int y), joilla 
Field olion sisältämiä Tile olioita GameLogicin kautta käsitellään. 

### Esimerkki toiminnallisuudesta

Kuvataan sovelluksen toimintalogiikkaa toiminnallisuuksia kuvaavien sekvenssikaavioiden avulla.

#### Sekvenssikaavio tekstin asettamisesta ruutuihin peli näkymässä:

Kun ruudulle (jonka x koordinaatti on 3 ja y koordinaatti 1 sekä ruudun lähellä olevien miinojen lukumäärän kertovan attribuutin minesNear arvona on 0 ja ruutu on miinoitettu) halutaan asettaa String-muotoinen arvo, (joka näytetään, kun käyttäjä avaa kyseisen ruudun käyttöliittymässä) etenee sovelluksen kontrolliseuraavasti:

![Sekvenssikaavio](https://github.com/Viannaiv/otm-harjoitustyo/blob/master/dokumentaatio/kuvat/sekvenssikaavio1.png)

### Ohjelman rakenteeseen jääneitä heikkouksia

Metodien ja muuttujien nimentää voisi parantaa. Gamescenea rakentava metodi createGamescene() luokassa MinesweeperUIssa voitaisiin pilkkoa osiin, jotta metodi hieman lyhenisi.

