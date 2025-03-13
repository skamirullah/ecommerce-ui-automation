package com.opencart.utility;

import com.google.gson.Gson;
import com.opencart.constants.Env;
import com.opencart.pojo.Config;
import com.opencart.pojo.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONUtil {

    public static String readJSON(Env env) {
        Gson gson = new Gson();
        File jsonFile = new File(System.getProperty("user.dir") + "/config/config.json");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(jsonFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Config config = gson.fromJson(fileReader, Config.class);
        Environment environment = config.getEnvironments().get(env.toString());
        return environment.getUrl();
    }
}
