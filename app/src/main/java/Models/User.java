package Models;

import FalconAPIClientSDK.FFObject;

public class User extends FFObject {

    public String name;
    public String email;
    public Integer age;

    @Override
    public String resourceName() {
        return "user";
    }
}
