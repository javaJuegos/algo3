package dab.juego;
import dab.dragonBallExceptions.CeldaNoContieneFicha;
import dab.dragonBallExceptions.CeldaOcupada;

import dab.interfaces.IContenedorDeFicha;
import dab.interfaces.IFicha;


public class Celda implements IContenedorDeFicha{
	
	int fila, columna;
	boolean ocupada;
	IFicha ficha;
	
	public Celda(int fila, int columna){
		this.fila = fila;
		this.columna = columna;
		ocupada = false;
	}
	
	public boolean estaOcupada(){
		return ocupada;
	}
	
	public IFicha getFicha(){
		if(!ocupada) throw new CeldaNoContieneFicha();
		return ficha;
	}
	
	public void colocarFicha(IFicha ficha){
		
		if (ocupada){
			//Si estaba ocupada, puede haber un consumidor
			if(!this.ficha.permiteSuperposicion()) throw new CeldaOcupada();
			//Si lo habia, la ficha interactua con el
			ficha.interactuarAlContacto(this.ficha);
		}
		this.ficha = ficha;
		ocupada = true;
		}
		
	
	public void quitarFichaMovible(){
		ficha = null;
		ocupada = false;
	}
	
	public int getFila(){
		return fila;		
	}
	
	public int getColumna(){
		return columna;
	}

	public boolean permitePosicionarUnaFicha() {
		if (ocupada){
			return ficha.permiteSuperposicion();
		}
		
		return true;
	}

}
