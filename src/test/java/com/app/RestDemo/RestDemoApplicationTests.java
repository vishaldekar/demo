package com.app.RestDemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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