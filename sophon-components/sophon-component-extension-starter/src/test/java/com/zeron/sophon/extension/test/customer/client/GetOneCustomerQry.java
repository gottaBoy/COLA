package com.zeron.sophon.extension.test.customer.client;

import com.zeron.sophon.dto.Query;

/**
 * GetOneCustomerQry
 *
 */
public class GetOneCustomerQry extends Query{
    private long customerId;
    private String companyName;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
