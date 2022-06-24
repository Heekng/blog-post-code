package com.heekng.blogtestcode.blog;

import com.heekng.blogtestcode.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class SpringTest {

    @PersistenceContext
    EntityManager em;

    @Test
    void oneToManyFetchJoinTest() throws Exception {
        //given
        Home home1 = Home.builder()
                .name("home1")
                .build();
        em.persist(home1);
        Home home2 = Home.builder()
                .name("home2")
                .build();
        em.persist(home2);
        Home home3 = Home.builder()
                .name("home3")
                .build();
        em.persist(home3);
        Person person1 = Person.builder()
                .name("person1")
                .home(home1)
                .build();
        em.persist(person1);
        Person person2 = Person.builder()
                .name("person2")
                .home(home1)
                .build();
        em.persist(person2);
        Dog dog1 = Dog.builder()
                .name("dog1")
                .home(home1)
                .build();
        em.persist(dog1);
        Dog dog2 = Dog.builder()
                .name("dog2")
                .home(home1)
                .build();
        em.persist(dog2);
        em.flush();
        em.clear();
        //when
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QHome qHome = QHome.home;

        List<Home> homes = queryFactory
                .selectFrom(qHome)
                .fetch();
        homes.stream()
                .map(Home::getPersons)
                .forEach(Hibernate::initialize);
        homes.stream()
                .map(Home::getDogs)
                .forEach(Hibernate::initialize);
        em.flush();
        em.clear();
        //then
        assertThat(homes.size()).isEqualTo(3);
        assertThat(homes.get(0).getPersons().size()).isEqualTo(2);
        assertThat(homes.get(0).getPersons().get(0).getName()).isEqualTo(person1.getName());
        assertThat(homes.get(0).getDogs().size()).isEqualTo(2);
        assertThat(homes.get(0).getDogs().get(0).getName()).isEqualTo(dog1.getName());
    }
}
