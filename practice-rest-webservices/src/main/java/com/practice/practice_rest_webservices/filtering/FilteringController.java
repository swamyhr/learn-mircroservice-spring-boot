package com.practice.practice_rest_webservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.practice.practice_rest_webservices.beans.SampleData;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

  @GetMapping("filtering")
  public SampleData getSampleDataBean() {
    return new SampleData("filed_1", "field_2","field_3");
  }

  @GetMapping("filters-list")
  public MappingJacksonValue getSampleDataBeanList() {
    MappingJacksonValue mapJV = new MappingJacksonValue(new SampleData("f1", "f2","f3"));
    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
    FilterProvider filterProvider = new SimpleFilterProvider().addFilter("Default_Filter", filter);
    mapJV.setFilters(filterProvider);
    return mapJV;
  }
}
