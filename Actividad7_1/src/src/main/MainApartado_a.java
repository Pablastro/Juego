package main;

import java.util.Scanner;

import clases.Jugador;
/**
 * En la clase principal se ha escrito el funcionamiento del juego, para ello hemos utilizado las funciones de jugador (la cuál 
 * contiene funciones propias y llamadas a la clase baraja).
 * 
 * @author Pablo Cabello,Sergio Millan, Jose Angel Viyuela
 * @version 1.0
 * @since 2019-02-15
 *
 */
public class MainApartado_a {
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
        Jugador[] jugadores;
		String nombre;
		char menu = 'a', menu2 = 'a';
		int cont,tam, i = 0, ganador, juego;
		boolean banca;
		
		do {
			do {
				System.out.println("¿Cuantos jugadores? [1-5]");
                cont = sc.nextInt();
			} while (cont < 1 || cont > 5);
			sc.nextLine();
			tam = cont + 1;
			juego = cont;
			jugadores = new Jugador[tam];
			
			for (banca = false;!banca;cont--) {
				if (cont == 0) {
					banca = true;
					nombre = "Banca";
				} else {
					System.out.println("Introduce nombre del jugador " + (tam - cont));
					nombre = sc.nextLine();
				}
				jugadores[tam - cont - 1] = new Jugador(nombre,banca);
			}

            for (Jugador jugador : jugadores) {
                jugador.repartoInicial();
				System.out.println(" ");
                System.out.println("--------------------------" + jugador.getNombre() + "--------------------------");
                System.out.println(jugador);
			}
			
			do {
                for (Jugador jugador : jugadores) {
                    if (jugador.isJuega() && jugador.sumarPuntos() < 7.5) {
						System.out.println(" ");
                        System.out.println("--------------------------" + jugador.getNombre() + "--------------------------");
                        System.out.println(jugador);
                        if (!jugador.isBanca()) {
							do {
								System.out.println("¿Quieres robar? [s/n]");
								menu = sc.nextLine().charAt(0);
							} while (menu != 's' && menu != 'n');
						} else {
                            jugador.sumarPuntos();
						}
                        if ((!jugador.isBanca() && menu == 's') || (jugador.isBanca() && jugador.probabilidad(jugadores, (i)) < 50)) {
							System.out.println();
                            jugador.robar(jugadores);
                            jugador.setJuega(true);
							System.out.println(jugadores[i]);
						} else {
                            if (!jugador.isBanca() && menu == 'n') {
                                jugador.setJuega(false);
								juego--;
                                System.out.println(jugador);
							}
						}
                        if (jugador.sumarPuntos() > 7.5 && !jugador.isBanca()) {
							System.out.println("Te has pasado");
                            jugador.setJuega(false);
							juego--;
						}
                        if ((jugador.isBanca() && jugador.sumarPuntos() == 7.5) || (jugador.sumarPuntos() == 7.5)) {
							juego = 0;
						}
					}
				}
			} while(juego != 0);
				
			ganador = Jugador.mayorPuntacionLugar(jugadores);
			if (!Jugador.seHanPasadoTodos(jugadores)) {
				if (jugadores[ganador].sumarPuntos() <= jugadores[tam-1].sumarPuntos() && jugadores[tam-1].sumarPuntos() <= 7.5) {
					System.out.println("Gana la banca");
				} else {
					System.out.println(jugadores[ganador].getNombre() + " ha ganado");
				}
			} else {
				System.out.println("Gana la banca");
			}
			
			do {
				System.out.println("¿Quieres volver a jugar? [s/n]");
				menu2 = sc.nextLine().charAt(0);
			} while (menu2 != 's' && menu2 != 'n');
			if (menu2 == 'n') {
				System.out.println("Hasta luego");
			}
		} while (menu == 's') ;
		
		sc.close();
	}
}