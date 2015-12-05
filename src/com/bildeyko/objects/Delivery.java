package com.bildeyko.objects;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

/**
 * Created by bilde_000 on 05.12.2015.
 */
public class Delivery {
    public Long staffId;
    public Long auctionId;
    public Integer stateId;
    public Date date;
    public Date actualDate;

    public Delivery(Long staffId, Long auctionId, Integer stateId, LocalDateTime localdate) {
        this.staffId = staffId;
        this.auctionId = auctionId;
        this.stateId = stateId;

        Instant instant = localdate.atZone(ZoneId.systemDefault()).toInstant();
        date = Date.from(instant);

        Random rand = new Random();
        Integer offset = rand.nextInt(7)+1;
        instant = localdate.plusDays(offset).atZone(ZoneId.systemDefault()).toInstant();
        actualDate = Date.from(instant);
    }
}
