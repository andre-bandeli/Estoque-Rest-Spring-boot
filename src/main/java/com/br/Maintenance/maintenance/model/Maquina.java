package com.br.Maintenance.maintenance.model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Maquina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;

    @NotNull
    @Column(name = "codigo")
    private long codigo;

    @NotNull
    @Column(name = "setor")
    private String setor;

    @NotNull
    @Column(name = "dataInicioOperacao")
    private Date dataInicioOperacao;

    @NotNull
    @Column(name = "nivelPrioridade")
    private int nivelPrioridade;

    private boolean isActive;

    public Maquina() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Date getDataInicioOperacao() {
        return dataInicioOperacao;
    }

    public void setDataInicioOperacao(Date dataInicioOperacao) {
        this.dataInicioOperacao = dataInicioOperacao;
    }

    public int getNivelPrioridade() {
        return nivelPrioridade;
    }

    public void setNivelPrioridade(int nivelPrioridade) {
        this.nivelPrioridade = nivelPrioridade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }
}
