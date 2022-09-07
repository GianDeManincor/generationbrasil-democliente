package com.generation.brasil.demo.v1.controller;

import com.generation.brasil.demo.v1.model.Cliente;
import com.generation.brasil.demo.v1.services.ClientesService;
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
    public ResponseEntity<Cliente> getById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping()
    public ResponseEntity<Cliente> add(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(service.add(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
        return ResponseEntity.ok(service.update(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
