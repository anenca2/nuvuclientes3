package com.nuvu.clientes.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@SpringBootTest
public class TarjetaClienteServiceTest {
    private static final Logger log = LoggerFactory.getLogger(TarjetaClienteServiceTest.class);
    @Autowired
    private TarjetaClienteService tarjetaClienteService;

    @Test
    @DisplayName("findAll")
    public void findAll() {
        assertNotNull(tarjetaClienteService);
    }

    @Test
    @DisplayName("save")
    public void save() throws Exception {
        assertNotNull(tarjetaClienteService);
    }

    @Test
    @DisplayName("delete")
    public void delete() throws Exception {
        assertNotNull(tarjetaClienteService);
    }

    @Test
    @DisplayName("deleteById")
    public void deleteById() throws Exception {
        assertNotNull(tarjetaClienteService);
    }

    @Test
    @DisplayName("update")
    public void update() throws Exception {
        assertNotNull(tarjetaClienteService);
    }

    @Test
    @DisplayName("findById")
    public void findById() throws Exception {
        assertNotNull(tarjetaClienteService);
    }

    @Test
    @DisplayName("count")
    public void count() throws Exception {
        assertNotNull(tarjetaClienteService);
    }
}
