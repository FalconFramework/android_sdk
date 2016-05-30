package falconframework.samplefalconsdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import FalconAPIClientSDK.FFAPIClient;
import FalconAPIClientSDK.FFError;
import FalconAPIClientSDK.FFRequestResponse;
import FalconAPIClientSDK.ServerPattern;
import Models.User;

public class MainActivity extends AppCompatActivity implements FFRequestResponse<User>{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set API settings
        FFAPIClient apiSetting = new FFAPIClient("192.168.0.21:3000", "none", ServerPattern.JSONAPI);
        User user = new User();
        user.setRequestResponse(this);
        user.findRecord("1");
    }

    @Override
    public void afterFindSuccess(ArrayList<User> objects) {
        User u = objects.get(0);
        u.setRequestResponse(this);
        System.out.println("######## Velho ##########");
        System.out.println(u.name);
        u.delete();
    }

    @Override
    public void afterSaveSuccess(User object) {
        System.out.println("######## Novo ##########");
        System.out.println(object.name);
    }

    @Override
    public void afterDeleteSuccess(String status) {

    }

    @Override
    public void afterFindError(FFError error) {

    }

    @Override
    public void afterSaveError(FFError error) {

    }

    @Override
    public void afterDeleteError(FFError error) {

    }
}
