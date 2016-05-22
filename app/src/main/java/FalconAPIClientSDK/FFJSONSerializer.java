package FalconAPIClientSDK;

import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class FFJSONSerializer<T> {

//    private final Class<T> type;

    private String resourceName;

    public FFJSONSerializer(String resourceName) {
        this.resourceName = resourceName;
    }


    public T serializePayload(JSONObject payload) {
        System.out.println("#############################");
        System.out.println(payload);
        System.out.println("#############################");


        Class<T> resourceClass = null;
        try {
            String className = this.resourceName.substring(0, 1).toUpperCase() + this.resourceName.substring(1);
            className = "Models." + className;
            resourceClass = (Class<T>)Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        T object = null;
        try {
            object = resourceClass.getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

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
        System.out.println("");

        try {
            System.out.println(object.getClass().getDeclaredField("name"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


        return  object;
    }

}
