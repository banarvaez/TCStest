package com.tcs.tcsserver.repository;
import com.tcs.tcsserver.model.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

    List<Movimiento> findByCuentaIdAndFechaBetween(Long cuentaId, String fechaInicio, String fechaFin);
}
