package com.bildeyko.objects;

import com.bildeyko.Tools;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Nick Bildeyko on 22.11.2015.
 */
public class Company {
    public BigInteger tin;
    public String name;
    public Integer postCode;
    public String address;

    public Company() {
        tin = Tools.randomBigInt(new BigInteger("1000000000"), new BigInteger("9999999999"));
        name = Tools.generateString(30);
        postCode = ThreadLocalRandom.current().nextInt(10000000, 99999999+1);

        address = Tools.generateString(120);
        //ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
