package org.example.services;

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

    /**
     * Метод, который возвращает количество праздничных дней за год
     *
     * @return
     */
    public static int countOfAllHolidays() {
        int countOfAllHolidays = 0;
        for (Holidays holiday : Holidays.values()) {
            countOfAllHolidays += holiday.getCountOfDays();
        }
        return countOfAllHolidays;
    }

    /**
     * Метод, который возвращает полную дату праздника
     *
     * @return
     */
    public LocalDate getDateOfHoliday() {
        return LocalDate.parse(getYear() + this.getDate());
    }

    /**
     * Метод, который возвращает количество дней в празднике
     *
     * @return
     */
    public int getCountOfDays() {
        return countOfDays;
    }

    /**
     * Метод, который возвращает дату праздника без года в формате String
     *
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * Метод, который возвращает заданный год
     *
     * @return
     */
    public int getYear() {
        return year;
    }

    /**
     * Метод, который принимает и задает год
     *
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }
}

