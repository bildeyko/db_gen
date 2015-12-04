package com.bildeyko.objects;

import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

/**
 * Created by bilde_000 on 04.12.2015.
 */
public class Product_item {
    public BigInteger itemId = null;
    public BigInteger tin;
    public Integer productId;
    public Date shelfLife;
    public Double quantity;
    public Double price;

    public Double sum;
    public Integer type;

    public Product_item(BigInteger tin, Integer productId, LocalDateTime currentTime) {
        this.tin = tin;
        this.productId = productId;

        Random rand = new Random();
        Integer offset = rand.nextInt(148)+30;
        Instant instant = currentTime.plusDays(offset).atZone(ZoneId.systemDefault()).toInstant();
        shelfLife = Date.from(instant);

        quantity = (double)(rand.nextInt(1000)+1);
        price = rand.nextDouble()*1000;
    }

    public Product_item(BigInteger itemId, Double quantity, Integer type, Double sum) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.type = type;
        this.sum = sum;
    }
}
