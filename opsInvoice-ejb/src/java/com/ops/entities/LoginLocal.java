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
public interface LoginLocal extends EJBLocalObject {

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    String getRole();

    void setRole(String role);
    
    
}
