package fr.saintmartin.yohan.busi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

public class SuccessRestResponse extends RestResponse {
    private String status;
    private int statusCode;
    private String message;
    @JsonProperty("data")
    private Object data;

    public SuccessRestResponse(String message, Object data, int statusCode, String status) {
        super();
        this.message = message;
        this.statusCode = statusCode;
        this.status = status;
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

    public Object getBkAccInfo() {
        return data;
    }

    public void setBkAccInfo(Object data) {
        this.data = data;
    }
}
