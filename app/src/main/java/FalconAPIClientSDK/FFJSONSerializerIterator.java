package FalconAPIClientSDK;

import com.loopj.android.http.RequestParams;

import org.atteo.evo.inflector.English;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FFJSONSerializerIterator<T>  extends FFJSONSerializer<T> implements Iterator<T> {

    JSONArray array;
    int position = 0;

    public FFJSONSerializerIterator(String resourceName,JSONArray jsonArray) {
        super(resourceName);
        this.array = jsonArray;
    }

    @Override
    public boolean hasNext() {
        try {
            if (position >= array.length() || array.get(position) == null) {
                return false;
            } else {
                return true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }    }

    @Override
    public T next() {
        try {
            T object = this.serialize(array.getJSONObject(this.position));
            position++;
            return object;
        }catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void remove() {

    }
}
