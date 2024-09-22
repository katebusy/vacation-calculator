package org.example.utils;

import java.time.LocalDate;

public enum Holidays {

    NEW_YEAR_HOLIDAYS(8, "-01-01"),
    DEFENDER_DAY(1, "-02-23"),
    WOMEN_DAY(1, "-03-08"),
    SPRING_DAY(1, "-05-01"),
    VICTORY_DAY(1, "-05-09"),
    DAY_OF_RUSSIA(1, "-07-12"),
    NATION_UNION_DAY(1, "-11-04");

    private int countOfDays;
    private String date;
    private int year;

    Holidays(int countOfDays, String date) {
        this.year = LocalDate.now().getYear();
        this.date = date;
        this.countOfDays = countOfDays;

    }

    public static int countOfAllHolidays() {
        int countOfAllHolidays = 0;
        for (Holidays holiday : Holidays.values()) {
            countOfAllHolidays += holiday.getCountOfDays();
        }
        return countOfAllHolidays;
    }

    public LocalDate getDateOfHoliday() {
        return LocalDate.parse(getYear() + this.getDate());
    }

    public int getCountOfDays() {
        return countOfDays;
    }

    public String getDate() {
        return date;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

