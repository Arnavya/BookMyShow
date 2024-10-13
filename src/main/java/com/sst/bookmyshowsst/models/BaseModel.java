package com.sst.bookmyshowsst.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id      //used to define PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for auto incrementation of PK.
    private Long id;
    private Date createdAt;
    private Date lastModifiedAt;
}
