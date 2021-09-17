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
public interface InvoiceitemsLocal extends EJBLocalObject {

    String getItemcode();

    void setItemcode(String itemcode);

    String getItemdesc();

    void setItemdesc(String itemdesc);

    Double getAmount();

    void setAmount(Double amount);

    String getInvoicecode();

    void setInvoicecode(String invoicecode);
    
    
}
