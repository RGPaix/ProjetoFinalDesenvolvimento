package com.example.models.controllers;

import com.example.models.Produto;
import com.example.models.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listar() {
        return produtoService.listarProdutos();
    }

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return produtoService.salvarProduto(produto);
    }

    @GetMapping("/id/{id}")
    public Produto buscar(@PathVariable Long id) {
        return produtoService.buscarProdutoPorId(id);
    }
    @GetMapping("/nome/{nome}")
    public Produto buscar(@PathVariable String nome){
        return produtoService.buscarProdutoPorNome(nome);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }
}
