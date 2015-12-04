package com.bildeyko.objects;

import com.bildeyko.Tools;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by bilde_000 on 04.12.2015.
 */
public class Customer extends Person {
    public Long customer_id = null;
    public Integer postCode;
    public String address;

    public Customer() {
        super();
        postCode = ThreadLocalRandom.current().nextInt(10000000, 99999999+1);
        address = Tools.generateString(120);
    }

    public Customer(Long customer_id, Long personId, Integer postCode, String address) {
        this.customer_id = customer_id;
        this.postCode = postCode;
        this.address = address;
        this.personId = personId;
    }
}
