package br.com.pecepoli.demo.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pacote {

    private String descricao;
    private Localidade localidade;
    private final List<ItemPacote> itens = new ArrayList<>();


    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ItemPacote> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public void addItem(ItemPacote item) {
        if (item != null) {
            this.itens.add(item);
        }
    }
    
    public void removeItem(ItemPacote item) {
        this.itens.remove(item);
    }

    public double getPreco() {
        return itens.stream().mapToDouble(ItemPacote::getPreco).sum();
    }

    @Override
    public String toString() {
        return "Pacote{" +
                "localidade=" + localidade +
                ", descricao='" + descricao + '\'' +
                ", itens=" + itens +
                '}';
    }
}
