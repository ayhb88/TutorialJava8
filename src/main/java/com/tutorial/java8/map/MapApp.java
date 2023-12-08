package com.tutorial.java8.map;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MapApp {

	private Map<Integer, String> map;
	
	public void poblar() {
		map = new HashMap<Integer, String>();
		map.put(1, "carro");
		map.put(2, "barco");
		map.put(3, "avion");
		map.put(4, "tren");
	}
	
	public void imprimir_javaV7(){
		for(Entry<Integer, String> e: map.entrySet()) {
			System.out.println("llave: " + e.getKey() + " valor: " + e.getValue());
		}
	}
	
	//Manera declarativa
	public void imprimir_javaV8() {
		//map.forEach((k,v) -> System.out.println("llave: " + k + " valor: " + v));
		map.entrySet().stream().forEach(System.out::println);
	}
	
	public void recolectar() {
		Map<Integer, String> mapaRecolectado = map.entrySet().stream().filter(e -> e.getValue().contains("r")).collect(Collectors.toMap(p-> p.getKey(), p-> p.getValue()));
		
		mapaRecolectado.forEach((k,v) -> System.out.println(k +" "+ v));
	}
	
	public void insertarSiAusente() {
		map.putIfAbsent(5, "metro");
	}
	
	public void operarSiPresente() {
		map.computeIfPresent(3, (k,v) -> k +" - "+ v);
		
		
		System.out.println(map.get(3));
	}
	
	public void obtenerOrPredeterminado() {
		String valor = map.getOrDefault(5, "valor por defecto");
		System.out.println(valor);
	}
	
	
	public static void main(String[] args) {
		MapApp app = new MapApp();
		app.poblar();
		//app.imprimir_javaV7();
		//app.insertarSiAusente();		
		//app.imprimir_javaV8();
		//app.operarSiPresente();
		//app.obtenerOrPredeterminado();
		app.recolectar();
		
	}
	
}
