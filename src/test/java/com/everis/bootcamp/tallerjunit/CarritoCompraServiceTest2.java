package com.everis.bootcamp.tallerjunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarritoCompraServiceTest2 {
	
	private static CarritoCompraService carritoCompras = new CarritoCompraService();

	
	@Test
	public void test1AddArticulo() {
		Articulo a = new Articulo("kiwi", 10D);
		Articulo b = new Articulo("maça", 3D);
		Articulo c = new Articulo("morango", 3D);
		assertEquals(false, carritoCompras.getArticulos().contains(a));
		assertEquals(false, carritoCompras.getArticulos().contains(b));
		assertEquals(false, carritoCompras.getArticulos().contains(c));
		
		carritoCompras.addArticulo(a);
		carritoCompras.addArticulo(b);
		carritoCompras.addArticulo(c);
		
		assertEquals(true, carritoCompras.getArticulos().contains(a));
		assertEquals(true, carritoCompras.getArticulos().contains(b));
		assertEquals(true, carritoCompras.getArticulos().contains(c));

	}
	
	@Test
	public void test2TotalPrice() {
		assertEquals(16D, carritoCompras.totalPrice(), 0);
	}
	
	@Test
	public void test3LimpiarCesta() {
		assertFalse(carritoCompras.getArticulos().isEmpty());
		carritoCompras.limpiarCesta();
		assertTrue(carritoCompras.getArticulos().isEmpty());
	}
	
	
}
