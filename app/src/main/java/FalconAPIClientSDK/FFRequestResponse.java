package FalconAPIClientSDK;

import java.util.ArrayList;

/**
 * Created by luisresende on 05/05/16.
 */
public interface FFRequestResponse<T> {

    /**
     * This method is for running a code after operation
     * find become success
     *
     * @param objects list of return objects if find success
     */
    void afterFindSuccess(ArrayList<T> objects);

    /**
     * This method is for running a code after operation
     * save become success
     *
     * @param object a return object if save success
     */
    void afterSaveSuccess(T object);

    /**
     * This method is for running a code after operation
     * delete become success
     *
     * @param status an actual status if delete success
     */
    void afterDeleteSuccess(String status);

    /**
     * This method is for running a code after operation
     * find return an error.
     *
     * @param error an error that causes find operation fail
     */
    void afterFindError(FFError error);

    /**
     * This method is for running a code after operation
     * save return an error.
     *
     * @param error an error that causes save operation fail
     */
    void afterSaveError(FFError error);

    /**
     * This method is for running a code after operation
     * delete return an error.
     *
     * @param error an error that causes delete operation fail
     */
    void afterDeleteError(FFError error);
}
