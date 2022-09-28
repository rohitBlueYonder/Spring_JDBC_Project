WEB LAYER
CLIENT => displayed on the client

CONTROLLER => getPlayerController => Autowired Player DAO  => view -> json data => client


DAO layer
=> PlayerDAO => @Autowired JDBCTemplate

=> Jdbc Template => Querying => From the Database, Mapping to => Player Model [Encapsulated Data]


DATABASE


Architecture link:
https://drive.google.com/file/d/1I3tRl8oKDn7YJBADJUisSqqQXmTJy-D0/view?usp=sharing

-------------------------------------------------------------------
OVERVIEW:

CLIENT => BROWSER => REQUEST => http://localhost:8080/movies  => GET


TOMCAT SERVER => 127.0.01:8080 => SpringBootJDBCApp => Class => @SpringBootApplication


SpringBootJDBCApp => @ComponentScan => Player Controller @RestController[Bean] => Default Constructor => @Autowired Player DAO


PlayerDAO.getAllPlayers() =>Communicate with the Database using JDBC Template=>  @Autowired JDBC Template => Querying, RowMapping [Player Model] DAO=>

Image:
https://drive.google.com/file/d/1zh-lA4336Upk4H67mXPlJ_LVnkx16Ko6/view?usp=sharing

JPA Layer:
https://drive.google.com/file/d/17oghBGETMLB6HeFLVZiI1QQfSXEpor2R/view?usp=sharing

--------------------------------------------------------------------
REST API

HTTP => Hyper Text Transfer Protocol


Hypermedia Information, Collaborative Media => TCP Connections by default on PORT 80


Stateless => No Particular Form => HTML, JSON, XML, PDF, PNG, JPEG => Data Exchange

Statefull  => Restful API => JSON, XML => Proper Form


URL + HTTP + Restful API


URL: Location your server => 192.168.8.8:8080 => Flipkart.com

HTTP: TCP by 80 => Stateless => Data Exchange between your server and client

Restful API => Representational State Transfer => It should make sense

Client And Server

Browser App <=> Spring Boot App

URL + HTTP + Restful API[JSON,XML]

Weather App => Client => Request Temperature of Mumbai => Weather Data Its raining

GoogleMaps => Server => Response Temperature of Mumbai

Location: Mumbai
Temperature: 80 celsius

Link:
https://drive.google.com/file/d/1Jpdv77XTyuGgAbOkfHniEOO14I2vI4l-/view?usp=sharing

HTTP Methods
1. POST => CREATING A RESOURCE => h2Database testdb
2. GET => READING A RESOURCE => h2Database:testdb
3. PUT => UPDATING A RESOURCE => h2Database:testdb
4. DELETE => DELETING A RESOURCE=> h2Database:testdb
