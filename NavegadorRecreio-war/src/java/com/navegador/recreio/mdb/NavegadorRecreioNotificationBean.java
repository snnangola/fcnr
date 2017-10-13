/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.navegador.recreio.mdb;

import com.navegador.recreio.entity.NavegadorRecreio;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author snnangolaPC
 */
@JMSDestinationDefinition(name = "NotificationQueue", interfaceName = "javax.jms.Queue", resourceAdapter = "jmsra", destinationName = "NotificationQueue")
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/NotificationQueue")
})
public class NavegadorRecreioNotificationBean implements MessageListener {
    
    public NavegadorRecreioNotificationBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        try    {      
  		Object msgObj = ((ObjectMessage)message).getObject();      
  			if (msgObj != null)        {   
        


 				NavegadorRecreio navegadorRecreio = (NavegadorRecreio)msgObj;         

   					System.out.println("Navegador de Recreio com os seguintes detalhes actualizado:");       
    
 					StringBuilder sb = new StringBuilder();          
  					sb.append("Numero da carta do Navegador de Recreio=");            
					sb.append(navegadorRecreio.getNumeroCartaNavegadorRecreio());       
     					sb.append(", ");    
       	        			sb.append("Nome Completo=");         
   					sb.append(navegadorRecreio.getNomeCompletoNavegadorRecreio());      
    					sb.append(", ");    
       					sb.append("Data de Validade da carta do Navegador de Recreio=");         
   					sb.append(navegadorRecreio.getDataValidadeCartaNavegadorRecreio());  
 
         				System.out.println(sb.toString());  

  
    }    }   
 


catch (JMSException ex)    {     


   Logger.getLogger(NavegadorRecreioNotificationBean.class.getName()).log(Level.SEVERE, null, ex);   

 }
        
        
    }
    
}
