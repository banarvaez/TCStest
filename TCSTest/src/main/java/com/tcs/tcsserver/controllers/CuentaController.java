package com.tcs.tcsserver.controllers;

import com.tcs.tcsserver.model.model.Cliente;
import com.tcs.tcsserver.model.model.Cuenta;
import com.tcs.tcsserver.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public List<Cuenta> obtenerCuentas() {
        return cuentaService.obtenerCuentas();
    }

    @GetMapping("/{id}")
    public Cuenta obtenerCuenta(@PathVariable Long id) {
        return cuentaService.obtenerCuentasPorId(id);
    }

    @PostMapping
    public Cuenta crearCliente(@RequestBody Cuenta cuenta) {
        return cuentaService.crearCuenta(cuenta);
    }

    @PutMapping("/{id}")
    public Cuenta actualizarCuenta(@PathVariable Long id, @RequestBody Cuenta cuenta) {
        return cuentaService.actualizarCuenta(id, cuenta);
    }

    @DeleteMapping("/{id}")
    public void eliminarCuenta(@PathVariable Long id) {
        cuentaService.eliminarCuenta(id);
    }

}
