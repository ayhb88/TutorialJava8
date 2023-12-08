package com.tutorial.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.tutorial.java8.lambda.Operacion;
import com.tutorial.java8.lambda.Operacion2;

/**
 * Hello world!
 *
 */
public class LambdaApp {
	public List<String> ordernar() {
		List<String> lista = new ArrayList<String>();
		lista.add("mitocode");
		lista.add("mito");
		lista.add("code");

		// JDK 1.7
		/*
		  Collections.sort(lista, new Comparator<String>() {
		  
		  @Override public int compare(String o1, String o2) { return o1.compareTo(o2);
		  } })
		 */

		// Lambda
		Collections.sort(lista, (String p1, String p2) -> p1.compareTo(p2));

		return lista;
	}
	
	public void calcular() {
		
		//Instancia de la interfaz
		/*Operacion operacion = new Operacion() {
			
			@Override
			public double calcularPromedio(double n1, double n2) {
				// TODO Auto-generated method stub
				return (n1 + n2) / 2;
			}
		};		
		*/
		
		//Sintaxis Lambda
		//Operacion operacion = (double x, double y) -> (x+y)/2;
		//Operacion operacion = (double x, double y) -> {return (x+y)/2;};
		/* No es recomendable este codigo
		Operacion operacion = (double x, double y) -> {
			double a = 2.0;
			System.out.println(a);
			return (x+y)/2 + a;
		};*/
		Operacion operacion = (x,y) -> (x+y)/2;
		
		//Operacion2 operacion2 = () -> 2;
		Operacion2 operacion2 = () -> {
			double x = 2;
			double y = 3;
			return x+y;
		};
		//System.out.println(operacion.calcular(2,3));
		
		//System.out.println(operacion2.calcularPromedio());
	}

	public static void main(String[] args) {
		// System.out.println( "Hello World!" );
		LambdaApp app = new LambdaApp();

		//System.out.println(app.ordernar());
		app.calcular();
	}
}
