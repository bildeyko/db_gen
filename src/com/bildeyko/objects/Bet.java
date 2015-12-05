package com.bildeyko.objects;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by bilde_000 on 05.12.2015.
 */
public class Bet {
    public Long betId = null;
    public Long auctionId;
    public Long contractId;
    public Double bet;
    public Date time;

    public Bet(Long auctionId, Long contractId, Double bet, LocalDateTime time) {
        this.auctionId = auctionId;
        this.contractId = contractId;
        this.bet = bet;
        Instant instant = time.atZone(ZoneId.systemDefault()).toInstant();
        this.time = Date.from(instant);
    }
}
