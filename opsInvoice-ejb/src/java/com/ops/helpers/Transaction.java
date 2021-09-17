/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ops.helpers;

/**
 *
 * @author OLIDAN
 */
public class Transaction {
    private String transid;
    private String cusname;
    private String cusaddress;
    private String transdate;
    private String transtime;
    private String invoicecode;
    private String transtype;

    public Transaction(String transid, String cusname, String cusaddress, String transdate, String transtime, String invoicecode, String transtype) {
        this.transid = transid;
        this.cusname = cusname;
        this.cusaddress = cusaddress;
        this.transdate = transdate;
        this.transtime=transtime;
        this.invoicecode=invoicecode;
        this.transtype = transtype;
    }

    public String getCusaddress() {
        return cusaddress;
    }

    public void setCusaddress(String cusaddress) {
        this.cusaddress = cusaddress;
    }

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public String getTransdate() {
        return transdate;
    }

    public void setTransdate(String transdate) {
        this.transdate = transdate;
    }

    public String getTransid() {
        return transid;
    }

    public void setTransid(String transid) {
        this.transid = transid;
    }

    public String getInvoicecode() {
        return invoicecode;
    }

    public void setInvoicecode(String invoicecode) {
        this.invoicecode = invoicecode;
    }

    public String getTranstime() {
        return transtime;
    }

    public void setTranstime(String transtime) {
        this.transtime = transtime;
    }

    public String getTranstype() {
        return transtype;
    }

    public void setTranstype(String transtype) {
        this.transtype = transtype;
    }
    
    
}
