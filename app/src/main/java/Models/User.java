package Models;

import FalconAPIClientSDK.FFObject;

public class User extends FFObject {

    public String name;

    @Override
    public String resourceName() {
        return "user";
    }

    public User() {


    }

}
