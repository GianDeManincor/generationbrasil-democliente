package com.generation.brasil.demo.v1.service;

import com.generation.brasil.demo.exception.ClienteNotFoundException;
import com.generation.brasil.demo.v1.model.Cliente;
import com.generation.brasil.demo.v1.repository.ClientesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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

    public Cliente getById(Integer id) throws ClienteNotFoundException {
        Optional<Cliente> clienteAtual = repository.findById(id);
        if(clienteAtual.isEmpty()) {
            throw new ClienteNotFoundException("Não foi possivel encontrar o cliente", HttpStatus.NOT_FOUND.value());
        }
        return clienteAtual.get();
    }

    public Cliente update(Integer id, Cliente cliente) throws ClienteNotFoundException {
        Cliente clienteAtual = getById(id);
        cliente.setId(clienteAtual.getId());
        return repository.save(cliente);
    }

    public void delete(Integer id) throws ClienteNotFoundException {
        Cliente cliente = getById(id);
        repository.deleteById(cliente.getId());
    }
}
