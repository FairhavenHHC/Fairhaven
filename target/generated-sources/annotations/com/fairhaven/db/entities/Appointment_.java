package com.fairhaven.db.entities;

import com.fairhaven.db.entities.Location;
import com.fairhaven.db.entities.Services;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-05T20:50:39")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-05T08:11:44")
>>>>>>> master
@StaticMetamodel(Appointment.class)
public class Appointment_ { 

    public static volatile SingularAttribute<Appointment, String> firstName;
    public static volatile SingularAttribute<Appointment, String> lastName;
    public static volatile SingularAttribute<Appointment, String> bestCallTime;
    public static volatile SingularAttribute<Appointment, Date> appointmentTime;
    public static volatile SingularAttribute<Appointment, String> phone;
    public static volatile SingularAttribute<Appointment, Services> service;
    public static volatile SingularAttribute<Appointment, Location> location;
    public static volatile SingularAttribute<Appointment, Integer> id;
    public static volatile SingularAttribute<Appointment, Date> appointmentDate;
    public static volatile SingularAttribute<Appointment, String> email;

}