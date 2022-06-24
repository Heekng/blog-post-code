package com.heekng.blogtestcode.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHome is a Querydsl query type for Home
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHome extends EntityPathBase<Home> {

    private static final long serialVersionUID = 2066482882L;

    public static final QHome home = new QHome("home");

    public final ListPath<Dog, QDog> dogs = this.<Dog, QDog>createList("dogs", Dog.class, QDog.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<Person, QPerson> persons = this.<Person, QPerson>createList("persons", Person.class, QPerson.class, PathInits.DIRECT2);

    public QHome(String variable) {
        super(Home.class, forVariable(variable));
    }

    public QHome(Path<? extends Home> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHome(PathMetadata metadata) {
        super(Home.class, metadata);
    }

}

