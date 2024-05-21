package com.zeron.sophon.extension.test.customer.domain.rule;

import com.zeron.sophon.exception.BizException;
import com.zeron.sophon.extension.Extension;
import com.zeron.sophon.extension.test.customer.client.Constants;
import com.zeron.sophon.extension.test.customer.domain.CustomerEntity;
import com.zeron.sophon.extension.test.customer.domain.SourceType;

/**
 * CustomerBizOneRuleExt
 *
 */
@Extension(bizId = Constants.BIZ_1)
public class CustomerBizOneRuleExt implements CustomerRuleExtPt{

    @Override
    public boolean addCustomerCheck(CustomerEntity customerEntity) {
        if(SourceType.AD == customerEntity.getSourceType()){
            throw new BizException("Sorry, Customer from advertisement can not be added in this period");
        }
        return true;
    }
}
