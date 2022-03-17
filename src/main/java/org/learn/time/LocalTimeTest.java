package org.learn.time;

import java.time.LocalDateTime;

/**
 * @author : gaoluu
 * @date : Created in 5:49 下午 2022/1/5
 */

public class LocalTimeTest {

    public static void main(String[] args) {
//        System.out.println(LocalDateTime.now());
//        System.out.println(LocalDate.now());
//        System.out.println(LocalTime.MIN);
//        System.out.println(LocalTime.MAX);
//        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0, 0)));
//        LocalDateTime now = LocalDateTime.now();
//        String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        System.out.println(format);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.toLocalTime().getSecond());
        System.out.println(now.toLocalTime().toSecondOfDay());

    }

}
