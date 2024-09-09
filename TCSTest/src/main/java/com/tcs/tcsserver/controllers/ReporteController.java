package com.tcs.tcsserver.controllers;
import com.tcs.tcsserver.reports.ReporteEstadoCuenta;
import com.tcs.tcsserver.services.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public ReporteEstadoCuenta generarReporte(@RequestParam Long clienteId,
                                              @RequestParam String fechaInicio,
                                              @RequestParam String fechaFin) {
        return reporteService.generarReporte(clienteId, fechaInicio, fechaFin);
    }
}

