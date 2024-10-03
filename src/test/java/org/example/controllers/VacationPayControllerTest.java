package org.example.controllers;

import jdk.jfr.ContentType;
import org.example.services.VacationPayService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.regex.Matcher;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringJUnitConfig({
        VacationPayController.class
})
@MockBean(VacationPayService.class)
@WebMvcTest
class VacationPayControllerTest {

    @Autowired
    private VacationPayController vacationPayController;

    @Autowired
    private VacationPayService vacationPayService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void calculateTwoArgs() throws Exception {
        double expected = 142207.053;
        when(vacationPayService.calculateVacationSalary(anyDouble(), anyInt())).thenReturn(expected);

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/calculate")
                        .param("salary", "5000000")
                        .param("vacationDays", "10")
                ).andExpectAll(
                        MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers.jsonPath("$").value(expected));

        verify(vacationPayService).calculateVacationSalary(anyDouble(), anyInt());
        verifyNoMoreInteractions(vacationPayService);
    }

    @Test
    void calculateThreeArgs() throws Exception {
        double expected = 142207.053;
        when(vacationPayService.calculateVacationSalary(anyDouble(), any(), any())).thenReturn(expected);

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/calculate")
                        .param("salary", "5000000")
                        .param("vacationBegin", "2024-04-29")
                        .param("vacationEnd", "2024-05-10")
                ).andExpectAll(
                        MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers.jsonPath("$").value(expected));


        verify(vacationPayService).calculateVacationSalary(anyDouble(), any(), any());
        verifyNoMoreInteractions(vacationPayService);
    }
}