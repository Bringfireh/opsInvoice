/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ops.helpers;

/**
 *
 * @author OLIDAN
 */
public class InvoiceType {
    private String invoicecode;
    private String invoicedesc;
    private String type;

    public InvoiceType(String invoicecode, String invoicedesc, String type) {
        this.invoicecode = invoicecode;
        this.invoicedesc = invoicedesc;
        this.type = type;
    }

    public String getInvoicecode() {
        return invoicecode;
    }

    public void setInvoicecode(String invoicecode) {
        this.invoicecode = invoicecode;
    }

    public String getInvoicedesc() {
        return invoicedesc;
    }

    public void setInvoicedesc(String invoicedesc) {
        this.invoicedesc = invoicedesc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
