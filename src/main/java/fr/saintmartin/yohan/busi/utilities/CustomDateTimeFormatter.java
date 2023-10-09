package fr.saintmartin.yohan.busi.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomDateTimeFormatter {
    public static String localDateTimeToString(LocalDateTime dateTime){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss");
        return dateTime.format(dtf);
    }
}
