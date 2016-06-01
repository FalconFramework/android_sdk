package FalconAPIClientSDK;

import android.text.TextUtils;

import org.atteo.evo.inflector.English;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;


public class FFJSONApiURLBuilder extends FFURLBuilder {


    public FFJSONApiURLBuilder(){
        this.apiSettings = FFAPIClient.sharedClient();
        this.host = this.apiSettings.getHost();
        this.apiKey = this.apiSettings.getApiKey();
    }
    /**
     * Builds a URL for a given type and optional ID.
     * By default, it pluralizes the type's name (for example, 'post' becomes 'posts' and 'person' becomes 'people').
     * If an ID is specified, it adds the ID to the path generated for the type, separated by a /.
     */
    @Override
    public String buildURL(String requestType, String modelName) {
        switch (requestType) {
            case "findAll":
                return this._buildURL(modelName);
            case "query":
                return this._buildURL(modelName);
            case "createRecord":
                return this._buildURL(modelName);
            default:
                return this._buildURL(modelName);
        }
    }

    @Override
    public String buildURL(String requestType, String modelName, String id) {
        switch (requestType) {
            case "findRecord":
                return this._buildURL(modelName, id);
            case "updateRecord":
                return this._buildURL(modelName, id);
            case "deleteRecord":
                return this._buildURL(modelName, id);
            default:
                return this._buildURL(modelName,id);
        }
    }

    private String _buildURL(String modelName) {
        String path = this.pathForType(modelName);
        String host = this.host;

        return host + "/" + path;

//        ArrayList<String> stringArrayList = new ArrayList<String>(Arrays.asList(host, path));
//        return TextUtils.join("/", stringArrayList);
    }

    private String _buildURL(String modelName, String id) {
        String encodedID = null;
        try {
            encodedID = URLEncoder.encode(id, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return this._buildURL(modelName) + "/" + encodedID;
        //ArrayList<String> stringArrayList = new ArrayList<String>(Arrays.asList(this._buildURL(modelName), encodedID));
        //return TextUtils.join("/", stringArrayList);
    }

    private String pathForType(String modelName) {
        return English.plural(modelName);
    }
}

