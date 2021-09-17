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
public interface TransdetailtempLocal extends EJBLocalObject {

    String getTdid();

    void setTdid(String tdid);

    Integer getQnty();

    void setQnty(Integer qnty);

    String getItemdesc();

    void setItemdesc(String itemdesc);

    Double getRate();

    void setRate(Double rate);

    Double getAmount();

    void setAmount(Double amount);

    String getTransid();

    void setTransid(String transid);
    
    
}
