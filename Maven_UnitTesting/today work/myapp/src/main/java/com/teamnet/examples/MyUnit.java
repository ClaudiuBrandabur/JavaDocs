package com.teamnet.examples;

/**
 * Created by Claudiu.Brandabur on 10-Jul-17.
 */
public class MyUnit {

    public String concatenate(String one, String two) {
        if (one==null && two==null)
            return null;
        if (one==null)
            return two;
        if (two==null)
            return one;
        return one + two;
    }


    public Boolean getBoolean() {
        return new java.util.Random().nextBoolean();
    }
}
