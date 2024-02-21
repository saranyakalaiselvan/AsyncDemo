package com.crackit.AsyncDemo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "employee-service",
        url = "http://localhost:8080/crackit/v1/")
public interface EmployeeFeignClient {
    @GetMapping("/addresses")
    public String getAddresses();

    @GetMapping("/phoneNumbers")
    public String getPhoneNumbers();

    @GetMapping("/names")
    public String getEmployeeNames();
}
