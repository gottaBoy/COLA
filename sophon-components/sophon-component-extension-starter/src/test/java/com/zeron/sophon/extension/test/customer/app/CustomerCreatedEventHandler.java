package com.zeron.sophon.extension.test.customer.app;

import com.zeron.sophon.dto.Response;
import com.zeron.sophon.extension.test.customer.client.CustomerCreatedEvent;

/**
 * CustomerCreatedEventHandler
 */
public class CustomerCreatedEventHandler {

    public Response execute(CustomerCreatedEvent customerCreatedEvent) {
        System.out.println("customerCreatedEvent processed");
        return null;
    }
}
