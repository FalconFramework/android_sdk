package FalconAPIClientSDK;

public class FFObject<T> {

    public FFRestAdapter adapter;

    public FFObject() {
        adapter = new FFRestAdapter<T>(resourceName());
    }

    public String resourceName(){
        return "invalid";
    }

    public void findAll() {
        this.adapter.findAll();
    }

    public void findRecord(String id) {
        this.adapter.findRecord(id);
    }
}
