package com.br.Maintenance.maintenance.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "solicitacao")
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int codigo;

    private String maquina;

    private String setor;

    @Column(name = "nome_solicitante")
    private String nomeSolicitante;

    @Column(name = "data_solicitacao")
    private Date dataSolicitacao;

    private String descricao;

    private boolean is_urgente;

    public Solicitacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getNomeSolicitante() {
        return nomeSolicitante;
    }

    public void setNomeSolicitante(String nomeSolicitante) {
        this.nomeSolicitante = nomeSolicitante;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getIs_urgente() {
        return is_urgente;
    }

    public void setIs_urgente(boolean is_urgente) {
        this.is_urgente = is_urgente;
    }
}
