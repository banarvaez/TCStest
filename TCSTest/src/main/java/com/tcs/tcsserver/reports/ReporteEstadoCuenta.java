package com.tcs.tcsserver.reports;
import java.util.List;

public class ReporteEstadoCuenta {
    private Long clienteId;
    private List<DetalleReporteCuenta> cuentas;

    public ReporteEstadoCuenta(Long clienteId, List<DetalleReporteCuenta> cuentas) {
        this.clienteId = clienteId;
        this.cuentas = cuentas;
    }

    // Getters y Setters
}
