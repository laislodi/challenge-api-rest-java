package com.challenge.service;

import com.challenge.exception.ContaNaoEncontrada;
import com.challenge.model.Conta;
import com.challenge.repository.ContaCustomRepository;
import com.challenge.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    private static final String MSG_CONTA_NAO_ENCONTRADA = "Conta não encontrada.";
    private static final String CODE_CONTA_NAO_ENCONTRADA = "CONTA_NAO_ENCONTRADA";

    private ContaRepository contaRepository;
    private ContaCustomRepository contaCustomRepository;

    @Autowired
    public ContaService(ContaRepository contaRepository, ContaCustomRepository contaCustomRepository) {
        this.contaRepository = contaRepository;
        this.contaCustomRepository = contaCustomRepository;
    }

    public List<Conta> findAll() {
        return (List<Conta>) contaRepository.findAll();
    }

    public Conta findById(Long id) {
        Optional<Conta> optionalConta = contaRepository.findById(id);
        if (!optionalConta.isPresent()) {
            throw new ContaNaoEncontrada(MSG_CONTA_NAO_ENCONTRADA, CODE_CONTA_NAO_ENCONTRADA);
        }
        return optionalConta.get();
    }

    public void save(Conta conta) {
        contaRepository.save(conta);
    }

    public void updateConta(Long id, Conta conta) {
        findById(id);
        save(conta);
    }

    public void logicDeleteById(Long id) {
        findById(id);
        contaCustomRepository.logicDeleteById(id);
    }
}
