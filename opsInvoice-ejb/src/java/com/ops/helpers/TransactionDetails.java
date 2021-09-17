/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ops.helpers;

/**
 *
 * @author OLIDAN
 */
public class TransactionDetails {
    private String transdid;
    private String itemcode;
    private Integer qnty;
    private String itemdesc;
    private Double itemrate;
    private Double amount;
    private String transid;

    public TransactionDetails(String transdid, String itemcode, Integer qnty, String itemdesc, Double itemrate, Double amount, String transid) {
        this.transdid = transdid;
        this.itemcode = itemcode;
        this.qnty = qnty;
        this.itemdesc = itemdesc;
        this.itemrate = itemrate;
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

    public Double getItemrate() {
        return itemrate;
    }

    public void setItemrate(Double itemrate) {
        this.itemrate = itemrate;
    }

    public Integer getQnty() {
        return qnty;
    }

    public void setQnty(Integer qnty) {
        this.qnty = qnty;
    }

    public String getTransdid() {
        return transdid;
    }

    public void setTransdid(String transdid) {
        this.transdid = transdid;
    }

    public String getTransid() {
        return transid;
    }

    public void setTransid(String transid) {
        this.transid = transid;
    }
    
    
}
