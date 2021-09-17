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
public interface TransdetailditempLocalHome extends EJBLocalHome {
    
    com.ops.entities.TransdetailditempLocal findByPrimaryKey(java.lang.String key) throws FinderException;
    
    com.ops.entities.TransdetailditempLocal create(java.lang.String key) throws CreateException;

    Collection findByTdid(String tdid) throws FinderException;

    Collection findByItemcode(String itemcode) throws FinderException;

    Collection findByItemdesc(String itemdesc) throws FinderException;

    Collection findByAmount(Double amount) throws FinderException;

    Collection findByTransid(String transid) throws FinderException;

    double getTotalSum(String transid) throws FinderException;
}
