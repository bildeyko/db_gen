package com.bildeyko.objects;

import java.math.BigInteger;

/**
 * Created by bilde_000 on 04.12.2015.
 */
public class Batch_item {
    public Long batchId;
    public BigInteger itemId;
    public Double quantity;

    public Batch_item(Long batchId, BigInteger itemId, Double quantity) {
        this.batchId = batchId;
        this.itemId = itemId;
        this.quantity = quantity;
    }
}
