package com.fairhaven.db.entities;

import com.fairhaven.db.entities.ContactType;
import com.fairhaven.db.entities.Location;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-05T20:50:39")
@StaticMetamodel(Contact.class)
public class Contact_ { 

    public static volatile SingularAttribute<Contact, Integer> id;
    public static volatile SingularAttribute<Contact, ContactType> type;
    public static volatile SingularAttribute<Contact, String> value;
    public static volatile CollectionAttribute<Contact, Location> locationCollection;

}