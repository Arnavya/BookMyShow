package com.sst.bookmyshowsst.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)//role -> if any event happen on those attributes with (@CreatedDate, @LastModifiedDate) annotations keep a track of those events.
public class BaseModel {
    @Id      //used to define PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for auto incrementation of PK.
    private Long id;

    //Auditing attributes
    @CreatedDate // means whenever we create an object in the database this value(createdAt) will take the current timestamp & gets saved in the database. & @EntityListner() will start listning.
    private Date createdAt;
    @LastModifiedDate//whenever we are performing modification over this data this value(lastModifiedAt) will get updated with the current timestamp as @EventListner is listning and will be saved in automatically.
    private Date lastModifiedAt;
}
