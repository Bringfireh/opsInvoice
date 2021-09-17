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
public interface InvoicetypeLocal extends EJBLocalObject {

    String getInvoicecode();

    void setInvoicecode(String invoicecode);

    String getInvoicedesc();

    void setInvoicedesc(String invoicedesc);

    String getType();

    void setType(String type);
    
    
}
