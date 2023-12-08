package com.tutorial.java8.methodReference;

import java.util.Arrays;
import java.util.Comparator;

import com.tutorial.java8.lambda.Operacion3;

public class MeRefApp {
	
	public static void refenciarMetodoStatic() {
		System.out.println("Metodo referido static");
	}
	
	public void referenciarMetodoInstanciaObjetoArbitrario(){
		String[] nombres = {"casa","avion","barco"};
		
		//clase comparator
		/*Arrays.sort(nombres, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {				
				return o1.compareToIgnoreCase(o2);
			}			
		});*/
		
		//lambda
		//Arrays.sort(nombres, (s1,s2) -> s1.compareToIgnoreCase(s2));
		
		//metodo referenciado
		Arrays.sort(nombres, String::compareToIgnoreCase);
		
		System.out.println(Arrays.toString(nombres));
	}
	
	public void referenciarMetodoInstanciaObjetoParticular(){
		System.out.println("Metodo referido instancia de objeto particular");
	}
	
	public void referenciaConstructor() {
		//Clase anonima
		/*IPersona iper = new IPersona() {
			
			@Override
			public Persona crear(int id, String nombre) {				
				return new Persona(id, nombre);
			}
		};
		iper.crear(1, "Tutorial");*/
		
		//Lambda
		/*IPersona iper2 = (x, y) -> (new Persona(x,y));
		Persona per = iper2.crear(1, "Tutorial");
		System.out.println(per.getId() +" - "+ per.getNombre() );*/
		
		//Metodos referencias se apoyan en interfaces funcionales
		IPersona iper3 = Persona::new;
		Persona per = iper3.crear(1, "Tutorial");
		System.out.println(per.getId() +" - "+ per.getNombre() );
	}
	
	public void operar() {
		Operacion3 op = () -> MeRefApp.refenciarMetodoStatic();
		op.saludar();
		
		Operacion3 op2 = MeRefApp::refenciarMetodoStatic;
		op2.saludar();
		
		
	}
	
	public static void main(String[] args) {
		MeRefApp app = new MeRefApp();
		//app.operar();
		//app.referenciarMetodoInstanciaObjetoArbitrario();
		//Operacion3 op = app::referenciarMetodoInstanciaObjetoParticular;
		//op.saludar();
		app.referenciaConstructor();
	}

}
