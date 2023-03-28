package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableTransactionManagement
@TestPropertySource(locations="classpath:test.properties")
public class JunitConfiguration {}
