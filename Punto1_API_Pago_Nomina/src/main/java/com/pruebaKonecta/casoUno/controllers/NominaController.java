package com.pruebaKonecta.casoUno.controllers;

import com.pruebaKonecta.casoUno.services.NominaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class NominaController {

    @GetMapping("/proxima-fecha-pago")
    public String getProximaFechaPago(@RequestParam String fecha) throws IOException {
        LocalDate date = LocalDate.parse(fecha);
        LocalDate nextPayDate = NominaService.calculateNextPayDate(date);
        return "La próxima fecha de pago es: " + nextPayDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
