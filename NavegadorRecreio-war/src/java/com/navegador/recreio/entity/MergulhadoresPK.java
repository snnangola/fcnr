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
public class MergulhadoresPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_mergulhadores")
    private int idMergulhadores;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_licenca_mergulhador_id_tipo_licenca_mergulhador")
    private int tipoLicencaMergulhadorIdTipoLicencaMergulhador;

    public MergulhadoresPK() {
    }

    public MergulhadoresPK(int idMergulhadores, int tipoLicencaMergulhadorIdTipoLicencaMergulhador) {
        this.idMergulhadores = idMergulhadores;
        this.tipoLicencaMergulhadorIdTipoLicencaMergulhador = tipoLicencaMergulhadorIdTipoLicencaMergulhador;
    }

    public int getIdMergulhadores() {
        return idMergulhadores;
    }

    public void setIdMergulhadores(int idMergulhadores) {
        this.idMergulhadores = idMergulhadores;
    }

    public int getTipoLicencaMergulhadorIdTipoLicencaMergulhador() {
        return tipoLicencaMergulhadorIdTipoLicencaMergulhador;
    }

    public void setTipoLicencaMergulhadorIdTipoLicencaMergulhador(int tipoLicencaMergulhadorIdTipoLicencaMergulhador) {
        this.tipoLicencaMergulhadorIdTipoLicencaMergulhador = tipoLicencaMergulhadorIdTipoLicencaMergulhador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMergulhadores;
        hash += (int) tipoLicencaMergulhadorIdTipoLicencaMergulhador;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MergulhadoresPK)) {
            return false;
        }
        MergulhadoresPK other = (MergulhadoresPK) object;
        if (this.idMergulhadores != other.idMergulhadores) {
            return false;
        }
        if (this.tipoLicencaMergulhadorIdTipoLicencaMergulhador != other.tipoLicencaMergulhadorIdTipoLicencaMergulhador) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.navegador.recreio.entity.MergulhadoresPK[ idMergulhadores=" + idMergulhadores + ", tipoLicencaMergulhadorIdTipoLicencaMergulhador=" + tipoLicencaMergulhadorIdTipoLicencaMergulhador + " ]";
    }
    
}
