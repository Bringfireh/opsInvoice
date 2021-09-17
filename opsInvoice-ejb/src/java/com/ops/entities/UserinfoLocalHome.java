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
public interface UserinfoLocalHome extends EJBLocalHome {
    
    com.ops.entities.UserinfoLocal findByPrimaryKey(java.lang.String key) throws FinderException;
    
    com.ops.entities.UserinfoLocal create(java.lang.String key) throws CreateException;

    Collection findByUsername(String username) throws FinderException;

    Collection findBySurname(String surname) throws FinderException;

    Collection findByFirstname(String firstname) throws FinderException;

    Collection findByOthernames(String othernames) throws FinderException;

    Collection findBySex(String sex) throws FinderException;

    Collection findByPhone(String phone) throws FinderException;

    Collection findByEmail(String email) throws FinderException;

    Collection findByAddress(String address) throws FinderException;
}
