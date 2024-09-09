package com.tcs.tcsserver.controllers;

import com.tcs.tcsserver.model.model.Cuenta;
import com.tcs.tcsserver.model.model.Movimiento;
import com.tcs.tcsserver.services.CuentaService;
import com.tcs.tcsserver.services.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public List<Movimiento> obtenerMovimiento() {
        return movimientoService.obtenerMovimiento();
    }

    @GetMapping("/{id}")
    public Movimiento obtenerMovimiento(@PathVariable Long id) {
        return movimientoService.obtenerMovimientoPorId(id);
    }

    @PostMapping("/cuenta/{cuentaId}")
    public Movimiento registrarMovimiento(@PathVariable Long cuentaId, @RequestBody Movimiento movimiento) {
        return movimientoService.registrarMovimiento(cuentaId, movimiento);
    }

    @DeleteMapping("/{id}")
    public void eliminarMovimiento(@PathVariable Long id) {
        movimientoService.eliminarMovimiento(id);
    }
}
