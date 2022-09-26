package helpers;

import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Converter singleton class for {@link LocalDate} objects.
 * <p>
 * This converter takes String input in the form of yy/MM/yyyy and turns them into
 * concrete date objects.
 */
public class DateConverter extends StringConverter<LocalDate> {
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(("yyyy-MM-dd HH:mm"));
    private static final DateConverter instance = new DateConverter();

    private DateConverter() {
        // Singleton class.
    }

    public static DateConverter getInstance() {
        return instance;
    }

    @Override
    public String toString(LocalDate localDate) {
        if (localDate == null)
            return "";
        return dateFormatter.format(localDate);
    }

    @Override
    public LocalDate fromString(String dateString) {
        if (dateString == null || dateString.trim().isEmpty()) {
            return null;
        }
        return LocalDate.parse(dateString, dateFormatter);
    }

    public LocalDateTime checkDateTime(String dateTime){
        if (dateTime == null || dateTime.trim().isEmpty()) {
            return null;
        }
        try{
            var date = LocalDateTime.parse(dateTime, dateTimeFormatter);
            return date;
        }catch (Exception e){
            return null;
        }
    }
}
