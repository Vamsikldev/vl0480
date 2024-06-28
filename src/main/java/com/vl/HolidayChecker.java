package com.vl;

import com.vl.domain.Tool;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;

public class HolidayChecker {

    private  static  final String CHAINSAW = "Chainsaw";
    public static boolean isHoliday(LocalDate date, Tool tool) {

        // Check for Independence Day
        MonthDay independenceDay = MonthDay.of(Month.JULY, 4);

        if(CHAINSAW.equals(tool.type) && date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                return false;
        }

        // Adjust Independence Day if it falls on a weekend
        if (independenceDay.atYear(date.getYear()).equals(date)) {
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
                return true; // Observed on Friday before
            } else if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                return true; // Observed on Monday after
            }
        }

        // Check if the date is the first Monday in September (Labor Day)
        if (date.getMonth() == Month.SEPTEMBER && date.getDayOfWeek() == DayOfWeek.MONDAY && date.getDayOfMonth() <= 7) {
            return true;
        }

        return false;
    }
}
