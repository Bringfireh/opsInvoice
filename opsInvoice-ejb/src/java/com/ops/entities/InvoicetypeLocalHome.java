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
public interface InvoicetypeLocalHome extends EJBLocalHome {
    
    com.ops.entities.InvoicetypeLocal findByPrimaryKey(java.lang.String key) throws FinderException;
    
    com.ops.entities.InvoicetypeLocal create(java.lang.String key) throws CreateException;

    Collection findByInvoicecode(String invoicecode) throws FinderException;

    Collection findByInvoicedesc(String invoicedesc) throws FinderException;

    Collection findByType(String type) throws FinderException;

    Collection findAll() throws FinderException;
}
