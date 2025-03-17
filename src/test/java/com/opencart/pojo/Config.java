package com.opencart.pojo;

import java.util.Map;

public class Config {

    Map<String, Environment> environments;

    public Map<String, Environment> getEnvironments() {
        return environments;
    }

    public Config setEnvironments() {
        return this;
    }
}
