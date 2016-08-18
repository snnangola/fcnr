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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import com.navegador.recreio.entity.Competencia;
/**
 *
 * @author snnangolaPC
 */
@Entity
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByIdCategoria", query = "SELECT c FROM Categoria c WHERE c.categoriaPK.idCategoria = :idCategoria"),
    @NamedQuery(name = "Categoria.findByCategoriaCategoriaNavegadorRecreio", query = "SELECT c FROM Categoria c WHERE c.categoriaCategoriaNavegadorRecreio = :categoriaCategoriaNavegadorRecreio"),
    @NamedQuery(name = "Categoria.findByCompetenciaIdCompetencia", query = "SELECT c FROM Categoria c WHERE c.categoriaPK.competenciaIdCompetencia = :competenciaIdCompetencia")})
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected CategoriaPK categoriaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "categoria_categoria_navegador_recreio")
    private String categoriaCategoriaNavegadorRecreio;
    @JoinColumn(name = "competencia_id_competencia", referencedColumnName = "id_competencia", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Competencia competencia;
    @OneToMany(cascade  = CascadeType.ALL, mappedBy = "categoria") 
    private List<NavegadorRecreio> navegadorRecreioList;
    


    public Categoria() {
    
    competencia = new Competencia();
    
    }

    public Categoria(CategoriaPK categoriaPK) {
        this.categoriaPK = categoriaPK;
    }

    public Categoria(CategoriaPK categoriaPK, String categoriaCategoriaNavegadorRecreio) {
        this.categoriaPK = categoriaPK;
        this.categoriaCategoriaNavegadorRecreio = categoriaCategoriaNavegadorRecreio;
    }

    public Categoria(int idCategoria, int competenciaIdCompetencia) {
        this.categoriaPK = new CategoriaPK(idCategoria, competenciaIdCompetencia);
    }

    public CategoriaPK getCategoriaPK() {
        return categoriaPK;
    }

    public void setCategoriaPK(CategoriaPK categoriaPK) {
        this.categoriaPK = categoriaPK;
    }

    public String getCategoriaCategoriaNavegadorRecreio() {
        return categoriaCategoriaNavegadorRecreio;
    }

    public void setCategoriaCategoriaNavegadorRecreio(String categoriaCategoriaNavegadorRecreio) {
        this.categoriaCategoriaNavegadorRecreio = categoriaCategoriaNavegadorRecreio;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    @XmlTransient
    public List<NavegadorRecreio> getNavegadorRecreioList() {
        return navegadorRecreioList;
    }

    public void setNavegadorRecreioList(List<NavegadorRecreio> navegadorRecreioList) {
        this.navegadorRecreioList = navegadorRecreioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoriaPK != null ? categoriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.categoriaPK == null && other.categoriaPK != null) || (this.categoriaPK != null && !this.categoriaPK.equals(other.categoriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.navegador.recreio.entity.Categoria[ categoriaPK=" + categoriaPK + " ]";
    }
    
}
