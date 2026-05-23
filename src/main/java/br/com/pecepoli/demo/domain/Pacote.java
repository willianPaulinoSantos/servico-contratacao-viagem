package br.com.pecepoli.demo.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pacote {

    private String descricao;
    private Localidade localidade;
    private final List<ItemPacote> itens = new ArrayList<>();

    public double getPreco() {
        return itens.stream().mapToDouble(ItemPacote::getPreco).sum();
    }

    public List<ItemPacote> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public void adicionarItem(ItemPacote item) {
        if (item != null) {
            this.itens.add(item);
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }
}
