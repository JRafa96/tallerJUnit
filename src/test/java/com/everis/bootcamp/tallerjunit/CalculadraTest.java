package com.everis.bootcamp.tallerjunit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculadraTest {

	@Test
	public void testSuma() {
		Calculadora calculadora = new Calculadora();
		double res = calculadora.suma(1.0, 1.0);
		assertEquals(2.0, res, 0);
		System.out.println("TEST SUMA");
	}

	@Test
	public void testResta() {
		Calculadora calculadora = new Calculadora();
		double res = calculadora.resta(3.0, 2.0);
		assertEquals(1, res, 0);
		System.out.println("TEST RESTA");
	}

	@Test
	public void testMultiplicar() {
		Calculadora calculadora = new Calculadora();
		double res = calculadora.multiplicar(3.0, 2.0);
		assertEquals(6, res, 0);
		System.out.println("TEST MULTIPLICAR");
	}

	@Test
	public void testDividir() {
		Calculadora calculadora = new Calculadora();
		double res = calculadora.dividir(4.0, 2.0);
		assertEquals(2, res, 0);
		System.out.println("TEST DIVIDIR");
	}

	@BeforeClass
	public static void testBeforeClass() {
		System.out.println("BEFORE CLASS\n");
	}

	@Before
	public void testBefore() {
		System.out.println("BEFORE");
	}

	@After
	public void testAfter() {
		System.out.println("AFTER\n");
	}

	@AfterClass
	public static void testAfterClass() {
		System.out.println("AFTER CLASS");
	}

}
