/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.navegador.recreio.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author snnangolaPC
 */
@Embeddable
public class EmbarcacoesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_embarcacoes")
    private int idEmbarcacoes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "associacoes_id_associacoes")
    private int associacoesIdAssociacoes;

    public EmbarcacoesPK() {
    }

    public EmbarcacoesPK(int idEmbarcacoes, int associacoesIdAssociacoes) {
        this.idEmbarcacoes = idEmbarcacoes;
        this.associacoesIdAssociacoes = associacoesIdAssociacoes;
    }

    public int getIdEmbarcacoes() {
        return idEmbarcacoes;
    }

    public void setIdEmbarcacoes(int idEmbarcacoes) {
        this.idEmbarcacoes = idEmbarcacoes;
    }

    public int getAssociacoesIdAssociacoes() {
        return associacoesIdAssociacoes;
    }

    public void setAssociacoesIdAssociacoes(int associacoesIdAssociacoes) {
        this.associacoesIdAssociacoes = associacoesIdAssociacoes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEmbarcacoes;
        hash += (int) associacoesIdAssociacoes;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmbarcacoesPK)) {
            return false;
        }
        EmbarcacoesPK other = (EmbarcacoesPK) object;
        if (this.idEmbarcacoes != other.idEmbarcacoes) {
            return false;
        }
        if (this.associacoesIdAssociacoes != other.associacoesIdAssociacoes) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.navegador.recreio.entity.EmbarcacoesPK[ idEmbarcacoes=" + idEmbarcacoes + ", associacoesIdAssociacoes=" + associacoesIdAssociacoes + " ]";
    }
    
}
