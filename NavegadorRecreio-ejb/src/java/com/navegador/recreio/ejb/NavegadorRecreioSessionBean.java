/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.navegador.recreio.ejb;
 
import com.navegador.recreio.entity.Categoria;
import com.navegador.recreio.entity.Competencia;
import com.navegador.recreio.entity.NavegadorRecreio;
import java.io.IOException;
import java.io.InputStream;
//import java.sql.Connection;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
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
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;




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
    private ConnectionFactory notificationQueueFactory;
    


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
    
    public void adicionarNavegadorRecreio(NavegadorRecreio navegadorRecreio){
           
        //em.getTransaction().begin();
        em.persist(navegadorRecreio);
        //em.flush();
    
       // em.getTransaction().commit();
    }
    
        // Adicionar uma Bean Categoria a base de dados
    
    public void adicionarCategoria(Categoria categoria){
      
        em.persist(categoria);
      
    }
    
        // Adicionar uma Bean competencia a base de dados
    
    public void adicionarCompetencia(Competencia competencia){
     
        em.persist(competencia);
  
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

    public NavegadorRecreio retornaNavegadorPorNumeroCartao(String numeroCartao) {
        return null;
    }

  

    public NavegadorRecreio retornaNavegadorPorNumeroID(String numeroCartaoID) {
        return null;
    }
        // Rever bem esse metodo. Nao me convenceu  
    public NavegadorRecreio retornaNavegadorPorListagemID(NavegadorRecreio navegadorRecreio) {
                
        Query pedido = em.createNamedQuery("NavegadorRecreio.findByIdNavegadorRecreio");
        return (NavegadorRecreio)pedido.getSingleResult();
                
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
    
    public byte[] conversorPartToByteArray(Part fotoUpload){
    
        Part arquivoUpload = fotoUpload;
        byte[] saidaDeBytes = null;
        
     try{  
            
        // Receber o que cai na Bean fotoNavegadorRecreio:
        // Receber o upload em Part, converter para InputStream
        
            InputStream receptaculo = arquivoUpload.getInputStream();
            saidaDeBytes = IOUtils.toByteArray(receptaculo);
            
        
        }
        catch(IOException ex){
        
            System.out.println("Impossivel realizar a conversao: " + ex);
        
        }
    
        // retornar o ByteArray. Antes converter em String
        System.out.println("Conversao realizada com sucesso.\nSaida: " + Arrays.toString(saidaDeBytes));
         return saidaDeBytes;
    
    }

    public NavegadorRecreio modificaNavegadorPorID(NavegadorRecreio navegadorRecreio) {
        

        
        
        //Depois das instrucoes de actualizacao da bean, rever metodo abaixo
        
          NavegadorRecreio nav = em.find(NavegadorRecreio.class, navegadorRecreio.getNavegadorRecreioPK().getIdNavegadorRecreio());
          nav.setCategoria(navegadorRecreio.getCategoria());
          nav.setDataValidadeCartaNavegadorRecreio(navegadorRecreio.getDataValidadeCartaNavegadorRecreio());
          // aqui metodo pra converter foto em Part para Byte Array
          
          nav.setFotoNavegadorRecreio(conversorPartToByteArray(navegadorRecreio.getFotoUpload()));
          nav.setMoradaNavegadorRecreio(navegadorRecreio.getMoradaNavegadorRecreio());
          nav.setNomeCompletoNavegadorRecreio(navegadorRecreio.getNomeCompletoNavegadorRecreio());
          nav.setNumeroCartaNavegadorRecreio(navegadorRecreio.getNumeroCartaNavegadorRecreio());
      
          try{
          
         // em.getTransaction().commit();
          sendJMSMessageToNotificationQueue(navegadorRecreio);
 
      
     }
     catch(JMSException ex)
     {
          
         Logger.getLogger(NavegadorRecreioSessionBean.class.getName()).log(Level.SEVERE, null, ex);  
            
     }
        return nav;
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

    
    
    
    
    
    
    
}
