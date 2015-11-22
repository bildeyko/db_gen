package com.bildeyko.objects;

/**
 * Created by Nick Bildeyko on 22.11.2015.
 */
public class ProductType {
    public String name;
    public Integer unitId;
    public Integer typeId = null;

    public ProductType(String name, Integer unitId) {
        this.name = name;
        this.unitId = unitId;
    }

    public ProductType(Integer typeId, String name, Integer unitId) {
        this.name = name;
        this.unitId = unitId;
        this.typeId = typeId;
    }
}
