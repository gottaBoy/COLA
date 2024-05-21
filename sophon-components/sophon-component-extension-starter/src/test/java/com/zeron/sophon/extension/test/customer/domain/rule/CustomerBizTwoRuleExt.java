package com.zeron.sophon.extension.test.customer.domain.rule;

import com.zeron.sophon.extension.Extension;
import com.zeron.sophon.extension.test.customer.client.Constants;
import com.zeron.sophon.extension.test.customer.domain.CustomerEntity;

/**
 * CustomerBizTwoRuleExt
 *
 */
@Extension(bizId = Constants.BIZ_2)
public class CustomerBizTwoRuleExt implements CustomerRuleExtPt{

    @Override
    public boolean addCustomerCheck(CustomerEntity customerEntity) {
        //Any Customer can be added
        return true;
    }
}
