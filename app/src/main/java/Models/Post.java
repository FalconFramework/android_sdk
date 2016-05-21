package Models;

import FalconAPIClientSDK.FFObject;

public class Post extends FFObject {

    public String name;

    @Override
    public String resourceName() {
        return "post";
    }
}
