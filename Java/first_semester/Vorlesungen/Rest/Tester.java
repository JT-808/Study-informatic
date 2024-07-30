package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Tester {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeAll");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("AfterAll");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("BeforeEach");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("AfterEach");
	}

	@Test
	void testVolumen() {
		assertEquals(1, Berechnung.berechneVolumen(1));
		assertEquals(27,Berechnung.berechneVolumen(3));
	}
	
	@Test
	void testMax() {
		assertEquals(4,Berechnung.sucheMax(new int[] {1,2,3,4}));
		assertEquals(-4,Berechnung.sucheMax(new int[] {-1,-2,-3,-4}));
	}

}
