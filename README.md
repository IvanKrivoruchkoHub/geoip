# RESTful GeoIP Web Service
# Table of Contents
* [Project purpose](#purpose)
* [Project structure](#structure)
* [For developer](#developer-start)
* [Authors](#authors)
# <a name="purpose"></a>Project purpose

<hr>
It is a REST application that has one method GET /geoip/{ip}. 

Example request GET http://localhost:8080/geoip/8.8.8.8

Example response: 

{"canonicalIPv4Representation":"8.8.8.8",
"countryCode":"US",
"countryName":"United States of America",
"regionName":"California",
"cityName":"Mountain View",
"latitude":37.405992,
"longitude":-122.078515}

<hr>

# <a name="structure"></a>Project Structure
* Java 11
* Maven 4.0.0
* SpringBoot 2.2.7.RELEASE
* Hibernate 
* mysql-connector-java 
<hr>

# <a name="developer-start"></a>For developer
Open the project in your IDE.

Add it as maven project.

Add sdk 11.0.3 in project struсture.

Change a spring.datasource.url, spring.datasource.username 
and spring.datasource.password in src/main/resources/application.properties on your own properties.

Follow these steps to create a database:
* Download csv file from https://lite.ip2location.com/database/ip-country-region-city-latitude-longitude
* Change a path in src/main/resources/init_db.sql on the path to your csv file that you downloaded
* Execute file src/main/resources/init_db.sql

Run the project.

<hr>

# <a name="authors"></a>Authors
[Ivan Krivoruchko](https://github.com/IvanKrivoruchkoHub)