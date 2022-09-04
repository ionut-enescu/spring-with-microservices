package com.in28minutes.rest.webservices.restfulwebservices.filtering;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties("field1")

@JsonFilter("SomeBeanFilter")
public class SomeBean {
    private String field1;
//    @JsonIgnore
    private String password;
    private String field3;

    public SomeBean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.password = field2;
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public String getPassword() {
        return password;
    }

    public String getField3() {
        return field3;
    }

    @Override
    public String toString() {
        return "SomeBean{" +
                "field1='" + field1 + '\'' +
                ", password='" + password + '\'' +
                ", field3='" + field3 + '\'' +
                '}';
    }
}
