package falconframework.samplefalconsdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import FalconAPIClientSDK.FFAPIClient;
import Models.Post;
import Models.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set API settings
        FFAPIClient apiSetting = new FFAPIClient("localhost:3000", "none");

        Post post = new Post();
        post.findAll();

        User user = new User();
        user.findAll();
        user.findRecord("10");
//        user.findRecord('1');
//        user.query('adadadasd');
//        user.deleteRecord();
//        user.updateRecord();
//        user.createRecord();
    }
}
