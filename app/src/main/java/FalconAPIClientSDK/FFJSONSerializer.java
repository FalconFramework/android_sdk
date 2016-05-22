package FalconAPIClientSDK;

import org.json.JSONObject;

import java.lang.reflect.Field;

public class FFJSONSerializer<T> {

    public T serializePayload(JSONObject payload, Object model) {
        System.out.println("#############################");
        System.out.println(payload);
        System.out.println("#############################");

//        Object object1 = new Object();
        Class<T> aClass = (Class<T>) model.getClass();
        T object = null;
        try {
            object = aClass.newInstance();

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


        return  object;
    }

}
