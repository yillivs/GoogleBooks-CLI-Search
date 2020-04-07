package sanchez.eighthLight.controllers;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLIController {

    public static void run(){

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter one of the following commands.\n's': Search\n'q': Quit");
            String input = "";

            while (!input.equalsIgnoreCase("q")) {
                input = reader.readLine();
                System.out.println(input);

            }

            reader.close();
        }
        catch (IOException e){
            System.err.println("I/O exception");
            e.printStackTrace();
        }
    }
}
