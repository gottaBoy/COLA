package com.zeron.sophon.extension.test.customer.app;

import com.zeron.sophon.dto.Response;
import com.zeron.sophon.dto.SingleResponse;
import com.zeron.sophon.extension.test.customer.client.AddCustomerCmd;
import com.zeron.sophon.extension.test.customer.client.CustomerDTO;
import com.zeron.sophon.extension.test.customer.client.CustomerServiceI;
import com.zeron.sophon.extension.test.customer.client.GetOneCustomerQry;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * CustomerServiceImpl
 */
@Service
public class CustomerServiceImpl implements CustomerServiceI {

    @Resource
    private AddCustomerCmdExe addCustomerCmdExe;

    @Resource
    private GetOneCustomerQryExe getOneCustomerQryExe;


    @Override
    public Response addCustomer(AddCustomerCmd addCustomerCmd) {
        return addCustomerCmdExe.execute(addCustomerCmd);
    }

    @Override
    public SingleResponse<CustomerDTO> getCustomer(GetOneCustomerQry getOneCustomerQry) {
        return getOneCustomerQryExe.execute(getOneCustomerQry);
    }
}
