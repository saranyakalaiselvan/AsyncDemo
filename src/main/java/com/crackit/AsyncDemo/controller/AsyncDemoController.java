package com.crackit.AsyncDemo.controller;

import com.crackit.AsyncDemo.client.EmployeeFeignClient;
import com.crackit.AsyncDemo.service.AsyncService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/crackit/async/v1")
public class AsyncDemoController {

    private final AsyncService asyncService;

    public AsyncDemoController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }
    @GetMapping("/employees")
    public List<String> demoAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<String> employeeNames = asyncService.getEmployeeNames();
        CompletableFuture<String> employeeAddresses = asyncService.getEmployeeAddresses();
        CompletableFuture<String> employeePhoneNumbers = asyncService.getEmployeePhoneNumbers();

        // Wait until they are all done
        CompletableFuture.allOf(employeeNames, employeeAddresses, employeePhoneNumbers).join();


        return List.of(employeeNames.get(), employeePhoneNumbers.get()
        ,employeeAddresses.get());
    }
}
