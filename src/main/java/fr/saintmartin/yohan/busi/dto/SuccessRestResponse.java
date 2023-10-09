package fr.saintmartin.yohan.busi.dto;

import org.springframework.http.HttpStatus;

public class SuccessRestResponse extends RestResponse {
    private String status;
    private int statusCode;
    private String message;
    public SuccessRestResponse(String message) {
        this.message = message;
        this.statusCode = HttpStatus.OK.value();
        this.status = HttpStatus.OK.name();
    }
    public SuccessRestResponse(String message, int statusCode, String status) {
        super();
        this.message = message;
        this.statusCode = statusCode;
        this.status = status;
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
}
