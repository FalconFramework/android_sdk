package FalconAPIClientSDK;

import java.util.ArrayList;

/**
 * Created by luisresende on 05/05/16.
 */
public interface FFObjectResponse {
    void afterFindSuccess(ArrayList<Object> objects);
    void afterSaveSuccess(Object object);
    void afterDeleteSuccess(String status);
    void afterFindError(FFError error);
    void afterSaveError(FFError error);
    void afterDeleteError(FFError error);
}
