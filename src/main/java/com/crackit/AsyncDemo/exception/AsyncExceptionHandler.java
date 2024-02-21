package com.crackit.AsyncDemo.exception;

import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;
import org.slf4j.Logger;

public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(AsyncExceptionHandler.class);

    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        logger.error("Unexpected asynchronous exception at : "
                + method.getDeclaringClass().getName() + "." + method.getName(), ex);
    }
}
