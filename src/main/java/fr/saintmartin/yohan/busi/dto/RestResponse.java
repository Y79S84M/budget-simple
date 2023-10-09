package fr.saintmartin.yohan.busi.dto;

import fr.saintmartin.yohan.busi.utilities.CustomDateTimeFormatter;

import java.time.LocalDateTime;
import java.util.UUID;

public class RestResponse {
    private String rspId;
    private String dateTime;

    protected RestResponse() {
        this.rspId = UUID.randomUUID().toString();
        this.dateTime = CustomDateTimeFormatter.localDateTimeToString(LocalDateTime.now());
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
}
