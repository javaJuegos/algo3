package dab.tests.movimiento;

import org.junit.Test;

import dab.estados.piccolo.Piccolo;
import dab.juego.Celda;
import dab.juego.Tablero;
import dab.personaje.Personaje;

public class MoverPersonaje {

	@Test 
	public void moverPersonaje() {
		Tablero tablero = new Tablero();
		Personaje piccolo = new Personaje(new Piccolo());
		tablero.colocarPersonaje(1, 1, piccolo);
		Celda destino = tablero.obtenerCelda(1, 2);
		assert(piccolo.movimientoPosible(destino));
		piccolo.mover(destino);
		assert(destino.darOcupante() == piccolo);
	}	
}