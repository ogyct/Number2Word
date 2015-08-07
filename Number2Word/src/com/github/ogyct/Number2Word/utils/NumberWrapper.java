package com.github.ogyct.Number2Word.utils;

/**
 * This class is a wrapper for a integerTenth method.
 * @author Dmitry
 *
 */
public class NumberWrapper {

    public int getLengthOfTenth() {
        return lengthOfTenth;
    }

    public void setLengthOfTenth(int lengthOfTenth) {
        this.lengthOfTenth = lengthOfTenth;
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public int getTenth() {
        return tenth;
    }

    public void setTenth(int tenth) {
        this.tenth = tenth;
    }

    private int integer;
    private int tenth;
    private int lengthOfTenth;

}
