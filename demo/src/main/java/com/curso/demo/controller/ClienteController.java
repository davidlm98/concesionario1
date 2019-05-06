package com.curso.demo.controller;

import com.curso.demo.model.clases.ClienteWeb;
import com.curso.demo.repositories.ClienteRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.RollbackException;
import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping("/cliente")
    public ClienteWeb addCliente(@RequestBody ClienteWeb input) throws Exception {
        Optional<ClienteWeb> clienteWeb = clienteRepository.findById(input.getId());
        if (!clienteWeb.isPresent()) {
            clienteRepository.save(input);
            System.out.println("Enhorabuena, el cliente ha sido incluido con exito");
        } else {
            throw new Exception("El cliente ya esta en la lista");
        }
        return input;
    }


    @PutMapping("/cliente")
    public ClienteWeb updateClientes(@RequestBody ClienteWeb input) throws Exception {
        Optional<ClienteWeb> clienteWeb = clienteRepository.findById(input.getId());
        if (!clienteWeb.isPresent()) {
            clienteRepository.save(input);
            return input;
        } else {
            throw new Exception("El cliente no se ha encontrado");
        }
    }

    @GetMapping("/cliente/{id}")
    public ClienteWeb cliente(@PathVariable Integer id) throws Exception {
        Optional<ClienteWeb> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) return cliente.get();
        throw new Exception("El cliente con " + id + " no existe");
    }


    @GetMapping("/clientes")
    public List<ClienteWeb> clientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("")
    public String home() {
        return "login";
    }

    @DeleteMapping("/clienteEliminar/{id}")
    public String deleteCliente(@PathVariable Integer id) throws Exception {
        Optional<ClienteWeb> clienteWeb = clienteRepository.findById(id);
        if (clienteWeb.isPresent()) {
            clienteRepository.deleteById(id);
            return "El cliente " + id + " ha sido borrado";
        } else {
            throw new Exception("El cliente con " + id + "no existe");
        }
    }
}