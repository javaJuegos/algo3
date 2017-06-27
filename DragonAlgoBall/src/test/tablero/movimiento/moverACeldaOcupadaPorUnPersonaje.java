package test.tablero.movimiento;

import org.junit.Test;

import dab.dragonBallExceptions.MovimientoInvalido;
import dab.juego.Tablero;
import dab.personajes.Personaje;
import dab.personajes.Goku.Goku;
import dab.personajes.cell.Cell;
public class moverACeldaOcupadaPorUnPersonaje {

	@Test(expected=MovimientoInvalido.class)
	public void testMoverACeldaOcupada() {
		Tablero tablero = new Tablero(20, 20);
		Personaje goku = new Goku();
		int filaGoku = 1;
		int columnaGoku = 1;
		Personaje cell = new Cell();
		int filaCell = 2;
		int columnaCell = 1;
		tablero.colocarFicha(goku, filaGoku, columnaGoku);
		tablero.colocarFicha(cell, filaCell, columnaCell);
		tablero.moverFicha(goku, 2, 1);
	}

}
