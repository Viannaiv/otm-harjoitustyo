# OTM-harjoitustyö: Minesweeper

Kurssin Ohjelmistotekniikan menetemät harjoitustyönä toteutettu Miinaharava-peli. Miinaharava-pelin idea ja säännöt ovat varmasti kaikille tuttuja. Tällä hetkellä vielä keskeneräinen.


## Dokumentaatio

[Tuntikirjanpito](https://github.com/Viannaiv/otm-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Vaatimusmäärittely](https://github.com/Viannaiv/otm-harjoitustyo/blob/master/dokumentaatio/vaatimusmäärittely.md)

[Arkkitehtuuri](https://github.com/Viannaiv/otm-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)


## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla  mvn test

Testikattavuusraportti luodaan komennolla  mvn test jacoco:report

### Checkstyle

Tiedoston checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla  mvn jxr:jxr checkstyle:checkstyle

### Suoritettavan jar-tiedoston generointi

Komennolla  mvn package  luodaan hakemistoon target suoritettava jar-tiedosto Minesweeper-1.0-SNAPSHOT.jar
