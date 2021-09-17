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
public interface TransdetailditempLocal extends EJBLocalObject {

    String getTdid();

    void setTdid(String tdid);

    String getItemcode();

    void setItemcode(String itemcode);

    String getItemdesc();

    void setItemdesc(String itemdesc);

    Double getAmount();

    void setAmount(Double amount);

    String getTransid();

    void setTransid(String transid);
    
    
}
