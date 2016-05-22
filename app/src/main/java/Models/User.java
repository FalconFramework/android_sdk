package Models;

import FalconAPIClientSDK.FFObject;
import FalconAPIClientSDK.FFRequestResponse;

public class User extends FFObject {

    public String name;


    @Override
    public String resourceName() {
        return "user";
    }

}
