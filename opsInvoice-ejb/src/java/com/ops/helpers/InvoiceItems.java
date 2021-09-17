/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ops.helpers;

/**
 *
 * @author OLIDAN
 */
public class InvoiceItems {
    private String itemcode;
    private String itemdesc;
    private Double amount;
    private String invoicecode;

    public InvoiceItems(String itemcode, String itemdesc, Double amount, String invoicecode) {
        this.itemcode = itemcode;
        this.itemdesc = itemdesc;
        this.amount = amount;
        this.invoicecode = invoicecode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getInvoicecode() {
        return invoicecode;
    }

    public void setInvoicecode(String invoicecode) {
        this.invoicecode = invoicecode;
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
    
    
}
