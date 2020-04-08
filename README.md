Program searches the GoogleBooksAPI for a user query.
<br/>
`BookUtil/SRC/main/java/sanchez.eighthLight/`<br/>
-Contains source files<br/>
`BookUtil/SRC/test/java/sanchez.eighthLight/`<br/>
-Contains test files<br/>
`BookUtil/Doc/`<br/>
-Contains all JavaDocs with class definitions<br/>
`BookUtil/target/`<br/>
-Contains compiled source files as well as executable JAR file.<br/>

To run the program execute the JAR within the target folder from the top-level project folder using your local java compiler.

`java -jar target/bookutil-1.0-jar-with-dependencies.jar`

This project was compiled with Maven. If you have maven installed and the target package get's corrupted you can run

`maven compile assembly:single`

This will create the target folder with the appropriate executable.

The approach taken to complete this project was first I drew out a diagram with the class tree. I had a rough idea of
everything I needed and how it all fit together. I wanted it to be modular so my Main class might call a Driver class
which is in charge of the application loop. But as for the modules that conform the Driver class I would like them to be
built with appropriate decoupling. I started writing from the class within my project object tree that was furthest
from my Main method. This was my Book Class as well  as my API Client, I wrote the test for both classes, watched them fail.
Then I began building the actual methods that were being tested until they passed. I kept this approach for the most part
until I got down to my CLI controller.