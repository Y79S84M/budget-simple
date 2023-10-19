package fr.saintmartin.yohan.busi.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.saintmartin.yohan.busi.utilities.CustomSerializer;

public class SuccessRestResponse extends RestResponse {

    @JsonProperty("data_returned")
    @JsonSerialize(using = CustomSerializer.class)
    private Object data;

    public SuccessRestResponse(String message, Object data, int statusCode, String status) {
        super(message,statusCode,status);
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
