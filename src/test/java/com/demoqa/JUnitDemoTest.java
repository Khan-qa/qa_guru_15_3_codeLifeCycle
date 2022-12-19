package com.demoqa;

import org.junit.jupiter.api.*;

public class JUnitDemoTest {

    @BeforeAll
    static void setUp() {
        System.out.println("### @BeforeAll !");
    }

    @BeforeEach
    void beforeEachTest() {
        System.out.println("###     @BeforeEach !");
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("###     @AfterEach !");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("### @AfterAll !");
    }

    @Test
    void simpleTestFirst() {
        System.out.println("###         @Test simpleTestFirst() !");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void simpleTestSecond() {
        System.out.println("###         @Test simpleTestSecond() !");
        Assertions.assertTrue(3 > 2);
    }
}
