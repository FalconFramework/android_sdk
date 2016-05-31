package FalconAPIClientSDK;

import android.content.Context;



/**
 * Created by luisresende on 04/05/16.
 */
public class FFAPIClient {

    private  String host="";
    private  ServerPattern serverPattern = ServerPattern.NONE;
    private  String apiKey = "";

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
    public FFAPIClient (String url, String key, ServerPattern serverPattern){
        sharedClient().setHost(this.normalizeNakedURL(url));
        sharedClient().setApiKey(key);
        sharedClient().setServerPattern(serverPattern);
    }

    public String getHost() {
        return host;
    }

    private void setHost(String apiBaseUrl) {
        this.host = apiBaseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    private void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    private String normalizeNakedURL(String nakedURL) {
        return "http://" + nakedURL;
    }

    public ServerPattern getServerPattern() {
        return serverPattern;
    }

    private void setServerPattern(ServerPattern serverPattern) {
        this.serverPattern = serverPattern;
    }

}
