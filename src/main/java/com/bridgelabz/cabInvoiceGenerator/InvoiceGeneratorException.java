package com.bridgelabz.cabInvoiceGenerator;

public class InvoiceGeneratorException extends Exception {
    public enum ExceptionType {
        NOT_ASSIGNED,SETUP_METHOD_NOT_WORKING, INCORRECT_EXTENSION, INTERNAL_FILE_ISSUES
    }
    ExceptionType type;

    public InvoiceGeneratorException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
