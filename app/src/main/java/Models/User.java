package Models;

import FalconAPIClientSDK.FFObject;

public class User extends FFObject {

    @Override
    public String resourceName() {
        return "user";
    }
}
