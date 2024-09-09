package com.tcs.tcsserver.services;

import com.tcs.tcsserver.model.model.Cuenta;
import com.tcs.tcsserver.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> obtenerCuentas() {
        return cuentaRepository.findAll();
    }
    public Cuenta obtenerCuentasPorId(Long id) {
        return cuentaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cuenta no encontrado"));
    }

    public List<Cuenta> obtenerCuentasPorCliente(Long clienteId) {
        return cuentaRepository.findByClienteId(clienteId);
    }

    public Cuenta crearCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public Cuenta actualizarCuenta(Long id, Cuenta cuentaDetalles) {
        Cuenta cuenta = obtenerCuentasPorId(id);
        cuenta.setNumeroCuenta(cuentaDetalles.getNumeroCuenta());
        return cuentaRepository.save(cuenta);
    }

    public void eliminarCuenta(Long id) {
        cuentaRepository.deleteById(id);
    }
}
