package br.com.techstock.repository;

import br.com.techstock.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    // Métodos de consulta personalizados podem ser adicionados aqui, se necessário
}