package com.opencart.pojo;

public class Environment {

    private String url;
    private int MAX_NUMBER_OF_ATTEMPTS;
    private int IMPLICIT_WAIT;
    private int EXPLICIT_WAIT;

    public String getUrl() {
        return url;
    }

    public Environment setUrl() {
        return this;
    }

    public int getMAX_NUMBER_OF_ATTEMPTS() {
        return MAX_NUMBER_OF_ATTEMPTS;
    }

    public int getIMPLICIT_WAIT() {
        return IMPLICIT_WAIT;
    }

    public int getEXPLICIT_WAIT() {
        return EXPLICIT_WAIT;
    }

    public Environment setMAX_NUMBER_OF_ATTEMPTS() {
        return this;
    }
}
