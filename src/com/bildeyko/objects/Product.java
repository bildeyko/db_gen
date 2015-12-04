package com.bildeyko.objects;

import com.bildeyko.Tools;

import java.math.BigInteger;

/**
 * Created by bilde_000 on 22.11.2015.
 */
public class Product {
    public Integer productId = null;
    public BigInteger barcode;
    public String name;
    public ProductType type;

    public Product (String name, ProductType type) {
        this.name = name;
        this.type = type;
        barcode = Tools.randomBigInt(new BigInteger("1000000000000"), new BigInteger("9999999999999"));
    }

    public Product (Integer productId, BigInteger barcode, String name) {
        this.name = name;
        this.type = null;
        this.productId = productId;
        this.barcode = barcode;
    }
}
