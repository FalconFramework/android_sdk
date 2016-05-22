package FalconAPIClientSDK;

import com.loopj.android.http.*;

import Models.User;

public class FFObject {
    private FFJSONSerializer<?> serializer;
    private FFRestAdapter adapter;

    public FFObject() {
        this.serializer = new FFJSONSerializer<FFObject>();
        this.adapter = new FFRestAdapter(this.serializer);
    }

    public String resourceName() {
        return "undefined";
    }

    public void findAll() {
        this.adapter.findAll(this.resourceName());
    }

    public void findRecord(String id) {
        this.adapter.findRecord(this.resourceName(), id, this);
    }
}
