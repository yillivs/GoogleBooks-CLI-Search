package sanchez.eighthLight.utilities;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JSONUtilityTest {

    @Test
    public void testReadApiKey(){
        JSONUtility jsonUtility = new JSONUtility();

        assertEquals(jsonUtility.readApiKey(),"AIzaSyDBycFB92OCbsj6Rka4s7zLr80OmOowTcM");
    }
}
