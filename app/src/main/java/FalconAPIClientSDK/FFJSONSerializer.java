package FalconAPIClientSDK;

import com.loopj.android.http.RequestParams;

import org.atteo.evo.inflector.English;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

    public class FFJSONSerializer<T> {

    //    private final Class<T> type;

        private String resourceName;

        public String getResourceName() {
            return resourceName;
        }

        private void setResourceName(String resourceName) {
            this.resourceName = resourceName;
        }

        public FFJSONSerializer(String resourceName) {
            setResourceName(resourceName);
        }

        public ArrayList<T> serializePayload(JSONObject payload) {

            ArrayList<T> serializedPayload = new ArrayList<T>();


            if (payload.has(this.pluralizedResourceName())) {
                JSONArray payloadArray = null;
                try {
                    payloadArray = payload.getJSONArray(this.pluralizedResourceName());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Iterator<T> jsonArrayIterator  = new FFJSONSerializerIterator<>(this.resourceName, payloadArray);
                while (jsonArrayIterator.hasNext()) {
                    T object = jsonArrayIterator.next();
                    serializedPayload.add(object);
                }

            } else {
                try {
                    serializedPayload.add(this.serialize(payload.getJSONObject(this.resourceName)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            return serializedPayload;
        }

        protected T serialize(JSONObject payload) {
            T newResource = this.newResourceInstance();

            try {
                payload = payload.getJSONObject(this.resourceName);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            Iterator<?> keys = payload.keys();

            while(keys.hasNext()) {
                String key = (String)keys.next();
                try {
                    Object value = payload.get(key);
                    this.setFildToInstace(value, key, newResource);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            return  newResource;
        }

        private Class<T> getResourceClass() {
            Class<T> resourceClass = null;
            try {
                String className = "falconframework.samplefalconsdk.Models." + this.capitalizedResourceName();
                resourceClass = (Class<T>)Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            return resourceClass;
        }

        private T newResourceInstance() {
            Class<T> resourceClass = this.getResourceClass();
            T newResourceInstace = null;

            try {
                newResourceInstace = resourceClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            return newResourceInstace;
        }

        private String capitalizedResourceName() {
            return this.resourceName.substring(0, 1).toUpperCase() + this.resourceName.substring(1);
        }

        private String pluralizedResourceName() {
            return English.plural(this.resourceName);
        }

        private void setFildToInstace(Object fieldValue, String fieldName, T instance) {
            Field field = null;

            try {
                field = instance.getClass().getField(fieldName);
                field.setAccessible(true);
                try {
                    field.set(instance, fieldValue);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }

        public RequestParams deserialize(T model) {
            Field[] fields = this.getResourceClass().getFields();

            RequestParams params = new RequestParams();

//            Map<Object, Object> map = new HashMap<Object, Object>();

            for (Field field : fields ) {
                try {
                    if (field.get(model) != null )
                        params.put(field.getName(), "" + field.get(model));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

//            params.put(this.resourceName, map);

            return params;
        }

    }
