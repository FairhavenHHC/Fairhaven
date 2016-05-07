package com.fairhaven.db.entities;

import com.fairhaven.db.entities.Link;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-07T12:42:20")
@StaticMetamodel(Faq.class)
public class Faq_ { 

    public static volatile SingularAttribute<Faq, String> question;
    public static volatile SingularAttribute<Faq, String> answer;
    public static volatile CollectionAttribute<Faq, Link> linkCollection;
    public static volatile SingularAttribute<Faq, Integer> id;

}