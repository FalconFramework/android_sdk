package falconframework.samplefalconsdk;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import java.util.*;
import FalconAPIClientSDK.FFJSONSerializer;
import Models.User;

import static org.mockito.Mockito.mock;

/**
 * Created by luisresende on 05/05/16.
 */
@RunWith(PowerMockRunner.class)
public class FFJSONSerializerTest {

    FFJSONSerializer<User> serializer = mock(FFJSONSerializer.class);
    JSONObject payload =  mock(JSONObject.class);
    @Before
    public void setUp(){

        try {
            payload = new JSONObject();

            JSONObject userObject = new JSONObject();
            userObject.put("id", "1");
            userObject.put("name", "Thiago");
            userObject.put("email", "thiago.mb@icloud.com");
            userObject.put("age", null);

            payload.put("user",userObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        serializer = new FFJSONSerializer<User>("user");
    }

    @Test
    public void testSerializePayload() {
        serializer.serializePayload(payload);
       // User user = serializer.serializePayload(payload);

    }
}
