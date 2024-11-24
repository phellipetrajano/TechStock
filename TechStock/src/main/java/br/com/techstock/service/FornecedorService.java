package br.com.techstock.service;

import br.com.techstock.model.Fornecedor;
import br.com.techstock.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor save(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public Fornecedor findById(Long id) {
        return fornecedorRepository.findById(id).orElse(null);
    }

    public Fornecedor update(Long id, Fornecedor fornecedor) {
        fornecedor.setId(id);
        return fornecedorRepository.save(fornecedor);
    }

    public void delete(Long id) {
        fornecedorRepository.deleteById(id);
    }
}