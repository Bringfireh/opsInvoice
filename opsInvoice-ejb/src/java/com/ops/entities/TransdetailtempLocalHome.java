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
public interface TransdetailtempLocalHome extends EJBLocalHome {
    
    com.ops.entities.TransdetailtempLocal findByPrimaryKey(java.lang.String key) throws FinderException;
    
    com.ops.entities.TransdetailtempLocal create(java.lang.String key) throws CreateException;

    Collection findByTdid(String tdid) throws FinderException;

    Collection findByQnty(Integer qnty) throws FinderException;

    Collection findByItemdesc(String itemdesc) throws FinderException;

    Collection findByRate(Double rate) throws FinderException;

    Collection findByAmount(Double amount) throws FinderException;

    Collection findByTransid(String transid) throws FinderException;

    Collection findAll() throws FinderException;

    double SumAmount(String transid) throws FinderException;
}
