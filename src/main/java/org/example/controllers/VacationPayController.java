package org.example.controllers;

import org.example.services.VacationPayService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;

@RestController
public class VacationPayController {

    private final VacationPayService vacationPayService;

    public VacationPayController(VacationPayService vacationPayService) {
        this.vacationPayService = vacationPayService;
    }

    @GetMapping(path = "/calculate", params = {"salary", "vacationDays"})
    public ResponseEntity<Double> calculate(
            @RequestParam("salary") double salary,
            @RequestParam("vacationDays") int vacationDays
    ) {
        return ResponseEntity.ok(vacationPayService.calculateVacationSalary(salary, vacationDays));
    }
    @GetMapping(path = "/calculate", params = {"salary", "vacationBegin", "vacationEnd"})
    public ResponseEntity<Double> calculate(
            @RequestParam("salary") double salary,
            @RequestParam("vacationBegin") @DateTimeFormat(iso = DATE) LocalDate vacationBegin,
            @RequestParam("vacationEnd") @DateTimeFormat(iso = DATE) LocalDate vacationEnd
    ) {
        return ResponseEntity.ok(vacationPayService.calculateVacationSalary(salary, vacationBegin, vacationEnd));
    }
}
