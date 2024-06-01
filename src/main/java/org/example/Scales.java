package org.example;

public enum Scales {
    MM(1),
    CM(10),
    DM(100),
    M(1000),
    DAM(10000),
    KM(1000000);

    private final int value;

    Scales(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
