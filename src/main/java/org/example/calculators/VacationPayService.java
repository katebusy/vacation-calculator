package org.example.calculators;

import java.time.LocalDate;

public interface VacationPayService {

    /**
     * Метод, который принимает в качестве аргументов среднюю готовую зарплату и количество отпускных дней
     * и возвращаяет сумму отпусных, которые придут сотруднику.
     *
     * @param yearSalary
     * @param vacationDays
     * @return
     */
    double calculateVacationSalary(double yearSalary, int vacationDays);

    /**
     * Метод, который принимает в качестве аргументов среднюю готовую зарплату, дату начала отпуска
     * и дату последнего дня отпуска и возвращает сумму откпускных, которые придут сотруднику с учетом праздников.
     *
     * @param yearSalary
     * @param vacationBegin
     * @param vacationEnd
     * @return
     */
    double calculateVacationSalary(double yearSalary, LocalDate vacationBegin, LocalDate vacationEnd);
}
