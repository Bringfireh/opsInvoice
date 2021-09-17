/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ops.helpers;

/**
 *
 * @author OLIDAN
 */
public class TransDetailTemp {
    private String tdid;
    private Integer qnty;
    private String itemdesc;
    private Double rate;
    private Double amount;
    private String transid;

    public TransDetailTemp(String tdid, Integer qnty, String itemdesc, Double rate, Double amount, String transid) {
        this.tdid = tdid;
        this.qnty = qnty;
        this.itemdesc = itemdesc;
        this.rate = rate;
        this.amount = amount;
        this.transid = transid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getItemdesc() {
        return itemdesc;
    }

    public void setItemdesc(String itemdesc) {
        this.itemdesc = itemdesc;
    }

    public Integer getQnty() {
        return qnty;
    }

    public void setQnty(Integer qnty) {
        this.qnty = qnty;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
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
