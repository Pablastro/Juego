package clases;

import java.util.Arrays;

public class Alumno {
	private int DNI;
	private String nombre;
	private Asignatura[] asignatura=new Asignatura[6];
	
	
	public Alumno() {
		this.DNI=0;
		this.nombre=" ";
		this.asignatura= new Asignatura[6].clone();
	}
	
	public Alumno(int dni, String nombre) {
		this.DNI=dni;
		this.nombre=nombre;
	}
	
	public int getDNI() {
		return this.DNI;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public boolean matricular(Asignatura a) {
		boolean sw = false;
		for (int i = 0; i < this.asignatura.length && sw == false; i++) {
			if(asignatura[i] == a) {
				sw = false;
				break;
			}else {
				if(asignatura[i] == null) {
					asignatura[i] = a;
					sw = true;
					break;
				}else {
					sw = false;
				}
			}
		}
		return sw;
		
	}
	
	public boolean Desmatricular(Asignatura a) {
		boolean sw = false;
		for (int i = 0; i < asignatura.length && sw == false; i++) {
			if(asignatura[i] == null) {
				sw = false;
				break;
			}else {
				if(asignatura[i] == a) {
					asignatura[i] = null;
					sw = true;
					break;
				}else {
					sw = false;
				}
			}
		}
		return sw;
	}
	
	public String toString() {
		String cadena;
		
		cadena = new String	("El alumno con DNI: " + DNI + ", nombre: " + nombre + ", asignaturas: " + Arrays.toString(asignatura));
		
		return cadena;
	}
	
	public int PrecioaPagar() {
		int euros = 0;
		int precioTotal = 0;
		int total;
		boolean sw = false;
		for (int i = 0; i < asignatura.length && sw == false; i++) {
			if(asignatura[i] == null) {
				sw = true;
				break;
			}else {
				if(asignatura[i].getPracticasAsignatura().equals("si")) {
					euros = euros + 50;
				}
				precioTotal = precioTotal + asignatura[i].getCreditosAsignatura() * 50;
				sw = false;
			}
		}
		total = euros + precioTotal;
		return total;
	}
}
