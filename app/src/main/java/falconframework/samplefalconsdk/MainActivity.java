package falconframework.samplefalconsdk;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import FalconAPIClientSDK.FFAPIClient;
import FalconAPIClientSDK.FFUrlRequest;
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
    }
}
