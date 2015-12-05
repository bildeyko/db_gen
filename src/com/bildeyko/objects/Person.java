package com.bildeyko.objects;

import com.bildeyko.Tools;

import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

/**
 * Created by bilde_000 on 22.11.2015.
 */
public class Person {
    public String name;
    public String surname;
    public Long personId = null;
    public Date dob;

    public String email;
    public String phone;

    public Person()
    {
        name = Tools.generateString(7);
        surname = Tools.generateString(15);

        Random rnd = new Random();
        long ms = -946771200000L + (Math.abs(rnd.nextLong()) % (56L * 365 * 24 * 60 * 60 * 1000));
        dob = new Date(ms);

        email = Tools.generateString(7) + "@" + "gmail.com";
        phone = "+" + Tools.randomBigInt(new BigInteger("10000000000"), new BigInteger("99999999999")).toString();
    }
}
