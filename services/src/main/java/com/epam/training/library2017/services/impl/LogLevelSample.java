package com.epam.training.library2017.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogLevelSample {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

    public static void main(String[] args) {

        LOGGER.debug("debug");
        LOGGER.info("info");
        LOGGER.warn("warn");
        LOGGER.error("error", new Exception());

    }
}
