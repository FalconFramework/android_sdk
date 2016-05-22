package FalconAPIClientSDK;

public class FFObject<T> {

    public FFRestAdapter adapter;
    public FFRequestResponse<T> requestResponse;


    public FFRequestResponse<T> getRequestResponse() {
        return requestResponse;
    }

    public void setRequestResponse(FFRequestResponse<T> requestResponse) {
        this.requestResponse = requestResponse;
    }

    public String resourceName(){
        return "invalid";
    }

    public void findAll() {
        this.beforeRequest();

        this.adapter.findAll();
    }

    public void findRecord(String id) {
        this.beforeRequest();
        this.adapter.findRecord(id);
    }

    private void beforeRequest() {
        if (this.adapter == null) {
            this.adapter = new FFRestAdapter(this.resourceName(), this.requestResponse);
        }
    }
}
