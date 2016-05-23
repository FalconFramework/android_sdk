package FalconAPIClientSDK;

import android.content.Context;

/**
 * Created by luisresende on 04/05/16.
 */
public class FFAPIClient {

    private  String host="";
    private  String apiKey = "";
    private Context context;

    private static FFAPIClient ourInstance = new FFAPIClient();

    /**
     * Returns an Singleton Instance
     *
     * @return  the static instance of this class
     */
    public static FFAPIClient sharedClient() {
        return ourInstance;
    }

    private FFAPIClient(){

    }
    /**
     * Set in Singleton Instance the parametres url and apiKey
     *
     * @param url an api base url for client
     * @param key an api key of client in server
     */
    public FFAPIClient (String url, String key, Context context){
        sharedClient().host = this.normalizeNakedURL(url);
        sharedClient().apiKey = key;
        sharedClient().context = context.getApplicationContext();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String apiBaseUrl) {
        this.host = apiBaseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return this.context;
    }

    private String normalizeNakedURL(String nakedURL) {
        return "http://" + nakedURL;
    }

}
