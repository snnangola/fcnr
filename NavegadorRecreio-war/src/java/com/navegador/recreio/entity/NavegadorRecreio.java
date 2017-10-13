/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.navegador.recreio.entity;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
//import javax.servlet.http.Part;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author snnangolaPC
 */
@Entity
@Table(name = "navegador_recreio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NavegadorRecreio.findAll", query = "SELECT n FROM NavegadorRecreio n"),
    @NamedQuery(name = "NavegadorRecreio.findByIdNavegadorRecreio", query = "SELECT n FROM NavegadorRecreio n WHERE n.navegadorRecreioPK.idNavegadorRecreio = :idNavegadorRecreio"),
    @NamedQuery(name = "NavegadorRecreio.findByNomeCompletoNavegadorRecreio", query = "SELECT n FROM NavegadorRecreio n WHERE n.nomeCompletoNavegadorRecreio = :nomeCompletoNavegadorRecreio"),
    @NamedQuery(name = "NavegadorRecreio.findByMoradaNavegadorRecreio", query = "SELECT n FROM NavegadorRecreio n WHERE n.moradaNavegadorRecreio = :moradaNavegadorRecreio"),
    @NamedQuery(name = "NavegadorRecreio.findByNrIDNavegadorRecreio", query = "SELECT n FROM NavegadorRecreio n WHERE n.informacaoAdicional = :informacaoAdicional"),
    @NamedQuery(name = "NavegadorRecreio.findByNumeroCartaNavegadorRecreio", query = "SELECT n FROM NavegadorRecreio n WHERE n.numeroCartaNavegadorRecreio = :numeroCartaNavegadorRecreio"),
    @NamedQuery(name = "NavegadorRecreio.findByDataValidadeCartaNavegadorRecreio", query = "SELECT n FROM NavegadorRecreio n WHERE n.dataValidadeCartaNavegadorRecreio = :dataValidadeCartaNavegadorRecreio"),
    @NamedQuery(name = "NavegadorRecreio.findByCategoriaIdCategoria", query = "SELECT n FROM NavegadorRecreio n WHERE n.navegadorRecreioPK.categoriaIdCategoria = :categoriaIdCategoria"),
    @NamedQuery(name = "NavegadorRecreio.findByCategoriaCompetenciaIdCompetencia", query = "SELECT n FROM NavegadorRecreio n WHERE n.navegadorRecreioPK.categoriaCompetenciaIdCompetencia = :categoriaCompetenciaIdCompetencia")})

public class NavegadorRecreio implements Serializable {
    @Basic(optional = false)
    @NotNull()
    @Lob
    @Column(name = "foto_navegador_recreio")
    private byte[] fotoNavegadorRecreio;
    @Lob
    @Column(name = "copia_bi")
    private byte[] copiaBi;
    @Lob
    @Column(name = "copia_cartao_contribuinte")
    private byte[] copiaCartaoContribuinte;
    @Lob
    @Column(name = "recibo_pagamento_taxa_inscricao")
    private byte[] reciboPagamentoTaxaInscricao;
    @Lob
    @Column(name = "atestado_medico")
    private byte[] atestadoMedico;
    @Lob
    @Column(name = "autorizacao_tutor")
    private byte[] autorizacaoTutor;
    @Lob
    @Column(name = "declaracao_formacao")
    private byte[] declaracaoFormacao;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 255)
    @Column(name = "informacao_adicional")
    private String informacaoAdicional;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NavegadorRecreioPK navegadorRecreioPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome_completo_navegador_recreio")
    private String nomeCompletoNavegadorRecreio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "morada_navegador_recreio")
    private String moradaNavegadorRecreio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numero_carta_navegador_recreio")
    private String numeroCartaNavegadorRecreio;
    @Column(name = "data_validade_carta_navegador_recreio")
    @Temporal(TemporalType.DATE)
    private Date dataValidadeCartaNavegadorRecreio;
    @ManyToOne(optional = false)
    @JoinColumns({
        @JoinColumn(name = "categoria_id_categoria", referencedColumnName = "id_categoria", insertable = false, updatable = false),
        @JoinColumn(name = "categoria_competencia_id_competencia", referencedColumnName = "competencia_id_competencia", insertable = false, updatable = false)})
    private Categoria categoria;
    //@Transient para evitar gravacao na base de dados
   // @Transient private Part fotoUpload;
    @Transient private UploadedFile fotoUpload;
    @Transient private UploadedFile copiaBiUpload;
    @Transient private UploadedFile copiaCartaoContribuinteUpload;
    @Transient private UploadedFile reciboPagamentoTaxaInscricaoUpload;
    @Transient private UploadedFile atestadoMedicoUpload;
    @Transient private UploadedFile autorizacaoTutorUpload;
    @Transient private UploadedFile declaracaoFormacaoUpload;
    @Transient private String pegaCategoria; 
    @Transient private String pegaCompetencia;

    

    

    public NavegadorRecreio() {
    
        categoria = new Categoria();
    
    }
    
 
    public NavegadorRecreio(NavegadorRecreioPK navegadorRecreioPK) {
        this.navegadorRecreioPK = navegadorRecreioPK;
    }

    public NavegadorRecreio(String nomeCompletoNavegadorRecreio, String moradaNavegadorRecreio, String numeroCartaNavegadorRecreio, Date dataValidadeCartaNavegadorRecreio ,byte[] fotoNavegadorRecreio, Categoria categoria ) {
    
        this.nomeCompletoNavegadorRecreio = nomeCompletoNavegadorRecreio;
        this.moradaNavegadorRecreio = moradaNavegadorRecreio;
        this.numeroCartaNavegadorRecreio = numeroCartaNavegadorRecreio;
        this.fotoNavegadorRecreio = fotoNavegadorRecreio;
        this.dataValidadeCartaNavegadorRecreio = dataValidadeCartaNavegadorRecreio;
        this.categoria = categoria;
        
    }
    
    public NavegadorRecreio(NavegadorRecreioPK navegadorRecreioPK, String nomeCompletoNavegadorRecreio, String moradaNavegadorRecreio, String numeroCartaNavegadorRecreio, byte[] fotoNavegadorRecreio) {
        this.navegadorRecreioPK = navegadorRecreioPK;
        this.nomeCompletoNavegadorRecreio = nomeCompletoNavegadorRecreio;
        this.moradaNavegadorRecreio = moradaNavegadorRecreio;
        this.numeroCartaNavegadorRecreio = numeroCartaNavegadorRecreio;
        this.fotoNavegadorRecreio = fotoNavegadorRecreio;
    }

    public NavegadorRecreio(int idNavegadorRecreio, int categoriaIdCategoria, int categoriaCompetenciaIdCompetencia) {
        this.navegadorRecreioPK = new NavegadorRecreioPK(idNavegadorRecreio, categoriaIdCategoria, categoriaCompetenciaIdCompetencia);
    }

    public NavegadorRecreioPK getNavegadorRecreioPK() {
        return navegadorRecreioPK;
    }

    public void setNavegadorRecreioPK(NavegadorRecreioPK navegadorRecreioPK) {
        this.navegadorRecreioPK = navegadorRecreioPK;
    }

    public String getNomeCompletoNavegadorRecreio() {
        return nomeCompletoNavegadorRecreio;
    }

    public void setNomeCompletoNavegadorRecreio(String nomeCompletoNavegadorRecreio) {
        this.nomeCompletoNavegadorRecreio = nomeCompletoNavegadorRecreio;
    }

    public String getMoradaNavegadorRecreio() {
        return moradaNavegadorRecreio;
    }

    public void setMoradaNavegadorRecreio(String moradaNavegadorRecreio) {
        this.moradaNavegadorRecreio = moradaNavegadorRecreio;
    }

    public String getNumeroCartaNavegadorRecreio() {
        return numeroCartaNavegadorRecreio;
    }

    public void setNumeroCartaNavegadorRecreio(String numeroCartaNavegadorRecreio) {
        this.numeroCartaNavegadorRecreio = numeroCartaNavegadorRecreio;
    }

    public Date getDataValidadeCartaNavegadorRecreio() {
        return dataValidadeCartaNavegadorRecreio;
    }

    public void setDataValidadeCartaNavegadorRecreio(Date dataValidadeCartaNavegadorRecreio) {
        this.dataValidadeCartaNavegadorRecreio = dataValidadeCartaNavegadorRecreio;
    }

    public byte[] getFotoNavegadorRecreio() {
        return fotoNavegadorRecreio;
    }

    public void setFotoNavegadorRecreio(byte[] fotoNavegadorRecreio) {
        this.fotoNavegadorRecreio = fotoNavegadorRecreio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public void setFotoUpload(UploadedFile fotoUpload)
    {
        this.fotoUpload = fotoUpload;
    
    }
    
    public UploadedFile getFotoUpload()
    {
            return fotoUpload;
    }
    
    public String getPegaCategoria() {
        return pegaCategoria;
    }

    public void setPegaCategoria(String pegaCategoria) {
        this.pegaCategoria = pegaCategoria;
    }

    public String getPegaCompetencia() {
        return pegaCompetencia;
    }

    public void setPegaCompetencia(String pegaCompetencia) {
        this.pegaCompetencia = pegaCompetencia;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (navegadorRecreioPK != null ? navegadorRecreioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NavegadorRecreio)) {
            return false;
        }
        NavegadorRecreio other = (NavegadorRecreio) object;
        if ((this.navegadorRecreioPK == null && other.navegadorRecreioPK != null) || (this.navegadorRecreioPK != null && !this.navegadorRecreioPK.equals(other.navegadorRecreioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.navegador.recreio.entity.NavegadorRecreio[ navegadorRecreioPK=" + navegadorRecreioPK + " ]";
    }

    //public byte[] getFotoNavegadorRecreio() {
     //   return fotoNavegadorRecreio;
    //}

    //public void setFotoNavegadorRecreio(byte[] fotoNavegadorRecreio) {
    //    this.fotoNavegadorRecreio = fotoNavegadorRecreio;
    //}

    public byte[] getCopiaBi() {
        return copiaBi;
    }

    public void setCopiaBi(byte[] copiaBi) {
        this.copiaBi = copiaBi;
    }

    public byte[] getCopiaCartaoContribuinte() {
        return copiaCartaoContribuinte;
    }

    public void setCopiaCartaoContribuinte(byte[] copiaCartaoContribuinte) {
        this.copiaCartaoContribuinte = copiaCartaoContribuinte;
    }

    public byte[] getReciboPagamentoTaxaInscricao() {
        return reciboPagamentoTaxaInscricao;
    }

    public void setReciboPagamentoTaxaInscricao(byte[] reciboPagamentoTaxaInscricao) {
        this.reciboPagamentoTaxaInscricao = reciboPagamentoTaxaInscricao;
    }

    public byte[] getAtestadoMedico() {
        return atestadoMedico;
    }

    public void setAtestadoMedico(byte[] atestadoMedico) {
        this.atestadoMedico = atestadoMedico;
    }

    public byte[] getAutorizacaoTutor() {
        return autorizacaoTutor;
    }

    public void setAutorizacaoTutor(byte[] autorizacaoTutor) {
        this.autorizacaoTutor = autorizacaoTutor;
    }

    public byte[] getDeclaracaoFormacao() {
        return declaracaoFormacao;
    }

    public void setDeclaracaoFormacao(byte[] declaracaoFormacao) {
        this.declaracaoFormacao = declaracaoFormacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getInformacaoAdicional() {
        return informacaoAdicional;
    }

    public void setInformacaoAdicional(String informacaoAdicional) {
        this.informacaoAdicional = informacaoAdicional;
    }
public UploadedFile getCopiaBiUpload() {
        return copiaBiUpload;
    }

    public void setCopiaBiUpload(UploadedFile copiaBiUpload) {
        this.copiaBiUpload = copiaBiUpload;
    }

    public UploadedFile getCopiaCartaoContribuinteUpload() {
        return copiaCartaoContribuinteUpload;
    }

    public void setCopiaCartaoContribuinteUpload(UploadedFile copiaCartaoContribuinteUpload) {
        this.copiaCartaoContribuinteUpload = copiaCartaoContribuinteUpload;
    }

    public UploadedFile getReciboPagamentoTaxaInscricaoUpload() {
        return reciboPagamentoTaxaInscricaoUpload;
    }

    public void setReciboPagamentoTaxaInscricaoUpload(UploadedFile reciboPagamentoTaxaInscricaoUpload) {
        this.reciboPagamentoTaxaInscricaoUpload = reciboPagamentoTaxaInscricaoUpload;
    }

    public UploadedFile getAtestadoMedicoUpload() {
        return atestadoMedicoUpload;
    }

    public void setAtestadoMedicoUpload(UploadedFile atestadoMedicoUpload) {
        this.atestadoMedicoUpload = atestadoMedicoUpload;
    }

    public UploadedFile getAutorizacaoTutorUpload() {
        return autorizacaoTutorUpload;
    }

    public void setAutorizacaoTutorUpload(UploadedFile autorizacaoTutorUpload) {
        this.autorizacaoTutorUpload = autorizacaoTutorUpload;
    }

    public UploadedFile getDeclaracaoFormacaoUpload() {
        return declaracaoFormacaoUpload;
    }

    public void setDeclaracaoFormacaoUpload(UploadedFile declaracaoFormacaoUpload) {
        this.declaracaoFormacaoUpload = declaracaoFormacaoUpload;
    }


  
    
}
