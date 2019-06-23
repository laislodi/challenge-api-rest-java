package com.challenge.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.cglib.core.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Table(name = "CONTA")
@Entity
public class Conta {

    @Id
    @SequenceGenerator(name="seq_conta", sequenceName="seq_id_conta", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;
    @Column(name = "NUMERO", nullable = false)
    private String numero;
    @Column(name = "AGENCIA", nullable = false)
    private String agencia;
    @Column(name = "CPF", length = 11)
    private String cpf;
    @Column(name = "STATUS", nullable = false)
    private Boolean status;
    @Column(name = "DATA_CRIACAO")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataCriacao;
    @Column(name = "DATA_ATUALIZACAO")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataAtualizacao;

    public Conta() {
    }

    public Conta(Long id, String numero, String agencia, String cpf) {
        this.id = id;
        this.numero = numero;
        this.agencia = agencia;
        this.cpf = cpf;
        this.status = true;
        this.dataCriacao = LocalDate.now();
        this.dataAtualizacao = LocalDate.now();
    }

    public Conta(Long id, String numero, String agencia, String cpf, Boolean status, LocalDate dataCriacao, LocalDate dataAtualizacao) {
        this.id = id;
        this.numero = numero;
        this.agencia = agencia;
        this.cpf = cpf;
        this.status = status;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", agencia='" + agencia + '\'' +
                ", cpf='" + cpf + '\'' +
                ", status=" + status +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return Objects.equals(id, conta.id) &&
                Objects.equals(numero, conta.numero) &&
                Objects.equals(agencia, conta.agencia) &&
                Objects.equals(cpf, conta.cpf) &&
                Objects.equals(status, conta.status) &&
                Objects.equals(dataCriacao, conta.dataCriacao) &&
                Objects.equals(dataAtualizacao, conta.dataAtualizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, agencia, cpf, status, dataCriacao, dataAtualizacao);
    }
}
