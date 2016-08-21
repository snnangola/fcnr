/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.navegador.recreio.web;

import com.navegador.recreio.ejb.NavegadorRecreioSessionBean;
import com.navegador.recreio.entity.Categoria;
import com.navegador.recreio.entity.CategoriaPK;
import com.navegador.recreio.entity.Competencia;
import com.navegador.recreio.entity.NavegadorRecreio;
import com.navegador.recreio.entity.NavegadorRecreioPK;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;


/**
 *
 * @author snnangolaPC
 */
@ManagedBean(name="navegadorRecreio")
@SessionScoped
public class NavegadorRecreioMBean implements java.io.Serializable{
    @EJB
    private NavegadorRecreioSessionBean navegadorRecreioSessionBean;
    private NavegadorRecreio navegadorRecreio;
    private NavegadorRecreioPK navegadorRecreioPk;
    private CategoriaPK categoriaPk;
    private Categoria categoria;
    private Competencia competencia;
    private List<Categoria> categorias;
    private List<Competencia> competencias;
    private List<Competencia> subCompetencias;

    

    /**
     * Creates a new instance of NavegadorRecreioMBean
     */
    public NavegadorRecreioMBean() {
        
        navegadorRecreio = new NavegadorRecreio();
        categoria = new Categoria(); 
        categoriaPk = new CategoriaPK();
        competencia = new Competencia();        
// navegadorRecreioPk = new NavegadorRecreioPK();
      //  competencia = new Competencia();
         
    }
    
    //Persistir uma bean NavegadorRecreio na base de dados
    public String inserirNavegadorRecreio(){
           
        // cria um objecto do tipo categoria  e do tipo competencia 
        // Recebe categoria do Navegador de Recreio. Para garantir integridade de dados usar .toString
           
            String categoriaNavegadorRecreio = navegadorRecreio.getPegaCategoria();  
      
        /* Como ja possuimos categoria em formato String, em seguida pegar ID da Categoria na BD e 
           atribuir a Objecto Categoria */
        /* Fazer o mesmo com o objecto competencia,   */
        //?????????????????????????????????????????????????????????????????????????????????????????????????
         categoria = navegadorRecreioSessionBean.retornaCategoria(categoriaNavegadorRecreio);
        //!!!! REVER ESSE CODIGO. VALOR INPUT DE RETORNACOMPETENCIA TEM DE SER BASEADO EM COMPETENCIAPK, NAO EM
        //!!!! CATEGORIAPK 
         competencia = navegadorRecreioSessionBean.retornaCompetencia(categoria.getCategoriaPK().getIdCategoria());
         //idCategoria = this.navegadorRecreioSessionBean.retornaIDCategoria(categoria); 
         categoria.setCompetencia(competencia);
         navegadorRecreio.setCategoria(categoria);
         //A parte que tava a dar cabelo na insercao do navegador de recreio e
         //nas chaves primarias com as entidades categoria e competencia
         navegadorRecreio.setNavegadorRecreioPK(new com.navegador.recreio.entity.NavegadorRecreioPK());
         navegadorRecreio.getNavegadorRecreioPK().setCategoriaIdCategoria(categoria.getCategoriaPK().getIdCategoria());
         navegadorRecreio.getNavegadorRecreioPK().setCategoriaCompetenciaIdCompetencia(categoria.getCategoriaPK().getCompetenciaIdCompetencia());
         
          
      if(categoria != null && competencia != null && navegadorRecreio !=null)
      {
          
        try{  
            
        // Receber o que cai na Bean fotoNavegadorRecreio:
        // Receber o upload em Part, converter para InputStream
        
            Part arquivoUpload = navegadorRecreio.getFotoUpload(); 
            InputStream receptaculo = arquivoUpload.getInputStream();
            byte[] saidaDeBytes = IOUtils.toByteArray(receptaculo);
            
        // Atribuir a property fotoNavegadorRecreio    
            navegadorRecreio.setFotoNavegadorRecreio(saidaDeBytes);
        
            
        }
        catch(IOException ex){
        
            System.out.println("Impossivel adicionar dados a base de dados devido ao erro: " + ex);
        
        }
            
          System.out.println("Objectos nao nulos. Imprimindo os resultados:");
          System.out.println("Nome da categoria: " + categoria.getCategoriaCategoriaNavegadorRecreio());
          System.out.println("ID da categoria: " + categoria.getCategoriaPK().getIdCategoria());
          System.out.println("Descricao da competencia: " + competencia.getDescricaoCompetenciaCategoriaNavegadorRecreio());
          System.out.println("ID da competencia: " + competencia.getIdCompetencia());
          System.out.println("*****************NAVEGADOR RECREIO******************");
          System.out.println("Nome do navegador de Recreio: " + navegadorRecreio.getNomeCompletoNavegadorRecreio());
          System.out.println("Procurando saber se bean navegadorRecreio assumiu valores de bean categoria e competencia...");
          System.out.println("Chave Primaria de categoria por NavegadorRecreio: " + navegadorRecreio.getCategoria().getCategoriaPK().getIdCategoria());
          System.out.println("Chave Primaria de competencia por NavegadorRecreio: " + navegadorRecreio.getCategoria().getCompetencia().getIdCompetencia());
        
        
            navegadorRecreioSessionBean.adicionarNavegadorRecreio(this.navegadorRecreio);
            System.out.println("Inserido com sucesso na base de dados!!!!");
            return "LISTARTODOSNAVEGADORESRECREIO"; 
    
      }else{
          
          //Mostrar alguns resultados
          
          System.out.println("Nome da categoria: " + categoria.getCategoriaCategoriaNavegadorRecreio());
          System.out.println("Chave Primaria de categoria " + categoria.getCategoriaPK().getIdCategoria());
          //System.out.println("Chave Primaria de competencia por NavegadorRecreio: " + navegadorRecreio.getNavegadorRecreioPK().getCategoriaCompetenciaIdCompetencia());
          System.out.println("Insucesso!!!\nObjectos nulos. \n Redireccionando...");
          return "LISTARTODOSNAVEGADORESRECREIO";
       
    }
    
    } 
    
    
    //Persistir uma bean categoria na base de dados
    public String inserirCategoria(){
        
 //   navegadorRecreio = new NavegadorRecreio();    
   // String categoriaNavegadorRecreio = navegadorRecreio.getCategoria().getCategoriaCategoriaNavegadorRecreio();
    String descricaoCompetencia = navegadorRecreio.getCategoria().getCompetencia().getDescricaoCompetenciaCategoriaNavegadorRecreio();
    
    //Capturar descricao e categorias vindas do formulario    
    //String descricaoCompetencia = categoria.getCompetencia().getDescricaoCompetenciaCategoriaNavegadorRecreio();
    //String categoriaNavegadorRecreio = categoria.getCategoriaCategoriaNavegadorRecreio();   
    
   
    //Em seguida pegar id da Competencia respectiva. Chamar metodo de captura de id da propriedade de competencia
    competencia = navegadorRecreioSessionBean.retornaCompetenciaPorDesc(descricaoCompetencia);
   // categoria.setCategoriaCategoriaNavegadorRecreio(categoriaNavegadorRecreio);
   
    //Inserindo chaves primarias de Bean Categoria...   
    categoria.setCategoriaCategoriaNavegadorRecreio(navegadorRecreio.getCategoria().getCategoriaCategoriaNavegadorRecreio());
    categoria.setCompetencia(competencia);
    categoria.setCategoriaPK(new com.navegador.recreio.entity.CategoriaPK());  
    categoria.getCategoriaPK().setCompetenciaIdCompetencia(competencia.getIdCompetencia());
    
   // categoria.getCategoriaPK().setIdCategoria(7);
    
     //Testar nullidade de beans categoria e competencia...
    if(categoria!=null){
      
        
        navegadorRecreioSessionBean.adicionarCategoria(categoria);
        
        System.out.println("Sucesso!!! Dados inseridos com sucesso na base de dados\n");
        System.out.println("Valor de ID categoria: " + categoria.getCategoriaPK().getIdCategoria());
        System.out.println("Valor de categoria navegador Recreio: " +  categoria.getCategoriaCategoriaNavegadorRecreio());
        System.out.println("Valor de descricao competencia: " + descricaoCompetencia);
        System.out.println("Valor de ID descricao competencia: " + categoria.getCompetencia().getIdCompetencia());
        System.out.println("Valor de Descricao descricao competencia: " + categoria.getCompetencia().getDescricaoCompetenciaCategoriaNavegadorRecreio());
        
           
         
            return "LISTARTODOSNAVEGADORESRECREIO"; 
    
    }
    else{
        System.out.println("Insucesso!!!\nDados nulos");
            return "LISTARTODOSNAVEGADORESRECREIO";    
    
    }
    
    
    
    /*
    
    //Em seguida pegar id da Competencia respectiva. Chamar metodo de captura de id da propriedade de competencia
    competencia = navegadorRecreioSessionBean.retornaCompetenciaPorDesc(descricaoCompetencia);
    categoria.setCategoriaCategoriaNavegadorRecreio(categoriaNavegadorRecreio);
   
    //Inserindo chaves primarias de Bean Categoria...    
    categoria.setCategoriaPK(new com.navegador.recreio.entity.CategoriaPK());
    categoria.setCompetencia(competencia);
    categoria.getCategoriaPK().setCompetenciaIdCompetencia(competencia.getIdCompetencia());
    
    //Testar nullidade de beans categoria e competencia...
    if(categoria!=null && competencia!=null && categoria.getCategoriaPK() !=null){
        //inserir Bean Categoria...
        navegadorRecreioSessionBean.adicionarCategoria(categoria);
        System.out.println("Sucesso!!! Dados inseridos com sucesso na base de dados\n");
        return "LISTARTODOSNAVEGADORESRECREIO";
    
    }
    else{
        System.out.println("Insucesso!!!\nDados nulos");
        return "LISTARTODOSNAVEGADORESRECREIO";    
    
    }
    */
    
    }
    
    //Persistir uma bean categoria na base de dados
    public String inserirCompetencia(){
    
    //competencia = new Competencia();
    //competencia = this.navegadorRecreio.getCategoria().getCompetencia();
    
    //    competencia.setIdCompetencia(7);
    competencia.setDescricaoCompetenciaCategoriaNavegadorRecreio(this.navegadorRecreio.getCategoria().getCompetencia().getDescricaoCompetenciaCategoriaNavegadorRecreio());
    //Testar nullidade de beans categoria e competencia...
    if(competencia!=null){
        //inserir Bean Categoria...
        
        navegadorRecreioSessionBean.adicionarCompetencia(competencia);
        System.out.println("Sucesso!!! Dados inseridos com sucesso na base de dados\n");
        return "LISTARTODOSNAVEGADORESRECREIO";
    
    }
    else{
        System.out.println("Insucesso!!!\nDados nulos");
        return "LISTARTODOSNAVEGADORESRECREIO";    
    
    }
    
    
    }
    
     //Retorna lista de Navegadores de Recreio
public List listarNavegadoresRecreio()    {        

        return navegadorRecreioSessionBean.listarTodosNavegadores();   

}
    //Retorna lista de categorias
public List listarCategorias()    {        

        return navegadorRecreioSessionBean.listarTodasCategorias();   

}
    //Retorna lista de competencias
public List listarCompetencias()    {        

        return navegadorRecreioSessionBean.listarTodasCompetencias();   

}

public List listarNavegadoresRecreioPorCategoria(String categoria){

        return navegadorRecreioSessionBean.listarTodosNavegadoresPorCategoria(categoria);

}

public List listarTodosNavegadoresRecreioPorNome(String nomeNavegadorRecreio){


        return navegadorRecreioSessionBean.listarTodosNavegadoresPorNome(nomeNavegadorRecreio);

}

public List TodosNavegadoresRecreioPorIntervalo(Date dataInicial, Date dataFinal){

        return navegadorRecreioSessionBean.listarTodosNavegadoresPorIntervaloRegisto(dataInicial, dataFinal);

}

public NavegadorRecreio getNavegadorRecreioPorID(String navegadorRecreioCartaoID)
{

    return navegadorRecreioSessionBean.retornaNavegadorPorNumeroID(navegadorRecreioCartaoID);

}

public String getNavegadorRecreioPorListagemID(NavegadorRecreio navegadorRecreio)
{

    this.navegadorRecreio = navegadorRecreio;
    return "DETALHESNAVEGADOR";
            //navegadorRecreioSessionBean.retornaNavegadorPorListagemID(navegadorRecreio);

}

public String retornaAListarTodosNavegadoresRecreio()
{

        return "LISTARTODOSNAVEGADORESRECREIO";

}

//Preencher uma combobox com uma lista de categorias retornada da base de dados FCNRNR

public javax.faces.model.SelectItem[] getCategorias()
{
     
    SelectItem[] listaCategorias = null;
    categorias = navegadorRecreioSessionBean.getCategoria();
    if (categorias != null && categorias.size() > 0)
        {
            int i = 0;
            listaCategorias = new SelectItem[categorias.size()];
            for (Categoria cat : categorias)
            {
                listaCategorias[i++] = new SelectItem(cat.getCategoriaCategoriaNavegadorRecreio());
            }
        }
    return listaCategorias;

}

//Preencher uma combobox com uma lista de categorias retornada da base de dados FCNRNR

public javax.faces.model.SelectItem[] getCompetencias()
{
     
    SelectItem[] listaCompetencias = null;
    competencias = navegadorRecreioSessionBean.listarTodasCompetencias();
  //  subCompetencias = competencias.subList(0, competencias.size());
    if (competencias != null && competencias.size() > 0)
        {
            int i = 0;
            listaCompetencias = new SelectItem[competencias.size()];
            for (Competencia comp : competencias)
            {
                if(comp.getDescricaoCompetenciaCategoriaNavegadorRecreio().length()>2){
                    listaCompetencias[i++] = new SelectItem(comp.getDescricaoCompetenciaCategoriaNavegadorRecreio());
                }
                else
                    listaCompetencias[i++] = new SelectItem(comp.getDescricaoCompetenciaCategoriaNavegadorRecreio());
                
                    
            }
        }
    return listaCompetencias;

}

public NavegadorRecreio getNavegadorRecreio()
{

        return navegadorRecreio;

} 

public NavegadorRecreio getNavegadorRecreioPorNumeroCartao(String numeroCartaoNavegadorRecreio){

    return navegadorRecreioSessionBean.retornaNavegadorPorNumeroCartao(numeroCartaoNavegadorRecreio);

}

public void apagaNavegadorPorID(String idNavegador){

    navegadorRecreioSessionBean.apagaNavegadorPorID(idNavegador);
    
}

public NavegadorRecreio modificaNavegadorRecreioPorID(NavegadorRecreio navegadorRecreio){

    return navegadorRecreioSessionBean.modificaNavegadorPorID(navegadorRecreio);

}

public NavegadorRecreio modificaNavegadorRecreio(){

    return navegadorRecreioSessionBean.modificaNavegador();

}
    
}

