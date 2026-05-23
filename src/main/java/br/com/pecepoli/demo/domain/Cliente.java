package br.com.pecepoli.demo.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente {

    private String nome;
    private LocalDate dataNascimento;
    private final List<Contratacao> contratacoes = new ArrayList<>();

    public List<Contratacao> getContratacoes() {
        return Collections.unmodifiableList(contratacoes);
    }

    public void registrarContratacao(Contratacao contratacao) {
        if (contratacao != null) {
            this.contratacoes.add(contratacao);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
