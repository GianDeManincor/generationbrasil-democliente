package com.generation.brasil.demo.v1.controller;

import com.generation.brasil.demo.exception.ClienteNotFoundException;
import com.generation.brasil.demo.v1.model.Cliente;
import com.generation.brasil.demo.v1.service.ClientesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
public class ClientesController {

    private ClientesService service;

    public ClientesController(ClientesService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Cliente>> get(){
        return ResponseEntity.ok(service.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable("id") Integer id) throws ClienteNotFoundException {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Cliente> add(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(service.add(cliente), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Integer id, @RequestBody Cliente cliente) throws ClienteNotFoundException {
        return new ResponseEntity<>(service.update(id, cliente), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) throws ClienteNotFoundException {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
