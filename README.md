# OTM-harjoitustyö: Minesweeper

Kurssin Ohjelmistotekniikan menetemät harjoitustyönä toteutettu Miinaharava-peli. Miinaharava-pelin idea ja säännöt ovat varmasti kaikille tuttuja. Tällä hetkellä vielä keskeneräinen.


## Dokumentaatio

[Tuntikirjanpito](https://github.com/Viannaiv/otm-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Vaatimusmäärittely](https://github.com/Viannaiv/otm-harjoitustyo/blob/master/dokumentaatio/vaatimusmäärittely.md)

[Arkkitehtuuri](https://github.com/Viannaiv/otm-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Käyttöohje](https://github.com/Viannaiv/otm-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Testaus](https://github.com/Viannaiv/otm-harjoitustyo/blob/master/dokumentaatio/testaus.md)


## Releaset
[Release 1: Viikko 5](https://github.com/Viannaiv/otm-harjoitustyo/releases/tag/otm)

[Release 2: Viikko 6](https://github.com/Viannaiv/otm-harjoitustyo/releases/tag/otm-release2)

[]()

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla  ```mvn test```

Testikattavuusraportti luodaan komennolla  ```mvn jacoco:report``` ja sitä voi tarkastella avaamalla selaimella tiedosto target/site/jacoco/index.html

### Checkstyle

Tiedoston checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla  ```mvn jxr:jxr checkstyle:checkstyle``` ja mahdollisia virheilmoituksia voi tarkastella avaamalla selaimella tiedosto target/site/checkstyle.html

### Suoritettavan jar-tiedoston generointi

Komennolla  ```mvn package```  luodaan hakemistoon target suoritettava jar-tiedosto Minesweeper-1.0-SNAPSHOT.jar

### JavaDoc

Komennolla ```mvn javadoc:javadoc``` generoidaan JavaDoc, jonka tarkastelu onnistuu avaamalla
tiedosto target/site/apidocs/index.html
