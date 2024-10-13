package com.sst.bookmyshowsst.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.security.auth.callback.LanguageCallback;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;

    private Date startDate;
    private Date endDate;

    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    private String language;
}
/*
  1   :   1
Show -- Movie : M:1
  M   :    1

  1   :   1
Show -- Screen : M:1
  M   :   1
 */