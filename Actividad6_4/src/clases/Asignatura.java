package clases;

public class Asignatura {
	private String nombre;
	private int creditos;
	private String practicas;
	
	
	public Asignatura() {
		this.nombre=" ";
		this.creditos=0;
		this.practicas=" ";
	}
	
	public Asignatura(String nombre, int creditos, String practicas) {
		this.nombre=nombre;
		this.creditos=creditos;
		this.practicas=practicas;
	}
	
	
	public String getNombreAsignatura() {
		return this.nombre;
	}
	
	public int getCreditosAsignatura() {
		return this.creditos;
	}
	
	public String getPracticasAsignatura() {
		return this.practicas;
	}
	
	public void setNombreAsignatura(String nombre) {
		this.nombre=nombre;
	}
	
	public void setCreditosAsignatura(int creditos) {
		this.creditos=creditos;
	}
	
	public void setPracticasAsignaturas(String practicas) {
		this.practicas=practicas;
	}
	
	public String toString() {
		String cadena= new String(this.nombre);
		return cadena;
	}
	
	public Asignatura clone() {
		Asignatura p=new Asignatura();
		
		p.creditos=this.creditos;
		p.nombre=this.nombre;
		p.practicas=this.practicas;
		
		return p;
	}
}
