package com.zenika.javabasics.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomLoggerFactory {
    public static Logger getLogger(Class<?> clazz) {
        return new CustomLogger(LoggerFactory.getLogger(clazz));
    }
}
