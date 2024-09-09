package com.tcs.tcsserver.services;

import com.tcs.tcsserver.model.model.Cuenta;
import com.tcs.tcsserver.model.model.Movimiento;
import com.tcs.tcsserver.repository.CuentaRepository;
import com.tcs.tcsserver.repository.MovimientoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Movimiento> obtenerMovimiento() {
        return movimientoRepository.findAll();
    }
    public List<Movimiento> obtenerMovimientosPorCuentaYRangoFechas(Long cuentaId, String fechaInicio, String fechaFin) {
        return movimientoRepository.findByCuentaIdAndFechaBetween(cuentaId, fechaInicio, fechaFin);
    }
    public Movimiento obtenerMovimientoPorId(Long id) {
        return movimientoRepository.findById(id).orElseThrow(() -> new RuntimeException("Cuenta no encontrado"));
    }

    @Transactional
    public Movimiento registrarMovimiento(Long cuentaId, Movimiento movimiento) {
        Cuenta cuenta = cuentaRepository.findById(cuentaId)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        // Verificar si es un retiro o un depósito
        if (movimiento.getTipoMovimiento().equalsIgnoreCase("retiro")) {
            // Validar que el saldo sea suficiente
            if (cuenta.getSaldoInicial() < movimiento.getValor()) {
                throw new RuntimeException("Saldo no disponible");
            }
            cuenta.setSaldoInicial(cuenta.getSaldoInicial() - movimiento.getValor());
        } else if (movimiento.getTipoMovimiento().equalsIgnoreCase("deposito")) {
            cuenta.setSaldoInicial(cuenta.getSaldoInicial() + movimiento.getValor());
        }

        // Actualizar el saldo del movimiento
        movimiento.setSaldo(cuenta.getSaldoInicial());
        movimiento.setCuenta(cuenta);

        // Guardar el movimiento y actualizar la cuenta
        movimientoRepository.save(movimiento);
        cuentaRepository.save(cuenta);

        return movimiento;
    }

    public Movimiento actualizarMovimiento(Long id, Movimiento movimientoDetalles) {
        Movimiento movimiento = obtenerMovimientoPorId(id);
        movimiento.setTipoMovimiento(movimientoDetalles.getTipoMovimiento());
        return movimientoRepository.save(movimiento);
    }

    public void eliminarMovimiento(Long id) {
        movimientoRepository.deleteById(id);
    }
}
