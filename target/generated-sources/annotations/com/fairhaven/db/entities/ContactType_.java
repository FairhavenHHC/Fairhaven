package com.fairhaven.db.entities;

import com.fairhaven.db.entities.Contact;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-04T23:00:44")
@StaticMetamodel(ContactType.class)
public class ContactType_ { 

    public static volatile CollectionAttribute<ContactType, Contact> contactCollection;
    public static volatile SingularAttribute<ContactType, String> name;
    public static volatile SingularAttribute<ContactType, String> description;
    public static volatile SingularAttribute<ContactType, Integer> id;

}