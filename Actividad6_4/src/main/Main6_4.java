package main;

import java.util.Scanner;

import clases.Alumno;
import clases.Asignatura;

public class Main6_4 {

	public static void main(String[] args) {
		int r=0,p=0,l=0,k=0, num=0, creditos=0,i=0,DNI=0,I=0;
		String nombre,practicas,nomAlumno;
		Scanner sc= new Scanner(System.in);
		boolean sw=false;
		Asignatura[] asignaturas =new Asignatura[13];
		Alumno[] alumno=new Alumno[15];
		
		//Creacion Array de asignaturas
		asignaturas[0]=new Asignatura("Gestión Empresarial",6,"no");
		asignaturas[1]=new Asignatura("Fundamentos de Electricidad y Electrónica",6,"si");
		asignaturas[2]=new Asignatura("Métodos Matemáticos de la Ingeniería",12,"no");
		asignaturas[3]=new Asignatura("Matemática Discreta y Lógica Matemática",12,"no");
		asignaturas[4]=new Asignatura("Fundamentos de la Programación",12,"si");
		asignaturas[5]=new Asignatura("Fundamentos de los Computador",12,"no");
		asignaturas[6]=new Asignatura("Ampliación de Matemáticas",6,"no");
		asignaturas[7]=new Asignatura("Tecnología y Organización de Computadores",6,"si");
		asignaturas[8]=new Asignatura("Probabilidad y Estadística",6,"no");
		asignaturas[9]=new Asignatura("Estructura de Computadores",6,"si");
		asignaturas[10]=new Asignatura("Ingeniería del Software",9,"no");
		asignaturas[11]=new Asignatura("Estructura de Datos y Algoritmo",9,"si");
		asignaturas[12]=new Asignatura("Tecnología de la programación",12,"si");
		
		do {
			System.out.println("Introduce que gestion desea realizar");
			System.out.println("1- GESTION DE ALUMNOS");
			System.out.println("2- GESTION DE MATRICULA");
			System.out.println("3- GESTION DE LAS ASIGNATURAS");
			System.out.println("4- FIN");
			r=sc.nextInt();
			switch(r) {
			case 1:
				do {
					System.out.println("Introduce que operacion desea realizar");
					System.out.println("1 - DAR DE ALTA UN ALUMNO");
					System.out.println("2 - DAR DE BAJA UN ALUMNO");
					System.out.println("3 - MOSTRAR ASIGNATURAS EN LAS QUE ESTÁ MATRICULADO UN ALUMNO");
					System.out.println("4 - MOSTRAR PRECIO A PAGAR DE UN ALUMNO");
					System.out.println("5 - VOLVER MENU PRINCIPAL");
					p=sc.nextInt();
					switch(p) {
					case 1:
						for(i=0;i<alumno.length;i++) {
							if(alumno[i]==null) {
								System.out.println("Introduce el DNI del alumno");
								DNI=sc.nextInt();
								sc.nextLine();
								System.out.println("Introduce el nombre del alumno");
								nomAlumno=sc.nextLine();
								alumno[i]=new Alumno(DNI,nomAlumno);
								sw=true;
								I=i;
								break;
							}
						}
						if(sw=true) {
							System.out.println("Se ha dado de alta a "+alumno[I].getNombre());
						}
						else {
							System.out.println("No se ha podido dar de alta");
						}
						break;
					case 2:
						System.out.println("Introduzca el DNI del alumno que desea dar de baja");
						DNI=sc.nextInt();
						for(i=0;i<alumno.length;i++) {
							if(alumno[i].getDNI()==DNI) {
								alumno[i]=null;
								sw=true;
								break;
							}
						}
						if(sw=true) {
							System.out.println("Se ha dado de baja al alumno");
						}
						else {
							System.out.println("No se ha podido dar de baja al alumno");
						}
						
						break;
					case 3:
						System.out.println("Introduce el DNI del alumno");
						DNI=sc.nextInt();
						for(i=0;i<alumno.length;i++) {
							if(alumno[i].getDNI()==DNI) {
								System.out.println(alumno[i]);
								break;
							}
						}
						break;
					case 4:
						System.out.println("Introduzca el DNI del alumno");
						DNI=sc.nextInt();
						for(i=0;i<alumno.length;i++) {
							if(alumno[i].getDNI()==DNI) {
								System.out.println(alumno[i].PrecioaPagar()+" euros tendra que pagar");
								break;
							}
						}
						break;
					default:
						System.out.println("Numero incorrecto,introduzca un numero del 1-5");
						break;
					}
				}
				while(p!=5);
				break;
			
			case 2:
				do {
					System.out.println("Introduzca que operacion desea realizar");
					System.out.println("1 MATRICULARSE DE UNA ASIGANTURA");
					System.out.println("2 ANULAR LA MATRICULA DE UNA ASIGNATURA");
					System.out.println("3 VOLVER AL MENU PRINCIPAL");
					l=sc.nextInt();
					switch(l) {
					case 1:
						boolean sw2=false;
						System.out.println("Introduza el DNI del alumno");
						DNI=sc.nextInt();
						for(i=0;i<alumno.length;i++) {
							if(alumno[i].getDNI()==DNI) {
								System.out.println("Introduzca el numero de la asignatura");
								num=sc.nextInt();
								if(alumno[i].matricular(asignaturas[num-1])==true) {
									System.out.println("Se ha matriculado con exito");
								}
								else {
									System.out.println("Ya esta matriculado o no puede matricularse en ninguna asignatura mas");
								}
								break;
								}
							}
						break;
					case 2:
						System.out.println("Introduce el DNI del alumno");
						DNI=sc.nextInt();
						for(i=0;i<alumno.length;i++) {
							if(alumno[i].getDNI()==DNI) {
								System.out.println("Introduzca el numero de la asignatura de la que desea darse de baja");
								num=sc.nextInt();
								if((alumno[i].Desmatricular(asignaturas[num-1])==true)) {
									System.out.println("Se ha desmatriculado con exito");
								}
								else {
									System.out.println("No se ha podido desmatricular");
								}
								break;
							}
						}
						break;
					default:
						System.out.println("Numero incorrecto, introduzca un numero del 1-3");
						break;
					}
				}
				while(l!=3);
				break;
			
			case 3:
				do {
					System.out.println("Introduzca que operacion desea realizar");
					System.out.println("1 MOFICAR NOMBRE ASIGNATURA");
					System.out.println("2 MODIFICAR CREDITOS");
					System.out.println("3 MODIFICAR LABORATORIO");
					System.out.println("4 VOLVER AL MENU PRINCIPAL");
					k=sc.nextInt();
					switch(k) {
					case 1:
						System.out.println("Introduce el numero de la asignatura");
						num=sc.nextInt();
						sc.nextLine();
						System.out.println("Introduzca el nuevo nombre que desea ponerle a la asignatura");
						nombre=sc.nextLine();
						asignaturas[num-1].setNombreAsignatura(nombre);
						break;
					case 2:
						System.out.println("Introduce el numero de la asignatura");
						num=sc.nextInt();
						sc.nextLine();
						System.out.println("Introduce los nuevos creditos de la asignatura");
						creditos=sc.nextInt();
						asignaturas[num-1].setCreditosAsignatura(creditos);
						break;
					case 3:
						System.out.println("Introduce el numero de la asignatura");
						num=sc.nextInt();
						sc.nextLine();
						System.out.println("Introduzca 'si' si la asignatura tendra practicas o introduzca 'no' si no tendra practicas");
						practicas=sc.nextLine();
						asignaturas[num-1].setPracticasAsignaturas(practicas);
						break;
					default:
						System.out.println("Numero incorrecto");
						break;
					}
				}
				while(k!=4);
				break;
			default:
				System.out.println("Numero incorrecto,introduzca un numero del 1-5");
				break;
			}
		}
		while(r!=4);
		
		
		for( i=0;i<asignaturas.length;i++) {
			System.out.println(asignaturas[i]);
		}

	}

}
