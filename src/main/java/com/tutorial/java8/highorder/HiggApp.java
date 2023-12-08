package com.tutorial.java8.highorder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HiggApp {

	private Function<String, String> convertirMayusculas = x -> x.toUpperCase();
	private Function<String, String> convertirMinusculas = x -> x.toLowerCase();
	
	public void imprimir(Function<String, String> fuction,  String valor) {
		System.out.println(fuction.apply(valor));
	}
	
	public Function<String, String> mostrar(String mensaje){
		return (String x) -> mensaje + x;
	}
	
	public void filtrar(List<String> lista, Consumer<String> consumidor, int longitud, String cadena) {
		//lista.stream().filter(this.establecerLogicaFiltro(longitud)).forEach(consumidor);
		lista.stream().filter(this.establecerLogicaFiltro(cadena)).forEach(consumidor);
	}
	
	public Predicate<String> establecerLogicaFiltro(int longitud){
		return texto -> texto.length() < longitud;
	}
	
	public Predicate<String> establecerLogicaFiltro(String cadena){
		return texto -> texto.contains(cadena);
	}
	
	public static void main(String[] args) {
		HiggApp app = new HiggApp();
		//app.imprimir(app.convertirMayusculas, "cadena");
		//app.imprimir(app.convertirMinusculas, "CADENA");
		
		//String resp = app.mostrar("Hola ").apply("Cadena");
		//System.out.println(resp);
		
		List<String> lista = new ArrayList<String>();
		lista.add("carro");
		lista.add("barco");
		lista.add("avion");
		
		//app.filtrar(lista, System.out::println, 10, null);
		app.filtrar(lista, System.out::println, 0, "b");
	}
}
