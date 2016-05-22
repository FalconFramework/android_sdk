package Models;

import FalconAPIClientSDK.FFObject;
import FalconAPIClientSDK.FFRequestResponse;

public class Post extends FFObject {

    public String name;


    @Override
    public String resourceName() {
        return "post";
    }
}
