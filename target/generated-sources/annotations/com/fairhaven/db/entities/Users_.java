package com.fairhaven.db.entities;

import com.fairhaven.db.entities.Groups;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-28T22:17:53")
=======
<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-02-14T15:55:13")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-26T16:49:44")
>>>>>>> login
>>>>>>> c4c55a6de9ef3c9716c8d750a5b4d5d57a1445b2
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> password;
    public static volatile CollectionAttribute<Users, Groups> groupsCollection;
    public static volatile SingularAttribute<Users, Boolean> enabled;
    public static volatile SingularAttribute<Users, String> username;

}