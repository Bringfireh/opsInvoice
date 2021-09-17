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
public interface LoginLocalHome extends EJBLocalHome {
    
    com.ops.entities.LoginLocal findByPrimaryKey(java.lang.String key) throws FinderException;
    
    com.ops.entities.LoginLocal create(java.lang.String key) throws CreateException;

    Collection findByUsername(String username) throws FinderException;

    Collection findByPassword(String password) throws FinderException;

    Collection findByRole(String role) throws FinderException;

    Collection findAll() throws FinderException;
}
