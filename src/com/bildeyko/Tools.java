package com.bildeyko;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by bilde_000 on 22.11.2015.
 */
public class Tools {
    public Tools(){}
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
