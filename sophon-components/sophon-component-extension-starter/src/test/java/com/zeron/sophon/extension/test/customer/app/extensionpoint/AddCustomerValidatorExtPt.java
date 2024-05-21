package com.zeron.sophon.extension.test.customer.app.extensionpoint;

import com.zeron.sophon.extension.ExtensionPointI;
import com.zeron.sophon.extension.test.customer.client.AddCustomerCmd;

/**
 * AddCustomerValidatorExtPt
 *
 */
public interface AddCustomerValidatorExtPt extends ExtensionPointI {

    public void validate(AddCustomerCmd addCustomerCmd);
}
