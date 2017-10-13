/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.navegador.recreio.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author snnangolaPC
 */
@Entity
@Table(name = "tipo_licenca_mergulhador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoLicencaMergulhador.findAll", query = "SELECT t FROM TipoLicencaMergulhador t"),
    @NamedQuery(name = "TipoLicencaMergulhador.findByIdTipoLicencaMergulhador", query = "SELECT t FROM TipoLicencaMergulhador t WHERE t.idTipoLicencaMergulhador = :idTipoLicencaMergulhador"),
    @NamedQuery(name = "TipoLicencaMergulhador.findByTipoLicencaMergulho", query = "SELECT t FROM TipoLicencaMergulhador t WHERE t.tipoLicencaMergulho = :tipoLicencaMergulho"),
    @NamedQuery(name = "TipoLicencaMergulhador.findByCategoriaLicencaMergulhador", query = "SELECT t FROM TipoLicencaMergulhador t WHERE t.categoriaLicencaMergulhador = :categoriaLicencaMergulhador")})
public class TipoLicencaMergulhador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_licenca_mergulhador")
    private Integer idTipoLicencaMergulhador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tipo_licenca_mergulho")
    private String tipoLicencaMergulho;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "categoria_licenca_mergulhador")
    private String categoriaLicencaMergulhador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoLicencaMergulhador")
    private List<Mergulhadores> mergulhadoresList;

    public TipoLicencaMergulhador() {
    }

    public TipoLicencaMergulhador(Integer idTipoLicencaMergulhador) {
        this.idTipoLicencaMergulhador = idTipoLicencaMergulhador;
    }

    public TipoLicencaMergulhador(Integer idTipoLicencaMergulhador, String tipoLicencaMergulho, String categoriaLicencaMergulhador) {
        this.idTipoLicencaMergulhador = idTipoLicencaMergulhador;
        this.tipoLicencaMergulho = tipoLicencaMergulho;
        this.categoriaLicencaMergulhador = categoriaLicencaMergulhador;
    }

    public Integer getIdTipoLicencaMergulhador() {
        return idTipoLicencaMergulhador;
    }

    public void setIdTipoLicencaMergulhador(Integer idTipoLicencaMergulhador) {
        this.idTipoLicencaMergulhador = idTipoLicencaMergulhador;
    }

    public String getTipoLicencaMergulho() {
        return tipoLicencaMergulho;
    }

    public void setTipoLicencaMergulho(String tipoLicencaMergulho) {
        this.tipoLicencaMergulho = tipoLicencaMergulho;
    }

    public String getCategoriaLicencaMergulhador() {
        return categoriaLicencaMergulhador;
    }

    public void setCategoriaLicencaMergulhador(String categoriaLicencaMergulhador) {
        this.categoriaLicencaMergulhador = categoriaLicencaMergulhador;
    }

    @XmlTransient
    public List<Mergulhadores> getMergulhadoresList() {
        return mergulhadoresList;
    }

    public void setMergulhadoresList(List<Mergulhadores> mergulhadoresList) {
        this.mergulhadoresList = mergulhadoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoLicencaMergulhador != null ? idTipoLicencaMergulhador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoLicencaMergulhador)) {
            return false;
        }
        TipoLicencaMergulhador other = (TipoLicencaMergulhador) object;
        if ((this.idTipoLicencaMergulhador == null && other.idTipoLicencaMergulhador != null) || (this.idTipoLicencaMergulhador != null && !this.idTipoLicencaMergulhador.equals(other.idTipoLicencaMergulhador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.navegador.recreio.entity.TipoLicencaMergulhador[ idTipoLicencaMergulhador=" + idTipoLicencaMergulhador + " ]";
    }
    
}
