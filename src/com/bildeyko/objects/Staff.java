package com.bildeyko.objects;

import com.bildeyko.Tools;

import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * Created by bilde_000 on 30.11.2015.
 */
public class Staff extends Person {
    public Long staffId = null;
    public BigInteger snils;
    public Integer positionTypeId = null;
    public Date startTime;

    public Staff(Integer positionTypeId, LocalDateTime startTime) {
        super();
        System.out.println("insertPositionTypes");
        this.positionTypeId = positionTypeId;

        Instant instant = startTime.toInstant(ZoneOffset.UTC);
        this.startTime = Date.from(instant);

        snils = Tools.randomBigInt(new BigInteger("10000000000"), new BigInteger("99999999999"));
    }
}
