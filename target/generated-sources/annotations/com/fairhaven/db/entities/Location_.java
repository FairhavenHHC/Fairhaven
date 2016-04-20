package com.fairhaven.db.entities;

import com.fairhaven.db.entities.Contact;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-19T20:53:29")
@StaticMetamodel(Location.class)
public class Location_ { 

    public static volatile SingularAttribute<Location, String> zip;
    public static volatile SingularAttribute<Location, String> country;
    public static volatile SingularAttribute<Location, String> city;
    public static volatile SingularAttribute<Location, String> street;
    public static volatile CollectionAttribute<Location, Contact> contactCollection;
    public static volatile SingularAttribute<Location, Double> latitude;
    public static volatile SingularAttribute<Location, String> name;
    public static volatile SingularAttribute<Location, Integer> id;
    public static volatile SingularAttribute<Location, String> state;
    public static volatile SingularAttribute<Location, Double> longitude;

}