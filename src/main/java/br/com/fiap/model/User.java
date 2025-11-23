package br.com.fiap.model;

import java.time.LocalDate;

public class User {
    private Long user_id; // NUMBER
    private String name;  // VARCHAR2(100)
    private String email; // VARCHAR2(100)
    private LocalDate registration_date; // DATE

    private String senha;
    private String nomeUser;

    public User() {}

    public Long getUser_id() { return user_id; }
    public void setUser_id(Long user_id) { this.user_id = user_id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getRegistration_date() { return registration_date; }
    public void setRegistration_date(LocalDate registration_date) { this.registration_date = registration_date; }

    public String getNome() { return name; } // O front pede 'nome'
    public void setNome(String nome) { this.name = nome; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getNomeUser() { return nomeUser; }
    public void setNomeUser(String nomeUser) { this.nomeUser = nomeUser; }
}