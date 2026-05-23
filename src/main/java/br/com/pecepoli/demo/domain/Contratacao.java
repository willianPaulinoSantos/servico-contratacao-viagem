package br.com.pecepoli.demo.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Contratacao {

    private double valor;
    private Instant dataContratacao;
    private final List<Pacote> pacotes = new ArrayList<>();

    public Contratacao(double valor, Instant dataContratacao) {
        this.valor = valor;
        this.dataContratacao = dataContratacao;
    }

    public List<Pacote> getPacotes() {
        return Collections.unmodifiableList(pacotes);
    }

    public void adicionarPacote(Pacote pacote) {
        if (pacote != null) {
            this.pacotes.add(pacote);
        }
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Instant getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Instant dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
}
