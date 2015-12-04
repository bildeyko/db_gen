package com.bildeyko.objects;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

/**
 * Created by bilde_000 on 04.12.2015.
 */
public class Contract {
    public Long contractId = null;
    public Long customerId;
    public Long brokerId;
    public Date startTime;
    public Date endTime;
    public Double limit;

    public Contract (Long customerId, Long brokerId, LocalDateTime currentTime) {
        this.customerId = customerId;
        this.brokerId = brokerId;

        Random rand = new Random();
        Integer offset = rand.nextInt(90)+1;
        Instant instant = currentTime.atZone(ZoneId.systemDefault()).toInstant();
        startTime = Date.from(instant);

        instant = currentTime.plusDays(offset).atZone(ZoneId.systemDefault()).toInstant();
        endTime = Date.from(instant);

        limit = rand.nextDouble()*10000;
    }
}
