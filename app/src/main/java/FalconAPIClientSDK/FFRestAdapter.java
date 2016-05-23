package FalconAPIClientSDK;

import com.loopj.android.http.*;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;


public class FFRestAdapter<T extends FFObject> extends FFURLBuilder implements FFAdapter<T> {


    private AsyncHttpClient asyncHttp = new AsyncHttpClient();
    private FFJSONSerializer<T> serializer;
    private String resourceName;
    private FFRequestResponse<T> requestResponse;

    public FFRestAdapter(String resourceName, FFRequestResponse<T> requestResponse) {
        this.resourceName = resourceName;
        this.requestResponse = requestResponse;
        serializer =  new FFJSONSerializer<>(resourceName);
    }

    /**
     * Called by the FFResource in order to fetch the JSON for a given type and ID.
     * The findRecord method makes an Asynchronous request to a URL computed by buildURL,
     * and returns a promise for the resulting payload.
     * This method performs an HTTP GET request with the id provided as part of the query string.
     */
    @Override
    public void findRecord(String id) {
        String url = this.buildURL("findRecord", this.resourceName, id);
        final FFRestAdapter self = this;
        this.asyncHttp.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                ArrayList<T> response = (ArrayList<T>) self.serializer.serializePayload(jsonObject);
                self.requestResponse.afterFindSuccess(response);
            }

            @Override
            public void onFailure(int statusCode, Throwable throwable, JSONObject error) {
                System.out.println(error);
            }
        });
    }

    /**
     * Called by the FFResource in order to fetch a JSON array for all of the records for a given type.
     * The findAll method makes an Asynchronous (HTTP GET) request to a URL computed by buildURL,
     * and returns a promise for the resulting payload.
     */
    @Override
    public void findAll() {
        String url = this.buildURL("findAll", this.resourceName);
        final FFRestAdapter self = this;

        this.asyncHttp.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                ArrayList<T> response = (ArrayList<T>) self.serializer.serializePayload(jsonObject);
                self.requestResponse.afterFindSuccess(response);
            }

            @Override
            public void onFailure(int statusCode, Throwable throwable, JSONObject error) {
                System.out.println(error);
            }
        });
    }

//    /**
//     * Called by the FFResource in order to fetch a JSON array for the records that match a particular query.
//     * The query method makes an Asynchronous (HTTP GET) request to a URL computed by buildURL, and returns a
//     * promise for the resulting payload.
//     * The query argument is a simple Map object that will be passed directly to the server as parameters.
//     */
//    @Override
//    public void query(String modelName, String query) {
//
//    }

    /**
     * Called by FFResource when a newly created record is saved via the save method on a model
     * record instance. The createRecord method serializes the record and makes an Asynchronous
     * (HTTP POST) request to a URL computed by buildURL.
     * See serialize for information on how to customize the serialized form of a record.
     */
    @Override
    public void createRecord(final T model) {
        String url = this.buildURL("createRecord", this.resourceName);
        final FFRestAdapter self = this;

        RequestParams params = this.serializer.deserialize(model);

        this.asyncHttp.post(url, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                System.out.println(jsonObject);
                try {
                    model.id = jsonObject.getJSONObject(self.resourceName).getInt("id");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                self.requestResponse.afterSaveSuccess(model);
            }

            @Override
            public void onFailure(int statusCode, Throwable throwable, JSONObject error) {
                System.out.println(error);
            }
        });
    }

    /**
     * Called by the FFResource when an existing record is saved via the save method on a model record instance.
     * The updateRecord method serializes the record and makes an Asynchronous (HTTP PUT) request to
     * a URL computed by buildURL.
     * See serialize for information on how to customize the serialized form of a record.
     */
    @Override
    public void updateRecord(final T model) {
        String url = this.buildURL("updateRecord", this.resourceName, model.id.toString());

        final FFRestAdapter self = this;

        RequestParams params = this.serializer.deserialize(model);

        this.asyncHttp.put(url, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                self.requestResponse.afterSaveSuccess(model);
            }

            @Override
            public void onFailure(int statusCode, Throwable throwable, JSONObject error) {
                System.out.println(error);
            }
        });
    }

    /**
     * Called by the FFResource when a record is deleted.
     * The deleteRecord method makes an Asynchronous (HTTP DELETE) request to a URL computed
     * by buildURL.
     */
    @Override
    public void deleteRecord(String id) {
        String url = this.buildURL("deleteRecord", this.resourceName, id);
        final FFRestAdapter self = this;

        this.asyncHttp.delete(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                self.requestResponse.afterDeleteSuccess("204");
            }

            @Override
            public void onFailure(int statusCode, Throwable throwable, JSONObject error) {
                System.out.println(error);
            }
        });
    }


}
