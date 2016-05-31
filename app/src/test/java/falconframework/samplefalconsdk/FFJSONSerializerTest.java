package falconframework.samplefalconsdk;

import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.powermock.modules.junit4.PowerMockRunner;
import java.util.*;
import FalconAPIClientSDK.FFJSONSerializer;
import falconframework.samplefalconsdk.Models.User;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;

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

            JSONArray payloadArray = new JSONArray();

            JSONObject userObject = new JSONObject();
            userObject.put("id", 1);
            userObject.put("name", "Luis");
            userObject.put("email", "luis@icloud.com");
            userObject.put("age", 21);
            JSONObject userKey = new JSONObject();
            userKey.put("user",userObject);
           payloadArray.put(userKey);
            payload.put("users",payloadArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        serializer = new FFJSONSerializer<User>("user");
    }

    @Test
    public void testSerializePayload() {
        User user = new User();
        user.setAge(21);
        user.setEmail("luis@icloud.com");
        user.setName("Luis");

        ArrayList<User> users = new ArrayList<>();
        users = serializer.serializePayload(payload);
        User userPayload = users.get(0);
        assertEquals(user.getAge(),userPayload.getAge());
        assertEquals(user.getEmail(),userPayload.getEmail());
        assertEquals(user.getName(),userPayload.getName());

    }

    @Test
    public void testShouldReturnResourceName() {
        FFJSONSerializer<User> jsonSerializer = new FFJSONSerializer<User>("someResourceName");
        assertEquals(jsonSerializer.getResourceName(),"someResourceName");
    }

    @Test
    public void testDeserializePayload() {
        User user = new User();
        user.setAge(21);
        user.setEmail("luis@icloud.com");
        user.setName("Luis");

        RequestParams params = new RequestParams();
        params.put("name","Luis");
        params.put("email","luis@icloud.com");
        params.put("age","21");

        RequestParams requestParams = serializer.deserialize(user);

        //Refatorar Teste
        //assertEquals(params.toString(),requestParams.toString());

    }

}
