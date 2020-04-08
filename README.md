Program searches the GoogleBooksAPI for a user query.

BookUtil/
            SRC/
                main/java/sanchez.eighthLight/
                -->Contains source files
                test/java/sanchez.eighthLight/
                -->Contains test   files
            Doc/
                -->Contains all JavaDocs with class definitions
            target/
                -->Contains compiled source files as well as executable JAR file.

To run the program excecute the JAR within the target folder using your local java compiler. Will look something like

`java -jar target/bookutil-1.0-SNAPSHOT-jar-with-dependencies.jar`

This project was compiled with Maven. If you have maven installed and the target package get's corrupted you can run

`maven compile assembly:single`

This will create the target folder with the appropriate executable.