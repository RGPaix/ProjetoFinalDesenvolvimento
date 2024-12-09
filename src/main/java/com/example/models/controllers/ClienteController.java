package com.example.models.controllers;

import com.example.models.Cliente;
import com.example.models.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listarClientes();
    }

    @PostMapping public Cliente salvar(@RequestBody Cliente cliente) {
        return clienteService.salvarCliente(cliente);
    }

    @GetMapping("/id/{id}")
    public Cliente buscar(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id);
    }
    @GetMapping("/nome/{nome}")
    public Cliente buscar(@PathVariable String nome){
        return clienteService.buscarClientePorNome(nome);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        clienteService.deletarCliente(id);
    }
}
