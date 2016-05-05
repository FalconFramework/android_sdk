package falconframework.samplefalconsdk;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import FalconAPIClientSDK.FFError;

import static org.junit.Assert.*;
/**
 * Created by luisresende on 05/05/16.
 */
public class FFErrorUnitTest {

    FFError error;

    @Before
    public void setUp(){
        error = new FFError();
        error.setCod(10);
        error.setMessage("Server Internal");
    }

    @Test
    public void testShouldGetErrorDescriptionMessage() throws Exception {
        assertEquals("Error 10: Server Internal",error.FFErrorDescriptionMessage());
    }
}
