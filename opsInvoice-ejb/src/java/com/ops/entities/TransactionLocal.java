/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ops.entities;

import javax.ejb.EJBLocalObject;

/**
 *
 * @author OLIDAN
 */
public interface TransactionLocal extends EJBLocalObject {

    String getTransid();

    void setTransid(String transid);

    String getCusname();

    void setCusname(String cusname);

    String getCusaddress();

    void setCusaddress(String cusaddress);

    String getTransdate();

    void setTransdate(String transdate);

    String getTranstime();

    void setTranstime(String transtime);

    String getInvoicecode();

    void setInvoicecode(String invoicecode);

    String getTranstype();

    void setTranstype(String transtype);
    
    
}
