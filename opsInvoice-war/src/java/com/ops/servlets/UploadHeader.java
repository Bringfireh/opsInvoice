/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ops.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 *
 * @author OLIDAN
 */
public class UploadHeader extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         String itemName;
          boolean isMultipart = ServletFileUpload.isMultipartContent(request);
 if (!isMultipart) {
    out.print("this is not multipart, sorry!");
 } else {
      //if the directory does not exist/create it
                   File f = new File("hd");
                   if(f.mkdir() == false){
                        f.mkdir();
                    }
   FileItemFactory factory = new DiskFileItemFactory(10485760, f);
   ServletFileUpload upload = new ServletFileUpload(factory);
   List items = null;

   //get all the form fields here
   try {
        items = upload.parseRequest(request);//gets all the form fields
   } catch (FileUploadException e) {
        e.printStackTrace();
   }
   //iterate them here
   Iterator itr = items.iterator();
   while (itr.hasNext()){
         FileItem item = (FileItem) itr.next();
         if (item.isFormField()){
             //process other form fields here
        } else{//it is a file
            try {
                   itemName = item.getName();
                   //*************************************before upload, i want to see the details*****************************************//
                  String fname="";
                  String ext="";
                  int mid= itemName.lastIndexOf(".");
                  fname=itemName.substring(0,mid);
                  ext=itemName.substring(mid+1,itemName.length());
                  System.out.println("File name ="+fname);
                  System.out.println("Extension ="+ext);

                 
                   File savedFile = new File("hd/" + "header" + "." + "jpg");

                   item.write(savedFile);
                   out.println("Upload Successful - header.jpg");
                  response.sendRedirect("AdminBoard");

       } catch (Exception e) {
            e.printStackTrace();
       }
    }//end of else
  }//end of if itr.hasnext
}
        try {
            /*
             * TODO output your page here. You may use following sample code.
             
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UploadHeader</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UploadHeader at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            * 
            */
        } finally {            
            if (out != null) {
                          out.close();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
