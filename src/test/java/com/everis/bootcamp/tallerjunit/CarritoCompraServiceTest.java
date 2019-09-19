package com.everis.bootcamp.tallerjunit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarritoCompraServiceTest {
	
	CarritoCompraService carritoCompras;
	List<Articulo> articulos;
	
	@InjectMocks
	static CarritoCompraService service;
	
	@Mock
	BaseDeDadosService baseMock;
	
	
	

	@Before
	public void testBefore() {
		carritoCompras = new CarritoCompraService();
		Articulo a = new Articulo("maça", 3D);
		Articulo b = new Articulo("pera", 4D);
		Articulo c = new Articulo("laranja", 5D);
		Articulo d = new Articulo("banana", 3D);
		articulos = new ArrayList<Articulo>(Arrays.asList(a, b, c, d));
		carritoCompras.setArticulos(articulos);
		
		Mockito.when(baseMock.findById(1L)).thenReturn(new Articulo(100L, "mocked", 100D));
	}

	@Test
	public void testLimpiarCesta() {
		assertFalse(carritoCompras.getArticulos().isEmpty());
		carritoCompras.limpiarCesta();
		assertTrue(carritoCompras.getArticulos().isEmpty());
	}

	@Test
	public void addArticulo() {
		Articulo e = new Articulo("morango", 3D);
		assertEquals(false, carritoCompras.getArticulos().contains(e));
		carritoCompras.addArticulo(e);
		assertEquals(true, carritoCompras.getArticulos().contains(e));

	}

	@Test
	public void testGetNumArticulo() {
		assertEquals(4, carritoCompras.getNumArticulo(), 0);
	}

	@Test
	public void testTotalPrice() {
		assertEquals(15, carritoCompras.totalPrice(), 0);
	}

	@Test
	public void testCalculadorDescuento() {
		assertEquals(4.5, CarritoCompraService.calculadorDescuento(5D, 10D), 0);
	}

	@Test
	public void testGetArticulos() {
	Articulo f = new Articulo("kiwi", 10D);
		Articulo g = new Articulo("maça", 3D);
		List<Articulo> articulos2 = new ArrayList<Articulo>(Arrays.asList(f,g));
		
		assertEquals(articulos, carritoCompras.getArticulos());
		assertNotEquals(articulos2, carritoCompras.getArticulos());
	}

	@Test
	public void testSetArticulos() {
		Articulo f = new Articulo("kiwi", 10D);
		Articulo g = new Articulo("maça", 3D);
		List<Articulo> articulos2 = new ArrayList<Articulo>(Arrays.asList(f,g));
		
		assertEquals(articulos, carritoCompras.getArticulos());
		
		carritoCompras.setArticulos(articulos2);
		
		assertNotEquals(articulos, carritoCompras.getArticulos());
		assertEquals(articulos2, carritoCompras.getArticulos());

	}
	
	//-------------------------------------------------------------
	
	@Test
	public void testCalculadorDescuentoId() {
		assertEquals(50,service.calculadorDescuentoId(1L, 50D),0);
		Mockito.verify(baseMock, times(1)).findById(1L);
	}
	
	

}
