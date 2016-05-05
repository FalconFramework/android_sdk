package FalconAPIClientSDK;

/**
 * Created by luisresende on 05/05/16.
 */
public class FFError {

    private Integer cod=0;

    private String message="";

    /**
     * Returns an Error Description Message that can then be show
     * on the screen.
     * This method construct an error description message with
     * his actual propertys
     *
     * @return      the error description message
     */
    public String FFErrorDescriptionMessage(){
        return "Error " + getCod() + ": " + getMessage();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

}
