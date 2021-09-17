/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ops.entities;

import javax.ejb.CreateException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

/**
 *
 * @author OLIDAN
 */
public abstract class Transaction implements EntityBean {
    
    private EntityContext context;

    // <editor-fold defaultstate="collapsed" desc="EJB infrastructure methods. Click on the + sign on the left to edit the code.">
    // TODO Consider creating Transfer Object to encapsulate data
    // TODO Review finder methods
    /**
     * @see javax.ejb.EntityBean#setEntityContext(javax.ejb.EntityContext)
     */
    public void setEntityContext(EntityContext aContext) {
        context = aContext;
    }

    /**
     * @see javax.ejb.EntityBean#ejbActivate()
     */
    public void ejbActivate() {
        
    }

    /**
     * @see javax.ejb.EntityBean#ejbPassivate()
     */
    public void ejbPassivate() {
        
    }

    /**
     * @see javax.ejb.EntityBean#ejbRemove()
     */
    public void ejbRemove() {
        
    }

    /**
     * @see javax.ejb.EntityBean#unsetEntityContext()
     */
    public void unsetEntityContext() {
        context = null;
    }

    /**
     * @see javax.ejb.EntityBean#ejbLoad()
     */
    public void ejbLoad() {
        
    }

    /**
     * @see javax.ejb.EntityBean#ejbStore()
     */
    public void ejbStore() {
        
    }

    // </editor-fold>
    public java.lang.String ejbCreate(java.lang.String key) throws CreateException {
        if (key == null) {
            throw new CreateException("The field \"key\" must not be null");
        }
        this.setTransid(key);
        // TODO add additional validation code, throw CreateException if data is not valid

        return null;
    }
    
    public void ejbPostCreate(java.lang.String key) {
        // TODO populate relationships here if appropriate
    }

    public abstract String getTransid();

    public abstract void setTransid(String transid);

    public abstract String getCusname();

    public abstract void setCusname(String cusname);

    public abstract String getCusaddress();

    public abstract void setCusaddress(String cusaddress);

    public abstract String getTransdate();

    public abstract void setTransdate(String transdate);

    public abstract String getTranstime();

    public abstract void setTranstime(String transtime);

    public abstract String getInvoicecode();

    public abstract void setInvoicecode(String invoicecode);

    public abstract String getTranstype();

    public abstract void setTranstype(String transtype);
    
}
