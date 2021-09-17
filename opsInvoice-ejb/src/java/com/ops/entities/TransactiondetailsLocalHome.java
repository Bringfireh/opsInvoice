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
public interface TransactiondetailsLocalHome extends EJBLocalHome {
    
    com.ops.entities.TransactiondetailsLocal findByPrimaryKey(java.lang.String key) throws FinderException;
    
    com.ops.entities.TransactiondetailsLocal create(java.lang.String key) throws CreateException;

    Collection findByTransdid(String transdid) throws FinderException;

    Collection findByItemcode(String itemcode) throws FinderException;

    Collection findByQnty(Integer qnty) throws FinderException;

    Collection findByItemdesc(String itemdesc) throws FinderException;

    Collection findByItemrate(Double itemrate) throws FinderException;

    Collection findByAmount(Double amount) throws FinderException;

    Collection findByTransid(String transid) throws FinderException;
}
