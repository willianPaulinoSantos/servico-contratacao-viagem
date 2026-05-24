package br.com.pecepoli.demo.entity;

public class Localidade {

    private String descricao;

    public Localidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Localidade{" +
                "descricao='" + descricao + '\'' +
                '}';
    }
}
