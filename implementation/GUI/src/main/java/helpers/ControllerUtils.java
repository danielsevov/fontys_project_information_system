package helpers;

import businessentitiesapi.Entity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.Duration;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Util class for common controller functions.
 */
public class ControllerUtils {
    private ControllerUtils() {
    }

    /**
     * Maps entities with mapper and collect them in ObservableList.
     */
    public static <T extends Entity, R> ObservableList<R> entitiesToObservableList(
            Stream<T> entities, Function<? super T, ? extends R> mapper) {
        var mapped = entities.map(mapper);
        return mapped.collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public static <T extends Entity, R> ObservableList<R> entitiesToObservableListDistinct(
            Stream<T> entities, Function<? super T, ? extends R> mapper) {
        var mapped = entities.map(mapper).distinct();
        return mapped.collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    public static boolean isInteger(String s) {
        return isInteger(s, 10);
    }

    public static OptionalInt tryParseInt(String s, int radix) {
        try {
            return OptionalInt.of(Integer.parseInt(s, radix));
        } catch (NumberFormatException e) {
            return OptionalInt.empty();
        }
    }

    public static OptionalDouble tryParseDouble(String s) {
        try {
            return OptionalDouble.of(Double.parseDouble(s));
        } catch (NumberFormatException e) {
            return OptionalDouble.empty();
        }
    }

    public static boolean isInteger(String s, int radix) {
        if (s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) return false;
                else continue;
            }
            if (Character.digit(s.charAt(i), radix) < 0) return false;
        }
        return true;
    }


    public static <T> T mostCommon(List<T> list) {
        Map<T, Integer> map = new HashMap<>();

        for (T t : list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }

        Map.Entry<T, Integer> max = null;

        for (Map.Entry<T, Integer> e : map.entrySet()) {
            if (max == null || e.getValue() > max.getValue())
                max = e;
        }

        if(max == null) return null;
        return max.getKey();
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static String durationToString(Duration duration){
        String hours, minutes;
        long h, m;
        h = duration.toHours();
        m = duration.toMinutesPart();
        if(duration.toHours()==1) hours = "hour";
        else hours = "hours";
        if(duration.toMinutesPart()==1) minutes = "minute";
        else minutes = "minutes";
        return String.format("%d %s and %02d %s ",
                h,
                hours,
                m,
                minutes);
    }
}
