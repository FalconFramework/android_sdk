package FalconAPIClientSDK;

public abstract class FFObject<T> {

    public Integer id;
    public FFRestRequester currentRequester;
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
        this.currentRequester.findAll();
    }

    public void findRecord(String id) {
        if (this.requestResponse == null) {
            return;
        }
        this.beforeRequest();
        this.currentRequester.findRecord(id);
    }

    private void beforeRequest() {
        if (this.currentRequester == null) {
            this.currentRequester = new FFRestRequester(this.resourceName(), this.requestResponse);
        }
    }

    public void save() {
        if (this.requestResponse == null) {
            return;
        }
        this.beforeRequest();

        if (this.id != null) {
            //update
            this.currentRequester.updateRecord(this);
        } else {
            //create
            this.currentRequester.createRecord(this);

        }
    }

    public void delete() {
        this.beforeRequest();
        if (this.id != null) {
            System.out.println(this.id);
            this.currentRequester.deleteRecord(String.valueOf(this.id));
        }
    }
}
