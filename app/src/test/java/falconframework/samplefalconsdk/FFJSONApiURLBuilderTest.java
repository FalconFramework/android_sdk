package falconframework.samplefalconsdk;

import org.junit.Before;
import org.junit.Test;

import FalconAPIClientSDK.FFAPIClient;
import FalconAPIClientSDK.FFJSONApiURLBuilder;
import FalconAPIClientSDK.ServerPattern;

import static org.junit.Assert.*;

/**
 * Created by luisresende on 31/05/16.
 */
public class FFJSONApiURLBuilderTest {

    FFAPIClient ffapiClient;
    FFJSONApiURLBuilder ffjsonApiURLBuilder;

    @Before
    public void setUp(){
        ffapiClient = new FFAPIClient("www.falcon.com","keyapifalcon", ServerPattern.JSONAPI);
        ffjsonApiURLBuilder = new FFJSONApiURLBuilder();
    }


    @Test
    public void testShouldGetNewInstance(){
        assertNotNull(ffjsonApiURLBuilder);
    }

    @Test
    public void testBuildUrlFindAll(){
        String url = ffjsonApiURLBuilder.buildURL("findAll","user");
        assertEquals(url,"http://www.falcon.com/users");
    }

    @Test
   public void testBuildUrlQuery(){
        String url = ffjsonApiURLBuilder.buildURL("query","user");
        assertEquals(url,"http://www.falcon.com/users");
    }

    @Test
    public void testBuildUrlCreateRecord(){
        String url = ffjsonApiURLBuilder.buildURL("createRecord","user");
        assertEquals(url,"http://www.falcon.com/users");
    }

    @Test
    public void testBuildUrlDefault(){
        String url = ffjsonApiURLBuilder.buildURL("","user");
        assertEquals(url,"http://www.falcon.com/users");
    }

    @Test
    public void testBuildUrlWithIDFindRecord(){
        String url = ffjsonApiURLBuilder.buildURL("findRecord","user","1");
        assertEquals(url,"http://www.falcon.com/users/1");
    }

    @Test
    public void testBuildUrlWithIDUpdateRecord(){
        String url = ffjsonApiURLBuilder.buildURL("updateRecord","user","1");
        assertEquals(url,"http://www.falcon.com/users/1");
    }

    @Test
    public void testBuildUrlWithIDDeleteRecord(){
        String url = ffjsonApiURLBuilder.buildURL("deleteRecord","user","1");
        assertEquals(url,"http://www.falcon.com/users/1");
    }

    @Test
    public void testBuildUrlWithIDDefault(){
        String url = ffjsonApiURLBuilder.buildURL("","user","1");
        assertEquals(url,"http://www.falcon.com/users/1");
    }
}
