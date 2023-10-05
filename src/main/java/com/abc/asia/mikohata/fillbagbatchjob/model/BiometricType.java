package com.abc.asia.mikohata.fillbagbatchjob.model;

public enum BiometricType {
    FACE("face"),
    FINGER("finger"),
    IRIS("iris");

    private String value;

    BiometricType(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
