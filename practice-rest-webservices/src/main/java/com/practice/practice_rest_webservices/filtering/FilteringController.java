package com.practice.practice_rest_webservices.filtering;

import com.practice.practice_rest_webservices.beans.SampleData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

  @GetMapping("filtering")
  public SampleData getSampleDataBean() {
    return new SampleData("filed_1", "field_2","field_3");
  }
}
