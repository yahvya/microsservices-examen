package yahvya.appointment.response;

/**
 * @brief application response format
 */
public class Response {
    /**
     * @brief success state
     */
    public boolean success;

    /**
     * @brief data
     */
    public Object data;

    public Response(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }
}
