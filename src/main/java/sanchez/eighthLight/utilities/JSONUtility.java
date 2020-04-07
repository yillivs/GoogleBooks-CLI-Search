package sanchez.eighthLight.utilities;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONUtility {

    /**
     * Reads and parses googleBooksAPIkey.
     * @return key
     */
    public String readApiKey() {
        String result = "";
        try{
            Object obj = new JSONParser().parse(new FileReader("resources/api.json"));

            JSONObject jsonObj = (JSONObject) obj;

            result = (String) jsonObj.get("key");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
