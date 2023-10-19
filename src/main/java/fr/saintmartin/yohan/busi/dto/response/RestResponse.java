package fr.saintmartin.yohan.busi.dto.response;

import fr.saintmartin.yohan.busi.utilities.CustomDateTimeFormatter;

import java.time.LocalDateTime;
import java.util.UUID;

public class RestResponse {
    private String rspId;
    private String dateTime;
    protected String status;
    protected int statusCode;
    protected String message;

    protected RestResponse(String message, int statusCode, String status) {
        this.rspId = UUID.randomUUID().toString();
        this.dateTime = CustomDateTimeFormatter.localDateTimeToString(LocalDateTime.now());
        this.message = message;
        this.statusCode = statusCode;
        this.status = status;
    }

    protected String getRspId() {
        return rspId;
    }

    protected void setRspId(String rspId) {
        this.rspId = rspId;
    }

    protected String getDateTime() {
        return dateTime;
    }

    protected void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    protected String getStatus() {
        return status;
    }

    protected void setStatus(String status) {
        this.status = status;
    }

    protected int getStatusCode() {
        return statusCode;
    }

    protected void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    protected String getMessage() {
        return message;
    }

    protected void setMessage(String message) {
        this.message = message;
    }
}
