package falconframework.samplefalconsdk.Models;

import FalconAPIClientSDK.FFObject;

public class User extends FFObject {

    public String name;
    public String email;
    public Integer age;

    @Override
    public String resourceName() {
        return "user";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
