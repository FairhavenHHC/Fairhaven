package com.fairhaven.db.entities;

import com.fairhaven.db.entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-05T20:50:39")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-05T08:11:44")
>>>>>>> master
@StaticMetamodel(Groups.class)
public class Groups_ { 

    public static volatile SingularAttribute<Groups, String> name;
    public static volatile SingularAttribute<Groups, String> description;
    public static volatile SingularAttribute<Groups, Integer> id;
    public static volatile CollectionAttribute<Groups, Users> usersCollection;

}