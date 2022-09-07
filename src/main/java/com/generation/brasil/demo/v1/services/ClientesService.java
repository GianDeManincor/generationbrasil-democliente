package com.generation.brasil.demo.v1.services;

import com.generation.brasil.demo.v1.model.Cliente;
import com.generation.brasil.demo.v1.repository.ClientesRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {

    private ClientesRepository repository;

    public ClientesService(ClientesRepository repository) {
        this.repository = repository;
    }

    public Cliente add(Cliente cliente) {
        return repository.save(cliente);
    }

    public List<Cliente> get(){
        return repository.findAll();
    }

    public Cliente getById(Integer id) {
        Optional<Cliente> clienteAtual = repository.findById(id);

        if(clienteAtual.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente NotFoundException");
        }

        return clienteAtual.get();
    }

    public Cliente update(Integer id, Cliente cliente) {
        Optional<Cliente> clienteAtual = repository.findById(id);

        if(clienteAtual.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente NotFoundException");
        }

        cliente.setId(clienteAtual.get().getId());
        return repository.save(cliente);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
