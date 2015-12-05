package com.bildeyko.objects;

import com.bildeyko.Generator;
import com.bildeyko.Main;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

/**
 * Created by bilde_000 on 05.12.2015.
 */
public class Auction {
    public Long auctionId = null;
    public Long batchId = null;
    public Date startTime;
    public Date endTime;

    public Auction (Long batchId, LocalDateTime currentTime) {
        this.batchId = batchId;

        Instant instant = currentTime.atZone(ZoneId.systemDefault()).toInstant();
        startTime = Date.from(instant);

        Random rand = new Random();
        Integer offset = rand.nextInt(30) + Generator.settings.getAuctionWeeks();
        instant = currentTime.plusDays(offset).atZone(ZoneId.systemDefault()).toInstant();
        endTime = Date.from(instant);
    }

    public Auction (Long auctionId) {
        this.auctionId = auctionId;
    }
}
