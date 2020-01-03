package com.endtheme.ninesquarediary.exception;

import org.apache.log4j.Logger;

public class DBException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = -3228039543786058181L;

    private static final Logger LOGGER = Logger.getLogger(DBException.class);

    public DBException() {
    }

    public DBException(Exception exception) {
        LOGGER.error(exception.getCause());
    }

}
