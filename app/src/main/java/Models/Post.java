package Models;

import FalconAPIClientSDK.FFObject;
import FalconAPIClientSDK.FFRequestResponse;

public class Post extends FFObject {


    @Override
    public String resourceName() {
        return "post";
    }
}
