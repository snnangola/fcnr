/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.navegador.recreio.web;


import com.navegador.recreio.util.Conexao;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author snnangolaPC
 */
@WebServlet(name = "PDFServlet", urlPatterns = {"/plugins/PDFServlet"})
public class PDFServlet extends HttpServlet {
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        Connection conn=null;        

        ServletOutputStream servletOutputStream = response.getOutputStream();

        File arquivo = new File(getServletConfig().getServletContext().getRealPath("resources/reports/navegador/Blank_A4_6.jasper"));
        //File arquivo = new File(getServletConfig().getServletContext().getRealPath("resources/reports/competencia/Blank_A4_1.jasper"));
        byte[] bytes;

        String idGeral = request.getParameter("idGeral");
	String idCategoria = request.getParameter("idCategoria");
	String comando = request.getParameter("comando");
	

       if (comando.equalsIgnoreCase("NAVEGADOR")) {

       
        HashMap mapa = new HashMap();
   
       // mapa.put("navegadorRecreio.navegadorRecreioPK.idNavegadorRecreio", idNavegadorRecreio);
       // mapa.put("navegadorRecreio.navegadorRecreioPK.categoriaIdCategoria", idCategoria);
       // mapa.put("navegadorRecreio.navegadorRecreioPK.categoriaCompetenciaIdCompetencia", idCategoria);
        
        //mapa.put("idNavegadorRecreio", Integer.parseInt(idNavegadorRecreio)); WORKS!!!
        
          mapa.put("id_navegador_recreio", Integer.parseInt(idGeral));
          mapa.put("categoriaIdCategoria", Integer.parseInt(idCategoria));
          mapa.put("categoriaCompetenciaIdCompetencia", Integer.parseInt(idCategoria));
        
        /*      id_navegador_recreio
                categoriaIdCategoria
                categoriaCompetenciaIdCompetencia*/

            try {
           
                conn = Conexao.getConnection();
                //bytes = JasperRunManager.runReportToPdf(arquivo.getPath(), mapa, conn);
                bytes = JasperRunManager.runReportToPdf(arquivo.getPath(), mapa, conn);
                conn.close();
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                servletOutputStream.write(bytes, 0, bytes.length);
                servletOutputStream.flush();
                servletOutputStream.close();

            } catch (IOException | JRException | SQLException ex) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                ex.printStackTrace(printWriter);
                response.setContentType("text/plain");
                response.getOutputStream().print(stringWriter.toString());

            }

        }
      else{
       
       response.sendRedirect("../faces/Welcome.xhtml");
       System.out.println("Falha de parametros");
       
       }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    
            processRequest(request, response);
       
          
        
     
           
        }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
     
            processRequest(request, response);
       
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
