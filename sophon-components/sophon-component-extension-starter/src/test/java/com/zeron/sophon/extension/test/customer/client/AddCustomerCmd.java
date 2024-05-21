package com.zeron.sophon.extension.test.customer.client;


import com.zeron.sophon.dto.Command;
import com.zeron.sophon.extension.BizScenario;
import lombok.Data;

/**
 * AddCustomerCmd
 */
@Data
public class AddCustomerCmd extends Command {

    private CustomerDTO customerDTO;

    private String biz;

    private BizScenario bizScenario;
}
