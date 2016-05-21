package FalconAPIClientSDK;
import org.atteo.evo.inflector.English;


public class FFUrlRequest {

    private FFAPIClient apiSettings = FFAPIClient.sharedClient();


    private String buildURL(String resourceName) {
        String baseURL = this.apiSettings.getApiBaseUrl();
        String pulizeredResourceName = English.plural(resourceName);

        return baseURL + pulizeredResourceName;
    }

    private String buildURL(String resourceName, int id) {
        String baseURL = this.apiSettings.getApiBaseUrl();
        String pulizeredResourceName = English.plural(resourceName);

        return baseURL + pulizeredResourceName + "/" + id;
    }

    public String urlForFindAll(String resourceName) {
        return this.buildURL(resourceName);
    }
}
