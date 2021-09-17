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
public interface TransactionLocalHome extends EJBLocalHome {
    
    com.ops.entities.TransactionLocal findByPrimaryKey(java.lang.String key) throws FinderException;
    
    com.ops.entities.TransactionLocal create(java.lang.String key) throws CreateException;

    Collection findByTransid(String transid) throws FinderException;

    Collection findByCusname(String cusname) throws FinderException;

    Collection findByCusaddress(String cusaddress) throws FinderException;

    Collection findByTransdate(String transdate) throws FinderException;

    Collection findByCustomerName(String name) throws FinderException;

    Collection findByDateRange(String startdate, String enddate) throws FinderException;
}
