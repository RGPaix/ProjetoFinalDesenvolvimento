package com.example.models.services;

import com.example.models.Cliente;
import com.example.models.Pedido;
import com.example.models.Produto;
import com.example.models.repositories.ClienteRepository;
import com.example.models.repositories.PedidoRepository;
import com.example.models.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido salvarPedido(Pedido pedido) {
        validarCliente(pedido.getCliente());
        validarProdutos(pedido.getProdutos());
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizarPedido(Long id, Pedido pedidoAtualizado) {
        Pedido pedidoExistente = pedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido com ID " + id + " não encontrado."));

        validarCliente(pedidoAtualizado.getCliente());
        validarProdutos(pedidoAtualizado.getProdutos());

        pedidoExistente.setCliente(pedidoAtualizado.getCliente());
        pedidoExistente.setProdutos(pedidoAtualizado.getProdutos());

        return pedidoRepository.save(pedidoExistente);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido com ID " + id + " não encontrado."));
    }

    public List<Pedido> buscarPedidosPorCliente(Long idCliente) {
        if (!clienteRepository.existsById(idCliente)) {
            throw new IllegalArgumentException("Cliente com ID " + idCliente + " não existe.");
        }
        return pedidoRepository.findByClienteId(idCliente);
    }

    public List<Pedido> buscarPedidoPorIdProdutos(Long idProduto) {
        if (!produtoRepository.existsById(idProduto)) {
            throw new IllegalArgumentException("Produto com ID " + idProduto + " não existe.");
        }
        return pedidoRepository.findByProdutosId(idProduto);
    }

    public void deletarPedido(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new IllegalArgumentException("Pedido com ID " + id + " não encontrado.");
        }
        pedidoRepository.deleteById(id);
    }

    private void validarCliente(Cliente cliente) {
        if (cliente == null || cliente.getId() == null || !clienteRepository.existsById(cliente.getId())) {
            throw new IllegalArgumentException("Cliente inválido. O ID do cliente não existe.");
        }
    }

    private void validarProdutos(List<Produto> produtos) {
        if (produtos == null || produtos.isEmpty()) {
            throw new IllegalArgumentException("O pedido deve conter pelo menos um produto.");
        }
        for (Produto produto : produtos) {
            if (produto.getId() == null || !produtoRepository.existsById(produto.getId())) {
                throw new IllegalArgumentException("Produto inválido. O ID " + produto.getId() + " não existe.");
            }
        }
    }
}
