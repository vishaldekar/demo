package com.app.RestDemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

//@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class RestDemoApplicationTests {

	@BeforeEach
	public void beforeEach() {
		System.out.println("Executing before each test cases ");
	}

	@BeforeEach
	public void beforeAll() {
		System.out.println("Executing before all test cases ");
	}

}