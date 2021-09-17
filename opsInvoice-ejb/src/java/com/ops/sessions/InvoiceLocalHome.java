/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ops.sessions;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

/**
 *
 * @author OLIDAN
 */
public interface InvoiceLocalHome extends EJBLocalHome {
    
    com.ops.sessions.InvoiceLocal create() throws CreateException;
}
