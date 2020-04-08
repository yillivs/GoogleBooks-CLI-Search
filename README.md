Program searches the GoogleBooksAPI for a user query.
<br/>
BookUtil/SRC/main/java/sanchez.eighthLight/<br/>
            -->Contains source files<br/>
            BookUtil/SRC/test/java/sanchez.eighthLight/<br/>
            -->Contains test   files<br/>
            Doc/<br/>
            -->Contains all JavaDocs with class definitions<br/>
            target/<br/>
            -->Contains compiled source files as well as executable JAR file.<br/>

To run the program excecute the JAR within the target folder using your local java compiler. Will look something like

`java -jar target/bookutil-1.0-SNAPSHOT-jar-with-dependencies.jar`

This project was compiled with Maven. If you have maven installed and the target package get's corrupted you can run

`maven compile assembly:single`

This will create the target folder with the appropriate executable.
