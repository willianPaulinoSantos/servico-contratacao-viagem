package br.com.pecepoli.demo.repository;

import java.util.List;

import br.com.pecepoli.demo.entity.Pacote;

public interface PacoteRepository {

    List<Pacote> obterTodos();
}
