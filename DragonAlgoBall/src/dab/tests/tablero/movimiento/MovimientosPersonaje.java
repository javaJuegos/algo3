package dab.tests.tablero.movimiento;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import dab.dragonBallExceptions.CeldaOcupada;
import dab.dragonBallExceptions.MovimientoInvalido;
import dab.juego.Celda;
import dab.juego.Tablero;
import dab.personajes.Personaje;
import dab.personajes.Freezer.Freezer;
import dab.personajes.Gohan.Gohan;
import dab.personajes.Goku.Goku;
import dab.personajes.Piccolo.Piccolo;
import dab.personajes.cell.Cell;
import dab.personajes.majinBoo.MajinBoo;

public class MovimientosPersonaje {

	@Test 
	public void moverPersonaje() {
		Tablero tablero = new Tablero();
		Personaje piccolo = new Piccolo();
		tablero.colocarFichaMovil(piccolo, 1, 1);
		Celda destino = tablero.obtenerCelda(1, 2);
		assert(piccolo.movimientoPosible(destino));
		tablero.moverFicha(piccolo,  1, 2);
		assert(destino.getFicha() == piccolo);
	}	
	

	@Test
	public void testPersonajePuedeMoverseEnSentidoHorizontalHastaSuAlcanceMaximo(){ 
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		tableroDab.colocarFichaMovil(goku, 5, 6);
		tableroDab.colocarFichaMovil(goku, 5 + goku.getVelocidad(), 6);
		assertEquals(tableroDab.getFilaDeLaFicha(goku), 5+ goku.getVelocidad());
		assertEquals(tableroDab.getColumnaDeLaFicha(goku), 6);
	}
	
	@Test
	public void testPersonajePuedeMoverseEnSentidoVerticalHastaSuAlcanceMaximo(){
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		tableroDab.colocarFichaMovil(goku, 5, 6);
		tableroDab.colocarFichaMovil(goku, 5, 6 + goku.getVelocidad());
		assertEquals(tableroDab.getFilaDeLaFicha(goku), 5);
		assertEquals(tableroDab.getColumnaDeLaFicha(goku), 6 + goku.getVelocidad());
	}
	@Test
	public void testPersonajePuedeMoverseEnSentidoDiagonalHastaSuAlcanceMaximo(){
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		tableroDab.colocarFichaMovil(goku, 5, 6);
		tableroDab.colocarFichaMovil(goku, 5 + ((int)(goku.getVelocidad())), 6 + ((int)(goku.getVelocidad())));
		assertEquals(tableroDab.getFilaDeLaFicha(goku), 5 + ((int)(goku.getVelocidad())));
		assertEquals(tableroDab.getColumnaDeLaFicha(goku), 6 + ((int)(goku.getVelocidad())));
	}
	@Test(expected = MovimientoInvalido.class)
	public void testMoverPersonajeHorizontalMayorQueAlcanceLanzaMovimientoInvalido(){
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		tableroDab.colocarFichaMovil(goku, 5, 6);
		
		tableroDab.moverFicha(goku, 5 + goku.getVelocidad() + 1, 6);
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void testMoverPersonajeVerticalMayorQueAlcanceLanzaMovimientoInvalido(){
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		tableroDab.colocarFichaMovil(goku, 5, 6);
		tableroDab.moverFicha(goku, 5, 6 + goku.getVelocidad() + 1);
	}
	@Test(expected = MovimientoInvalido.class)
	public void testMoverPersonajeDiagonalMayorAlcanceMaximoLanzaMovimientoInvalido(){
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		tableroDab.colocarFichaMovil(goku, 5, 6);
		tableroDab.moverFicha(goku, 5 + 1 + ((int)(goku.getVelocidad())), 6 + ((int)(goku.getVelocidad())));
	}
		
	
	@Test(expected=CeldaOcupada.class)
	public void testMoverACeldaOcupadaLanzaError() {
		Tablero tablero = new Tablero();
		Personaje goku = new Goku();
		int filaGoku = 1;
		int columnaGoku = 1;
		Personaje cell = new Cell();
		int filaCell = 2;
		int columnaCell = 1;
		tablero.colocarFichaMovil(goku, filaGoku, columnaGoku);
		tablero.colocarFichaMovil(cell, filaCell, columnaCell);
		tablero.moverFicha(goku, 2, 1);
	}
	@Test
	public void testPersonajeNoTieneDondeMoverseSiEstaRodeado() {
		//La idea de este test es rodear a un personaje por otros 6 y verificar
		//que no hayan celdas disponibles a las cual moverse
		//En este test, goku es el que esta encerrado
		Tablero tablero = new Tablero();
				
		Personaje cell = new Cell();
		int filaCell = 4;
		int columnaCell = 4;
		tablero.colocarFichaMovil(cell, filaCell, columnaCell);
		
		Personaje majinBoo = new MajinBoo();
		int filaMajinBoo = 4;
		int columnaMajinBoo = 5;
		tablero.colocarFichaMovil(majinBoo, filaMajinBoo, columnaMajinBoo);
		
		Personaje freezer = new Freezer();
		int filaFreezer= 4;
		int columnaFreezer = 6;
		tablero.colocarFichaMovil(freezer, filaFreezer, columnaFreezer);
		Personaje piccolo = new Piccolo();
		int filaPiccolo = 5;
		int columnaPiccolo = 4;
		tablero.colocarFichaMovil(piccolo, filaPiccolo, columnaPiccolo);
		
		Personaje goku = new Goku();
		int filaGoku = 5;
		int columnaGoku = 5;
		tablero.colocarFichaMovil(goku, filaGoku, columnaGoku);
		
		Personaje gohan = new Gohan();
		int filaGohan = 5;
		int columnaGohan = 6;
		tablero.colocarFichaMovil(gohan, filaGohan, columnaGohan);
		
		Personaje clonGohan = new Gohan();
		int filaClonGohan= 6;
		int columnaClonGohan = 4;
		tablero.colocarFichaMovil(clonGohan, filaClonGohan, columnaClonGohan);
		
		Personaje clonFreezer = new Freezer();
		int filaClonFreezer= 6;
		int columnaClonFreezer = 5;
		tablero.colocarFichaMovil(clonFreezer, filaClonFreezer, columnaClonFreezer);
		
		Personaje clonPiccolo = new Piccolo();
		int filaClonPiccolo= 6;
		int columnaClonPiccolo = 6;
		tablero.colocarFichaMovil(clonPiccolo, filaClonPiccolo, columnaClonPiccolo);
		
		ArrayList<Celda> celdasDisponiblesParaQueSeMuevaGoku = tablero.celdasPermitidas((Celda) goku.getPosicion(), goku.getVelocidad());
		assertEquals(celdasDisponiblesParaQueSeMuevaGoku.isEmpty(), true);
	}
	
	@Test
	public void testPersonajeTieneDondeMoverseSiEstaRodeadoPorSolo5Personajes() {
		//Sigue la idea de rodear al personaje del test anterior, pero esta vez lo 
		//rodeo por uno menos. 
		Tablero tablero = new Tablero();
		
		Personaje cell = new Cell();
		int filaCell = 4;
		int columnaCell = 4;
		tablero.colocarFichaMovil(cell, filaCell, columnaCell);
						
		Personaje majinBoo = new MajinBoo();
		int filaMajinBoo = 4;
		int columnaMajinBoo = 5;
		tablero.colocarFichaMovil(majinBoo, filaMajinBoo, columnaMajinBoo);
		
		Personaje freezer = new Freezer();
		int filaFreezer= 4;
		int columnaFreezer = 6;
		tablero.colocarFichaMovil(freezer, filaFreezer, columnaFreezer);
		
		Personaje piccolo = new Piccolo();
		int filaPiccolo = 5;
		int columnaPiccolo = 4;
		tablero.colocarFichaMovil(piccolo, filaPiccolo, columnaPiccolo);
		
		Personaje goku = new Goku();
		int filaGoku = 5;
		int columnaGoku = 5;
		tablero.colocarFichaMovil(goku, filaGoku, columnaGoku);
		
		Personaje gohan = new Gohan();
		int filaGohan = 5;
		int columnaGohan = 6;
		tablero.colocarFichaMovil(gohan, filaGohan, columnaGohan);
		
		Personaje clonGohan = new Gohan();
		int filaClonGohan= 6;
		int columnaClonGohan = 4;
		tablero.colocarFichaMovil(clonGohan, filaClonGohan, columnaClonGohan);
		
		Personaje clonFreezer = new Freezer();
		int filaClonFreezer= 6;
		int columnaClonFreezer = 5;
		tablero.colocarFichaMovil(clonFreezer, filaClonFreezer, columnaClonFreezer);
		
		Personaje clonPiccolo = new Piccolo();
		int filaClonPiccolo= 6;
		int columnaClonPiccolo = 6;
		tablero.colocarFichaMovil(clonPiccolo, filaClonPiccolo, columnaClonPiccolo);
		
		List<Personaje> personajesARemover = Arrays.asList(cell, majinBoo, freezer, gohan, 
				piccolo, clonGohan, clonFreezer, clonPiccolo);
		boolean pudoMoverseEnCualquierOportunidad = true;
		int filaRemovido;
		int columnaRemovido;
		Personaje removido;
		for (Personaje p: personajesARemover){
			filaRemovido = p.getPosicion().getFila();
			columnaRemovido = p.getPosicion().getColumna();
			removido = p;
			tablero.removerFicha(removido);
			ArrayList<Celda> celdasDisponiblesParaQueSeMuevaGoku = tablero.celdasPermitidas((Celda) goku.getPosicion(), goku.getVelocidad());
			if (celdasDisponiblesParaQueSeMuevaGoku.isEmpty()){
				pudoMoverseEnCualquierOportunidad = false;
				break;
			}
			tablero.colocarFichaMovil(removido, filaRemovido, columnaRemovido);
			//reinserto y pruebo con el siguiente
		}
		assertEquals(pudoMoverseEnCualquierOportunidad, true);
	}

	@Test
	public void testPersonajeRodeadoEnEsquinaDelTableroNoTieneMovimientosPosibles(){
		
		Tablero tablero = new Tablero();
		//hacer que tablero reciba la cantidad de filas y columnas
		int filasTablero = 20;
		int columnasTablero = 20;
		
		Personaje cell = new Cell();
		int filaCell = filasTablero - 1;
		int columnaCell = columnasTablero - 1;
		tablero.colocarFichaMovil(cell, filaCell, columnaCell);
						
		Personaje majinBoo = new MajinBoo();
		int filaMajinBoo = filasTablero - 2;
		int columnaMajinBoo = columnasTablero - 1;
		tablero.colocarFichaMovil(majinBoo, filaMajinBoo, columnaMajinBoo);
		
		Personaje freezer = new Freezer();
		int filaFreezer= filasTablero - 2;
		int columnaFreezer = columnasTablero - 2;
		tablero.colocarFichaMovil(freezer, filaFreezer, columnaFreezer);
		
		Personaje piccolo = new Piccolo();
		int filaPiccolo = filasTablero - 1;
		int columnaPiccolo = columnasTablero - 2;
		tablero.colocarFichaMovil(piccolo, filaPiccolo, columnaPiccolo);
		
		ArrayList<Celda> celdasDisponiblesParaQueSeMuevaCell= tablero.celdasPermitidas((Celda) cell.getPosicion(), cell.getVelocidad());
		assertEquals(celdasDisponiblesParaQueSeMuevaCell.isEmpty(), true);
		
		
	}
		
}
	