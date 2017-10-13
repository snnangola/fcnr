/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.navegador.recreio.web;

import com.navegador.recreio.ejb.NavegadorRecreioSessionBean;
import com.navegador.recreio.entity.Mergulhadores;
import com.navegador.recreio.entity.Embarcacoes;
import com.navegador.recreio.entity.EmbarcacoesPK;
import com.navegador.recreio.entity.MergulhadoresPK;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;



/**
 *
 * @author snnangolaPC
 */
@ManagedBean(name="embarcacoes")
//@ViewScoped
@SessionScoped
//@RequestScoped

public class EmbarcacoesMBean implements java.io.Serializable{
    @EJB
    private NavegadorRecreioSessionBean navegadorRecreioSessionBean;
    //private NavegadorRecreio navegadorRecreio;
    private Embarcacoes embarcacoes;
    //private NavegadorRecreioPK navegadorRecreioPk;
    private EmbarcacoesPK embarcacoesPk;
    //private CategoriaPK categoriaPk;
    //private Categoria categoria;
    //private Competencia competencia;
    //private List<Categoria> categorias;
    //private List<Competencia> competencias;
    //private List<NavegadorRecreio> listaNavegadorPorID;    
    //private List<NavegadorRecreio> listaNavegadorPorNumeroCarta;
    private List<Embarcacoes> listaEmbarcacaoPorNIF;
    private List<Embarcacoes> listaEmbarcacaoPorBI;
    private List<Embarcacoes> listaEmbarcacaoPorNome;
    private List<Embarcacoes> listaEmbarcacaoPorMatricula;
    //private NavegadorRecreio nav;
    private JasperPrint jasperPrint;

    
    

    

    /**
     * Creates a new instance of NavegadorRecreioMBean
     */
    public EmbarcacoesMBean() {
       
        
        //navegadorRecreio = new NavegadorRecreio();
        embarcacoes = new Embarcacoes();
        //categoria = new Categoria(); 
        //categoriaPk = new CategoriaPK();
        //competencia = new Competencia();        
       // navegadorRecreioPk = new NavegadorRecreioPK();
        embarcacoesPk = new EmbarcacoesPK();
            
      //  competencia = new Competencia();
     
         
    }
  /*  
    public AssociacoesMBean(List<Associacoes> listaAssociacaoPorNIF, List<NavegadorRecreio> listaNavegadorPorID, List<NavegadorRecreio> listaNavegadorPorNumeroCarta) {
       
    
       this.listaNavegadorPorID = listaNavegadorPorID;
       this.listaNavegadorPorNumeroCarta = listaNavegadorPorNumeroCarta; 
       this.listaAssociacaoPorNIF = listaAssociacaoPorNIF;
    }
    */
     public EmbarcacoesMBean(List<Embarcacoes> listaEmbarcacaoPorNIF, List<Embarcacoes> listaEmbarcacaoPorBI , List<Embarcacoes> listaEmbarcacaoPorNome, List<Embarcacoes> listaEmbarcacaoPorMatricula) {
       
    
       
       this.listaEmbarcacaoPorNIF = listaEmbarcacaoPorNIF;
       this.listaEmbarcacaoPorBI = listaEmbarcacaoPorBI;
       this.listaEmbarcacaoPorNome = listaEmbarcacaoPorNome;
       this.listaEmbarcacaoPorMatricula = listaEmbarcacaoPorMatricula;
    }
    
    public Embarcacoes getEmbarcacoes() {
        return embarcacoes;
    }
    
    
    /*
    public NavegadorRecreio getNav() {
        return nav;
    }

    public void setNav(NavegadorRecreio nav) {
        this.nav = nav;
    }
    
    
    public List getListaNavegadorPorID()
    {
    
        return listaNavegadorPorID;
    }
    */
    public List getListaEmbarcacaoPorNIF()
    {
    
        return listaEmbarcacaoPorNIF;
    }
    
    public List getListaEmbarcacaoPorBI()
    {
    
        return listaEmbarcacaoPorBI;
    }
    
    public List getListaEmbarcacaoPorNome()
    {
    
        return listaEmbarcacaoPorNome;
    }
    
    public List getListaEmbarcacaoPorMatricula()
    {
    
        return listaEmbarcacaoPorMatricula;
    }
    /*
    
    public void setListaNavegadorPorID(List<NavegadorRecreio> listaNavegadorPorID)
    {
    
         this.listaNavegadorPorID = listaNavegadorPorID;
    
    }
    
    public void setListaNavegadorPorNumeroCarta(List<NavegadorRecreio> listaNavegadorPorNumeroCarta)
    {
    
         this.listaNavegadorPorNumeroCarta = listaNavegadorPorNumeroCarta;
    
    }
    */
    
    //Persistir uma bean NavegadorRecreio na base de dados
    /*
    public String inserirNavegadorRecreio(){
           
        // cria um objecto do tipo categoria  e do tipo competencia 
        // Recebe categoria do Navegador de Recreio. Para garantir integridade de dados usar .toString
           
        String categoriaNavegadorRecreio = navegadorRecreio.getPegaCategoria();  
      
        // Como ja possuimos categoria em formato String, em seguida pegar ID da Categoria na BD e 
        //   atribuir a Objecto Categoria 
        // Fazer o mesmo com o objecto competencia,  
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
         
  
          
      if(categoria != null && competencia != null && navegadorRecreio !=null )
      {
          
        try{  
            
        // Receber o que cai na Bean fotoNavegadorRecreio:
        // Receber o upload em Part, converter para InputStream
        
          //  UploadedFile arquivoUpload = navegadorRecreio.getFotoUpload(); 
           // InputStream receptaculo = arquivoUpload.getInputStream();
            //byte[] saidaDeBytes = IOUtils.toByteArray(receptaculo);
            
            
        // Atribuir a property fotoNavegadorRecreio    
            //navegadorRecreio.setFotoNavegadorRecreio(saidaDeBytes);
            
            navegadorRecreio.setFotoNavegadorRecreio(IOUtils.toByteArray(navegadorRecreio.getFotoUpload().getInputstream()));
            navegadorRecreio.setCopiaBi(IOUtils.toByteArray(navegadorRecreio.getCopiaBiUpload().getInputstream()));
            navegadorRecreio.setCopiaCartaoContribuinte(IOUtils.toByteArray(navegadorRecreio.getCopiaCartaoContribuinteUpload().getInputstream()));
            navegadorRecreio.setReciboPagamentoTaxaInscricao(IOUtils.toByteArray(navegadorRecreio.getReciboPagamentoTaxaInscricaoUpload().getInputstream()));
            navegadorRecreio.setAtestadoMedico(IOUtils.toByteArray(navegadorRecreio.getAtestadoMedicoUpload().getInputstream()));
            navegadorRecreio.setAutorizacaoTutor(IOUtils.toByteArray(navegadorRecreio.getAutorizacaoTutorUpload().getInputstream()));
            navegadorRecreio.setDeclaracaoFormacao(IOUtils.toByteArray(navegadorRecreio.getDeclaracaoFormacaoUpload().getInputstream()));
         
        }
        catch(Exception ex){
        
            System.out.println("Excepcao na conversao upload : " + ex);
        
        }
            
          System.out.println("Objectos preenchidos. Imprimindo os resultados:");
          System.out.println("Nome da categoria: " + categoria.getCategoriaCategoriaNavegadorRecreio());
          System.out.println("ID da categoria: " + categoria.getCategoriaPK().getIdCategoria());
          System.out.println("Descricao da competencia: " + competencia.getDescricaoCompetenciaCategoriaNavegadorRecreio());
          System.out.println("ID da competencia: " + competencia.getIdCompetencia());
          System.out.println("*****************NAVEGADOR RECREIO******************");
          System.out.println("Nome de arquivo da foto: " + navegadorRecreio.getFotoUpload().getFileName());
          System.out.println("Nome de arquivo copia do BI: " + navegadorRecreio.getCopiaBiUpload().getFileName() + " \nTipo: " + navegadorRecreio.getCopiaBiUpload().getContentType());
          System.out.println("Nome do navegador de Recreio: " + navegadorRecreio.getNomeCompletoNavegadorRecreio());
          System.out.println("Procurando saber se bean navegadorRecreio assumiu valores de bean categoria e competencia...");
          System.out.println("Chave Primaria de categoria por NavegadorRecreio: " + navegadorRecreio.getCategoria().getCategoriaPK().getIdCategoria());
          System.out.println("Chave Primaria de competencia por NavegadorRecreio: " + navegadorRecreio.getCategoria().getCompetencia().getIdCompetencia());
          
        
          
            navegadorRecreioSessionBean.adicionarNavegadorRecreio(navegadorRecreio);
            System.out.println("Inserido com sucesso na base de dados!!!!");
            navegadorRecreioSessionBean.showSucesso("SUCESSO NA OPERACAO");
           // return "LISTARTODOSNAVEGADORESRECREIO"; 
            return "ListarTodosNavegadoresRecreio?faces-redirect=true";
    
      }else{
          
          //Mostrar alguns resultados
          
          System.out.println("Nome da categoria: " + categoria.getCategoriaCategoriaNavegadorRecreio());
          System.out.println("Chave Primaria de categoria " + categoria.getCategoriaPK().getIdCategoria());
          //System.out.println("Conteudo de arquivo da foto: " + Arrays.toString(navegadorRecreio.getFotoNavegadorRecreio()));
          //System.out.println("Tamanho de arquivo copia do BI: " + navegadorRecreio.getCopiaBi().length);
          //System.out.println("Chave Primaria de competencia por NavegadorRecreio: " + navegadorRecreio.getNavegadorRecreioPK().getCategoriaCompetenciaIdCompetencia());
          System.out.println("Insucesso!!!\nObjectos nulos. \n Redireccionando...");
          navegadorRecreioSessionBean.showInsucesso("ERRO NA OPERACAO");
          //return "LISTARTODOSNAVEGADORESRECREIO";
          //Mensagem de insucesso da operacao deve entrar aqui
          return "ListarTodosNavegadoresRecreio?faces-redirect=true";
       
    }
    
    } 
    
    */
    
    
    
    //Persistir uma bean categoria na base de dados
   
    /*
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
        
            navegadorRecreioSessionBean.showSucesso("SUCESSO NA OPERACAO");
            return "InserirCategoria?faces-redirect=true"; 
    
    }
    else{
            System.out.println("Insucesso!!!\nDados nulos");
            navegadorRecreioSessionBean.showInsucesso("ERRO NA OPERACAO"); 
            return "InserirCategoria?faces-redirect=true";    
    
    }
    
    
    
    
    
    //Em seguida pegar id da Competencia respectiva. Chamar metodo de captura de id da propriedade de competencia
    //competencia = navegadorRecreioSessionBean.retornaCompetenciaPorDesc(descricaoCompetencia);
    //categoria.setCategoriaCategoriaNavegadorRecreio(categoriaNavegadorRecreio);
   
    //Inserindo chaves primarias de Bean Categoria...    
    //categoria.setCategoriaPK(new com.navegador.recreio.entity.CategoriaPK());
    //categoria.setCompetencia(competencia);
    //categoria.getCategoriaPK().setCompetenciaIdCompetencia(competencia.getIdCompetencia());
    
    //Testar nullidade de beans categoria e competencia...
    //if(categoria!=null && competencia!=null && categoria.getCategoriaPK() !=null){
        //inserir Bean Categoria...
      //  navegadorRecreioSessionBean.adicionarCategoria(categoria);
        //System.out.println("Sucesso!!! Dados inseridos com sucesso na base de dados\n");
        //return "LISTARTODOSNAVEGADORESRECREIO";
    
    //}
    //else{
      //  System.out.println("Insucesso!!!\nDados nulos");
        //return "LISTARTODOSNAVEGADORESRECREIO";    
    
    //}
    
    
    }
    
    */
    
    //Persistir uma bean categoria na base de dados
    
    /*
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
        navegadorRecreioSessionBean.showSucesso("SUCESSO NA OPERACAO");
        return "InserirCompetencia?faces-redirect=true";
    
    }
    else{
        System.out.println("Insucesso!!!\nDados nulos");
       //Mensagem de insucesso vem aqui abaixo
       // navegadorRecreioSessionBean.showInsucesso(competencia.getDescricaoCompetenciaCategoriaNavegadorRecreio());
        navegadorRecreioSessionBean.showInsucesso("ERRO NA OPERACAO");
        return "InserirCompetencia?faces-redirect=true";    
    }
    
    
    }
    
    */
    
     //Retorna lista de Navegadores de Recreio
    /*
public List listarNavegadoresRecreio()    {        

        return navegadorRecreioSessionBean.listarTodosNavegadores();   

}
*/
//Retorna a lista de de Associacoes

public List listarEmbarcacoes(){

    return navegadorRecreioSessionBean.listarTodosEmbarcacoes();

}



// Retorna uma Bean NavegadorRecreio baseado no seu ID entregue.
/*
public void listarNavegadorRecreioPorIDNavegadorRecreio()
{

    //Codigo para retornar Bean NavegadorRecreio por meio da sua ID.
    
   listaNavegadorPorID =  navegadorRecreioSessionBean.NavegadorPorListagemID(navegadorRecreio.getInformacaoAdicional());
   
   System.out.println(listaNavegadorPorID.toString());
   
  // return "ListarNavegadorRecreioPorID?faces-redirect=true"; 
   
   //return listaNavegadorPorID;
}
*/

public void listarEmbarcacaoPorNIFEmbarcacao()
{

listaEmbarcacaoPorNIF = navegadorRecreioSessionBean.embarcacaoPorListagemNIF(embarcacoes.getNifProprietarioEmbarcacao().trim());
System.out.println(listaEmbarcacaoPorNIF.toString());


}

public void listarEmbarcacaoPorBIEmbarcacao()
{

listaEmbarcacaoPorBI = navegadorRecreioSessionBean.embarcacaoPorListagemBI(embarcacoes.getBiProprietarioEmbarcacao().trim());
System.out.println(listaEmbarcacaoPorNIF.toString());



}

public void listarEmbarcacaoPorNome()
{

  listaEmbarcacaoPorNome = navegadorRecreioSessionBean.embarcacaoPorListagemNome(embarcacoes.getNomeEmbarcacao().trim());
  System.out.println(listaEmbarcacaoPorNome.toString());
}

public void listarEmbarcacaoPorMatricula()
{

  listaEmbarcacaoPorMatricula = navegadorRecreioSessionBean.embarcacaoPorListagemMatricula(embarcacoes.getMatriculaEmbarcacao().trim());
  System.out.println(listaEmbarcacaoPorMatricula.toString());
}
  

//Retorna lista de Navegador de Recreio dada uma determinada Bean
/*
public List retornaListaNavegadorRecreioPorBean(Integer idNavegadorRecreio)    { 
    
    
            return navegadorRecreioSessionBean.retornaListaPorNavegador(idNavegadorRecreio);
        
        }
*/
/*
public String showNavegadorRecreioPorBean(Integer idNavegadorRecreio) throws JRException    {  

	//this.navegadorRecreio = nav;  
     //System.out.println(nav.getNavegadorRecreioPK().getIdNavegadorRecreio());
      //System.out.println(nav.getCategoria().getCategoriaPK().getIdCategoria()); 
     // gerarRelatorio("navegador", retornaListaNavegadorRecreioPorBean(nav), nav.getNavegadorRecreioPK().getIdNavegadorRecreio(), nav.getCategoria().getCategoriaPK().getIdCategoria());    
      
    // Aqui realizar redirect a Servlet
    
    return "/faces/PDFServlet?idNavegadorRecreio=" + idNavegadorRecreio;
    
    
   // gerarRelatorio("navegador", retornaListaNavegadorRecreioPorBean(idNavegadorRecreio), idNavegadorRecreio, idNavegadorRecreio);
       // REVVER ISSO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
      //return "DetalhesNavegador?faces-redirect=true";
      
  
}

public String showNavegadorRecreioPorListagemID(NavegadorRecreio nav)    {  

	this.navegadorRecreio = nav;        
         System.out.println(navegadorRecreio.getNomeCompletoNavegadorRecreio());
         return "DetalhesNavegador?faces-redirect=true";
}


// codigos para gerar reports

 public void gerarRelatorio(String nomeDaPasta, List lista, int idNavegadorRecreio, int idCategoria) throws JRException {
     
        
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        ServletContext context = (ServletContext)externalContext.getContext();
        JRDataSource jrds = null;
        String arquivo = null;
        
        if("navegador".equalsIgnoreCase(nomeDaPasta))
        {
         
       //  System.out.println(nav.getNavegadorRecreioPK().getIdNavegadorRecreio());
       //  System.out.println(nav.getCategoria().getCategoriaPK().getIdCategoria()); 
         
         List<NavegadorRecreio> navegadorRecreioIntern;
         navegadorRecreioIntern = lista;
         arquivo = context.getRealPath("resources/reports/navegador/Blank_A4_3.jasper"); 
         jrds = new JRBeanCollectionDataSource(navegadorRecreioIntern, false);
        
        }
        //JRJpaDataSource
        else if("categoria".equalsIgnoreCase(nomeDaPasta))
        {
         List<Categoria> categoriaIntern;
         categoriaIntern = lista;   
         arquivo = context.getRealPath("resources/reports/categoria/Blank_A4.jasper"); 
         jrds = new JRBeanCollectionDataSource(categoriaIntern); 
        }
        
        else if("competencia".equalsIgnoreCase(nomeDaPasta))
        {
         List<Competencia> competenciaIntern;
         competenciaIntern = lista;   
         arquivo = context.getRealPath("resources/reports/competencia/Blank_A4_1.jasper"); 
         jrds = new JRBeanCollectionDataSource(competenciaIntern, true); 
        }
        
        else
        {
                 System.out.println("Nome da pasta " + nomeDaPasta + " desconhecido");
        
        }
        
        //Aqui passar objectos ao mapa
        
        HashMap<String, Object> mapa = new HashMap<>();
        
        mapa.put("navegadorRecreio.navegadorRecreioPK.categoriaIdCategoria", idCategoria);
        mapa.put("navegadorRecreio.navegadorRecreioPK.idNavegadorRecreio", idNavegadorRecreio);
        
        jasperPrint = JasperFillManager.fillReport(arquivo, mapa, jrds);
        gerarRelatorioWeb(jrds, mapa, arquivo);
    }
 
    private void gerarRelatorioWeb(JRDataSource jrds, Map<String, Object> parametros, String arquivo) throws JRException {
        ServletOutputStream servletOutputStream = null;
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
 
        try {
            servletOutputStream = response.getOutputStream();
            JasperRunManager.runReportToPdfStream(new FileInputStream(new File(arquivo)), servletOutputStream, parametros, jrds);
          
            response.setContentType("application/pdf");
            response.addHeader("Content-disposition", "attachment; filename=Teste.pdf");
            servletOutputStream.flush();
            servletOutputStream.close();
            
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }  
          

        
            context.renderResponse();
            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
            context.responseComplete();
            
         

         

          

     
          
    }






// Retorna uma Bean NavegadorRecreio baseado no seu numero de carta.

public void listarNavegadorRecreioPorNumeroCartaNavegadorRecreio()
{

    //Codigo para retornar Bean NavegadorRecreio por meio da sua ID.
    
   listaNavegadorPorNumeroCarta =  navegadorRecreioSessionBean.retornaNavegadorPorNumeroCartao(navegadorRecreio.getNumeroCartaNavegadorRecreio());
   
   System.out.println(listaNavegadorPorNumeroCarta.toString());
   
  // return "ListarNavegadorRecreioPorID?faces-redirect=true"; 
   
   //return listaNavegadorPorID;
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



public DefaultStreamedContent byteToImage(byte[] imagem) throws IOException
{
    ByteArrayInputStream img = new ByteArrayInputStream(imagem);
    String contentType = new DefaultStreamedContent(img).getContentType();
    System.out.println(contentType);
    return new DefaultStreamedContent(img, "img/jpg");
    
    
}
        
        
        
public String retornaAListarTodosNavegadoresRecreio()
{

    navegadorRecreioSessionBean.showSucesso("SUCESSO NA OPERACAO");    
    return "ListarTodosNavegadorRecreio?faces-redirect=true";

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
 
 public void onRowSelect(SelectEvent event)
{
       nav = ((NavegadorRecreio) event.getObject());
       int i = 1 + 1;
       
       System.out.println(nav.toString());

}

public NavegadorRecreio getNavegadorRecreio()
{

        return navegadorRecreio;

} 

public NavegadorRecreio getNavegadorRecreioPorNumeroCartao(String numeroCartaoNavegadorRecreio){

   // return navegadorRecreioSessionBean.retornaNavegadorPorNumeroCartao(numeroCartaoNavegadorRecreio);
     return null;
}

public void apagaNavegadorPorID(String idNavegador){

    navegadorRecreioSessionBean.apagaNavegadorPorID(idNavegador);
    
}

public String modificaNavegadorRecreioPorID(){

        // !!! ISTO NAO EH MANEIRA DE SE PROGRAMAR UMA APLICACAO. POR ISSO REVER A PERFORMANCE DESSE METODO.
        
         //Aqui pegar categoria em funcao da string na propriedade
          String categoriaNavegadorRecreio = navegadorRecreio.getPegaCategoria(); 
         //Em funcao disso pegar Categoria correspondente.
          categoria = navegadorRecreioSessionBean.retornaCategoria(categoriaNavegadorRecreio);
        
         //Depois das instrucoes de actualizacao da bean, rever metodo abaixo
         // nav.setCategoria(navegadorRecreio.getCategoria());
          navegadorRecreio.setCategoria(categoria);
         // nav.setDataValidadeCartaNavegadorRecreio(navegadorRecreio.getDataValidadeCartaNavegadorRecreio());
         // aqui metodo pra converter foto em Part para Byte Array
          
          //navegadorRecreio.setFotoNavegadorRecreio(conversorPartToByteArray(navegadorRecreio.getFotoUpload()));
          navegadorRecreio.setFotoNavegadorRecreio(navegadorRecreio.getFotoUpload().getContents());
          //nav.setMoradaNavegadorRecreio(navegadorRecreio.getMoradaNavegadorRecreio());
          //nav.setNomeCompletoNavegadorRecreio(navegadorRecreio.getNomeCompletoNavegadorRecreio());
          //nav.setNumeroCartaNavegadorRecreio(navegadorRecreio.getNumeroCartaNavegadorRecreio());
         
    
          navegadorRecreioSessionBean.modificaNavegadorPorID(navegadorRecreio);
          navegadorRecreioSessionBean.showSucesso("SUCESSO NA OPERACAO"); 
          return "ListarTodosNavegadorRecreio?faces-redirect=true";
          

}

public NavegadorRecreio modificaNavegadorRecreio(){

    return navegadorRecreioSessionBean.modificaNavegador();

}


*/

// Seccao de testes
    
}