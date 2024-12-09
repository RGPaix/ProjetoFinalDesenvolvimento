package com.example.models.services;
import com.example.models.Cliente;
import com.example.models.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public Cliente salvarCliente(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente não pode estar vazio.");
        }
        clienteRepository.save(cliente);
        return cliente;
    }
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
    public Cliente buscarClientePorNome(String nome){
        return clienteRepository.findByNome(nome).orElse(null);
    }
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}