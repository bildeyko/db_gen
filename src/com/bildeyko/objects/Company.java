package com.bildeyko.objects;

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
        tin = randomBigInt(new BigInteger("1000000000"), new BigInteger("9999999999"));
        name = generateString(30);
        postCode = ThreadLocalRandom.current().nextInt(10000000, 99999999+1);

        address = generateString(120);
        //ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static BigInteger randomBigInt(BigInteger min, BigInteger max) {
        BigInteger sub = max.subtract(min);
        Random rnd = new Random();
        do {
            BigInteger i = new BigInteger(sub.bitLength(), rnd);
            if (i.compareTo(sub) <= 0)
                return i.add(min);
        } while (true);
    }

    public static String generateString(int length)
    {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rnd.nextInt(characters.length()));
        }
        return new String(text);
    }
}
