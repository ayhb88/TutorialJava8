package com.tutorial.java8.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollectionApp {

	private List<String> lista;

	public void llenarLista() {
		lista = new ArrayList<String>();

		lista.add("carro");
		lista.add("barco");
		lista.add("avion");
	}

	public void usarForEach() {
		// ForEach
		/*
		 * for (String elemento : lista) { System.out.println(elemento); }
		 */

		// Lambda
		// lista.forEach(x -> System.out.println(x));

		//// Metodo referenciado
		lista.forEach(System.out::println);
	}

	public void usarRemoveIf() {
		/*Iterator<String> it = lista.iterator();
		while (it.hasNext()) {
			if (it.next().equalsIgnoreCase("carro")) {
				it.remove();
			}
		}*/
		
		lista.removeIf(x -> x.equalsIgnoreCase("carro"));
	}

	public void usarSort() {
		//Metodo tradicional
		//Collections.sort(lista);
		
		//lambda
		lista.sort((x,y) -> x.compareToIgnoreCase(y));		
	}

	public static void main(String[] args) {
		CollectionApp app = new CollectionApp();
		app.llenarLista();
		//app.usarRemoveIf();
		app.usarSort();
		app.usarForEach();
	}
}
