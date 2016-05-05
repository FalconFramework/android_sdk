package falconframework.samplefalconsdk;

import org.junit.Before;
import org.junit.Test;

import FalconAPIClientSDK.FFAPIClient;

import static org.junit.Assert.*;

/**
 * Created by luisresende on 05/05/16.
 */
public class FFAPIClientTest {

    @Test
    public void testShouldGetNewInstanceWithBaseUrlAndKey() throws Exception {
        FFAPIClient ffapiClient = null;
        ffapiClient = new FFAPIClient("url","apikey");
        assertNotNull(ffapiClient);
    }

    @Test
    public void testShouldGetSharedClient() throws Exception {
        FFAPIClient ffapiClient = null;
        ffapiClient = FFAPIClient.sharedClient();
        assertNotNull(ffapiClient);
    }

    @Test
    public void testShouldGetApiUrlAndApiKey() throws Exception {
        FFAPIClient ffapiClient = new FFAPIClient("www.falcon.com","keyapifalcon");

        assertEquals(FFAPIClient.sharedClient().getApiBaseUrl(),"www.falcon.com");
        assertEquals(FFAPIClient.sharedClient().getApiKey(),"keyapifalcon");
    }
}
