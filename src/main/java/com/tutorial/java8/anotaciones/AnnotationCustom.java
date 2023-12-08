package com.tutorial.java8.anotaciones;

public @interface AnnotationCustom {
	String nombre();
	boolean habilitado() default true;
}
