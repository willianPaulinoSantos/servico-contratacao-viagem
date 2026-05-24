package br.com.pecepoli.demo.domain;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

public class Contratacao {

    private final Pacote pacote;
    private final Cliente cliente;
    private final double valor;
    private Instant dataContratacao;

    Contratacao(Pacote pacote, Cliente cliente, double valor, Instant dataContratacao) {
        this.pacote = pacote;
        this.cliente = cliente;
        this.valor = getPrecoFromPacote(pacote);
        this.dataContratacao = dataContratacao;
    }

    private double getPrecoFromPacote(Pacote pacote) {
        return pacote.getPreco();
    }

    public List<ItemPacote> getItensDoPacote() {
        return Collections.unmodifiableList(pacote.getItens());
    }

    public Pacote getPacote(){
        return pacote;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getValor() {
        return valor;
    }

    public Instant getDataContratacao() {
        return dataContratacao;
    }
}
