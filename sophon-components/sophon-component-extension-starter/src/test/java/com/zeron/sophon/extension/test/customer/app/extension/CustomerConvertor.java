package com.zeron.sophon.extension.test.customer.app.extension;

import com.zeron.sophon.domain.ApplicationContextHelper;
import com.zeron.sophon.extension.test.customer.client.AddCustomerCmd;
import com.zeron.sophon.extension.test.customer.client.CustomerDTO;
import com.zeron.sophon.extension.test.customer.domain.CustomerEntity;
import org.springframework.stereotype.Component;

/**
 * CustomerConvertor
 *
 */
@Component
public class CustomerConvertor{

    public CustomerEntity clientToEntity(Object clientObject){
        AddCustomerCmd addCustomerCmd = (AddCustomerCmd)clientObject;
        CustomerDTO customerDTO =addCustomerCmd.getCustomerDTO();
        CustomerEntity customerEntity = (CustomerEntity) ApplicationContextHelper.getBean(CustomerEntity.class);
        customerEntity.setCompanyName(customerDTO.getCompanyName());
        customerEntity.setCustomerType(customerDTO.getCustomerType());
        customerEntity.setBizScenario(addCustomerCmd.getBizScenario());
        return customerEntity;
    }
}
