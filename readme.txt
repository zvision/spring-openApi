
Simpel Spring Boot projekt implementerar OpenApi 

Hur/vad göra
============

- Att bygga: mvn clean package 
- Att köra:  mvn spring-boot:run    (java -jar target\spring-openApi-0.0.1-SNAPSHOT.jar)

- Debug: mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5000 -Dserver.port=8080"
 och sen i Eclipse meny -välj  "Debug configurations..." -> och skapa en "Remote Java Application",  
 sätt parametrarna Host: localhost, Port: 5000

Tjänsten kan nås
----------------
http://localhost:8080/index.html


In-memory databasen
----------------------------
http://localhost:8080/h2-console/login.do   (lösen: password)


Api dokumentaion
----------------
http://localhost:8080/swagger-ui.html



Ex på record
-----------------
{"firstName":"Graham","lastName":"Bell","email":"graham.bell@abc.com","email1":"belly@abc.com","age":38}
{"firstName":"Thomas","lastName":"Edison","email":"thomas.edison@abc.com","email1":"Eddy@abc.com","age":33}