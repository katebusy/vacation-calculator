package org.example.services;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class VacationPayServiceImpl implements VacationPayService {
    private static final int MONTH_IN_YEAR = 12;
    private static final double AVERAGE_COUNT_OF_DAYS_IN_MONTH = 29.3;

    @Override
    public double calculateVacationSalary(double yearSalary, int vacationDays) {
        double vacationSalary = calculateDaySalary(yearSalary) * vacationDays;
        double roundedSalary = Math.round(vacationSalary * 1000);
        return roundedSalary/1000;
    }

    @Override
    public double calculateVacationSalary(double yearSalary, LocalDate vacationBegin, LocalDate vacationEnd) {
        double vacationSalary = calculateDaySalary(yearSalary)
                * calculatePayableVacationDays(vacationBegin, vacationEnd);
        double roundedSalary = Math.round(vacationSalary * 1000);
        return roundedSalary/ 1000;
    }
    private double calculateDaySalary(double yearSalary) {
        return yearSalary / (MONTH_IN_YEAR * AVERAGE_COUNT_OF_DAYS_IN_MONTH);
    }
    private int calculatePayableVacationDays(LocalDate vacationBegin, LocalDate vacationEnd) {
        int paybleDays = (int) DAYS.between(vacationBegin, vacationEnd.plusDays(1));
        for (LocalDate day = vacationBegin;
             day.isBefore(vacationEnd.plusDays(1));
             day = day.plusDays(1)) {

            for (Holidays holiday : Holidays.values()) {
                holiday.setYear(vacationBegin.getYear());

                if (day.isEqual(holiday.getDateOfHoliday())
                        || (int) DAYS.between(Holidays.NEW_YEAR_HOLIDAYS.getDateOfHoliday(), day) < 7) {
                    paybleDays--;
                }
            }

        }
        return paybleDays;
    }
}
