package com.bildeyko;

import java.math.BigInteger;
import java.util.ArrayList;
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

    public static <T> ArrayList<T> generateRandomArray(ArrayList<T> array, Double percent) {
        Integer num = (int) Math.round(array.size()*percent);
        Random rand = new Random();
        ArrayList<T> list = new ArrayList<>();

        while (num > 0) {
            Integer index = rand.nextInt(array.size());
            T item = array.get(index);
            list.add(item);
            array.remove(index);
            num--;
        }
        return  list;
    }
}
