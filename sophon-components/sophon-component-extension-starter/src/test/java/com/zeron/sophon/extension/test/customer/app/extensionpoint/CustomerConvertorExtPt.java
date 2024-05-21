package com.zeron.sophon.extension.test.customer.app.extensionpoint;

import com.zeron.sophon.extension.ExtensionPointI;
import com.zeron.sophon.extension.test.customer.client.AddCustomerCmd;
import com.zeron.sophon.extension.test.customer.domain.CustomerEntity;

/**
 * CustomerConvertorExtPt
 *
 */
public interface CustomerConvertorExtPt extends ExtensionPointI {

    public CustomerEntity clientToEntity(AddCustomerCmd addCustomerCmd);
}
