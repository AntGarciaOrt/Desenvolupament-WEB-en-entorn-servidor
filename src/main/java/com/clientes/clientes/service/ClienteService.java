package com.clientes.clientes.service;

import com.clientes.clientes.model.Cliente;
import com.clientes.clientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> listar() {
        return repo.findAll();
    }

    public Cliente buscar(String id) {
        return repo.findById(id).orElseThrow();
    }

    public Cliente guardar(Cliente c) {
        if (c.getId() == null || c.getId().isBlank()) {
            // Alta: Mongo generará el id y ponemos la fecha de creación
            c.setId(null);
            c.setCreationDate(LocalDateTime.now());
        } else {
            // Modificación: conservamos la fecha de creación original
            repo.findById(c.getId())
                    .ifPresent(original -> c.setCreationDate(original.getCreationDate()));
        }
        return repo.save(c);
    }

    public void eliminar(String id) {
        repo.deleteById(id);
    }
}