package com.java.framework.ui.exceptions;

/**
 * Signals that a invalid element identification method used or
 * typo for element identification.
 *
 */

public class InvalidElementIdentificationTypeException extends ObjectClassException {

    public InvalidElementIdentificationTypeException(){}
    public InvalidElementIdentificationTypeException(String message) {
        super(message);
    }
}