/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.navegador.recreio.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author snnangolaPC
 */
@Entity
@Table(name = "associacoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Associacoes.findAll", query = "SELECT a FROM Associacoes a"),
    @NamedQuery(name = "Associacoes.findByIdAssociacoes", query = "SELECT a FROM Associacoes a WHERE a.idAssociacoes = :idAssociacoes"),
    @NamedQuery(name = "Associacoes.findByNomeAssociacao", query = "SELECT a FROM Associacoes a WHERE a.nomeAssociacao = :nomeAssociacao"),
    @NamedQuery(name = "Associacoes.findByTipoAssociacao", query = "SELECT a FROM Associacoes a WHERE a.tipoAssociacao = :tipoAssociacao"),
    @NamedQuery(name = "Associacoes.findByLocalizacaoAssociacao", query = "SELECT a FROM Associacoes a WHERE a.localizacaoAssociacao = :localizacaoAssociacao"),
    @NamedQuery(name = "Associacoes.findByCoordenadasAssociacao", query = "SELECT a FROM Associacoes a WHERE a.coordenadasAssociacao = :coordenadasAssociacao"),
    @NamedQuery(name = "Associacoes.findByNifAssociacao", query = "SELECT a FROM Associacoes a WHERE a.nifAssociacao = :nifAssociacao"),
    @NamedQuery(name = "Associacoes.findByRequerimentoAssociacao", query = "SELECT a FROM Associacoes a WHERE a.requerimentoAssociacao = :requerimentoAssociacao"),
    @NamedQuery(name = "Associacoes.findByCopiaEstatutoAssociacao", query = "SELECT a FROM Associacoes a WHERE a.copiaEstatutoAssociacao = :copiaEstatutoAssociacao"),
    @NamedQuery(name = "Associacoes.findByMemoriaDescritivaAssociacao", query = "SELECT a FROM Associacoes a WHERE a.memoriaDescritivaAssociacao = :memoriaDescritivaAssociacao"),
    @NamedQuery(name = "Associacoes.findByPlanoInfraestruturaAssociacao", query = "SELECT a FROM Associacoes a WHERE a.planoInfraestruturaAssociacao = :planoInfraestruturaAssociacao"),
    @NamedQuery(name = "Associacoes.findByFotografiaAssociacao", query = "SELECT a FROM Associacoes a WHERE a.fotografiaAssociacao = :fotografiaAssociacao"),
    @NamedQuery(name = "Associacoes.findByDocumentoAquisicaoAssociacao", query = "SELECT a FROM Associacoes a WHERE a.documentoAquisicaoAssociacao = :documentoAquisicaoAssociacao"),
    @NamedQuery(name = "Associacoes.findByCertificadoAssociacao", query = "SELECT a FROM Associacoes a WHERE a.certificadoAssociacao = :certificadoAssociacao"),
    @NamedQuery(name = "Associacoes.findByDataExpiracaoAssociacao", query = "SELECT a FROM Associacoes a WHERE a.dataExpiracaoAssociacao = :dataExpiracaoAssociacao"),
    @NamedQuery(name = "Associacoes.findByStatusAssociacao", query = "SELECT a FROM Associacoes a WHERE a.statusAssociacao = :statusAssociacao")})
public class Associacoes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_associacoes")
    private Integer idAssociacoes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome_associacao")
    private String nomeAssociacao;
    @Size(max = 255)
    @Column(name = "tipo_associacao")
    private String tipoAssociacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "localizacao_associacao")
    private String localizacaoAssociacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "coordenadas_associacao")
    private String coordenadasAssociacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nif_associacao")
    private String nifAssociacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "requerimento_associacao")
    private String requerimentoAssociacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "copia_estatuto_associacao")
    private String copiaEstatutoAssociacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "memoria_descritiva_associacao")
    private String memoriaDescritivaAssociacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "plano_infraestrutura_associacao")
    private String planoInfraestruturaAssociacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "fotografia_associacao")
    private String fotografiaAssociacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "documento_aquisicao_associacao")
    private String documentoAquisicaoAssociacao;
    @Size(max = 255)
    @Column(name = "certificado_associacao")
    private String certificadoAssociacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_expiracao_associacao")
    @Temporal(TemporalType.DATE)
    private Date dataExpiracaoAssociacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "status_associacao")
    private String statusAssociacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "associacoes")
    private List<Embarcacoes> embarcacoesList;

    public Associacoes() {
    }

    public Associacoes(Integer idAssociacoes) {
        this.idAssociacoes = idAssociacoes;
    }

    public Associacoes(Integer idAssociacoes, String nomeAssociacao, String localizacaoAssociacao, String coordenadasAssociacao, String nifAssociacao, String requerimentoAssociacao, String copiaEstatutoAssociacao, String memoriaDescritivaAssociacao, String planoInfraestruturaAssociacao, String fotografiaAssociacao, String documentoAquisicaoAssociacao, Date dataExpiracaoAssociacao, String statusAssociacao) {
        this.idAssociacoes = idAssociacoes;
        this.nomeAssociacao = nomeAssociacao;
        this.localizacaoAssociacao = localizacaoAssociacao;
        this.coordenadasAssociacao = coordenadasAssociacao;
        this.nifAssociacao = nifAssociacao;
        this.requerimentoAssociacao = requerimentoAssociacao;
        this.copiaEstatutoAssociacao = copiaEstatutoAssociacao;
        this.memoriaDescritivaAssociacao = memoriaDescritivaAssociacao;
        this.planoInfraestruturaAssociacao = planoInfraestruturaAssociacao;
        this.fotografiaAssociacao = fotografiaAssociacao;
        this.documentoAquisicaoAssociacao = documentoAquisicaoAssociacao;
        this.dataExpiracaoAssociacao = dataExpiracaoAssociacao;
        this.statusAssociacao = statusAssociacao;
    }

    public Integer getIdAssociacoes() {
        return idAssociacoes;
    }

    public void setIdAssociacoes(Integer idAssociacoes) {
        this.idAssociacoes = idAssociacoes;
    }

    public String getNomeAssociacao() {
        return nomeAssociacao;
    }

    public void setNomeAssociacao(String nomeAssociacao) {
        this.nomeAssociacao = nomeAssociacao;
    }

    public String getTipoAssociacao() {
        return tipoAssociacao;
    }

    public void setTipoAssociacao(String tipoAssociacao) {
        this.tipoAssociacao = tipoAssociacao;
    }

    public String getLocalizacaoAssociacao() {
        return localizacaoAssociacao;
    }

    public void setLocalizacaoAssociacao(String localizacaoAssociacao) {
        this.localizacaoAssociacao = localizacaoAssociacao;
    }

    public String getCoordenadasAssociacao() {
        return coordenadasAssociacao;
    }

    public void setCoordenadasAssociacao(String coordenadasAssociacao) {
        this.coordenadasAssociacao = coordenadasAssociacao;
    }

    public String getNifAssociacao() {
        return nifAssociacao;
    }

    public void setNifAssociacao(String nifAssociacao) {
        this.nifAssociacao = nifAssociacao;
    }

    public String getRequerimentoAssociacao() {
        return requerimentoAssociacao;
    }

    public void setRequerimentoAssociacao(String requerimentoAssociacao) {
        this.requerimentoAssociacao = requerimentoAssociacao;
    }

    public String getCopiaEstatutoAssociacao() {
        return copiaEstatutoAssociacao;
    }

    public void setCopiaEstatutoAssociacao(String copiaEstatutoAssociacao) {
        this.copiaEstatutoAssociacao = copiaEstatutoAssociacao;
    }

    public String getMemoriaDescritivaAssociacao() {
        return memoriaDescritivaAssociacao;
    }

    public void setMemoriaDescritivaAssociacao(String memoriaDescritivaAssociacao) {
        this.memoriaDescritivaAssociacao = memoriaDescritivaAssociacao;
    }

    public String getPlanoInfraestruturaAssociacao() {
        return planoInfraestruturaAssociacao;
    }

    public void setPlanoInfraestruturaAssociacao(String planoInfraestruturaAssociacao) {
        this.planoInfraestruturaAssociacao = planoInfraestruturaAssociacao;
    }

    public String getFotografiaAssociacao() {
        return fotografiaAssociacao;
    }

    public void setFotografiaAssociacao(String fotografiaAssociacao) {
        this.fotografiaAssociacao = fotografiaAssociacao;
    }

    public String getDocumentoAquisicaoAssociacao() {
        return documentoAquisicaoAssociacao;
    }

    public void setDocumentoAquisicaoAssociacao(String documentoAquisicaoAssociacao) {
        this.documentoAquisicaoAssociacao = documentoAquisicaoAssociacao;
    }

    public String getCertificadoAssociacao() {
        return certificadoAssociacao;
    }

    public void setCertificadoAssociacao(String certificadoAssociacao) {
        this.certificadoAssociacao = certificadoAssociacao;
    }

    public Date getDataExpiracaoAssociacao() {
        return dataExpiracaoAssociacao;
    }

    public void setDataExpiracaoAssociacao(Date dataExpiracaoAssociacao) {
        this.dataExpiracaoAssociacao = dataExpiracaoAssociacao;
    }

    public String getStatusAssociacao() {
        return statusAssociacao;
    }

    public void setStatusAssociacao(String statusAssociacao) {
        this.statusAssociacao = statusAssociacao;
    }

    @XmlTransient
    public List<Embarcacoes> getEmbarcacoesList() {
        return embarcacoesList;
    }

    public void setEmbarcacoesList(List<Embarcacoes> embarcacoesList) {
        this.embarcacoesList = embarcacoesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAssociacoes != null ? idAssociacoes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Associacoes)) {
            return false;
        }
        Associacoes other = (Associacoes) object;
        if ((this.idAssociacoes == null && other.idAssociacoes != null) || (this.idAssociacoes != null && !this.idAssociacoes.equals(other.idAssociacoes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.navegador.recreio.entity.Associacoes[ idAssociacoes=" + idAssociacoes + " ]";
    }
    
}
