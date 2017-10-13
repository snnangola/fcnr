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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author snnangolaPC
 */
@Entity
@Table(name = "embarcacoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Embarcacoes.findAll", query = "SELECT e FROM Embarcacoes e"),
    @NamedQuery(name = "Embarcacoes.findByIdEmbarcacoes", query = "SELECT e FROM Embarcacoes e WHERE e.embarcacoesPK.idEmbarcacoes = :idEmbarcacoes"),
    @NamedQuery(name = "Embarcacoes.findByStatusEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.statusEmbarcacao = :statusEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByPortoRegistoEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.portoRegistoEmbarcacao = :portoRegistoEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByNomeEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.nomeEmbarcacao = :nomeEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByNomeProprietarioEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.nomeProprietarioEmbarcacao = :nomeProprietarioEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByBiProprietarioEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.biProprietarioEmbarcacao = :biProprietarioEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByNifProprietarioEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.nifProprietarioEmbarcacao = :nifProprietarioEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByPedidoRegistoEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.pedidoRegistoEmbarcacao = :pedidoRegistoEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByTituloAquisicaoEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.tituloAquisicaoEmbarcacao = :tituloAquisicaoEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByClassificacaoEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.classificacaoEmbarcacao = :classificacaoEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByMatriculaEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.matriculaEmbarcacao = :matriculaEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByComprimentoEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.comprimentoEmbarcacao = :comprimentoEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByBocaEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.bocaEmbarcacao = :bocaEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByPontalEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.pontalEmbarcacao = :pontalEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByArqueacaoEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.arqueacaoEmbarcacao = :arqueacaoEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByLotacaoMaximaEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.lotacaoMaximaEmbarcacao = :lotacaoMaximaEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByCorCascoEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.corCascoEmbarcacao = :corCascoEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByMaterialCascoEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.materialCascoEmbarcacao = :materialCascoEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByCorSuperestruturaEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.corSuperestruturaEmbarcacao = :corSuperestruturaEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByModeloConstrucaoEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.modeloConstrucaoEmbarcacao = :modeloConstrucaoEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByNumeroConstrucaoEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.numeroConstrucaoEmbarcacao = :numeroConstrucaoEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByDataConstrucaoEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.dataConstrucaoEmbarcacao = :dataConstrucaoEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByEquipamentoTelecomEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.equipamentoTelecomEmbarcacao = :equipamentoTelecomEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByMeioSalvacaoEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.meioSalvacaoEmbarcacao = :meioSalvacaoEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByMeioCombateIncendioEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.meioCombateIncendioEmbarcacao = :meioCombateIncendioEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByMeioEsgotoEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.meioEsgotoEmbarcacao = :meioEsgotoEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByDeclaracaoEmbarcacao", query = "SELECT e FROM Embarcacoes e WHERE e.declaracaoEmbarcacao = :declaracaoEmbarcacao"),
    @NamedQuery(name = "Embarcacoes.findByAssociacoesIdAssociacoes", query = "SELECT e FROM Embarcacoes e WHERE e.embarcacoesPK.associacoesIdAssociacoes = :associacoesIdAssociacoes")})
public class Embarcacoes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmbarcacoesPK embarcacoesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status_embarcacao")
    private String statusEmbarcacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "porto_registo_embarcacao")
    private String portoRegistoEmbarcacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome_embarcacao")
    private String nomeEmbarcacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome_proprietario_embarcacao")
    private String nomeProprietarioEmbarcacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "bi_proprietario_embarcacao")
    private String biProprietarioEmbarcacao;
    @Size(max = 255)
    @Column(name = "nif_proprietario_embarcacao")
    private String nifProprietarioEmbarcacao;
    @Size(max = 255)
    @Column(name = "pedido_registo_embarcacao")
    private String pedidoRegistoEmbarcacao;
    @Size(max = 255)
    @Column(name = "titulo_aquisicao_embarcacao")
    private String tituloAquisicaoEmbarcacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "classificacao_embarcacao")
    private String classificacaoEmbarcacao;
    @Size(max = 255)
    @Column(name = "matricula_embarcacao")
    private String matriculaEmbarcacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comprimento_embarcacao")
    private float comprimentoEmbarcacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "boca_embarcacao")
    private float bocaEmbarcacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pontal_embarcacao")
    private float pontalEmbarcacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "arqueacao_embarcacao")
    private float arqueacaoEmbarcacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lotacao_maxima_embarcacao")
    private int lotacaoMaximaEmbarcacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cor_casco_embarcacao")
    private String corCascoEmbarcacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "material_casco_embarcacao")
    private String materialCascoEmbarcacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cor_superestrutura_embarcacao")
    private String corSuperestruturaEmbarcacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "modelo_construcao_embarcacao")
    private String modeloConstrucaoEmbarcacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_construcao_embarcacao")
    private long numeroConstrucaoEmbarcacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_construcao_embarcacao")
    @Temporal(TemporalType.DATE)
    private Date dataConstrucaoEmbarcacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "equipamento_telecom_embarcacao")
    private String equipamentoTelecomEmbarcacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "meio_salvacao_embarcacao")
    private String meioSalvacaoEmbarcacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "meio_combate_incendio_embarcacao")
    private String meioCombateIncendioEmbarcacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "meio_esgoto__embarcacao")
    private String meioEsgotoEmbarcacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "declaracao_embarcacao")
    private String declaracaoEmbarcacao;
    @JoinColumn(name = "associacoes_id_associacoes", referencedColumnName = "id_associacoes", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Associacoes associacoes;

    public Embarcacoes() {
    }

    public Embarcacoes(EmbarcacoesPK embarcacoesPK) {
        this.embarcacoesPK = embarcacoesPK;
    }

    public Embarcacoes(EmbarcacoesPK embarcacoesPK, String statusEmbarcacao, String portoRegistoEmbarcacao, String nomeEmbarcacao, String nomeProprietarioEmbarcacao, String biProprietarioEmbarcacao, String classificacaoEmbarcacao, float comprimentoEmbarcacao, float bocaEmbarcacao, float pontalEmbarcacao, float arqueacaoEmbarcacao, int lotacaoMaximaEmbarcacao, String corCascoEmbarcacao, String materialCascoEmbarcacao, String corSuperestruturaEmbarcacao, String modeloConstrucaoEmbarcacao, long numeroConstrucaoEmbarcacao, Date dataConstrucaoEmbarcacao, String equipamentoTelecomEmbarcacao, String meioSalvacaoEmbarcacao, String meioCombateIncendioEmbarcacao, String meioEsgotoEmbarcacao, String declaracaoEmbarcacao) {
        this.embarcacoesPK = embarcacoesPK;
        this.statusEmbarcacao = statusEmbarcacao;
        this.portoRegistoEmbarcacao = portoRegistoEmbarcacao;
        this.nomeEmbarcacao = nomeEmbarcacao;
        this.nomeProprietarioEmbarcacao = nomeProprietarioEmbarcacao;
        this.biProprietarioEmbarcacao = biProprietarioEmbarcacao;
        this.classificacaoEmbarcacao = classificacaoEmbarcacao;
        this.comprimentoEmbarcacao = comprimentoEmbarcacao;
        this.bocaEmbarcacao = bocaEmbarcacao;
        this.pontalEmbarcacao = pontalEmbarcacao;
        this.arqueacaoEmbarcacao = arqueacaoEmbarcacao;
        this.lotacaoMaximaEmbarcacao = lotacaoMaximaEmbarcacao;
        this.corCascoEmbarcacao = corCascoEmbarcacao;
        this.materialCascoEmbarcacao = materialCascoEmbarcacao;
        this.corSuperestruturaEmbarcacao = corSuperestruturaEmbarcacao;
        this.modeloConstrucaoEmbarcacao = modeloConstrucaoEmbarcacao;
        this.numeroConstrucaoEmbarcacao = numeroConstrucaoEmbarcacao;
        this.dataConstrucaoEmbarcacao = dataConstrucaoEmbarcacao;
        this.equipamentoTelecomEmbarcacao = equipamentoTelecomEmbarcacao;
        this.meioSalvacaoEmbarcacao = meioSalvacaoEmbarcacao;
        this.meioCombateIncendioEmbarcacao = meioCombateIncendioEmbarcacao;
        this.meioEsgotoEmbarcacao = meioEsgotoEmbarcacao;
        this.declaracaoEmbarcacao = declaracaoEmbarcacao;
    }

    public Embarcacoes(int idEmbarcacoes, int associacoesIdAssociacoes) {
        this.embarcacoesPK = new EmbarcacoesPK(idEmbarcacoes, associacoesIdAssociacoes);
    }

    public EmbarcacoesPK getEmbarcacoesPK() {
        return embarcacoesPK;
    }

    public void setEmbarcacoesPK(EmbarcacoesPK embarcacoesPK) {
        this.embarcacoesPK = embarcacoesPK;
    }

    public String getStatusEmbarcacao() {
        return statusEmbarcacao;
    }

    public void setStatusEmbarcacao(String statusEmbarcacao) {
        this.statusEmbarcacao = statusEmbarcacao;
    }

    public String getPortoRegistoEmbarcacao() {
        return portoRegistoEmbarcacao;
    }

    public void setPortoRegistoEmbarcacao(String portoRegistoEmbarcacao) {
        this.portoRegistoEmbarcacao = portoRegistoEmbarcacao;
    }

    public String getNomeEmbarcacao() {
        return nomeEmbarcacao;
    }

    public void setNomeEmbarcacao(String nomeEmbarcacao) {
        this.nomeEmbarcacao = nomeEmbarcacao;
    }

    public String getNomeProprietarioEmbarcacao() {
        return nomeProprietarioEmbarcacao;
    }

    public void setNomeProprietarioEmbarcacao(String nomeProprietarioEmbarcacao) {
        this.nomeProprietarioEmbarcacao = nomeProprietarioEmbarcacao;
    }

    public String getBiProprietarioEmbarcacao() {
        return biProprietarioEmbarcacao;
    }

    public void setBiProprietarioEmbarcacao(String biProprietarioEmbarcacao) {
        this.biProprietarioEmbarcacao = biProprietarioEmbarcacao;
    }

    public String getNifProprietarioEmbarcacao() {
        return nifProprietarioEmbarcacao;
    }

    public void setNifProprietarioEmbarcacao(String nifProprietarioEmbarcacao) {
        this.nifProprietarioEmbarcacao = nifProprietarioEmbarcacao;
    }

    public String getPedidoRegistoEmbarcacao() {
        return pedidoRegistoEmbarcacao;
    }

    public void setPedidoRegistoEmbarcacao(String pedidoRegistoEmbarcacao) {
        this.pedidoRegistoEmbarcacao = pedidoRegistoEmbarcacao;
    }

    public String getTituloAquisicaoEmbarcacao() {
        return tituloAquisicaoEmbarcacao;
    }

    public void setTituloAquisicaoEmbarcacao(String tituloAquisicaoEmbarcacao) {
        this.tituloAquisicaoEmbarcacao = tituloAquisicaoEmbarcacao;
    }

    public String getClassificacaoEmbarcacao() {
        return classificacaoEmbarcacao;
    }

    public void setClassificacaoEmbarcacao(String classificacaoEmbarcacao) {
        this.classificacaoEmbarcacao = classificacaoEmbarcacao;
    }

    public String getMatriculaEmbarcacao() {
        return matriculaEmbarcacao;
    }

    public void setMatriculaEmbarcacao(String matriculaEmbarcacao) {
        this.matriculaEmbarcacao = matriculaEmbarcacao;
    }

    public float getComprimentoEmbarcacao() {
        return comprimentoEmbarcacao;
    }

    public void setComprimentoEmbarcacao(float comprimentoEmbarcacao) {
        this.comprimentoEmbarcacao = comprimentoEmbarcacao;
    }

    public float getBocaEmbarcacao() {
        return bocaEmbarcacao;
    }

    public void setBocaEmbarcacao(float bocaEmbarcacao) {
        this.bocaEmbarcacao = bocaEmbarcacao;
    }

    public float getPontalEmbarcacao() {
        return pontalEmbarcacao;
    }

    public void setPontalEmbarcacao(float pontalEmbarcacao) {
        this.pontalEmbarcacao = pontalEmbarcacao;
    }

    public float getArqueacaoEmbarcacao() {
        return arqueacaoEmbarcacao;
    }

    public void setArqueacaoEmbarcacao(float arqueacaoEmbarcacao) {
        this.arqueacaoEmbarcacao = arqueacaoEmbarcacao;
    }

    public int getLotacaoMaximaEmbarcacao() {
        return lotacaoMaximaEmbarcacao;
    }

    public void setLotacaoMaximaEmbarcacao(int lotacaoMaximaEmbarcacao) {
        this.lotacaoMaximaEmbarcacao = lotacaoMaximaEmbarcacao;
    }

    public String getCorCascoEmbarcacao() {
        return corCascoEmbarcacao;
    }

    public void setCorCascoEmbarcacao(String corCascoEmbarcacao) {
        this.corCascoEmbarcacao = corCascoEmbarcacao;
    }

    public String getMaterialCascoEmbarcacao() {
        return materialCascoEmbarcacao;
    }

    public void setMaterialCascoEmbarcacao(String materialCascoEmbarcacao) {
        this.materialCascoEmbarcacao = materialCascoEmbarcacao;
    }

    public String getCorSuperestruturaEmbarcacao() {
        return corSuperestruturaEmbarcacao;
    }

    public void setCorSuperestruturaEmbarcacao(String corSuperestruturaEmbarcacao) {
        this.corSuperestruturaEmbarcacao = corSuperestruturaEmbarcacao;
    }

    public String getModeloConstrucaoEmbarcacao() {
        return modeloConstrucaoEmbarcacao;
    }

    public void setModeloConstrucaoEmbarcacao(String modeloConstrucaoEmbarcacao) {
        this.modeloConstrucaoEmbarcacao = modeloConstrucaoEmbarcacao;
    }

    public long getNumeroConstrucaoEmbarcacao() {
        return numeroConstrucaoEmbarcacao;
    }

    public void setNumeroConstrucaoEmbarcacao(long numeroConstrucaoEmbarcacao) {
        this.numeroConstrucaoEmbarcacao = numeroConstrucaoEmbarcacao;
    }

    public Date getDataConstrucaoEmbarcacao() {
        return dataConstrucaoEmbarcacao;
    }

    public void setDataConstrucaoEmbarcacao(Date dataConstrucaoEmbarcacao) {
        this.dataConstrucaoEmbarcacao = dataConstrucaoEmbarcacao;
    }

    public String getEquipamentoTelecomEmbarcacao() {
        return equipamentoTelecomEmbarcacao;
    }

    public void setEquipamentoTelecomEmbarcacao(String equipamentoTelecomEmbarcacao) {
        this.equipamentoTelecomEmbarcacao = equipamentoTelecomEmbarcacao;
    }

    public String getMeioSalvacaoEmbarcacao() {
        return meioSalvacaoEmbarcacao;
    }

    public void setMeioSalvacaoEmbarcacao(String meioSalvacaoEmbarcacao) {
        this.meioSalvacaoEmbarcacao = meioSalvacaoEmbarcacao;
    }

    public String getMeioCombateIncendioEmbarcacao() {
        return meioCombateIncendioEmbarcacao;
    }

    public void setMeioCombateIncendioEmbarcacao(String meioCombateIncendioEmbarcacao) {
        this.meioCombateIncendioEmbarcacao = meioCombateIncendioEmbarcacao;
    }

    public String getMeioEsgotoEmbarcacao() {
        return meioEsgotoEmbarcacao;
    }

    public void setMeioEsgotoEmbarcacao(String meioEsgotoEmbarcacao) {
        this.meioEsgotoEmbarcacao = meioEsgotoEmbarcacao;
    }

    public String getDeclaracaoEmbarcacao() {
        return declaracaoEmbarcacao;
    }

    public void setDeclaracaoEmbarcacao(String declaracaoEmbarcacao) {
        this.declaracaoEmbarcacao = declaracaoEmbarcacao;
    }

    public Associacoes getAssociacoes() {
        return associacoes;
    }

    public void setAssociacoes(Associacoes associacoes) {
        this.associacoes = associacoes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (embarcacoesPK != null ? embarcacoesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Embarcacoes)) {
            return false;
        }
        Embarcacoes other = (Embarcacoes) object;
        if ((this.embarcacoesPK == null && other.embarcacoesPK != null) || (this.embarcacoesPK != null && !this.embarcacoesPK.equals(other.embarcacoesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.navegador.recreio.entity.Embarcacoes[ embarcacoesPK=" + embarcacoesPK + " ]";
    }
    
}
