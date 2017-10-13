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
public class NavegadorRecreioPK implements Serializable {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_navegador_recreio")
    private int idNavegadorRecreio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "categoria_id_categoria")
    private int categoriaIdCategoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "categoria_competencia_id_competencia")
    private int categoriaCompetenciaIdCompetencia;

    public NavegadorRecreioPK() {
    }

    public NavegadorRecreioPK(int idNavegadorRecreio, int categoriaIdCategoria, int categoriaCompetenciaIdCompetencia) {
        this.idNavegadorRecreio = idNavegadorRecreio;
        this.categoriaIdCategoria = categoriaIdCategoria;
        this.categoriaCompetenciaIdCompetencia = categoriaCompetenciaIdCompetencia;
    }

    public int getIdNavegadorRecreio() {
        return idNavegadorRecreio;
    }

    public void setIdNavegadorRecreio(int idNavegadorRecreio) {
        this.idNavegadorRecreio = idNavegadorRecreio;
    }

    public int getCategoriaIdCategoria() {
        return categoriaIdCategoria;
    }

    public void setCategoriaIdCategoria(int categoriaIdCategoria) {
        this.categoriaIdCategoria = categoriaIdCategoria;
    }

   

    public int getCategoriaCompetenciaIdCompetencia() {
        return categoriaCompetenciaIdCompetencia;
    }

    public void setCategoriaCompetenciaIdCompetencia(int categoriaCompetenciaIdCompetencia) {
        this.categoriaCompetenciaIdCompetencia = categoriaCompetenciaIdCompetencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idNavegadorRecreio;
        hash += (int) categoriaIdCategoria;
        hash += (int) categoriaCompetenciaIdCompetencia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NavegadorRecreioPK)) {
            return false;
        }
        NavegadorRecreioPK other = (NavegadorRecreioPK) object;
        if (this.idNavegadorRecreio != other.idNavegadorRecreio) {
            return false;
        }
        if (this.categoriaIdCategoria != other.categoriaIdCategoria) {
            return false;
        }
        if (this.categoriaCompetenciaIdCompetencia != other.categoriaCompetenciaIdCompetencia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.navegador.recreio.entity.NavegadorRecreioPK[ idNavegadorRecreio=" + idNavegadorRecreio + ", categoriaIdCategoria=" + categoriaIdCategoria + ", categoriaCompetenciaIdCompetencia=" + categoriaCompetenciaIdCompetencia + " ]";
    }
    
}
