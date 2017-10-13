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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author snnangolaPC
 */
@Embeddable
public class CategoriaPK implements Serializable {
   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria")
    private int idCategoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "competencia_id_competencia")
    private int competenciaIdCompetencia;

    public CategoriaPK() {
    }

    public CategoriaPK(int idCategoria, int competenciaIdCompetencia) {
        this.idCategoria = idCategoria;
        this.competenciaIdCompetencia = competenciaIdCompetencia;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getCompetenciaIdCompetencia() {
        return competenciaIdCompetencia;
    }

    public void setCompetenciaIdCompetencia(int competenciaIdCompetencia) {
        this.competenciaIdCompetencia = competenciaIdCompetencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCategoria;
        hash += (int) competenciaIdCompetencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaPK)) {
            return false;
        }
        CategoriaPK other = (CategoriaPK) object;
        if (this.idCategoria != other.idCategoria) {
            return false;
        }
        if (this.competenciaIdCompetencia != other.competenciaIdCompetencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.navegador.recreio.entity.CategoriaPK[ idCategoria=" + idCategoria + ", competenciaIdCompetencia=" + competenciaIdCompetencia + " ]";
    }
    
}
