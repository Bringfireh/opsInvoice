/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ops.entities;

import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

/**
 *
 * @author OLIDAN
 */
public interface InvoiceitemsLocalHome extends EJBLocalHome {
    
    com.ops.entities.InvoiceitemsLocal findByPrimaryKey(java.lang.String key) throws FinderException;
    
    com.ops.entities.InvoiceitemsLocal create(java.lang.String key) throws CreateException;

    Collection findByItemcode(String itemcode) throws FinderException;

    Collection findByItemdesc(String itemdesc) throws FinderException;

    Collection findByAmount(Double amount) throws FinderException;

    Collection findByInvoicecode(String invoicecode) throws FinderException;
}
