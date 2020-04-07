package sanchez.eighthLight.controllers;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CLIControllerTest {


    @Test
    public void testCliQuery(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CLIController testController = new CLIController();
        BookController bookController = new BookController();
        }

}
