/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ops.entities;

import javax.ejb.EJBLocalObject;

/**
 *
 * @author OLIDAN
 */
public interface CompanyinfoLocal extends EJBLocalObject {

    String getCompanyname();

    void setCompanyname(String companyname);

    String getAddress();

    void setAddress(String address);

    String getPhone();

    void setPhone(String phone);

    String getEmail();

    void setEmail(String email);

    String getWebsite();

    void setWebsite(String website);
    
    
}
