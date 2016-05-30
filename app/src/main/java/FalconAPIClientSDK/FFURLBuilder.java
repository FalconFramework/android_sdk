package FalconAPIClientSDK;

public abstract class FFURLBuilder {

    protected FFAPIClient apiSettings;
    protected String host;
    protected String apiKey;

    public abstract String buildURL(String requestType, String modelName);
    public abstract String buildURL(String requestType, String modelName, String id);

}

