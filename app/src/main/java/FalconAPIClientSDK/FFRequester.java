package FalconAPIClientSDK;

/**
 An currentRequester is an object that receives requests from a FFResource and
 translates them into the appropriate action to take against your
 persistence layer. The persistence layer is usually an HTTP API, but
 may be anything, such as local storage. Typically the
 currentRequester is not invoked directly instead its functionality is accessed
 through the FFResource.

 FFRequester is an abstract base class that you should override in your
 application to customize it for your backend. The minimum set of methods
 that you should implement is:

   findRecord()
   createRecord()
   updateRecord()
   deleteRecord()
   findAll()
   query()
 */

public interface FFRequester<T> {

    /**
     * The `findRecord()` method is invoked when the FFResource is asked for a record.
     * In response to `findRecord()` being called, you
     * should query your persistence layer for a record with the given ID. The `findRecord`
     * method should return a promise that will resolve to a FFResource object that will be
     * normalized by the serializer.
     * @param FFResource
     * @param ID
     */
    void findRecord(String id);

    /**
     * The `findAll()` method is used to retrieve all records for a given type.
     */
    void findAll();


    /**
     * Implement this method in a subclass to handle the creation of a new records.
     * Serializes the record and sends it to the server.
     */
    void createRecord(T model);

    /**
     * Implement this method in a subclass to handle the updating of a record.
     * Serializes the record update and sends it to the server.
     */
    void updateRecord(T model);

    /**
     * Implement this method in a subclass to handle the deletion of a record.
     * Sends a delete request for the record to the server.
     */
    void deleteRecord(String id);
}
