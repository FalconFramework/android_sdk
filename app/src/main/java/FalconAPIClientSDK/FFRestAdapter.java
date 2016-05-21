package FalconAPIClientSDK;

import com.loopj.android.http.*;

public class FFRestAdapter extends FFURLBuilder implements FFAdapter {


    private AsyncHttpClient asyncHttp;

    public FFRestAdapter() {
        this.asyncHttp = new AsyncHttpClient();
    }

    /**
     * Called by the FFResource in order to fetch the JSON for a given type and ID.
     * The findRecord method makes an Asynchronous request to a URL computed by buildURL,
     * and returns a promise for the resulting payload.
     * This method performs an HTTP GET request with the id provided as part of the query string.
     */
    @Override
    public void findRecord(String modelName, String id) {
        String url = this.buildURL("findRecord", modelName, id);
        System.out.println(url);


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
        // Make GET CALL

        this.asyncHttp.get(url, new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                // called before request is started
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                // called when response HTTP status is "200 OK"
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }

            @Override
            public void onRetry(int retryNo) {
                // called when request is retried
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
