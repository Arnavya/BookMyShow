package com.sst.bookmyshowsst.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity  // Creates a table with the exact same name
public class City extends BaseModel{
    private String name;
    private String pinCode;
    //private List<Threatre> threatres;  In the city class we can have list of threatres or in the Threatre class we can have city
}
