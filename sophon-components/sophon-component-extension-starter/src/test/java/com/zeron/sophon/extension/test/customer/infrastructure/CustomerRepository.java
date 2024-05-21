package com.zeron.sophon.extension.test.customer.infrastructure;

import com.zeron.sophon.extension.test.customer.domain.CustomerEntity;
import org.springframework.stereotype.Repository;

/**
 * CustomerRepository
 */
@Repository
public class CustomerRepository {

    public void persist(CustomerEntity customerEntity){
        System.out.println("Persist customer to DB : "+ customerEntity);
    }
}
