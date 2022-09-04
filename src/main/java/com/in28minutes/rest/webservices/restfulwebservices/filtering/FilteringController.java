package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        SomeBean bean = new SomeBean("val1", "val2", "val3");
        MappingJacksonValue mjv = new MappingJacksonValue(bean);
        SimpleBeanPropertyFilter sbpf = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
        FilterProvider fp = new SimpleFilterProvider().addFilter("SomeBeanFilter", sbpf);
        mjv.setFilters(fp);
        return mjv;
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList() {
        return Arrays.asList(new SomeBean("val1", "val2", "val3"), new SomeBean("val4", "val5", "val6"));
    }
}
