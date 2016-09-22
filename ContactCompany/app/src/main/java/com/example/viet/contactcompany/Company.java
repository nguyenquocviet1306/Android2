package com.example.viet.contactcompany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Viet on 9/21/2016.
 */
public class Company implements Serializable {
    private String name;
    private String tel;
    private String email;

    private static List<Company> companyList;

    public static List<Company> getCompanyList() {
        if (companyList == null) {
            companyList = new ArrayList<>();
            companyList.add(new Company("FPT Software","Tel : 0473007575",
                    "Mail : https://www.fpt-software.com "));
            companyList.add(new Company("EWay","Tel : +84432595450",
                    "Mail : https://eway.vn "));
            companyList.add(new Company("BraveBits","Tel : +84838486888",
                    "http://www.bravebits.vn "));
            companyList.add(new Company("TechKids","Tel : +841653005670",
                    "http://techkids.vn"));
        }
        return companyList;
    }
    public Company(String name, String tel,String email) {
        this.name = name;
        this.tel = tel;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
