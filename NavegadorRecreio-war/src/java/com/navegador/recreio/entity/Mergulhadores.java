/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.navegador.recreio.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author snnangolaPC
 */
@Entity
@Table(name = "mergulhadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mergulhadores.findAll", query = "SELECT m FROM Mergulhadores m"),
    @NamedQuery(name = "Mergulhadores.findByIdMergulhadores", query = "SELECT m FROM Mergulhadores m WHERE m.mergulhadoresPK.idMergulhadores = :idMergulhadores"),
    @NamedQuery(name = "Mergulhadores.findByNomeMegulhador", query = "SELECT m FROM Mergulhadores m WHERE m.nomeMegulhador = :nomeMegulhador"),
    @NamedQuery(name = "Mergulhadores.findByMoradaMergulhador", query = "SELECT m FROM Mergulhadores m WHERE m.moradaMergulhador = :moradaMergulhador"),
    @NamedQuery(name = "Mergulhadores.findByBiMergulhador", query = "SELECT m FROM Mergulhadores m WHERE m.biMergulhador = :biMergulhador"),
    @NamedQuery(name = "Mergulhadores.findByNifMergulhador", query = "SELECT m FROM Mergulhadores m WHERE m.nifMergulhador = :nifMergulhador"),
    @NamedQuery(name = "Mergulhadores.findByNumeroLicencaMergulhador", query = "SELECT m FROM Mergulhadores m WHERE m.numeroLicencaMergulhador = :numeroLicencaMergulhador"),
    @NamedQuery(name = "Mergulhadores.findByTituloMergulhoMergulhador", query = "SELECT m FROM Mergulhadores m WHERE m.tituloMergulhoMergulhador = :tituloMergulhoMergulhador"),
    @NamedQuery(name = "Mergulhadores.findBySeguroAcidentesPessoaisMergulhador", query = "SELECT m FROM Mergulhadores m WHERE m.seguroAcidentesPessoaisMergulhador = :seguroAcidentesPessoaisMergulhador"),
    @NamedQuery(name = "Mergulhadores.findByTelefoneMergulhador", query = "SELECT m FROM Mergulhadores m WHERE m.telefoneMergulhador = :telefoneMergulhador"),
    @NamedQuery(name = "Mergulhadores.findByEmailMergulhador", query = "SELECT m FROM Mergulhadores m WHERE m.emailMergulhador = :emailMergulhador"),
    @NamedQuery(name = "Mergulhadores.findByTipoLicencaMergulhadorIdTipoLicencaMergulhador", query = "SELECT m FROM Mergulhadores m WHERE m.mergulhadoresPK.tipoLicencaMergulhadorIdTipoLicencaMergulhador = :tipoLicencaMergulhadorIdTipoLicencaMergulhador")})
public class Mergulhadores implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MergulhadoresPK mergulhadoresPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome_megulhador")
    private String nomeMegulhador;
    @Size(max = 255)
    @Column(name = "morada_mergulhador")
    private String moradaMergulhador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "bi_mergulhador")
    private String biMergulhador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nif_mergulhador")
    private String nifMergulhador;
    @Size(max = 255)
    @Column(name = "numero_licenca_mergulhador")
    private String numeroLicencaMergulhador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "titulo_mergulho_mergulhador")
    private String tituloMergulhoMergulhador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "seguro_acidentes_pessoais_mergulhador")
    private String seguroAcidentesPessoaisMergulhador;
    @Size(max = 45)
    @Column(name = "telefone_mergulhador")
    private String telefoneMergulhador;
    @Size(max = 90)
    @Column(name = "email_mergulhador")
    private String emailMergulhador;
    @JoinColumn(name = "tipo_licenca_mergulhador_id_tipo_licenca_mergulhador", referencedColumnName = "id_tipo_licenca_mergulhador", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoLicencaMergulhador tipoLicencaMergulhador;

    public Mergulhadores() {
    }

    public Mergulhadores(MergulhadoresPK mergulhadoresPK) {
        this.mergulhadoresPK = mergulhadoresPK;
    }

    public Mergulhadores(MergulhadoresPK mergulhadoresPK, String nomeMegulhador, String biMergulhador, String nifMergulhador, String tituloMergulhoMergulhador, String seguroAcidentesPessoaisMergulhador) {
        this.mergulhadoresPK = mergulhadoresPK;
        this.nomeMegulhador = nomeMegulhador;
        this.biMergulhador = biMergulhador;
        this.nifMergulhador = nifMergulhador;
        this.tituloMergulhoMergulhador = tituloMergulhoMergulhador;
        this.seguroAcidentesPessoaisMergulhador = seguroAcidentesPessoaisMergulhador;
    }

    public Mergulhadores(int idMergulhadores, int tipoLicencaMergulhadorIdTipoLicencaMergulhador) {
        this.mergulhadoresPK = new MergulhadoresPK(idMergulhadores, tipoLicencaMergulhadorIdTipoLicencaMergulhador);
    }

    public MergulhadoresPK getMergulhadoresPK() {
        return mergulhadoresPK;
    }

    public void setMergulhadoresPK(MergulhadoresPK mergulhadoresPK) {
        this.mergulhadoresPK = mergulhadoresPK;
    }

    public String getNomeMegulhador() {
        return nomeMegulhador;
    }

    public void setNomeMegulhador(String nomeMegulhador) {
        this.nomeMegulhador = nomeMegulhador;
    }

    public String getMoradaMergulhador() {
        return moradaMergulhador;
    }

    public void setMoradaMergulhador(String moradaMergulhador) {
        this.moradaMergulhador = moradaMergulhador;
    }

    public String getBiMergulhador() {
        return biMergulhador;
    }

    public void setBiMergulhador(String biMergulhador) {
        this.biMergulhador = biMergulhador;
    }

    public String getNifMergulhador() {
        return nifMergulhador;
    }

    public void setNifMergulhador(String nifMergulhador) {
        this.nifMergulhador = nifMergulhador;
    }

    public String getNumeroLicencaMergulhador() {
        return numeroLicencaMergulhador;
    }

    public void setNumeroLicencaMergulhador(String numeroLicencaMergulhador) {
        this.numeroLicencaMergulhador = numeroLicencaMergulhador;
    }

    public String getTituloMergulhoMergulhador() {
        return tituloMergulhoMergulhador;
    }

    public void setTituloMergulhoMergulhador(String tituloMergulhoMergulhador) {
        this.tituloMergulhoMergulhador = tituloMergulhoMergulhador;
    }

    public String getSeguroAcidentesPessoaisMergulhador() {
        return seguroAcidentesPessoaisMergulhador;
    }

    public void setSeguroAcidentesPessoaisMergulhador(String seguroAcidentesPessoaisMergulhador) {
        this.seguroAcidentesPessoaisMergulhador = seguroAcidentesPessoaisMergulhador;
    }

    public String getTelefoneMergulhador() {
        return telefoneMergulhador;
    }

    public void setTelefoneMergulhador(String telefoneMergulhador) {
        this.telefoneMergulhador = telefoneMergulhador;
    }

    public String getEmailMergulhador() {
        return emailMergulhador;
    }

    public void setEmailMergulhador(String emailMergulhador) {
        this.emailMergulhador = emailMergulhador;
    }

    public TipoLicencaMergulhador getTipoLicencaMergulhador() {
        return tipoLicencaMergulhador;
    }

    public void setTipoLicencaMergulhador(TipoLicencaMergulhador tipoLicencaMergulhador) {
        this.tipoLicencaMergulhador = tipoLicencaMergulhador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mergulhadoresPK != null ? mergulhadoresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mergulhadores)) {
            return false;
        }
        Mergulhadores other = (Mergulhadores) object;
        if ((this.mergulhadoresPK == null && other.mergulhadoresPK != null) || (this.mergulhadoresPK != null && !this.mergulhadoresPK.equals(other.mergulhadoresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.navegador.recreio.entity.Mergulhadores[ mergulhadoresPK=" + mergulhadoresPK + " ]";
    }
    
}
