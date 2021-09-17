/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ops.helpers;

/**
 *
 * @author OLIDAN
 */
public class TransactionDetailDITemp {
    private String tdid;
    private String itemcode;
    private String itemdesc;
    private Double amount;
    private String transid;

    public TransactionDetailDITemp(String tdid, String itemcode, String itemdesc, Double amount, String transid) {
        this.tdid = tdid;
        this.itemcode = itemcode;
        this.itemdesc = itemdesc;
        this.amount = amount;
        this.transid = transid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getItemdesc() {
        return itemdesc;
    }

    public void setItemdesc(String itemdesc) {
        this.itemdesc = itemdesc;
    }

    public String getTdid() {
        return tdid;
    }

    public void setTdid(String tdid) {
        this.tdid = tdid;
    }

    public String getTransid() {
        return transid;
    }

    public void setTransid(String transid) {
        this.transid = transid;
    }
    
}
