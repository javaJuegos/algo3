package atacar;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dab.equipo.Equipo;
import dab.juego.Tablero;
import dab.personajes.Personaje;
import dab.personajes.Freezer.Freezer;
import dab.personajes.Gohan.Gohan;
import dab.personajes.Goku.Goku;
import dab.personajes.Piccolo.Piccolo;
import dab.personajes.cell.Cell;
import dab.personajes.majinBoo.MajinBoo;

public class AtacarTest{
	
	private Gohan gohan;
	private Goku goku;
	private Piccolo piccolo;
	private Equipo guerrerosZ;
	
	private Cell cell;
	private MajinBoo boo;
	private Freezer freezer;
	private Equipo enemigosDeLaTierra;
	
	@Before
	public void before(){
		
		gohan = new Gohan();
		goku = new Goku();
		piccolo = new Piccolo();
		guerrerosZ = new Equipo("Guerreros Z");
		guerrerosZ.agregarPersonaje(gohan);
		guerrerosZ.agregarPersonaje(goku);
		guerrerosZ.agregarPersonaje(piccolo);
		
		cell = new Cell();
		boo = new MajinBoo();
		freezer = new Freezer();
		enemigosDeLaTierra = new Equipo("Enemigos de la Tierra");
		enemigosDeLaTierra.agregarPersonaje(cell);
		enemigosDeLaTierra.agregarPersonaje(boo);
		enemigosDeLaTierra.agregarPersonaje(freezer);
	}
	
	@Test
	public void testAtacarMismoPP(){
		Tablero tablero = new Tablero(20, 20);
		Personaje piccolo = guerrerosZ.obtenerPersonaje(Piccolo.identificador);
		Personaje cell = enemigosDeLaTierra.obtenerPersonaje(Cell.identificador);
		tablero.colocarFicha(piccolo, 5, 6);
		tablero.colocarFicha(cell, 5,7);
		
		double vidaEsperada = cell.getVida() - piccolo.getPoder();
		piccolo.atacarA(cell);
		assertEquals(cell.getVida(), vidaEsperada, 0);	
	}
	
	@Test
	public void pruebaAtacarMayorPP(){
		Tablero tablero = new Tablero(20, 20);
		Personaje piccolo = guerrerosZ.obtenerPersonaje(Piccolo.identificador);
		Personaje majinboo = enemigosDeLaTierra.obtenerPersonaje(MajinBoo.identificador);
		
		tablero.colocarFicha(piccolo, 5, 6);
		tablero.colocarFicha(majinboo, 5,7);
		
		double vidaEsperada = majinboo.getVida() - (int)(piccolo.getPoder() * 0.8);
		piccolo.atacarA(majinboo);
		assertEquals(majinboo.getVida(), vidaEsperada, 0);
	}
	
	@Test
	public void atacarADistancia(){
		Tablero tablero = new Tablero(20, 20);
		Personaje piccolo = guerrerosZ.obtenerPersonaje(Piccolo.identificador);
		Personaje majinboo = enemigosDeLaTierra.obtenerPersonaje(MajinBoo.identificador);
		tablero.colocarFicha(piccolo, 5, 6);
		tablero.colocarFicha(majinboo, 10, 8);
		assert(!piccolo.puedeAtacar(majinboo));
		
		
	}
	
}