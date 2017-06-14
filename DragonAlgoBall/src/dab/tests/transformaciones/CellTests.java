package dab.tests.transformaciones;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dab.equipo.Equipo;
import dab.juego.Tablero;
import dab.personajes.Goku.Goku;
import dab.personajes.cell.Cell;

public class CellTests {
	
	Cell cell;
	Goku goku;
	Equipo enemigos, guerrerosz;
	Tablero tablero;
	
	@Before
	public void setUp() throws Exception {
		cell = new Cell();
		enemigos = new Equipo("Enemigos de la Tierra");
		enemigos.agregarPersonaje(cell);
		goku = new Goku();
		guerrerosz = new Equipo("Guerreros Z");
		guerrerosz.agregarPersonaje(goku);
		tablero = new Tablero();
		tablero.colocarPersonaje(goku,1,1);
		tablero.colocarPersonaje(cell,1,2);
	}

	@Test
	public void testTransformacionNoDisponible() {
		Assert.assertFalse(cell.transformarDisponible());
	}
	@Test
	public void testAbsorberVida() {
		cell.agregarVida(-20);
		cell.modificarKi(5);
		cell.ataqueEspecial(goku);
		Assert.assertEquals(cell.getVidaMaxima(), cell.getVida(), 0);
		Assert.assertEquals(480, goku.getVida(),0);
	}
	@Test
	public void testTransformar(){
		for (int i = 0; i < 4; i++) {
			cell.modificarKi(5);
			cell.ataqueEspecial(goku);
		}
		Assert.assertTrue(cell.transformarDisponible());
		cell.transformar();
		Assert.assertEquals(40, cell.getPoder(), 0);
		Assert.assertEquals(4, cell.getAlcance());
	}
	

}
