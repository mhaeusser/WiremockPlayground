# Wiremock

Some basic [Wiremock](<http://wiremock.org/) tests.

### How to run
(1) [Download the standalone jar](http://repo1.maven.org/maven2/com/github/tomakehurst/wiremock-standalone/2.23.2/wiremock-standalone-2.23.2.jar), as described on <http://wiremock.org/docs/running-standalone/>

(2) Copy the `test files` folder next to where the wiremock-standalone-2.23.2.jar file resides.

(3) Start the server: `java -jar wiremock-standalone-2.23.2.jar`



Try these URLs (browser or curl):

http://localhost:8080/api/mytest 
returns response defined in `mappings/stuff.json`



http://localhost:8080/content.html
returns contents of `__files\content.html`

