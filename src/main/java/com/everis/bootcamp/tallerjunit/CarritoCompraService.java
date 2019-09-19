package com.everis.bootcamp.tallerjunit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CarritoCompraService {

	BaseDeDadosService bbdService = new BaseDeDadosService();
	List<Articulo> articulos = new ArrayList<Articulo>();
	
	public void limpiarCesta(){
		articulos = new ArrayList<Articulo>();
	}
	
	public void addArticulo(Articulo a){
		articulos.add(a);
	}
	
	public int getNumArticulo(){
		return articulos.size();
	}
	
	public Double totalPrice(){
		double precioTotal = articulos.stream().  	
			     mapToDouble(Articulo::getPrecio).
			     sum();
		return precioTotal;
	}
	
	
	public static Double calculadorDescuento(double precio, double porcentajeDescuento){
		return precio - (precio * (porcentajeDescuento/100));
	}
	
	public Double calculadorDescuentoId(Long id, double porcentajeDescuento){
		
		Articulo art = bbdService.findById(id);
		Double desconto = 0D;
		if(art != null) {
			desconto = calculadorDescuento(art.getPrecio(), porcentajeDescuento);
		}
		
		return desconto;
	}
	
	

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
	
	

}
