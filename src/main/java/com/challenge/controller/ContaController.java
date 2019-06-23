package com.challenge.controller;

import com.challenge.model.Conta;
import com.challenge.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContaController {
    private ContaService contaService;

    @Autowired
    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping("/conta")
    public List<Conta> listaContas() {
        return contaService.findAll();
    }

    @GetMapping("/conta/{id}")
    public Conta retornaContaPorId(@PathVariable(name = "id") Long id) {
        return contaService.findById(id);
    }

    @PostMapping("/conta")
    public void salvaConta(@RequestBody Conta conta) {
        contaService.save(conta);
    }

    @PutMapping("/conta/{id}")
    public void atualizaConta(@PathVariable(name = "id") Long id, @RequestBody Conta conta) {
        contaService.updateConta(id, conta);
    }

    @DeleteMapping("/conta/{id}")
    public void deleteLogico(@PathVariable(name = "id") Long id) {
        contaService.logicDeleteById(id);
    }
}
