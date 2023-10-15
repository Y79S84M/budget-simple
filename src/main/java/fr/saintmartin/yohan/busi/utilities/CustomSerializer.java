package fr.saintmartin.yohan.busi.utilities;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Map;

public class CustomSerializer extends JsonSerializer<Object> {
    private final Map<String,String> classNameMapping = Map.of(
            "BankAccountCreation", "bank_account",
            "BankAccountUpdate","bank_account",
            "BankAccountInfo", "bank_account",
            "String", "string"
    );
    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField(classNameMapping.get(o.getClass().getSimpleName()), o);
        jsonGenerator.writeEndObject();
    }
}
