package com.example.models.services;
import com.example.models.Produto;
import com.example.models.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    public Produto salvarProduto(Produto produto) {
        if (produto.getPreco() < 0) {
            throw new IllegalArgumentException("O preço do produto não pode ser negativo.");
        }
        return produtoRepository.save(produto);
    }
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }
    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }
    public Produto buscarProdutoPorNome(String nome){
        return produtoRepository.findByNome(nome).orElse(null);
    }
    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
