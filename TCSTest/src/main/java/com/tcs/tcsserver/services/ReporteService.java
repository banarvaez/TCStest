package com.tcs.tcsserver.services;
import com.tcs.tcsserver.model.model.Cuenta;
import com.tcs.tcsserver.model.model.Movimiento;
import com.tcs.tcsserver.reports.DetalleReporteCuenta;
import com.tcs.tcsserver.reports.ReporteEstadoCuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteService {

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private MovimientoService movimientoService;

    public ReporteEstadoCuenta generarReporte(Long clienteId, String fechaInicio, String fechaFin) {
        List<Cuenta> cuentas = cuentaService.obtenerCuentasPorCliente(clienteId);

        List<DetalleReporteCuenta> detalleCuentas = cuentas.stream().map(cuenta -> {
            List<Movimiento> movimientos = movimientoService
                    .obtenerMovimientosPorCuentaYRangoFechas(cuenta.getNumeroCuenta(), fechaInicio, fechaFin);

            return new DetalleReporteCuenta(cuenta.getNumeroCuenta(), cuenta.getTipoCuenta(), cuenta.getSaldoInicial(),
                    cuenta.getEstado(), movimientos);
        }).collect(Collectors.toList());

        return new ReporteEstadoCuenta(clienteId, detalleCuentas);
    }
}
