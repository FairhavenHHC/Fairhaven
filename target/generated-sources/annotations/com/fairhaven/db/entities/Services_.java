package com.fairhaven.db.entities;

import com.fairhaven.db.entities.Appointment;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-09T00:01:16")
@StaticMetamodel(Services.class)
public class Services_ { 

    public static volatile SingularAttribute<Services, Double> lowPrice;
    public static volatile SingularAttribute<Services, Boolean> offered;
    public static volatile SingularAttribute<Services, String> name;
    public static volatile SingularAttribute<Services, Double> highPrice;
    public static volatile SingularAttribute<Services, String> description;
    public static volatile SingularAttribute<Services, Integer> id;
    public static volatile SingularAttribute<Services, Boolean> competitorOffered;
    public static volatile CollectionAttribute<Services, Appointment> appointmentCollection;

}