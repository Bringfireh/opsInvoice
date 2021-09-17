/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ops.servlets;

import com.ops.helpers.CompanyInfo;
import com.ops.helpers.Transaction;
import com.ops.sessions.InvoiceLocal;
import com.ops.sessions.InvoiceLocalHome;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author OLIDAN
 */
public class InVoiceRep extends HttpServlet {

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
        
        InvoiceLocal iL=lookupInvoiceLocal();
        String transid = request.getParameter("transid");

        try{
             List lte = iL.viewAllTransactionDetail(transid);
             if(iL.checkTransactionExistence(transid)!=false && iL.checkCompanyInfoExistence()!=false){
             Transaction tz =iL.viewInvoiceTransaction(transid);
             CompanyInfo ci =iL.viewAllCompanyInfo();
             response.setContentType("application/pdf");
             ServletOutputStream sos = response.getOutputStream();
             String path = getServletConfig().getServletContext().getRealPath("Reports/InvoiceRep.jasper");

           

            JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(lte);
            HashMap hm = new HashMap();
            hm.put("transid", tz.getTransid());
            hm.put("cusname", tz.getCusname());
            hm.put("cusaddress", tz.getCusaddress());
            hm.put("transdate", tz.getTransdate());
            hm.put("transtime", tz.getTranstime());
            hm.put("invoicename", iL.getInvoiceName(tz.getInvoicecode()).toUpperCase());
            hm.put("companyname", ci.getCompanyname());
            hm.put("address", ci.getAddress());
            hm.put("phone", ci.getPhone());
            hm.put("email", ci.getEmail());
            hm.put("website", ci.getWebsite());
            hm.put("head", new FileInputStream(new File("hd/header"+ ".jpg")));
            JasperPrint jp = JasperFillManager.fillReport(path, hm, source);
            JasperExportManager.exportReportToPdfStream(jp, sos);
            sos.flush();
            sos.close();
             }else{
                 
             }
        }catch(Exception ex){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            response.setContentType("text/plain");
            response.getOutputStream().print(sw.toString());
            System.out.println("Error generating report "+ex.getMessage());
        }
         finally {
//          out.close();
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

    private InvoiceLocal lookupInvoiceLocal() {
        try {
            Context c = new InitialContext();
            InvoiceLocalHome rv = (InvoiceLocalHome) c.lookup("java:comp/env/Invoice");
            return rv.create();
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        } catch (CreateException ce) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ce);
            throw new RuntimeException(ce);
        }
    }
}
