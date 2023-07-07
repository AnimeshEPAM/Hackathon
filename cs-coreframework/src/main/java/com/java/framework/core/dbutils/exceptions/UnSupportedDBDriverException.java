package com.java.framework.core.dbutils.exceptions;

import com.java.framework.core.exceptions.TAFRuntimeException;

public class UnSupportedDBDriverException extends TAFRuntimeException {
    public UnSupportedDBDriverException(String message) {
        super(message);
    }

    public UnSupportedDBDriverException(Throwable throwable) {
        super(throwable);
    }

    public UnSupportedDBDriverException(String message, Exception innerException) {
        super(message, innerException);
    }
}
