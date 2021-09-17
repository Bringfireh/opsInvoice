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
public interface TransactiondetailsLocal extends EJBLocalObject {

    String getTransdid();

    void setTransdid(String transdid);

    String getItemcode();

    void setItemcode(String itemcode);

    Integer getQnty();

    void setQnty(Integer qnty);

    String getItemdesc();

    void setItemdesc(String itemdesc);

    Double getItemrate();

    void setItemrate(Double itemrate);

    Double getAmount();

    void setAmount(Double amount);

    String getTransid();

    void setTransid(String transid);
    
    
}
