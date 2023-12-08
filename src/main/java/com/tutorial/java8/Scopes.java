package com.tutorial.java8;

import com.tutorial.java8.lambda.Operacion;

public class Scopes {
	
	private static double atributo1;
	private double atributo2;
	
	public double probarLocalVariable() {
		//VARIABLE LOCAL
		final double n3 = 3;
		Operacion op = new Operacion() {
			
			@Override
			public double calcular(double n1, double n2) {
				// no se puede asignar nuevo valor a una variable solo usar la variable en una clase abstracta  y debe llevar la palabra FINAL 
				return n1 + n2 + n3;
			}
		};
		
		Operacion operacion = (x,y) -> {
			// no se puede asignar nuevo valor a una variable solo usar la variable en una funcion lambda y debe llevar la palabra FINAL
			return x + y + n3;
		};
		
		return operacion.calcular(1, 1);
	}
	
	public double probarAtributosStaticVariables() {
		Operacion operacion = (x,y) -> {
			atributo1 = x +y;
			atributo2 = atributo1;
			return atributo2;
		};
		return operacion.calcular(2, 2);
	}
	
	public static void main(String[] args) {
		Scopes scopes = new Scopes();
		System.out.println(scopes.probarLocalVariable());
		System.out.println(scopes.probarAtributosStaticVariables());
	}
}
