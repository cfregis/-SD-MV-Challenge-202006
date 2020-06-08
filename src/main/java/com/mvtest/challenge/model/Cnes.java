package com.mvtest.challenge.model;

import javax.persistence.*;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
@Entity
@Table(name="CNES")
public class Cnes implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6270769411197525965L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The auto generated identity")
    private Integer id;

    private String codCnes;
    private String codIbge;
    private String nomeFantasia;
    private String dsTipoUnidade;
    private String tpGestao;
    private String nomeLogradouro;
    private String numeroEndereco;
    private String nomeBairro;
    private String codCep;
    private String uf;
    private String municipio;
    private String numeroTelefone;

    public String getCodCnes() {
        return codCnes;
    }

    public void setCodCnes(String codCnes) {
        this.codCnes = codCnes;
    }

    public String getCodIbge() {
        return codIbge;
    }

    public void setCodIbge(String codIbge) {
        this.codIbge = codIbge;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getDsTipoUnidade() {
        return dsTipoUnidade;
    }

    public void setDsTipoUnidade(String dsTipoUnidade) {
        this.dsTipoUnidade = dsTipoUnidade;
    }

    public String getTpGestao() {
        return tpGestao;
    }

    public void setTpGestao(String tpGestao) {
        this.tpGestao = tpGestao;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getNomeBairro() {
        return nomeBairro;
    }

    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }

    public String getCodCep() {
        return codCep;
    }

    public void setCodCep(String codCep) {
        this.codCep = codCep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }
}
