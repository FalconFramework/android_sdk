package FalconAPIClientSDK;

/**
 * Created by luisresende on 04/05/16.
 */
public class FFAPIClient {

    private  String host="";
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
    public FFAPIClient (String url, String key){
        sharedClient().host = this.normalizeNakedURL(url);
        sharedClient().apiKey = key;
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

    private String normalizeNakedURL(String nakedURL) {
        return "http://" + nakedURL;
    }

}
