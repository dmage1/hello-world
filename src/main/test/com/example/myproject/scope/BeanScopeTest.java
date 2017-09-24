package com.example.myproject.scope;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanScopeTest {

    private static final Logger LOG = LoggerFactory.getLogger(BeanScopeTest.class);

    @Autowired
    private Name singletonA;

    @Autowired
    private Name singletonB;

    @Autowired
    private Address requestA;

    @Autowired
    private Address requestB;

    @Autowired
    private Age sessionA;

    @Autowired
    private Age sessionB;

    @Autowired
    private Language prototypeA;

    @Autowired
    private Language prototypeB;

    private static final String NAME = "John Smith";
    private static final String NAME_OTHER = "Anna Jones";

    private static final String ADDRESS = "UK";
    private static final String ADDRESS_OTHER = "EU";

    private static final String AGE = "21";
    private static final String AGE_OTHER = "22";

    private static final String LANGUAGE = "French";
    private static final String LANGUAGE_OTHER = "German";

    @Test
    public void givenSingletonScope_whenSetName_thenEqualNames() {

        singletonA.setFirstName(NAME);
        Assert.assertEquals(NAME, singletonA.getFirstName());

        singletonB.setFirstName(NAME_OTHER);
        Assert.assertEquals(NAME_OTHER, singletonB.getFirstName());

        //  both referencing the same bean instance
        Assert.assertEquals(NAME_OTHER, singletonA.getFirstName());
    }

    @Test
    public void givenRequestScope_whenSetAddress_thenEqualAddress() {

        requestA.setAddress(ADDRESS);
        Assert.assertEquals(ADDRESS, requestA.getAddress());

        requestB.setAddress(ADDRESS_OTHER);
        Assert.assertEquals(ADDRESS_OTHER, requestB.getAddress());

        //  both referencing the same bean instance
        Assert.assertEquals(ADDRESS_OTHER, requestA.getAddress());
    }

    @Test
    public void givenSessionScope_whenSetAge_thenEqualAges() {

        sessionA.setAge(AGE);
        Assert.assertEquals(AGE, sessionA.getAge());

        sessionB.setAge(AGE_OTHER);
        Assert.assertEquals(AGE_OTHER, sessionB.getAge());

        //  both referencing the same bean instance
        Assert.assertEquals(AGE_OTHER, sessionA.getAge());
    }

    @Test
    public void givenPrototypeScope_whenSetLanguage_thenEqualLanguages() {

        prototypeA.setLanguage(LANGUAGE);
        LOG.info(prototypeA.getLanguage());
        Assert.assertEquals(LANGUAGE, prototypeA.getLanguage());

        prototypeB.setLanguage(LANGUAGE_OTHER);
        Assert.assertEquals(LANGUAGE_OTHER, prototypeB.getLanguage());

        //  both referencing different bean instances
        Assert.assertEquals(LANGUAGE, prototypeA.getLanguage());
    }

}
