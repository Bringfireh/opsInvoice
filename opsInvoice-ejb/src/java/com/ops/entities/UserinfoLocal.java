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
public interface UserinfoLocal extends EJBLocalObject {

    String getUsername();

    void setUsername(String username);

    String getSurname();

    void setSurname(String surname);

    String getFirstname();

    void setFirstname(String firstname);

    String getOthernames();

    void setOthernames(String othernames);

    String getSex();

    void setSex(String sex);

    String getPhone();

    void setPhone(String phone);

    String getEmail();

    void setEmail(String email);

    String getAddress();

    void setAddress(String address);
    
    
}
