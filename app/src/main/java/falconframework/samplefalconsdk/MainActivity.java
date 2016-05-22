package falconframework.samplefalconsdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import FalconAPIClientSDK.FFAPIClient;
import FalconAPIClientSDK.FFError;
import FalconAPIClientSDK.FFRequestResponse;
import Models.Post;
import Models.User;

public class MainActivity extends AppCompatActivity implements FFRequestResponse<User> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set API settings
        FFAPIClient apiSetting = new FFAPIClient("192.168.0.21:3000", "none");

//        Post post = new Post(this);
//        post.findAll();

        User user = new User();
        user.setRequestResponse(this);

//        user.findAll();
        user.findRecord("1");
//        user.findRecord("10");
//        user.findRecord('1');
//        user.query('adadadasd');
//        user.deleteRecord();
//        user.updateRecord();
//        user.createRecord();
    }

    @Override
    public void afterFindSuccess(ArrayList<User> objects) {
        System.out.println(objects.get(0).name);
    }

    @Override
    public void afterSaveSuccess(User object) {

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
