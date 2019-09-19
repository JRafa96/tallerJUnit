package com.everis.bootcamp.tallerjunit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseDeDadosService {

	
	Articulo a = new Articulo(1L,"kiwi", 10D);
	Articulo b = new Articulo(2L,"maça", 5D);
	Articulo c = new Articulo(3L,"pera", 6D);
	Articulo d = new Articulo(4L,"laranja", 3D);
	Articulo e = new Articulo(5L,"banana", 1D);
	Articulo f = new Articulo(6L,"melancia", 4D);
	Articulo g = new Articulo(7L,"toranja", 8D);
	Articulo h = new Articulo(8L,"morango", 7D);
	Articulo i = new Articulo(9L,"melao", 9D);
	Articulo j = new Articulo(10L,"papaia", 10D);
	
	public List<Articulo> listaArticulos = new ArrayList<Articulo>(Arrays.asList(a,b,c,d,e,f,g,h,i,j));


	public List<Articulo> getListaArticulos() {
		return listaArticulos;
	}

	public void setListaArticulos(List<Articulo> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}
		
	
	public Articulo findById(Long id) {
		for (Articulo articulo : listaArticulos) {
			if(articulo.getId().equals(id)) {
				return articulo;
			}
		}
		return null;
	}
	
	
	
}
