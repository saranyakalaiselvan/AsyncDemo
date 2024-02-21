package com.crackit.AsyncDemo.service;

import com.crackit.AsyncDemo.client.EmployeeFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
public class AsyncService {
    private static Logger log = LoggerFactory.getLogger(AsyncService.class);

    private final EmployeeFeignClient employeeFeignClient;

    public AsyncService(EmployeeFeignClient employeeFeignClient) {
        this.employeeFeignClient = employeeFeignClient;
    }

    @Async
    public CompletableFuture<String> getEmployeeAddresses() {
        log.info("Start - getEmployeeAddresses");
        String addresses = employeeFeignClient.getAddresses();
        log.info("End - getEmployeeAddresses");
        return CompletableFuture.completedFuture(addresses);
    }

    @Async
    public CompletableFuture<String> getEmployeePhoneNumbers() {
        log.info("Start - getEmployeePhoneNumbers");
        String phoneNumbers = employeeFeignClient.getPhoneNumbers();
        log.info("End - getEmployeePhoneNumbers");
        return CompletableFuture.completedFuture(phoneNumbers);
    }

    @Async
    public CompletableFuture<String> getEmployeeNames() {
        log.info("Start - getEmployeeNames");
        String employeeNames = employeeFeignClient.getEmployeeNames();
        log.info("End - getEmployeeNames");
        return CompletableFuture.completedFuture(employeeNames);
    }
}
