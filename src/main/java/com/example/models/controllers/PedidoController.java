package com.example.models.controllers;

import com.example.models.Pedido;
import com.example.models.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listar() {
        return pedidoService.listarPedidos();
    }

    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        return pedidoService.salvarPedido(pedido);
    }

    @PutMapping("/{id}")
    public Pedido atualizar(@PathVariable Long id, @RequestBody Pedido pedidoAtualizado) {
        return pedidoService.atualizarPedido(id, pedidoAtualizado);
    }

    @GetMapping("/{id}")
    public Pedido buscar(@PathVariable Long id) {
        return pedidoService.buscarPedidoPorId(id);
    }

    @GetMapping("/clientes/{idCliente}")
    public List<Pedido> buscarPorCliente(@PathVariable Long idCliente) {
        return pedidoService.buscarPedidosPorCliente(idCliente);
    }

    @GetMapping("/produtos/{idProduto}")
    public List<Pedido> buscarPorProduto(@PathVariable Long idProduto) {
        return pedidoService.buscarPedidoPorIdProdutos(idProduto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
    }
}
