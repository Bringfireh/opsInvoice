/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ops.helpers;

/**
 *
 * @author OLIDAN
 */
public class CompanyInfo {
    private String companyname;
    private String address;
    private String phone;
    private String email;
    private String website;

    public CompanyInfo(String companyname, String address, String phone, String email, String website) {
        this.companyname = companyname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
    
    
}
