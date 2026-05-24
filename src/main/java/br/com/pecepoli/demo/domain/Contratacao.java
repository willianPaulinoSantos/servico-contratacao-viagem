package br.com.pecepoli.demo.domain;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

public class Contratacao {

    private final Pacote pacote;
    private final Cliente cliente;
    private final double valor;
    private Instant dataContratacao;

    Contratacao(Cliente cliente, Pacote pacote) {
        this.cliente = cliente;
        this.pacote = pacote;
        this.valor = getPrecoFromPacote(pacote);
        this.dataContratacao = Instant.now();
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
