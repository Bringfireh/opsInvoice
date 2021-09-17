/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ops.sessions;

import com.ops.helpers.CompanyInfo;
import com.ops.helpers.Transaction;
import java.util.ArrayList;
import javax.ejb.EJBLocalObject;
import javax.ejb.FinderException;

/**
 *
 * @author OLIDAN
 */
public interface InvoiceLocal extends EJBLocalObject {

    boolean createInvoiceItems(String itemcode, String itemdesc, Double amount, String invoicecode);

    boolean createInvoiceType(String invoicecode, String invoicedesc, String type);

    boolean createLogin(String username, String password, String role);

    boolean createTransaction(String transid, String cusname, String cusaddress, String transdate,String transtime, String invoicecode, String transtype);

    boolean createTransactionDetails(String transdid, String itemcode, Integer qnty, String itemdesc, Double itemrate, Double amount, String transid);

    boolean createTransdetailditemp(String tdid, String itemcode, String itemdesc, Double amount, String transid);

    boolean createTransDetailtemp(String tdid, Integer qnty, String itemdesc, Double rate, Double amount, String transid);

    boolean createUserInfo(String username, String surname, String firstname, String othernames, String sex, String phone, String email, String address,String password);
    
    String encryptPassword(String logpassword);

    ArrayList viewAllUsers();

    boolean changePassword(String username, String password);

    String getPassword(String username);

    boolean checkExistence(String username);

    ArrayList viewAllInvoiceTypes(String type);

    boolean prepareDInvoice(String invoicecode,String transid);

    String getInvoiceName(String invoicecode);

    ArrayList viewAllTransDetailDitemp(String transid);

    double getDITotal(String transid) throws FinderException;

    boolean moveTransDIdetailtemp(String transid);

    boolean deleteTransactionDetailDITemp(String transid);

    ArrayList viewAllTransactionDetail(String transid);

    Transaction viewInvoiceTransaction(String transid);

    boolean checkTransactionExistence(String transid);

    boolean checkNameExistence(String name);

    ArrayList viewTransactionsbyName(String name);

    boolean checkExistenceDateRange(String startdate, String enddate);

    ArrayList viewAllRecByDateRange(String startdate, String enddate);

    boolean createCompanyInfo(String companyname, String address, String phone, String email, String website);

    boolean checkCompanyInfoExistence();

    CompanyInfo viewAllCompanyInfo();

    boolean editCompanyInfo(String companyname, String address, String phone, String email, String website);

    ArrayList viewAllInvoices();

    ArrayList viewTransDetailtemp(String transid);

    double getTotalSumTransDetailTemp(String transid)throws FinderException;

    boolean moveTransdetailtempToTransDetail(String transid);

    boolean deleteTransDetailTemp(String transid);
}
