package fr.saintmartin.yohan.busi.utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.Integer.parseInt;

public class CustomDateTimeFormatter {
    public static String localDateTimeToString(LocalDateTime dateTime){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss");
        return dateTime.format(dtf);
    }
    public static String localDateToString(LocalDate date){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return date.format(dtf);
    }

    public static LocalDate toLocalDate(String createdOn) {
        String[] values = createdOn.split("\\.");
        return LocalDate.of(parseInt(values[2]),parseInt(values[1]),parseInt(values[0]));
    }
}
