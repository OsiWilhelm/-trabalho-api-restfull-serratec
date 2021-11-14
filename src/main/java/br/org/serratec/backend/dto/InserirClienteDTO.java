package br.org.serratec.backend.dto;

import java.time.LocalDate;

import br.org.serratec.backend.model.Cliente;
import br.org.serratec.backend.model.Endereco;

public class InserirClienteDTO {

    private Long id;
    private String email;
    private String nomeUsuario;
    private String nomeCompleto;
    private String cpf;
    private String telefone;
    private LocalDate dataNascimento;
    private Integer numero;
    private String complemento;
    private Endereco endereco;
    private String senha;

    public InserirClienteDTO() {
    }

    public InserirClienteDTO(Cliente cliente) {
        this.email = cliente.getEmail();
        this.nomeUsuario = cliente.getNomeUsuario();
        this.nomeCompleto = cliente.getNomeCompleto();
        this.senha = cliente.getSenha();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getTelefone();
        this.dataNascimento = cliente.getDataNascimento();
        this.numero = cliente.getNumero();
        this.complemento = cliente.getComplemento();
        this.endereco = cliente.getEndereco();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeCompleto() {
        return this.nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
