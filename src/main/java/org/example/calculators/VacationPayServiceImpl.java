package org.example.calculators;

import org.example.utils.Holidays;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class VacationPayServiceImpl implements VacationPayService {
    private static final int MONTH_IN_YEAR = 12;
    private static final double AVERAGE_COUNT_OF_DAYS_IN_MONTH = 29.3;

    @Override
    public double calculateVacationSalary(double yearSalary, int vacationDays) {
        return calculateDaySalary(yearSalary) * vacationDays;
    }

    @Override
    public double calculateVacationSalary(double yearSalary, LocalDate vacationBegin, LocalDate vacationEnd) {
        return calculateDaySalary(yearSalary)
                * calculatePayableVacationDays(vacationBegin, vacationEnd);
    }

    /**
     * Метод, который принимает среднюю годовую зарплату и возвращает среднюю дневную зарплату
     *
     * @param yearSalary
     * @return
     */
    private double calculateDaySalary(double yearSalary) {
        return yearSalary / (MONTH_IN_YEAR * AVERAGE_COUNT_OF_DAYS_IN_MONTH);
    }

    /**
     * Метод, который принимает дату начала отпуска и дату последнего дня отпуска и возвращает
     * количество оплачиваемых отпускных дней с учетом праздников
     *
     * @param vacationBegin
     * @param vacationEnd
     * @return
     */
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
