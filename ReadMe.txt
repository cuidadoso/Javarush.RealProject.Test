Java version: 1.7.0_79

Data base MySQL:
Shema: real_project
Table: test
Login: root
password: root
Date format for field 'createdDate': dd.mm.yyyy

Files applicationContext.xml, database.properties in src/main/resources use for Hibernate
and data base connection tests only in ru.alejandro.realproject.main.Main.Test class.

Web application configuration context defined in src/main/webapp/WEB-INF directory.
Used SpringMVC, Hibernate, Servlets.

Application server: Tomcat 8.22

Starting:
1. Create data base with setup.sql script on local station.
2. I used sheme real_project. If shema is different change in file database.properties
value for key = database.url to proper value.
3. Start application with Tomcat. Controller mapped to root request "/".