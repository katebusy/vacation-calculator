package org.example.calculators;

import java.time.LocalDate;

public interface VacationPayService {

    /**
     *
     * @param yearSalary
     * @param vacationDays
     * @return
     */
    double calculateVacationSalary(double yearSalary, int vacationDays);

    double calculateVacationSalary(double yearSalary, LocalDate vacationBegin, LocalDate vacationEnd);
}
