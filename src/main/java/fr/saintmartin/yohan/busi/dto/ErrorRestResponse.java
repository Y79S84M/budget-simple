package fr.saintmartin.yohan.busi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.saintmartin.yohan.busi.utilities.CustomSerializer;

public class ErrorRestResponse extends RestResponse{

    @JsonProperty("technical_message")
    private String technicalMessage;
    @JsonProperty("data_submitted")
    @JsonSerialize(using = CustomSerializer.class)
    private Object data;
    public ErrorRestResponse(String message, String technicalMessage, Object data, int statusCode, String status) {
        super(message,statusCode,status);
        this.technicalMessage = technicalMessage;
        this.data = data;
    }

    public String getTechnicalMessage() {
        return technicalMessage;
    }

    public void setTechnicalMessage(String technicalMessage) {
        this.technicalMessage = technicalMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
