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
public interface CompanyinfoLocalHome extends EJBLocalHome {
    
    com.ops.entities.CompanyinfoLocal findByPrimaryKey(java.lang.String key) throws FinderException;
    
    com.ops.entities.CompanyinfoLocal create(java.lang.String key) throws CreateException;

    Collection findByCompanyname(String companyname) throws FinderException;

    Collection findByAddress(String address) throws FinderException;

    Collection findByPhone(String phone) throws FinderException;

    Collection findByEmail(String email) throws FinderException;

    Collection findByWebsite(String website) throws FinderException;

    Collection findAll() throws FinderException;
}
