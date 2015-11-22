package com.bildeyko.objects;

/**
 * Created by Nick Bildeyko on 22.11.2015.
 */
public class PositionType {
    public Integer positionTypeId = null;
    public String name;
    public Double percent;

    public  PositionType(String name, Double percent)
    {
        this.name = name;
        this.percent = percent;
    }

    public  PositionType(Integer positionTypeId, String name, Double percent)
    {
        this.positionTypeId = positionTypeId;
        this.name = name;
        this.percent = percent;
    }
}
