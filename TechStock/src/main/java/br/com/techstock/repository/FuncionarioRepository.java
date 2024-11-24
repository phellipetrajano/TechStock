package br.com.techstock.repository;

import br.com.techstock.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    // Aqui você pode adicionar métodos de consulta personalizados, se necessário
    Funcionario findByUsername(String username);
}