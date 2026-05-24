package br.com.pecepoli.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pecepoli.demo.entity.Pacote;
import br.com.pecepoli.demo.repository.PacoteRepository;

@Service
public class PacoteService {

    private final PacoteRepository pacoteRepository;

    public PacoteService(PacoteRepository pacoteRepository) {
        this.pacoteRepository = pacoteRepository;
    }

    public List<Pacote> listarPacotes() {
        return pacoteRepository.obterTodos();
    }
}
