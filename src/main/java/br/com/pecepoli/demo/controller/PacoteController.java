package br.com.pecepoli.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pecepoli.demo.domain.Pacote;
import br.com.pecepoli.demo.service.PacoteService;

@RestController
public class PacoteController {

    private final PacoteService pacoteService;

    public PacoteController(PacoteService pacoteService) {
        this.pacoteService = pacoteService;
    }

    @GetMapping("/pacotes")
    public List<Pacote> listarPacotes() {
        return pacoteService.listarPacotes();
    }
}
