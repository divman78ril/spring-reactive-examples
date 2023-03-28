package com.example.demo.repository;

import com.example.demo.JunitConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import reactor.test.StepVerifier;

//@DataR2dbcTest
@SpringBootTest(classes = JunitConfiguration.class)
@TestPropertySource(locations="classpath:test.properties")
public class TutorialRepositoryTest {

    @Autowired
    TutorialRepository tutorialRepository;

    @Test
    public void test1(){
        tutorialRepository
                .findByTitleContaining("a")
                .take(1)
                .as(StepVerifier::create)
                .consumeNextWith(p->System.out.println(p))
                .verifyComplete();
    }

//    @Test
//    public void test2(){
//        tutorialRepository
//                .insertFin(1,"a","b",true)
//                .as(StepVerifier::create)
//                .consumeNextWith(p->System.out.println(p))
//                .verifyComplete();
//    }


}
