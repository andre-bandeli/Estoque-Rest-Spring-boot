package com.br.Maintenance.maintenance.model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Ativos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "codigo")
    private long codigo;

    @NotNull
    @Column(name = "setor")
    private String setor;

    @NotNull
    @Column(name = "dataInicioOperacao")
    private String dataInicioOperacao;

    @NotNull
    @Column(name = "nivelPrioridade")
    private int nivelPrioridade;

    @NotNull
    @Column(name = "tipo")
    private String tipo;

    public Ativos() {
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

    public String getDataInicioOperacao() {
        return dataInicioOperacao;
    }

    public void setDataInicioOperacao(String dataInicioOperacao) {
        this.dataInicioOperacao = dataInicioOperacao;
    }

    public int getNivelPrioridade() {
        return nivelPrioridade;
    }

    public void setNivelPrioridade(int nivelPrioridade) {
        this.nivelPrioridade = nivelPrioridade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
