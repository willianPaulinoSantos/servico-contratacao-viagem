package br.com.pecepoli.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import br.com.pecepoli.demo.entity.Hospedagem;
import br.com.pecepoli.demo.entity.ItemPacote;
import br.com.pecepoli.demo.entity.LocacaoVeiculo;
import br.com.pecepoli.demo.entity.Localidade;
import br.com.pecepoli.demo.entity.Pacote;
import br.com.pecepoli.demo.entity.TransladoAereo;

@Component
public class DummyPacoteRepository implements PacoteRepository {

    private final Random random = new Random();
    private final Faker faker = new Faker(Locale.forLanguageTag("pt-BR"));

    @Override
    public List<Pacote> obterTodos() {
        int numeroPacotes = random.nextInt(200);
        List<Pacote> pacotes = new ArrayList<>();
        for (int i = 0; i < numeroPacotes; i++) {
            pacotes.add(criarPacoteDummy());
        }
        return pacotes;
    }

    private Pacote criarPacoteDummy() {
        Pacote pacote = new Pacote();
        pacote.setDescricao(faker.lorem().paragraph());
        pacote.setLocalidade(criarLocalidadeDummy());

        pacote.addItem(criarHotelDummy());
        pacote.addItem(criarTransladoAereo());
        pacote.addItem(criarLocacaoVeiculo());

        return pacote;
    }

    private ItemPacote criarLocacaoVeiculo() {
        LocacaoVeiculo locacaoVeiculo = new LocacaoVeiculo();
        locacaoVeiculo.setMarca(faker.company().name());
        locacaoVeiculo.setModelo(faker.company().name());
        locacaoVeiculo.setPreco(faker.number().randomDouble(2, 100, 1000));
        return locacaoVeiculo;
    }

    private ItemPacote criarHotelDummy() {
        Hospedagem hospedagem = new Hospedagem();
        hospedagem.setEndereco(faker.address().fullAddress());
        hospedagem.setNomeHotel(faker.company().name());
        hospedagem.setPreco(faker.number().randomDouble(2, 100, 1000));
        return hospedagem;
    }

    private ItemPacote criarTransladoAereo() {
        TransladoAereo transladoAereo = new TransladoAereo();
        transladoAereo.setCompaniaAerea(faker.company().name());
        transladoAereo.setNumeroVoo(faker.commerce().promotionCode());
        transladoAereo.setPreco(faker.number().randomDouble(2, 100, 1000));
        return transladoAereo;
    }

    private Localidade criarLocalidadeDummy() {
        return new Localidade(faker.address().cityName());
    }
}
