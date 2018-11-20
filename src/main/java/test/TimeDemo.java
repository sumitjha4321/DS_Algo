package test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by sumit.jha on 17/09/18.
 */
public class TimeDemo {

    public static void getTime(long millis) {
        LocalDateTime dt = LocalDateTime.ofInstant(Instant.ofEpochSecond(millis), ZoneId.systemDefault());

        System.out.println(dt.getMinute());
        dt = dt.withSecond(0).withNano(0).plusMinutes((70 - dt.getMinute()) % 10);
        System.out.println(dt.getHour() + " " + dt.getMinute());
        System.out.println(dt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());


    }

    public static void main(String[] args) {

        getTime(Long.valueOf("1537468199"));

    }
}
