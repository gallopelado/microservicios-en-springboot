package com.juan.enrollment.service;

import com.juan.enrollment.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8081", value = "students-ms")
public interface OpenFeingConsumeStudent {

    @GetMapping("/api/v1/students/identification-number/{identification}")
    StudentDTO getByIdentificationNumber(@PathVariable("identification") String identificationNumber);

}
