package com.java.framework.core.logging.logger.impl;

import com.java.framework.core.logging.logger.CSLogger;
import com.java.framework.core.logging.logger.LogLevel;
import com.java.framework.core.logging.logger.exceptions.MethodNotImplementedException;

public class CustomCSLoggerImpl implements CSLogger {

    private String methodNotImplemented = "Custom logger implementation not provided";

    @Override
    public void log(String message) {
        throw new MethodNotImplementedException(methodNotImplemented);
    }

    @Override
    public void log(Object object) {
        throw new MethodNotImplementedException(methodNotImplemented);
    }

    @Override
    public void log(LogLevel level, String message) {
        throw new MethodNotImplementedException(methodNotImplemented);
    }

    @Override
    public void log(LogLevel level, Object object) {
        throw new MethodNotImplementedException(methodNotImplemented);
    }
}
