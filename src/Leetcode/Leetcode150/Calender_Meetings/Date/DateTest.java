package Leetcode.Leetcode150.Calender_Meetings.Date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;

public class DateTest {
    public static void main(String[] args) {
        //1. Find day of week
        /*LocalDate localDate = LocalDate.of(2026, 6, 16);
        DayOfWeek day =
                localDate.getDayOfWeek();
        System.out.println(day);*/

        //2. Count days between two dates
        /*LocalDate start = LocalDate.of(2026, 1, 1);
        LocalDate end = LocalDate.of(2026, 6, 16);
        long days =ChronoUnit.DAYS.between(start,end);
        System.out.println(days);*/

        //3. Check Leap Year
        Year year =
                Year.of(2024);
        System.out.println(
                year.isLeap()
        );


    }
}
