package com.zeron.sophon.extension.test.customer.domain.rule;

import com.zeron.sophon.extension.ExtensionPointI;
import com.zeron.sophon.extension.test.customer.domain.CustomerEntity;

/**
 * CustomerRuleExtPt
 */
public interface CustomerRuleExtPt extends ExtensionPointI {

    // Different business check for different biz
    public boolean addCustomerCheck(CustomerEntity customerEntity);

    // Different upgrade policy for different biz
    default public void customerUpgradePolicy(CustomerEntity customerEntity){
        // Nothing special
    }
}
