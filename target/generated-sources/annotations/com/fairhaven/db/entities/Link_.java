package com.fairhaven.db.entities;

import com.fairhaven.db.entities.Faq;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-07T08:56:54")
@StaticMetamodel(Link.class)
public class Link_ { 

    public static volatile SingularAttribute<Link, String> displayText;
    public static volatile CollectionAttribute<Link, Faq> faqCollection;
    public static volatile SingularAttribute<Link, Integer> id;
    public static volatile SingularAttribute<Link, String> url;

}