package fr.saintmartin.yohan.busi.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.saintmartin.yohan.busi.utilities.CustomSerializer;

import java.util.List;

public class ErrorRestResponse extends RestResponse {

    @JsonProperty("technical_message")
    private List<String> technicalMessage;
    @JsonProperty("data_submitted")
    @JsonSerialize(using = CustomSerializer.class)
    private Object data;
    public ErrorRestResponse(String message, List<String> technicalMessage, Object data, int statusCode, String status) {
        super(message,statusCode,status);
        this.technicalMessage = technicalMessage;
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
    public List<String> getTechnicalMessage() {
        return technicalMessage;
    }

    public void setTechnicalMessage(List<String> technicalMessage) {
        this.technicalMessage = technicalMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
