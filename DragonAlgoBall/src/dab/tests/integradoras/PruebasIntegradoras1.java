package dab.tests.integradoras;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dab.dragonBallExceptions.CeldaOcupada;
import dab.equipo.Equipo;
import dab.juego.Tablero;
import dab.personajes.Goku.Goku;
import dab.personajes.Piccolo.Piccolo;
import dab.personajes.Gohan.Gohan;
import dab.personajes.cell.Cell;
import dab.personajes.majinBoo.MajinBoo;
import dab.personajes.Freezer.Freezer;
public class PruebasIntegradoras1 {

	Goku goku;
	Piccolo piccolo;
	Gohan gohan;
	Cell cell;
	MajinBoo majinboo;
	Freezer freezer;
	Equipo equipo1;
	Equipo equipo2;
	@Before
	public void setUp() throws Exception {
		goku = new Goku();
		gohan = new Gohan();
		piccolo = new Piccolo();	
		equipo1 = new Equipo("Guerreros Z");
		equipo1.agregarPersonaje(goku);
		equipo1.agregarPersonaje(gohan);
		equipo1.agregarPersonaje(piccolo);
		
		cell = new Cell();
		majinboo = new MajinBoo();
		freezer = new Freezer();
		equipo2 = new Equipo("Enemigos De La Tierra");
		equipo2.agregarPersonaje(cell);
		equipo2.agregarPersonaje(freezer);
		equipo2.agregarPersonaje(majinboo);
		
	}

	
	@Test 
	public void testTransformarPersonaje() {
		Tablero tablero = new Tablero();
		int filaGoku = 1;
		int columnaGoku = 1;
		tablero.colocarPersonaje(filaGoku, columnaGoku, goku);
		goku.agregarKi(20);
		Assert.assertTrue(goku.transformarDisponible());
		goku.transformar();
		Assert.assertEquals(goku.getNombre(), "Goku Kaio-Ken");
		Assert.assertEquals(goku.getPosicion().getFila(), filaGoku);
		Assert.assertEquals(goku.getPosicion().getColumna(), columnaGoku);
		Assert.assertEquals(goku.getPoder(), 40,0);
	}


	@Test 
	public void testTransformarYMover(){
		Tablero tablero = new Tablero();
		int filaGoku = 1;
		int columnaGoku = 1;
		tablero.colocarPersonaje(filaGoku, columnaGoku, goku);
		goku.agregarKi(20);
		goku.transformar();
		goku.mover(tablero.obtenerCelda(1, 2));
		Assert.assertEquals(goku.getPoder(), 40, 0);
		Assert.assertEquals(goku.getPosicion().getFila(), 1);
		Assert.assertEquals(goku.getPosicion().getColumna(), 2);
	}
	@Test
	public void testInicializarTablero(){
		Tablero tablero = new Tablero(equipo2,equipo1);
		Assert.assertEquals(19, goku.getPosicion().getFila());
		Assert.assertEquals(0, freezer.getPosicion().getFila());
	}
	@Test
	public void testPelearCerca(){
		Tablero tablero = new Tablero();
		int filaGoku = 1;
		int columnaGoku = 1;
		tablero.colocarPersonaje(filaGoku, columnaGoku, goku);
		int filaFreezer = 1;
		int columnaFreezer = 2;
		tablero.colocarPersonaje(filaFreezer, columnaFreezer, freezer);
		Assert.assertEquals(400, freezer.getVida(),0);
		if (goku.puedeAtacar(freezer))
			goku.atacarA(freezer);	
		Assert.assertEquals(380, freezer.getVida(),0);
	}
	
	@Test
	public void testPelearLejos(){
		Tablero tablero = new Tablero();
		int filaGoku = 1;
		int columnaGoku = 1;
		tablero.colocarPersonaje(filaGoku, columnaGoku, goku);
		int filaFreezer = 9;
		int columnaFreezer = 1;
		tablero.colocarPersonaje(filaFreezer, columnaFreezer, freezer);
		if (goku.puedeAtacar(freezer))
			goku.atacarA(freezer);
		Assert.assertEquals(400, freezer.getVida(),0);
	}
	@Test(expected=CeldaOcupada.class)
	public void testMoverACeldaOcupada() {
		Tablero tablero = new Tablero();
		int filaGoku = 1;
		int columnaGoku = 1;
		tablero.colocarPersonaje(filaGoku, columnaGoku, goku);
		int filaCell = 2;
		int columnaCell = 1;
		tablero.colocarPersonaje(filaCell, columnaCell, cell);	
		goku.mover(tablero.obtenerCelda(2, 1));
	}

}
