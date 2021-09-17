/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ops.sessions;

import com.ops.entities.*;
import com.ops.helpers.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sun.misc.BASE64Encoder;

/**
 *
 * @author OLIDAN
 */
public class Invoice implements SessionBean {
    
    private SessionContext context;
    InvoiceitemsLocalHome iiLH=lookupInvoiceitemsLocal();
    InvoicetypeLocalHome itLH=lookupInvoicetypeLocal();
    LoginLocalHome lLH=lookupLoginLocal();
    TransactionLocalHome tLH=lookupTransactionLocal() ;
    TransactiondetailsLocalHome tdLH=lookupTransactiondetailsLocal();
    TransdetailditempLocalHome tditLH=lookupTransdetailditempLocal();
    TransdetailtempLocalHome tdtLH=lookupTransdetailtempLocal();
    UserinfoLocalHome uiLH=lookupUserinfoLocal();
    CompanyinfoLocalHome ciLH=lookupCompanyinfoLocal();
    
    

    // <editor-fold defaultstate="collapsed" desc="EJB infrastructure methods. Click the + sign on the left to edit the code.">;
    // TODO Add code to acquire and use other enterprise resources (DataSource, JMS, enterprise bean, Web services)
    // TODO Add business methods or web service operations
    /**
     * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
     */
    public void setSessionContext(SessionContext aContext) {
        context = aContext;
    }

    /**
     * @see javax.ejb.SessionBean#ejbActivate()
     */
    public void ejbActivate() {
        iiLH=lookupInvoiceitemsLocal();
        itLH=lookupInvoicetypeLocal();
        lLH=lookupLoginLocal();
        tLH=lookupTransactionLocal();
        tdLH=lookupTransactiondetailsLocal();
        tditLH=lookupTransdetailditempLocal();
        tdtLH=lookupTransdetailtempLocal();
        uiLH=lookupUserinfoLocal();
        ciLH=lookupCompanyinfoLocal();
    }

    /**
     * @see javax.ejb.SessionBean#ejbPassivate()
     */
    public void ejbPassivate() {
        iiLH=null;
        itLH=null;
        lLH=null;
        tLH=null;
        tdLH=null;
        tditLH=null;
        tdtLH=null;
        uiLH=null;
        ciLH=null;
    }

    /**
     * @see javax.ejb.SessionBean#ejbRemove()
     */
    public void ejbRemove() {
        iiLH=null;
        itLH=null;
        lLH=null;
        tLH=null;
        tdLH=null;
        tditLH=null;
        tdtLH=null;
        uiLH=null;
        ciLH=null;
    }

    // </editor-fold>;
    /**
     * See section 7.10.3 of the EJB 2.0 specification See section 7.11.3 of the
     * EJB 2.1 specification
     */
    public void ejbCreate() {
        iiLH=lookupInvoiceitemsLocal();
        itLH=lookupInvoicetypeLocal();
        lLH=lookupLoginLocal();
        tLH=lookupTransactionLocal();
        tdLH=lookupTransactiondetailsLocal();
        tditLH=lookupTransdetailditempLocal();
        tdtLH=lookupTransdetailtempLocal();
        uiLH=lookupUserinfoLocal();
        ciLH=lookupCompanyinfoLocal();
        // TODO implement ejbCreate if necessary, acquire resources
        // This method has access to the JNDI context so resource aquisition
        // spanning all methods can be performed here such as home interfaces
        // and data sources.
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")

    private InvoiceitemsLocalHome lookupInvoiceitemsLocal() {
        try {
            Context c = new InitialContext();
            InvoiceitemsLocalHome rv = (InvoiceitemsLocalHome) c.lookup("java:comp/env/Invoiceitems");
            return rv;
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private InvoicetypeLocalHome lookupInvoicetypeLocal() {
        try {
            Context c = new InitialContext();
            InvoicetypeLocalHome rv = (InvoicetypeLocalHome) c.lookup("java:comp/env/Invoicetype");
            return rv;
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private LoginLocalHome lookupLoginLocal() {
        try {
            Context c = new InitialContext();
            LoginLocalHome rv = (LoginLocalHome) c.lookup("java:comp/env/Login");
            return rv;
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private TransactionLocalHome lookupTransactionLocal() {
        try {
            Context c = new InitialContext();
            TransactionLocalHome rv = (TransactionLocalHome) c.lookup("java:comp/env/Transaction");
            return rv;
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private TransactiondetailsLocalHome lookupTransactiondetailsLocal() {
        try {
            Context c = new InitialContext();
            TransactiondetailsLocalHome rv = (TransactiondetailsLocalHome) c.lookup("java:comp/env/Transactiondetails");
            return rv;
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private TransdetailditempLocalHome lookupTransdetailditempLocal() {
        try {
            Context c = new InitialContext();
            TransdetailditempLocalHome rv = (TransdetailditempLocalHome) c.lookup("java:comp/env/Transdetailditemp");
            return rv;
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private TransdetailtempLocalHome lookupTransdetailtempLocal() {
        try {
            Context c = new InitialContext();
            TransdetailtempLocalHome rv = (TransdetailtempLocalHome) c.lookup("java:comp/env/Transdetailtemp");
            return rv;
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    private UserinfoLocalHome lookupUserinfoLocal() {
        try {
            Context c = new InitialContext();
            UserinfoLocalHome rv = (UserinfoLocalHome) c.lookup("java:comp/env/Userinfo");
            return rv;
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    private CompanyinfoLocalHome lookupCompanyinfoLocal() {
        try {
            Context c = new InitialContext();
            CompanyinfoLocalHome rv = (CompanyinfoLocalHome) c.lookup("java:comp/env/Companyinfo");
            return rv;
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public boolean createInvoiceItems(String itemcode, String itemdesc, Double amount, String invoicecode) {
        InvoiceitemsLocal iiL;
        try{
            iiL=iiLH.create(itemcode);
            iiL.setItemdesc(itemdesc);
            iiL.setAmount(amount);
            iiL.setInvoicecode(invoicecode);
            return true;
        }catch(Exception ex){
             return false;
        }
       
    }

    public boolean createInvoiceType(String invoicecode, String invoicedesc, String type) {
        InvoicetypeLocal itL;
        try{
            itL = itLH.create(invoicecode);
            itL.setInvoicedesc(invoicedesc);
            itL.setType(type);
            return true;
        }catch(Exception ex){
            return false;
        }
        
    }

    public boolean createLogin(String username, String password, String role) {
        LoginLocal lL;
        try{
            lL=lLH.create(username);
            lL.setPassword(password);
            lL.setRole(role);
             return true;
        }catch(Exception ex){
             return false;
        }
       
    }

    public boolean createTransaction(String transid, String cusname, String cusaddress, String transdate,String transtime, String invoicecode, String transtype) {
        TransactionLocal tL;
        try{
            tL = tLH.create(transid);
            tL.setCusname(cusname);
            tL.setCusaddress(cusaddress);
            tL.setTransdate(transdate);
            tL.setTranstime(transtime);
            tL.setInvoicecode(invoicecode);
            tL.setTranstype(transtype);
            return true;
        }catch(Exception ex){
            return false;
        }
        
    }

    public boolean createTransactionDetails(String transdid, String itemcode, Integer qnty, String itemdesc, Double itemrate, Double amount, String transid) {
        TransactiondetailsLocal tdL;
        try{
            tdL = tdLH.create(transdid);
            tdL.setItemcode(itemcode);
            tdL.setQnty(qnty);
            tdL.setItemdesc(itemdesc);
            tdL.setItemrate(itemrate);
            tdL.setAmount(amount);
            tdL.setTransid(transid);
            return true;
        }catch(Exception ex){
            return false;
        }
        
    }

    public boolean createTransdetailditemp(String tdid, String itemcode, String itemdesc, Double amount, String transid) {
        TransdetailditempLocal tditL;
        try{
            tditL = tditLH.create(tdid);
            tditL.setItemcode(itemcode);
            tditL.setItemdesc(itemdesc);
            tditL.setAmount(amount);
            tditL.setTransid(transid);
            return true;
        }catch(Exception ex){
            return false;
        }
        
    }

    public boolean createTransDetailtemp(String tdid, Integer qnty, String itemdesc, Double rate, Double amount, String transid) {
        TransdetailtempLocal tdtL;
        try{
            tdtL = tdtLH.create(tdid);
            tdtL.setQnty(qnty);
            tdtL.setItemdesc(itemdesc);
            tdtL.setRate(rate);
            tdtL.setAmount(amount);
            tdtL.setTransid(transid);
            return true;
        }catch(Exception ex){
            return false;
        }
        
    }

    public boolean createUserInfo(String username, String surname, String firstname, String othernames, String sex, String phone, String email, String address, String password) {
        UserinfoLocal uiL;
        try{
            uiL = uiLH.create(username);
            uiL.setSurname(surname);
            uiL.setFirstname(firstname);
            uiL.setOthernames(othernames);
            uiL.setSex(sex);
            uiL.setPhone(phone);
            uiL.setEmail(email);
            uiL.setAddress(address);
            this.createLogin(username, this.encryptPassword(password), "user");
            return true;
        }catch(Exception ex){
            return false;
        }
        
    }
    public String encryptPassword(String logpassword) {
       MessageDigest md = null;
    //System.out.println("Password main "+plaintext);
        try{
            md = MessageDigest.getInstance("SHA-256");
        }catch(Exception e){
            System.out.println("Error in encrypt password "+e.getMessage());
        }
        try{
            md.update(logpassword.getBytes("UTF-8"));
        }catch(UnsupportedEncodingException e){
        System.out.println("Error in encrypt password "+e.getMessage());
        }

         byte raw[] = md.digest();
         String hash = (new BASE64Encoder()).encode(raw);
     //System.out.println("Encrypt passworld "+hash);
        return hash;
        }

    public ArrayList viewAllUsers() {
        LoginLocal lL;
        Collection coll;
        ArrayList al = new ArrayList();
        try{
            coll =lLH.findAll();
            Iterator it = coll.iterator();
            while(it.hasNext()){
                lL =(LoginLocal)it.next();
                User u =new User(uiLH.findByPrimaryKey(lL.getUsername()).getSurname()+ " " + uiLH.findByPrimaryKey(lL.getUsername()).getFirstname() + " " + uiLH.findByPrimaryKey(lL.getUsername()).getOthernames(), uiLH.findByPrimaryKey(lL.getUsername()).getSex(),lL.getUsername(), lL.getPassword(), lL.getRole() );
                al.add(u);
            }
        }catch(Exception ex){
            
        }
        
        return al;
    }

    public boolean changePassword(String username, String password) {
        LoginLocal lL;
        try{
            lL=lLH.findByPrimaryKey(username);
            lL.setPassword(password);
             return true;
        }catch(Exception ex){
             return false;
        }
        
    }

    public String getPassword(String username) {
        LoginLocal lL;
        String password="";
        try{
            lL=lLH.findByPrimaryKey(username);
            password = lL.getPassword();
             
        }catch(Exception ex){
             
        }
        return password;
    }

    public boolean checkExistence(String username) {
        LoginLocal lL;
        boolean status=false;
        try{
            lL=lLH.findByPrimaryKey(username);
            if(lL!=null){
                status=true;
            }
             
        }catch(Exception ex){
             
        }
        return status;
    }

    public ArrayList viewAllInvoiceTypes(String type) {
        InvoicetypeLocal itL;
        Collection coll;
        ArrayList al = new ArrayList();
        try{
            coll = itLH.findByType(type);
            Iterator it = coll.iterator();
            while(it.hasNext()){
                itL =(InvoicetypeLocal)it.next();
                InvoiceType inte= new InvoiceType(itL.getInvoicecode(), itL.getInvoicedesc(), itL.getType());
                al.add(inte);
            }
        }catch(Exception ex){
            
        }
        return al;
    }

    public boolean prepareDInvoice(String invoicecode, String transid) {
        InvoiceitemsLocal iiL;
        Collection coll;
        ArrayList al = new ArrayList();
        try{
            coll =iiLH.findByInvoicecode(invoicecode);
            Iterator it = coll.iterator();
//            int c=0;
            while(it.hasNext()){
                iiL =(InvoiceitemsLocal)it.next();
//                c++;
                this.createTransdetailditemp(transid + iiL.getItemcode(), iiL.getItemcode(), iiL.getItemdesc(), iiL.getAmount(), transid);
            }
            return true;
        }catch(Exception ex){
            return false;
        }
        
    }

    public String getInvoiceName(String invoicecode) {
        InvoicetypeLocal itL;
        String name="";
        try{
            itL=itLH.findByPrimaryKey(invoicecode);
            name=itL.getInvoicedesc();
        }catch(Exception ex){
            
        }
        return name;
    }

    public ArrayList viewAllTransDetailDitemp(String transid) {
       TransdetailditempLocal tditL;
       Collection coll;
       ArrayList al = new ArrayList();
       try{
           coll = tditLH.findByTransid(transid);
           Iterator it =coll.iterator();
           while(it.hasNext()){
               tditL =(TransdetailditempLocal)it.next();
               TransactionDetailDITemp tdt = new TransactionDetailDITemp(tditL.getTdid(), tditL.getItemcode(), tditL.getItemdesc(), tditL.getAmount(), tditL.getTransid());
           al.add(tdt);
           }
       }catch(Exception ex){
           
       }
        return al;
    }

    public double getDITotal(String transid) throws FinderException {
       if (!tditLH.findByTransid(transid).isEmpty()){
           return tditLH.getTotalSum(transid);
       }else{
           return 0.00;
       }
        
    }

    public boolean moveTransDIdetailtemp(String transid) {
        TransdetailditempLocal tditL;
       Collection coll;
       ArrayList al = new ArrayList();
       try{
           coll = tditLH.findByTransid(transid);
           Iterator it =coll.iterator();
           int c=0;
           while(it.hasNext()){
               tditL =(TransdetailditempLocal)it.next();
               c++;
               this.createTransactionDetails(transid + c, tditL.getItemcode(), new Integer(1), tditL.getItemdesc(), tditL.getAmount(), tditL.getAmount(), transid);
           }
           return true;
        }catch(Exception ex){
             return false;
        }
       
    }

    public boolean deleteTransactionDetailDITemp(String transid) {
        TransdetailditempLocal tditL;
       Collection coll;
       ArrayList al = new ArrayList();
       try{
           coll = tditLH.findByTransid(transid);
           Iterator it =coll.iterator();
           int c=0;
           while(it.hasNext()){
               tditL =(TransdetailditempLocal)it.next();
               tditL.remove();
           }
           return true;
       }catch(Exception ex){
           return false;
       }
        
    }

    public ArrayList viewAllTransactionDetail(String transid) {
         TransactiondetailsLocal tdL;
         Collection coll;
         ArrayList al = new ArrayList();
         try{
             coll = tdLH.findByTransid(transid);
             Iterator it =coll.iterator();
             int c =0;
             while(it.hasNext()){
                 tdL=(TransactiondetailsLocal)it.next();
                 c++;
                 TransactionDetails td = new TransactionDetails(new Integer(c).toString(), tdL.getItemcode(), tdL.getQnty(), tdL.getItemdesc(), tdL.getItemrate(), tdL.getAmount(), tdL.getTransid());
                 al.add(td);
             }
         }catch(Exception ex){
              
         }
       return al;
    }

    public com.ops.helpers.Transaction viewInvoiceTransaction(String transid) {
        TransactionLocal tL = null;
        try{
            tL=tLH.findByPrimaryKey(transid);
        }catch(Exception ex){
            
        }
        return new com.ops.helpers.Transaction(tL.getTransid(), tL.getCusname(), tL.getCusaddress(), tL.getTransdate(), tL.getTranstime(), tL.getInvoicecode(), tL.getTranstype());
    }

    public boolean checkTransactionExistence(String transid) {
        TransactionLocal tL;
        boolean istrue =false;
        try{
            tL = tLH.findByPrimaryKey(transid);
            if(tL!=null){
                istrue = true;
            }
            
        }catch(Exception ex){
            
        }
        return istrue;
    }

    public boolean checkNameExistence(String name) {
        TransactionLocal tL;
        boolean istrue =false;
        try{
            tL =(TransactionLocal)tLH.findByCustomerName(name).iterator().next();
            if(tL!=null){
                istrue=true;
            }
        }catch(Exception ex){
            
        }
        return istrue;
    }

    public ArrayList viewTransactionsbyName(String name) {
        TransactionLocal tL;
        ArrayList al = new ArrayList();
        Collection coll;
        try{
            coll =tLH.findByCustomerName(name);
            Iterator it = coll.iterator();
            while(it.hasNext()){
                tL =(TransactionLocal)it.next();
                com.ops.helpers.Transaction tx = new com.ops.helpers.Transaction(tL.getTransid(), tL.getCusname(), tL.getCusaddress(), tL.getTransdate(), tL.getTranstime(), tL.getInvoicecode(), tL.getTranstype());
                al.add(tx);
            }
        }catch(Exception ex){
            
        }
        return al;
    }

    public boolean checkExistenceDateRange(String startdate, String enddate) {
        TransactionLocal tL;
        boolean test=false;
        try{
            tL=(TransactionLocal)tLH.findByDateRange(startdate, enddate).iterator().next();
            if(tL!=null){
               test=true; 
            }
        }catch(Exception ex){
            
        }
        return test;
    }

    public ArrayList viewAllRecByDateRange(String startdate, String enddate) {
        TransactionLocal tL;
        ArrayList al = new ArrayList();
        Collection coll;
        try{
            coll =tLH.findByDateRange(startdate, enddate);
            Iterator it = coll.iterator();
            while(it.hasNext()){
                tL =(TransactionLocal)it.next();
                com.ops.helpers.Transaction tx = new com.ops.helpers.Transaction(tL.getTransid(), tL.getCusname(), tL.getCusaddress(), tL.getTransdate(), tL.getTranstime(), tL.getInvoicecode(), tL.getTranstype());
                al.add(tx);
            }
        }catch(Exception ex){
            
        }
        return al;
        
    }

    public boolean createCompanyInfo(String companyname, String address, String phone, String email, String website) {
        CompanyinfoLocal ciL;
        try{
            ciL = ciLH.create(companyname);
            ciL.setAddress(address);
            ciL.setPhone(phone);
            ciL.setEmail(email);
            ciL.setWebsite(website);
            return true;
        }catch(Exception ex){
            return false;
        }
        
    }

    public boolean checkCompanyInfoExistence() {
        CompanyinfoLocal ciL;
        boolean test=false;
        try{
            ciL =(CompanyinfoLocal)ciLH.findAll().iterator().next();
            if(ciL!=null){
                test=true;
            }
        }catch(Exception ex){
            
        }
        return test;
    }

    public com.ops.helpers.CompanyInfo viewAllCompanyInfo() {
        CompanyinfoLocal ciL=null;
        try{
            ciL =(CompanyinfoLocal)ciLH.findAll().iterator().next();
        }catch(Exception ex){
            
        }
        return new CompanyInfo(ciL.getCompanyname(), ciL.getAddress(), ciL.getPhone(), ciL.getEmail(), ciL.getWebsite());
    }

    public boolean editCompanyInfo(String companyname, String address, String phone, String email, String website) {
        CompanyinfoLocal ciL;
        try{
            ciL =(CompanyinfoLocal)ciLH.findAll().iterator().next();
            ciL.setCompanyname(companyname);
            ciL.setAddress(address);
            ciL.setPhone(phone);
            ciL.setEmail(email);
            ciL.setWebsite(website);
            return true;
        }catch(Exception ex){
            return false;
        }
        
    }

    public ArrayList viewAllInvoices() {
        InvoicetypeLocal itL;
        Collection coll;
        ArrayList al = new ArrayList();
        try{
            coll = itLH.findAll();
            Iterator it = coll.iterator();
            while(it.hasNext()){
                itL =(InvoicetypeLocal)it.next();
                InvoiceType inte= new InvoiceType(itL.getInvoicecode(), itL.getInvoicedesc(), itL.getType());
                al.add(inte);
            }
        }catch(Exception ex){
            
        }
        return al;
    }

    public ArrayList viewTransDetailtemp(String transid) {
        TransdetailtempLocal tdtL;
        ArrayList al =new ArrayList();
        Collection coll;
        try{
            coll = tdtLH.findByTransid(transid);
            Iterator it = coll.iterator();
            while(it.hasNext()){
                tdtL =(TransdetailtempLocal)it.next();
                TransDetailTemp tdt = new TransDetailTemp(tdtL.getTdid(), tdtL.getQnty(),tdtL.getItemdesc(),tdtL.getRate(), tdtL.getAmount(), tdtL.getTransid());
                al.add(tdt);
            }
        }catch(Exception ex){
            
        }
        return al;
    }

    public double getTotalSumTransDetailTemp(String transid) throws FinderException {
        if (!tdtLH.findByTransid(transid).isEmpty()){
           return tdtLH.SumAmount(transid);
       }else{
           return 0.00;
       }
    }

    public boolean moveTransdetailtempToTransDetail(String transid) {
        TransdetailtempLocal tdtL;
       Collection coll;
       ArrayList al = new ArrayList();
       try{
           coll = tdtLH.findByTransid(transid);
           Iterator it =coll.iterator();
           int c=0;
           while(it.hasNext()){
               tdtL =(TransdetailtempLocal)it.next();
               c++;
               this.createTransactionDetails(transid + c, tdtL.getTdid(), tdtL.getQnty(), tdtL.getItemdesc(), tdtL.getRate(), tdtL.getAmount(), transid);
           }
           return true;
        }catch(Exception ex){
             return false;
        }
    }

    public boolean deleteTransDetailTemp(String transid) {
        TransdetailtempLocal tdtL;
        Collection coll;
       ArrayList al = new ArrayList();
       try{
           coll = tdtLH.findByTransid(transid);
           Iterator it =coll.iterator();
           
           while(it.hasNext()){
               tdtL =(TransdetailtempLocal)it.next();
               tdtL.remove();
           }
           return true;
       }catch(Exception ex){
           return false;
       }
        
    }

    
    
    
    
}
