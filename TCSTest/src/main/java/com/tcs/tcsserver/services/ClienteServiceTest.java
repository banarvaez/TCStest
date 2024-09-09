package com.tcs.tcsserver.services;

import com.tcs.tcsserver.model.model.Cliente;
import com.tcs.tcsserver.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cliente = new Cliente();
        cliente.setClienteId(1L);
        cliente.setNombre("Jose Lema");
        cliente.setContrasenia("124");
        cliente.setEstado(true);
    }

    @Test
    public void testObtenerClientePorId() {
        // Configurar el comportamiento del mock
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        // Ejecutar el método del servicio
        Cliente clienteEncontrado = clienteService.obtenerClientePorId(1L);

        // Verificar el resultado
        assertNotNull(clienteEncontrado);
        assertEquals("Jose Lema", clienteEncontrado.getNombre());
    }

    @Test
    public void testCrearCliente() {
        // Configurar el comportamiento del mock
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        // Ejecutar el método del servicio
        Cliente nuevoCliente = clienteService.crearCliente(cliente);

        // Verificar el resultado
        assertNotNull(nuevoCliente);
        assertEquals("Jose Lema", nuevoCliente.getNombre());
    }
}

