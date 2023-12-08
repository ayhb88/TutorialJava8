package com.tutorial.java8.streams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StreamsApp {
	
	private List<String> lista;
	private List<String> numeros;
	
	public StreamsApp() {
		lista = new ArrayList<String>();
		lista.add("carro");
		lista.add("barco");
		lista.add("avion");
		lista.add("metro");
		
		numeros = new ArrayList<String>();
		numeros.add("1");
		numeros.add("2");
		numeros.add("3");
		numeros.add("4");
	}	
	
	private void filtrar() {
		lista.stream().filter(x -> x.startsWith("m")).forEach(System.out::println);
	}

	public void ordernar() {
		//lista.stream().sorted().forEach(System.out::println);
		
		//orderna de manera inversa
		lista.stream().sorted((x,y) -> y.compareTo(x)).forEach(System.out::println);
	}
	
	public void transformar() {
		lista.stream().map(String::toUpperCase).sorted().forEach(System.out::println);
		
		//tradicional
//		for (String x : numeros) {
//			int num = Integer.parseInt(x) + 1;
//			System.out.println(num);
//			
//		}
		
		//forma declarativa
		numeros.stream().map(x -> Integer.parseInt(x) +1 ).forEach(System.out::println);
		
		
	}
	
	public void limitar() {
		lista.stream().limit(2).sorted().forEach(System.out::println);

	}
	
	public void contar() {
		long x = lista.stream().count();
		System.out.println(x);

	}
	
	public static void main(String[] args) {
		StreamsApp app = new StreamsApp();
		//app.filtrar();
		//app.ordernar();
		//app.transformar();
		//app.limitar();
		app.contar();
	}
	

}
