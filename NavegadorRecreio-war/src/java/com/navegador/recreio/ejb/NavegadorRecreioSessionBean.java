 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.navegador.recreio.ejb;
 
import com.navegador.recreio.entity.Associacoes;
import com.navegador.recreio.entity.Categoria;
import com.navegador.recreio.entity.Competencia;
import com.navegador.recreio.entity.Embarcacoes;
import com.navegador.recreio.entity.Mergulhadores;
import com.navegador.recreio.entity.NavegadorRecreio;
import com.navegador.recreio.entity.TipoLicencaMergulhador;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.UploadedFile;





/**
 *
 * @author snnangolaPC
 */
@Stateless
@LocalBean
public class NavegadorRecreioSessionBean {
    @Resource(mappedName = "jms/NotificationQueue")
    private Queue notificationQueue;
    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;
   // @Resource(mappedName = "NotificationQueue")
    
    @PersistenceContext(unitName = "NavegadorRecreio-ejbPU")
    private EntityManager em;
    public ConnectionFactory notificationQueueFactory;
    private boolean skip;


    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
       
    //retornar lista contendo todo registo de navegadores na base de dados
    public List<NavegadorRecreio> listarTodosNavegadores() {
        
    
     Query pedido = em.createNamedQuery("NavegadorRecreio.findAll");
     return pedido.getResultList();
    
       
    }
    
    public List<Associacoes> listarTodosAssociacoes() {
        Query pedido = em.createNamedQuery("Associacoes.findAll");
        return pedido.getResultList();
    }

    public List<Embarcacoes> listarTodosEmbarcacoes(){
    
        
        Query pedido = em.createNamedQuery("Embarcacoes.findAll");
        return pedido.getResultList();
    }
    
    public List<Mergulhadores> listarTodosMergulhadores(){
    
        
        Query pedido = em.createNamedQuery("Mergulhadores.findAll");
        return pedido.getResultList();
    }
    
    public List<TipoLicencaMergulhador> listarTodosTipoLicencaMergulhador(){
    
        
        Query pedido = em.createNamedQuery("TipoLicencaMergulhador.findAll");
        return pedido.getResultList();
    }
    
    
            // Rever bem esse metodo. Nao me convenceu  
    public List<NavegadorRecreio> NavegadorPorListagemID(String nrIDNavegadorRecreio) {
                
        Query pedido = em.createNamedQuery("NavegadorRecreio.findByNrIDNavegadorRecreio", NavegadorRecreio.class)
                     .setParameter("informacaoAdicional", nrIDNavegadorRecreio);
       return pedido.getResultList();                
    }
    
    public List<Associacoes> associacaoPorListagemNIF(String nifAssociacao) {
                
        Query pedido = em.createNamedQuery("Associacoes.findByNifAssociacao", Associacoes.class)
                     .setParameter("nifAssociacao", nifAssociacao);
       return pedido.getResultList();                
    }
    
    public List<Mergulhadores> mergulhadorPorListagemNIF(String nifMergulhador) {
                
        Query pedido = em.createNamedQuery("Mergulhadores.findByNifMergulhador", Mergulhadores.class)
                     .setParameter("nifMergulhador", nifMergulhador);
       return pedido.getResultList();                
    }
    
    public List<Embarcacoes> embarcacaoPorListagemNIF(String nifProprietarioEmbarcacao) {
                
        Query pedido = em.createNamedQuery("Embarcacoes.findByNifProprietarioEmbarcacao", Embarcacoes.class)
                     .setParameter("nifProprietarioEmbarcacao", nifProprietarioEmbarcacao);
       return pedido.getResultList();                
    }
    
    public List<Mergulhadores> mergulhadorPorListagemBI(String biMergulhador) {
                
        Query pedido = em.createNamedQuery("Mergulhadores.findByBiMergulhador", Mergulhadores.class)
                     .setParameter("biMergulhador", biMergulhador);
       return pedido.getResultList(); 
    }
    
    public List<Embarcacoes> embarcacaoPorListagemBI(String biProprietarioEmbarcacao) {
                
        Query pedido = em.createNamedQuery("Embarcacoes.findByBiProprietarioEmbarcacao", Mergulhadores.class)
                     .setParameter("biProprietarioEmbarcacao", biProprietarioEmbarcacao);
       return pedido.getResultList(); 
    }
    
    public List<Mergulhadores> mergulhadorPorListagemNumeroLicenca(String numeroLicencaMergulhador) {
                
        Query pedido = em.createNamedQuery("Mergulhadores.findByNumeroLicencaMergulhador", Mergulhadores.class)
                     .setParameter("numeroLicencaMergulhador", numeroLicencaMergulhador);
       return pedido.getResultList();                
    }
    
    public List<Embarcacoes> embarcacaoPorListagemNome(String nomeEmbarcacao) {
                
        Query pedido = em.createNamedQuery("Embarcacoes.findByNomeEmbarcacao", Mergulhadores.class)
                     .setParameter("nomeEmbarcacao", nomeEmbarcacao);
       return pedido.getResultList();                
    }
    
    public List<Embarcacoes> embarcacaoPorListagemMatricula(String matriculaEmbarcacao) {
                
        Query pedido = em.createNamedQuery("Embarcacoes.findByMatriculaEmbarcacao", Mergulhadores.class)
                     .setParameter("matriculaEmbarcacao", matriculaEmbarcacao);
       return pedido.getResultList();                
    }
    
    
    public List<Associacoes> associacaoPorListagemNome(String nomeAssociacao)
    {
    
        Query pedido = em.createNamedQuery("Associacoes.findByNomeAssociacao", Associacoes.class)
                      .setParameter("nomeAssociacao", nomeAssociacao);
        return pedido.getResultList();
    
    }
    
    //
    public List<NavegadorRecreio> retornaListaPorNavegador(Integer idNavegadorRecreio) {
                
        Query pedido = em.createNamedQuery("NavegadorRecreio.findByIdNavegadorRecreio", NavegadorRecreio.class)
                     .setParameter("idNavegadorRecreio", idNavegadorRecreio);
       return pedido.getResultList();                
    }
    
    
    
    //metodo para receber UploadedFile e retornar byte[]
    
    public byte[] retornaBytes(UploadedFile arquivo){
        
        return arquivo.getContents();
    }
    
    
    //retornar lista contendo todas categorias de navegacao de recreio registadas na base de dados
    public List<Categoria> listarTodasCategorias() {
    
    // Adicionar uma Bean a base de dados
    
     Query pedido = em.createNamedQuery("Categoria.findAll");
     return pedido.getResultList();
    
       
    }
    
     //retornar lista contendo todas competencias de navegacao de recreio registadas na base de dados
    public List<Competencia> listarTodasCompetencias() {
            
     Query pedido = em.createNamedQuery("Competencia.findAll");
     return pedido.getResultList();
         
    }
    
    
    // Adicionar uma Bean Navegador Recreio a base de dados
    
    public void adicionarNavegadorRecreio(NavegadorRecreio navegadorRecreio)
    {
           
        //em.getTransaction().begin();
        em.persist(navegadorRecreio);
        //em.flush();
    
       // em.getTransaction().commit();
    }
    
        // Adicionar uma Bean Categoria a base de dados
    
    public void adicionarCategoria(Categoria categoria)
    {
      
        em.persist(categoria);
      
    }
    
        // Adicionar uma Bean competencia a base de dados
    
    public void adicionarCompetencia(Competencia competencia)
    {
     
        em.persist(competencia);
  
    }
    
    //Metodo para adicionar Associacoes Nauticas
    
    public void adicionarAssociacao (Associacoes associacao)
    {
        em.persist(associacao);
    
    }

    //Metodo para adicionar Embarcacoes de recreio
    
    public void adicionaEmbarcacao (Embarcacoes embarcacao)
    {
            em.persist(embarcacao);
    
    }
    
    //Metodo para adicionar Tipo de Licenca Mergulho
    
    public void adicionaTipoLicencaMergulhador (TipoLicencaMergulhador tipoLicencaMergulhador)
    {
            em.persist(tipoLicencaMergulhador);
    
    }
    
    
    
    //Metodo para retornar ID duma bean Categoria. 
    //Reescrever esse metodo. Nao esta bem escrito.

public int retornaIDCategoria(Categoria cat){
    
    Query pedido = em.createNamedQuery("Categoria.findByCategoriaCategoriaNavegadorRecreio", Categoria.class);
    return pedido.getFirstResult();
    
}

    //Metodo para retornar Bean Categoria em funcao da sua Descricao

public Categoria retornaCategoria(String catDesc){

   Query pedido = em.createNamedQuery("Categoria.findByCategoriaCategoriaNavegadorRecreio", Categoria.class)
           .setParameter("categoriaCategoriaNavegadorRecreio", catDesc);
   //Quero teste para verificar se objecto esta nulo ou nao
       
       return (Categoria) pedido.getSingleResult();
}

// Metodo para retornar Bean competencia em funcao da sua ID

public Competencia retornaCompetencia(int compID){
    
   Competencia competencia = em.find(Competencia.class, compID);
    
        return competencia;
    
}

public Competencia retornaCompetenciaPorDesc(String compDesc){

   Query pedido = em.createNamedQuery("Competencia.findByDescricaoCompetenciaCategoriaNavegadorRecreio", Competencia.class)
           .setParameter("descricaoCompetenciaCategoriaNavegadorRecreio", compDesc);
   //Quero teste para verificar se objecto est]a nulo ou nao

       return (Competencia) pedido.getSingleResult();
}

    public List<NavegadorRecreio> listarTodosNavegadoresPorNome(String nomeNavegador) {
        return null;
    }

public List<Categoria> listarTodasCategoriasPorNome(String nomeCategoria) {
        return null;
    }

    public List<NavegadorRecreio> retornaNavegadorPorNumeroCartao(String numeroCartao) {
        
        Query pedido = em.createNamedQuery("NavegadorRecreio.findByNumeroCartaNavegadorRecreio", NavegadorRecreio.class)
                     .setParameter("numeroCartaNavegadorRecreio", numeroCartao);
        
        
       return pedido.getResultList();
        
    }

  

    public NavegadorRecreio retornaNavegadorPorNumeroID(String numeroCartaoID) {
        return null;
    }


    public List<NavegadorRecreio> listarTodosNavegadoresPorCategoria(String categoriaNavegacao) {
        return null;
    }

    public List<NavegadorRecreio> listarTodosNavegadoresPorIntervaloRegisto(Date dataInicial, Date dataFinal) {
        return null;
    }
    
    
    // Retornar uma lista de categorias para carregar uma combobox
    public List<Categoria> getCategoria(){
    
        Query pedido = em.createNamedQuery("Categoria.findAll");
        return pedido.getResultList();
    
    
    }

    public void apagaNavegadorPorID(String idNavegador) {
        
    }
    
    // metodos pra gestao de wizards menu
    
    public void showSucesso(String mensagem){
    
         FacesMessage msg = new FacesMessage("Sucesso na operacao!!!", "\n " + mensagem);
         FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
    
   public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }

    public NavegadorRecreio modificaNavegadorPorID(NavegadorRecreio navegadorRecreio) {
     
              
              if(navegadorRecreio!=null){
                  
                  em.merge(navegadorRecreio);
                  System.out.println("Dados enviados......................................................................");
                  System.out.println("Nome do navegador antes ->navegadorRecreio: " + navegadorRecreio.getNomeCompletoNavegadorRecreio());
              //    System.out.println("Nome do navegador depois->nav             : " + nav.getNomeCompletoNavegadorRecreio());
             //     sendJMSMessageToNotificationQueue(navegadorRecreio);
              }
              else{
                  
                  System.out.println("Objecto nulo");
              }
          
          
 
      
    // }
   //  catch(JMSException ex)
   //  catch()   
     //{
          
    //     Logger.getLogger(NavegadorRecreioSessionBean.class.getName()).log(Level.SEVERE, null, ex);  
            
   //  }
        return navegadorRecreio;
    }

    
public NavegadorRecreio modificaNavegador() {
        

        return null;
    }
    
    
    private void sendJMSMessageToNotificationQueue(String messageData) {
       context.createProducer().send(notificationQueue, messageData);
    }


private Message createJMSMessageForjmsNotificationQueue(Session session, Object messageData) throws JMSException{  


  //Modified to use ObjectMessage instead    

    ObjectMessage tm = session.createObjectMessage();   
    tm.setObject((Serializable) messageData);    
    return tm;

}


private void sendJMSMessageToNotificationQueue(Object messageData) throws JMSException{   


    Connection connection = null;    
    Session session = null;    


try    {       

    connection = notificationQueueFactory.createConnection();     
    session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);      
    MessageProducer messageProducer = session.createProducer(notificationQueue);   
    messageProducer.send(createJMSMessageForjmsNotificationQueue(session, messageData));  

  } 
          

finally {       


 if (session != null)  {          

  try {            

    session.close();         
    }            
  catch (JMSException e){   

             Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);           
             
 }      

  }        

if (connection != null) {         

    connection.close();      


  }    }}

    public void showInsucesso(String mensagem) {
       
        FacesMessage msg = new FacesMessage("Sucesso na operacao!!!", "\nString: " + mensagem);
         FacesContext.getCurrentInstance().addMessage(null, msg);
      
         
        
//To change body of generated methods, choose Tools | Templates.
    }

    
     
    
    
    
    
    
    
    
}