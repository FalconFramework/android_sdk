package FalconAPIClientSDK;

/**
 * Created by luisresende on 04/05/16.
 */
public class FFAPIClient {

    private  String apiBaseUrl="";
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

    /**
     * Returns an Singleton Instance with parametres url and apiKey
     *
     * @param url an api base url for client
     * @param key an api key of client in server
     * @return  the static instance of this class
     */
    public FFAPIClient initWithBaseUrlAndApiKey(String url, String key){
        sharedClient().apiBaseUrl = url;
        sharedClient().apiKey = key;
        return sharedClient();
    }

    public String getApiBaseUrl() {
        return apiBaseUrl;
    }

    public void setApiBaseUrl(String apiBaseUrl) {
        this.apiBaseUrl = apiBaseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

}
