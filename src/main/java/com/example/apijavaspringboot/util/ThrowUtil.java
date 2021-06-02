package com.example.apijavaspringboot.util;

import com.example.apijavaspringboot.exception.ServiceException;

public class ThrowUtil {

    public static void serviceExceptionThrow(boolean test, String message) {

        if (test) {

            throw new ServiceException(message);
        }
    }
}
