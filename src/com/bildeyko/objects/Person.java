package com.bildeyko.objects;

import com.bildeyko.Tools;

/**
 * Created by bilde_000 on 22.11.2015.
 */
public class Person {
    public String name;
    public String surname;
    public Integer personId = null;

    public Person()
    {
        name = Tools.generateString(7);
        surname = Tools.generateString(15);
    }
}
