package com.zeron.sophon.extension.test.customer.app.extension;

import com.zeron.sophon.extension.Extension;
import com.zeron.sophon.extension.test.customer.app.extensionpoint.CustomerConvertorExtPt;
import com.zeron.sophon.extension.test.customer.client.AddCustomerCmd;
import com.zeron.sophon.extension.test.customer.client.Constants;
import com.zeron.sophon.extension.test.customer.client.CustomerDTO;
import com.zeron.sophon.extension.test.customer.domain.CustomerEntity;
import com.zeron.sophon.extension.test.customer.domain.SourceType;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * CustomerBizOneConvertorExt
 */
@Extension(bizId = Constants.BIZ_1)
public class CustomerBizOneConvertorExt  implements CustomerConvertorExtPt {

    @Autowired
    private CustomerConvertor customerConvertor;//Composite basic convertor to do basic conversion

    @Override
    public CustomerEntity clientToEntity(AddCustomerCmd addCustomerCmd){
        CustomerEntity customerEntity = customerConvertor.clientToEntity(addCustomerCmd);
        CustomerDTO customerDTO =addCustomerCmd.getCustomerDTO();
        //In this business, AD and RFQ are regarded as different source
        if(Constants.SOURCE_AD.equals(customerDTO.getSource()))
        {
            customerEntity.setSourceType(SourceType.AD);
        }
        if (Constants.SOURCE_RFQ.equals(customerDTO.getSource())){
            customerEntity.setSourceType(SourceType.RFQ);
        }
        return customerEntity;
    }
}
