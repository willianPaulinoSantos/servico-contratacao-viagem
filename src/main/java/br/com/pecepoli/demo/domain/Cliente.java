package br.com.pecepoli.demo.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente {

    private String nome;
    private LocalDate dataNascimento;
    private final List<Contratacao> contratacoes = new ArrayList<>();

    private Cliente(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public List<Contratacao> getContratacoes() {
        return Collections.unmodifiableList(contratacoes);
    }

    public void contratar(Pacote pacote) {
        if (pacote != null) {
            this.contratacoes.add(new Contratacao(this, pacote));
        }
    }

    public Cliente cadastrar(String nome, LocalDate dataNascimento) {
        return new Cliente(nome, dataNascimento);
    }

    public Cliente buscarCadastro(String nome, LocalDate dataNascimento) {
        return new Cliente(nome, dataNascimento);
    }
}
