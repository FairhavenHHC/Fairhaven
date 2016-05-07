package com.fairhaven.db.entities;

import com.fairhaven.db.entities.Groups;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-05T20:50:39")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-05T08:11:44")
>>>>>>> master
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> password;
    public static volatile CollectionAttribute<Users, Groups> groupsCollection;
    public static volatile SingularAttribute<Users, Boolean> enabled;
    public static volatile SingularAttribute<Users, String> username;

}