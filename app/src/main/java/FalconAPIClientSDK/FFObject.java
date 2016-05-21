package FalconAPIClientSDK;

/**
 * Created by luisresende on 04/05/16.
 */
public class FFObject {
    private FFJSONSerializer serializer;
    private FFUrlRequest adapter;

    public FFObject() {
        this.serializer = new FFJSONSerializer();
        this.adapter = new FFUrlRequest();
    }

    public String resourceName() {
        return "undefined";
    }

    public void findAll() {
        String url = this.adapter.urlForFindAll(this.resourceName());
        System.out.println(url);
    }
}
