package fr.saintmartin.yohan.busi;

import fr.saintmartin.yohan.busi.utilities.CustomDateTimeFormatter;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomDateTimeFormatterTest {
    @Test
    public void localDateTimeFormatter_returnsCorrectFormatting(){
        String expected = "01.03.1988 09:45:00";
        LocalDateTime dateTime = LocalDateTime.of(1988,3,1,9,45,0);
        assertThat(CustomDateTimeFormatter.localDateTimeToString(dateTime)).isEqualTo(expected);
    }

    @Test
    public void localDateTimeFormatter_returnsFormattedDate(){
        String expected = "01.03.1988";
        LocalDate date = LocalDate.of(1988,3,1);
        assertThat(CustomDateTimeFormatter.localDateToString(date)).isEqualTo(expected);
    }
}
