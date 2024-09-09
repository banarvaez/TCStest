package com.tcs.tcsserver.reports;

import com.tcs.tcsserver.model.model.Movimiento;

import java.util.List;

public class DetalleReporteCuenta {
    private Long numeroCuenta;
    private String tipoCuenta;
    private Double saldoInicial;
    private Boolean estado;
    private List<Movimiento> movimientos;

    public DetalleReporteCuenta(Long numeroCuenta, String tipoCuenta, Double saldoInicial, Boolean estado,
                                List<Movimiento> movimientos) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
        this.movimientos = movimientos;
    }

    // Getters y Setters
}
