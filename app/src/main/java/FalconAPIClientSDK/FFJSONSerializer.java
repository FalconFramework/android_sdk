package FalconAPIClientSDK;

import org.json.JSONObject;

import java.lang.reflect.Field;

public class FFJSONSerializer {

    public void serializePayload(JSONObject payload, Object model) {
        System.out.println("#############################");
        System.out.println(payload);
        System.out.println("#############################");

//        Object object1 = new Object();

        Class<?> myClass = model.getClass();
        Object object = new Object();
        try {
            object = myClass.newInstance();

            Field field = null;
            try {
                field = object.getClass().getDeclaredField("name");
                field.setAccessible(true);
                try {
                    field.set(object,"thiago");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("");

        try {
            System.out.println(object.getClass().getDeclaredField("name"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

}
