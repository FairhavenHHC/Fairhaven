package com.fairhaven.db.entities;

import com.fairhaven.db.entities.Appointment;
import com.fairhaven.db.entities.Contact;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-12T23:05:09")
@StaticMetamodel(Location.class)
public class Location_ { 

    public static volatile SingularAttribute<Location, String> zip;
    public static volatile SingularAttribute<Location, String> country;
    public static volatile SingularAttribute<Location, String> city;
    public static volatile CollectionAttribute<Location, Contact> contactCollection;
    public static volatile SingularAttribute<Location, Double> latitude;
    public static volatile CollectionAttribute<Location, Appointment> appointmentCollection;
    public static volatile SingularAttribute<Location, String> street;
    public static volatile SingularAttribute<Location, String> name;
    public static volatile SingularAttribute<Location, Integer> id;
    public static volatile SingularAttribute<Location, String> state;
    public static volatile SingularAttribute<Location, Date> close;
    public static volatile SingularAttribute<Location, Date> open;
    public static volatile SingularAttribute<Location, Double> longitude;

}