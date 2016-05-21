package FalconAPIClientSDK;

import android.provider.UserDictionary;
import android.text.TextUtils;
import android.util.Log;

import com.loopj.android.http.*;

import org.json.JSONObject;

import Models.User;

public class FFRestAdapter extends FFURLBuilder implements FFAdapter {


    private AsyncHttpClient asyncHttp;
    private FFJSONSerializer serializer;

    public FFRestAdapter(FFJSONSerializer serializer) {
        this.asyncHttp = new AsyncHttpClient();
        this.serializer = serializer;
    }

    /**
     * Called by the FFResource in order to fetch the JSON for a given type and ID.
     * The findRecord method makes an Asynchronous request to a URL computed by buildURL,
     * and returns a promise for the resulting payload.
     * This method performs an HTTP GET request with the id provided as part of the query string.
     */
    @Override
    public void findRecord(final String modelName, String id, final Object model) {
        String url = this.buildURL("findRecord", modelName, id);
        final FFRestAdapter self = this;

        this.asyncHttp.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                self.serializer.serializePayload(jsonObject, model);
            }

            @Override
            public void onFailure(int statusCode, Throwable throwable, JSONObject error) {
                System.out.println(error);
            }
        });

        // Make GET CALL
    }

    /**
     * Called by the FFResource in order to fetch a JSON array for all of the records for a given type.
     * The findAll method makes an Asynchronous (HTTP GET) request to a URL computed by buildURL,
     * and returns a promise for the resulting payload.
     */
    @Override
    public void findAll(String modelName) {
        String url = this.buildURL("findAll", modelName);
        System.out.println(url);

        this.asyncHttp.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                System.out.println(jsonObject);
            }

            @Override
            public void onFailure(int statusCode, Throwable throwable, JSONObject error) {
                System.out.println(error);
            }
        });
    }

    /**
     * Called by the FFResource in order to fetch a JSON array for the records that match a particular query.
     * The query method makes an Asynchronous (HTTP GET) request to a URL computed by buildURL, and returns a
     * promise for the resulting payload.
     * The query argument is a simple Map object that will be passed directly to the server as parameters.
     */
    @Override
    public void query(String modelName, String query) {

    }

    /**
     * Called by FFResource when a newly created record is saved via the save method on a model
     * record instance. The createRecord method serializes the record and makes an Asynchronous
     * (HTTP POST) request to a URL computed by buildURL.
     * See serialize for information on how to customize the serialized form of a record.
     */
    @Override
    public void createRecord(String modelName) {
        String url = this.buildURL("createRecord", "post");

    }

    /**
     * Called by the FFResource when an existing record is saved via the save method on a model record instance.
     * The updateRecord method serializes the record and makes an Asynchronous (HTTP PUT) request to
     * a URL computed by buildURL.
     * See serialize for information on how to customize the serialized form of a record.
     */
    @Override
    public void updateRecord(String modelName, String id) {
        String url = this.buildURL("updateRecord", "post", "1");

    }

    /**
     * Called by the FFResource when a record is deleted.
     * The deleteRecord method makes an Asynchronous (HTTP DELETE) request to a URL computed
     * by buildURL.
     */
    @Override
    public void deleteRecord(String modelName, String id) {
        String url = this.buildURL("deleteRecord", "post", "1");

    }

}
