package com.challenge.repository;

import com.challenge.model.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ContaCustomRepository {

    private ContaRepository contaRepository;

    @Autowired
    public ContaCustomRepository(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public void logicDeleteById(Long id) {
        Optional<Conta> conta = contaRepository.findById(id);

        conta.ifPresent(c -> {
            c.setStatus(false);
            contaRepository.save(conta.get());
        });
    }
}
