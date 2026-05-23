package br.com.pecepoli.demo.repository;

import java.util.List;

import br.com.pecepoli.demo.domain.Pacote;

public interface PacoteRepository {

    List<Pacote> obterTodos();
}
