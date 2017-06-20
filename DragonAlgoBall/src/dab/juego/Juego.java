package dab.juego;

import java.util.LinkedList;
import java.util.Queue;

import dab.dragonBallExceptions.EstePersonajeNoPuedeRealizarMovimientosEsteTurno;
import dab.personajes.Personaje;

import dab.usuario.Usuario;

public class Juego {
	
	// Escribir a mdegiov at gmail.com
	
	////CAMBIOS A HACER:
	///QUE JUEGO RECIBA UN USUARIO CON SU EQUIPO DENTRO YA CREADO
	///QUE LOS TURNOS SE MANEJEN POR USUARIO Y NO POR EQUIPO
	
	private Tablero tablero;
	Turno turno;

	Queue<Usuario> ordenTurnos; 
	
	private Personaje personajeSeleccionado;
	
	public Juego(int altoTablero, int anchoTablero, Usuario userGuerrerosZ, Usuario userEnemigos){
		//PRE: SOLO DOS USUARIOS Y EL PRIMERO SERA EL PRIMERO EN JUGAR

	
		//Cambiaro esto de que el tablero conozca al equipo enemigo de un determinado equipo. Eso lo podria hacer
		//El juego o el usuario
		this.tablero = new Tablero(altoTablero, anchoTablero, userGuerrerosZ.getEquipo(), userEnemigos.getEquipo());
	
		ordenTurnos = new LinkedList<Usuario>();
		ordenTurnos.offer(userGuerrerosZ);
		ordenTurnos.offer(userEnemigos);
		
		turno = new Turno(ordenTurnos.peek().getEquipo(), tablero);

	}
	
	public void seleccionarPersonajeDeLaCelda(Celda celda){
		if (!turno.puedeJugar((Personaje) celda.getFicha())){
			throw new EstePersonajeNoPuedeRealizarMovimientosEsteTurno();
		}
		personajeSeleccionado = (Personaje)celda.getFicha();
	}
	
	public Tablero getTablero(){
		return tablero;
	}

	public void pasarTurno() {

		personajeSeleccionado = null;
		ordenTurnos.offer(ordenTurnos.poll());
		turno = new Turno(ordenTurnos.peek().getEquipo(), tablero);

	}
	
	public void seHaEfectuadoUnAtaque(){
		turno.seHaEfectuadoUnAtaque();
		this.verificarFinDeTurno();
	}
	
	public void seHaEfectuadoUnMovimiento(){
		turno.seHaEfectuadoUnMovimiento();
		this.verificarFinDeTurno();
	}
	
	public boolean personajeSeleccionadoPuedeAtacarA(Personaje otroPersonaje){
		
		return personajeSeleccionado.puedeAtacar(otroPersonaje);
		
	}
	
	public void personajeSeleccionadoAtacaA(Personaje otroPersonaje){
	
		personajeSeleccionado.atacarA(otroPersonaje);
		
	}
	
	public boolean personajeSeleccionadoPuedeMoverseHacia(int fila, int columna){
		return tablero.puedeTrasladarse(personajeSeleccionado, fila, columna);
	}
	
	public void moverPersonajeSeleccionadoHacia(int fila, int columna){
		tablero.moverFicha(personajeSeleccionado, fila, columna);
		turno.seHaEfectuadoUnMovimiento();
		
	}
	
	public void personajeSeleccionadoAtaqueEspecialA(Personaje otroPersonaje){
		personajeSeleccionado.ataqueEspecial(otroPersonaje);
		turno.seHaEfectuadoUnAtaque();
		
	}
	
	public boolean personajeSeleccionadoTieneAtaqueEspecialDisponible(){
		return personajeSeleccionado.ataqueEspecialDisponible();
	}
	
	public boolean personajeSeleccionadoTieneTransformacionDisponible(){
		return personajeSeleccionado.transformarDisponible();
	}
	
	public void personajeSeleccionadoTransformar(){
		personajeSeleccionado.transformar();
	}
	
	private void verificarFinDeTurno(){
		if (turno.haFinalizado()){
			this.pasarTurno();
		}
	}


	public boolean sePuedeSeleccionarUnPersonaje(Celda celda) {
		// TODO Auto-generated method stub
		return celda.estaOcupada();
	}
	
	public boolean elOcupantePuedeRealizarJugada(Celda celda){
		/*Devuelve si el ocupante de la celda esta en el turno*/
		Personaje personaje = (Personaje)celda.getFicha();
		return turno.puedeJugar(personaje);
	}


	public boolean sePuedeSeguirAtacando() {
		// TODO Auto-generated method stub
		System.out.println("Se puede seguir atacando: "+ turno.quedanAtaquesDisponibles() );
		System.out.println("");
		return turno.quedanAtaquesDisponibles();
	}


	public boolean sePuedeEfectuarUnMovimiento() {
		// TODO Auto-generated method stub
		System.out.println("Se puede seguir moviendo: "+ turno.quedanMovimientosDisponibles());
		
		return turno.quedanMovimientosDisponibles();
	}
}

