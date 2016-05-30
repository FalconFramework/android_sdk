package FalconAPIClientSDK;

import android.text.TextUtils;

import org.atteo.evo.inflector.English;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;


public abstract class FFURLBuilder {

    protected FFAPIClient apiSettings;
    protected String host;
    protected String apiKey;
    /**
     * Builds a URL for a given type and optional ID.
     * By default, it pluralizes the type's name (for example, 'post' becomes 'posts' and 'person' becomes 'people').
     * If an ID is specified, it adds the ID to the path generated for the type, separated by a /.
     */
    public abstract String buildURL(String requestType, String modelName);
    public abstract String buildURL(String requestType, String modelName, String id);

}

