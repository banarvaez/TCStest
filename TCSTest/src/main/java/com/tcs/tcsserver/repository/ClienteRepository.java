package com.tcs.tcsserver.repository;
import com.tcs.tcsserver.model.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
