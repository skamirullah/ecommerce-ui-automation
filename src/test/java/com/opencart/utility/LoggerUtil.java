package com.opencart.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {

    private LoggerUtil() {
    }

    public static Logger getLogger(Class<?> clazz) {
        Logger logger = null;
        if (logger == null) {
            logger = LogManager.getLogger(clazz);
        }
        return logger;
    }
}
