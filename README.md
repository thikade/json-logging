# Json-logger
simple java application using log4j2 to test standard logging AND exception stacktrace logging in JSON format to console/files.
- Docs for advanced Json Formatter: https://logging.apache.org/log4j/2.x/manual/json-template-layout.html

## Uber-Jar
- Uber-jar using maven-assembly plugin works in principle BUT NOT WHEN YOU WANT TO USE Json*Template*Layout!  => https://issues.apache.org/jira/browse/LOG4J2-3321
- Uber-jar works when using the default (but now deprecated) *JsonLayout*, though!

### Workaround
- Don't use uber-jar, use *maven-dependency-plugin* to copy dependencies to target/lib directory
- we also use *maven-dependency-plugin* to copy final artifact to a new directory.  
  **Note:**  that *copy*-goal must be bound to a phase **after** *package* phase, else there is no artifact to copy yet!
- Running app via `java -jar target/app.jar` will then automatically pick up `target/lib` folder in classpath!

## Run
```
cd json-logger
mvn clean install
java -jar json-logger/target/final/json-logger.jar 
```