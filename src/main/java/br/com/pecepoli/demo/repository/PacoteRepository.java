package br.com.pecepoli.demo.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.pecepoli.demo.domain.Hospedagem;
import br.com.pecepoli.demo.domain.ItemPacote;
import br.com.pecepoli.demo.domain.Localidade;
import br.com.pecepoli.demo.domain.LocacaoVeiculo;
import br.com.pecepoli.demo.domain.Pacote;
import br.com.pecepoli.demo.domain.TransladoAereo;

@Component
public class PacoteRepository {

    private static final List<Pacote> PACOTES = List.of(
            criarPacoteGramado(),
            criarPacoteRioDeJaneiro());

    public List<Pacote> obterTodos() {
        return PACOTES;
    }

    private static Pacote criarPacoteGramado() {
        Pacote pacote = new Pacote();
        pacote.setDescricao("Pacote Gramado - 5 dias");
        pacote.setLocalidade(new Localidade("Gramado - RS"));
        pacote.adicionarItem(criarHospedagem("Hotel Bavária", "Rua das Flores, 100", 1200.0));
        pacote.adicionarItem(criarTranslado("GOL", "G31234", 850.0));
        return pacote;
    }

    private static Pacote criarPacoteRioDeJaneiro() {
        Pacote pacote = new Pacote();
        pacote.setDescricao("Pacote Rio de Janeiro - 7 dias");
        pacote.setLocalidade(new Localidade("Rio de Janeiro - RJ"));
        pacote.adicionarItem(criarHospedagem("Copacabana Palace", "Av. Atlântica, 1702", 2500.0));
        pacote.adicionarItem(criarLocacaoVeiculo("Fiat", "Mobi", 350.0));
        return pacote;
    }

    private static ItemPacote criarHospedagem(String nomeHotel, String endereco, double preco) {
        Hospedagem hospedagem = new Hospedagem();
        hospedagem.setNomeHotel(nomeHotel);
        hospedagem.setEndereco(endereco);
        hospedagem.setPreco(preco);
        return hospedagem;
    }

    private static ItemPacote criarTranslado(String companiaAerea, String numeroVoo, double preco) {
        TransladoAereo translado = new TransladoAereo();
        translado.setCompaniaAerea(companiaAerea);
        translado.setNumeroVoo(numeroVoo);
        translado.setPreco(preco);
        return translado;
    }

    private static ItemPacote criarLocacaoVeiculo(String marca, String modelo, double preco) {
        LocacaoVeiculo locacao = new LocacaoVeiculo();
        locacao.setMarca(marca);
        locacao.setModelo(modelo);
        locacao.setPreco(preco);
        return locacao;
    }
}
