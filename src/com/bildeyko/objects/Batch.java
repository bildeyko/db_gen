package com.bildeyko.objects;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by bilde_000 on 04.12.2015.
 */
public class Batch {
    public Long batchId = null;
    public Long staffId;
    public Long typeId;
    public Date buildTime;

    public Batch(Long staffId, Long typeId, LocalDateTime currentTime) {
        this.staffId = staffId;
        this.typeId = typeId;
        Instant instant = currentTime.atZone(ZoneId.systemDefault()).toInstant();
        buildTime = Date.from(instant);
    }
}
