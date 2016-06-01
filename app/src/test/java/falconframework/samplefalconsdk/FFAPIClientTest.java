package falconframework.samplefalconsdk;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;

import org.junit.Before;
import org.junit.Test;

import FalconAPIClientSDK.FFAPIClient;
import FalconAPIClientSDK.ServerPattern;

import static org.junit.Assert.*;

/**
 * Created by luisresende on 05/05/16.
 */
public class FFAPIClientTest {

    @Test
    public void testShouldGetNewInstanceWithBaseUrlAndKeyAndContext() throws Exception {
        FFAPIClient ffapiClient = null;
        ffapiClient = new FFAPIClient("url","apikey",ServerPattern.NONE);
        assertNotNull(ffapiClient);
    }

    @Test
    public void testShouldGetSharedClient() throws Exception {
        FFAPIClient ffapiClient = null;
        ffapiClient = FFAPIClient.sharedClient();
        assertNotNull(ffapiClient);
    }

    @Test
    public void testShouldGetApiKeyAndServerPattern() throws Exception {
        Context context = Application.class.newInstance();
        FFAPIClient ffapiClient = new FFAPIClient("www.falcon.com","keyapifalcon", ServerPattern.JSONAPI);
        assertEquals(FFAPIClient.sharedClient().getApiKey(),"keyapifalcon");
        assertEquals(FFAPIClient.sharedClient().getServerPattern(),ServerPattern.JSONAPI);
    }

    @Test
    public void testShouldNormalizeNakedUrl() throws Exception {
        FFAPIClient ffapiClient = new FFAPIClient("www.falcon.com.br","keyapifalcon", ServerPattern.NONE);
        assertEquals(FFAPIClient.sharedClient().getHost(),"http://www.falcon.com.br");
    }
}
