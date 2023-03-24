package etu1836.framework.servlet;
import java.sql.SQLException;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import etu1836.framework.*;
import etu1836.framework.Utilitaire;
import etu1836.framework.Mapping;
public class FrontServlet extends HttpServlet 
{
    HashMap<String,Mapping> mappingUrls = new HashMap<>();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try {
                    response.setContentType("text/plain");
                    PrintWriter out = response.getWriter();
                    Utilitaire u = new Utilitaire();
                    String path= u.getPath(request); //Premiere methode
                    System.out.println(path);
                    String meth = u.getMethode(request); // Deuxieme methode  
                    System.out.println(meth);
                    out.println(path);
                    out.println(meth);
                    String paths = "D:/L2/S3/Reseaux/apache-tomcat-8/webapps/Script1/WEB-INF/classes/etu1836/framework/modele";
                    
                    mappingUrls= u.getHashmap( mappingUrls, paths);
                    u.printHM(mappingUrls);
                    Mapping map = u.geMap(mappingUrls, meth);
                    out.println( "Key : "+meth );
                    out.println( map.getClassName() + " | " + map.getMethod());
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    // TODO: handle exception
                }
               

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        processRequest(request,response);
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        

    }
}
