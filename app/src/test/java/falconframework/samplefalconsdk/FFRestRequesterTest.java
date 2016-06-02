package falconframework.samplefalconsdk;


import android.test.AndroidTestCase;

import FalconAPIClientSDK.FFAPIClient;
import FalconAPIClientSDK.FFError;
import FalconAPIClientSDK.FFRequestListener;
import FalconAPIClientSDK.FFRestRequester;
import FalconAPIClientSDK.ServerPattern;
import falconframework.samplefalconsdk.Models.User;
import android.os.HandlerThread;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * Created by luisresende on 02/06/16.
 */
public class FFRestRequesterTest extends AndroidTestCase {

    private ArrayList<User> resultsCallback;
    private ArrayList<User> expectedResults = new ArrayList<User>();

    private HandlerThread mHandlerThread;
    private Semaphore semaphore;
    private ListenerImpl listenerImpl;
    private FFAPIClient apiSetting;

    private User user;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        apiSetting = new FFAPIClient("localhost:3000", "none", ServerPattern.JSONAPI);
        listenerImpl = new ListenerImpl();
        User user = new User();
//        user.setName("Luis");
//        user.setAge(21);
//        user.setEmail("luis@gmail.com");
        expectedResults.add(user);
        user.setRequestResponse(listenerImpl);
       // user.save();
    }

    public void testDoAsync(){


        user = new User();
        user.setRequestResponse(listenerImpl);
        user.setName("Luis");
        user.setAge(21);
        user.setEmail("luis@gmail.com");

        mHandlerThread = new MyHandler("handlerThread");

        semaphore = new Semaphore(0);
        mHandlerThread.start();

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mHandlerThread.quit();
        assertEquals(expectedResults, resultsCallback);
    }

    private class MyHandler extends HandlerThread{

        public MyHandler (String name){
            super(name);
        }

        @Override
        public void run() {
            user.save();
        }
    }

    private class ListenerImpl implements FFRequestListener<User>{

        @Override
        public void afterFindSuccess(ArrayList<User> objects) {

            resultsCallback = objects;
            semaphore.release();

        }

        @Override
        public void afterSaveSuccess(User object) {
            semaphore.release();

        }

        @Override
        public void afterDeleteSuccess(String status) {

        }

        @Override
        public void afterFindError(FFError error) {

        }

        @Override
        public void afterSaveError(FFError error) {
            semaphore.release();

        }

        @Override
        public void afterDeleteError(FFError error) {

        }
    }

}
