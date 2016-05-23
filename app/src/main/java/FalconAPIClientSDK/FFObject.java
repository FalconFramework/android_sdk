package FalconAPIClientSDK;

public abstract class FFObject<T> {

    public Integer id;
    public FFRestAdapter adapter;
    public FFRequestResponse<T> requestResponse;

    public abstract String resourceName();

    public FFRequestResponse<T> getRequestResponse() {
        return requestResponse;
    }

    public void setRequestResponse(FFRequestResponse<T> requestResponse) {
        this.requestResponse = requestResponse;
    }

    public void findAll() {
        if (this.requestResponse == null) {
            return;
        }
        this.beforeRequest();
        this.adapter.findAll();
    }

    public void findRecord(String id) {
        if (this.requestResponse == null) {
            return;
        }
        this.beforeRequest();
        this.adapter.findRecord(id);
    }

    private void beforeRequest() {
        if (this.adapter == null) {
            this.adapter = new FFRestAdapter(this.resourceName(), this.requestResponse);
        }
    }

    public void save() {
        if (this.requestResponse == null) {
            return;
        }
        this.beforeRequest();

        if (this.id != null) {
            //update
            this.adapter.updateRecord(this);
        } else {
            //create
            this.adapter.createRecord(this);

        }
    }
}
