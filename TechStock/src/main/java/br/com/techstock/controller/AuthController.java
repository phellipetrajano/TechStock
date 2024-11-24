package br.com.techstock.controller;

import br.com.techstock.model.Funcionario;
import br.com.techstock.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        // Lógica de autenticação aqui
        boolean isAuthenticated = funcionarioService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok("Usuário autenticado com sucesso!");
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas.");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Funcionario> register(@RequestBody Funcionario funcionario) {
        Funcionario newFuncionario = funcionarioService.save(funcionario);
        return ResponseEntity.status(201).body(newFuncionario);
    }

    static class LoginRequest {
        private String username;
        private String password;

        // Getters e Setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}