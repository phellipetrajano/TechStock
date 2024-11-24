package br.com.techstock.service;

import br.com.techstock.model.Funcionario;
import br.com.techstock.repository.FuncionarioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // Método para encontrar todos os funcionários
    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    // Método para salvar um novo funcionário
    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    // Método para encontrar um funcionário pelo ID
    public Funcionario findById(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

    // Método para atualizar um funcionário existente
    public Funcionario update(Long id, Funcionario funcionario) {
        funcionario.setId(id);
        return funcionarioRepository.save(funcionario);
    }

    // Método para excluir um funcionário
    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

    // Método para autenticar o funcionário
    public boolean authenticate(String username, String password) {
        Funcionario funcionario = funcionarioRepository.findByUsername(username);
        
        // Verifica se o funcionário existe e se a senha está correta
        if (funcionario != null) {
            // Verifica se a senha fornecida corresponde à senha armazenada
            return new BCryptPasswordEncoder().matches(password, funcionario.getPassword());
        }
        return false; // Retorna false se o funcionário não existir ou a senha estiver incorreta
    }

    // Método para encontrar um funcionário pelo nome de usuário
    public Funcionario findByUsername(String username) {
        return funcionarioRepository.findByUsername(username);
    }
}